<html>
<head>
    <title></title>
</head>
<body>
    <table border="1" width="300px;" align="center" bgcolor="#7fffd4">
        <tr>
            <th>编号</th>
            <th>地址</th>
            <th><input type="button" value="添加" onclick="add()"></th>
        </tr>

        <#list list as list>
            <tr>
                <th>${list.areaID}</th>
                <th>${list.areaName}</th>
                <th>
                    <input type="button" value="删除" onclick="del(${list.areaID})">
                    <input type="button" value="修改" onclick="update(${list.areaID})">
                </th>
            </tr>
        </#list>
        <tr>
            <th colspan="300">
                ${page}
            ${cpage}/${totalPage}</th>
        </tr>
    </table>

    <script>
        function add(){
            location.href="insert.html";
        }
        function del(id){
            location.href="delete.html?areaID="+id;
        }
        function update (id){
            location.href="update.html?areaID="+id;
        }
    </script>

</body>
</html>