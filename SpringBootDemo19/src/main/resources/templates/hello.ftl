<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/webjarslocator/jquery/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="${urls.getForLookupPath('/css/index.css')}">
    <script type="text/javascript" src="${urls.getForLookupPath('/js/index.js')}"></script>
</head>
<body>

hello ${name}
<pre id="preId"></pre>

<script>
    $("#preId").append("AAABBBCCCDDD6");

    // 初始化一个 WebSocket 对象
    var ws = new WebSocket("ws://localhost:8080/echo");

    // 建立 web socket 连接成功触发事件
    ws.onopen = function () {
        // 使用 send() 方法发送数据
        ws.send("发送数据");
        alert("数据发送中...");
    };

    // 接收服务端数据时触发事件
    ws.onmessage = function (evt) {
        var received_msg = evt.data;
        alert("数据已接收..." + received_msg);
    };

    // 断开 web socket 连接成功触发事件
    ws.onclose = function () {
        alert("连接已关闭...");
    };
</script>

</body>
</html>
