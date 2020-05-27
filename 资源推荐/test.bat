::脚本说明
::获得第i个参数：%i，0<=i && i <=参数最大数量  set p0=%0  echo %0  echo %p0%

::生成文件 1.jsp  2.js  3.regist 4.out_band

::当前目录第一个参数
::set jsp=%~dp0\%0.jsp
::echo "This a redirect line">>%jsp%

::-----------------   开始生成ecpweb文件   ------------------------
echo "start ecpweb"

set jspFileName=%1.jsp
echo %jspFileName%

::复制jsp文件
echo f|xcopy 1.jsp %jspFileName%

::复制js文件
set jsFileName=%1.js
echo f|xcopy 1.js %jsFileName% 

::TODO 生成外呼文件regist     

::TODO 生成外呼out_band

::TODO 定义报文信息

::-----------------   开始生成后端文件   ---------------------

::TODO 生成接收信息xml

::TODO 定义那个接口xml

::TODO 生成后端Impl Inf

::TODO 生成VO等

::TODO 后端数据库访问xml

::开始移动文件
::目录信息


::替换文件内容
(
    for /f "tokens=*" %%i in (%file%) do (
        set s=%%i
        set s=!s:192.168.1.58=127.0.0.1!
        echo !s!
    )
)>%file_personal%