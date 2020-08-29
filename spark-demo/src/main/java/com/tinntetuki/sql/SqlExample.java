package com.tinntetuki.sql;

import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/8/29
 */
public class SqlExample {
    /**
     * calculate sum_reg_group by server_id, 3 days ago
     */
    public static final String SQL_ALL_REG_GROUP_BY_SERVER_ID =  "select count(role_id) as user_count,server_id from dwd_reg r left join dwd_tran t on r.role_id = t.role_id" +
            " where r.log_date = ''" +
            " group by server_id";
    /**
     * calculate sum_reg_group by server_id, 3 days all
     */
    public static final String SQL_SUM_TRAN_GROUP_BY_SERVER_ID=  "select sum(amount) as amount,server_id from dwd_tran t left join dwd_reg r on r.role_id = t.role_id" +
            " where r.log_date = " +
            " and t.log_date in ('','','')" +
            " group by server_id";

    /**
     * calculate result
     */
    public static final String SQL_RESULT = "select t.amount/r.user_count as LTV3 dwd_tran_info t left join dwd_user_info r" +
            " on t.server_id = r.server_id ";


    public static void main(String[] args) throws AnalysisException {
        SparkSession spark = SparkSession
                .builder()
                .appName("app_name")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        runLTV3(spark);

        spark.stop();
    }

    private static void runLTV3(SparkSession spark) throws AnalysisException {
        Dataset<Row> df_user_info = spark.sql(SQL_ALL_REG_GROUP_BY_SERVER_ID);
        df_user_info.createGlobalTempView("dwd_user_info");
        Dataset<Row> df_tran_info = spark.sql(SQL_SUM_TRAN_GROUP_BY_SERVER_ID);
        df_tran_info.createGlobalTempView("dwd_tran_info");

        Dataset<Row> df_result = spark.sql(SQL_RESULT);
        df_result.select("LTV3").write().format("parquet").save("LTV3.parquet");
    }
}
