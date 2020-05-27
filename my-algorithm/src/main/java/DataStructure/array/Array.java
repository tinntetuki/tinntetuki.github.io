package DataStructure.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 *
 * @Auther: tinntetuki
 * @Date: 2020/5/24 13:55
 * @Description:
 */
public class Array {
    /**
     * 定义数组保存的数据
     */
    public int[] data;

    /**
     * 定义数组长度
     */
    public int n;

    /**
     * 数组中实际个数
     */
    public int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 按下标查找
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 | index > count) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (index == count && count == 0) {
            data[index] = value;
            ++ count;
            return true;
        }

        if (count == n) {
            System.out.println("数组已满");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        for (int i = count;i > index; --i) {
            data[i] = data[i-1];
        }

        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index){
        if (index < 0 || index >= count) {
            return false;
        }

        for (int i = index + 1; i < count; i++) {
            data[i-1] = data[i];
        }
        int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;

        --count;
        return true;
    }

    public void printAll(){
        for (int i : data) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();

        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.printAll();
    }
}
