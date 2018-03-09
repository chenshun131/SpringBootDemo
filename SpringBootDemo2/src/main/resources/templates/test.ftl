<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>

    <script>
        $.ajax({
            url: "http://localhost:8081/api/get1",
            type: "POST",
            data: {
                name: "测试"
            },
            success: function (data, status, xhr) {
                console.log(data);
                alert(data.name);
            }
        });
    </script>
</head>
<body>

测试

</body>
</html>
