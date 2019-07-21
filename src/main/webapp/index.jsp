
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome to Tourism's handbook v1.0</title>
</head>
<style>
  h1 {
    text-align: center;
    overflow: hidden;
    background: linear-gradient(90deg, #000, #ffb419, #000);
    background-repeat: no-repeat;
    background-size: 80%;
    animation: animate 3s linear infinite;
    -webkit-background-clip: text;
    -webkit-text-fill-color: rgba(255, 255, 255, 0);
  }

  @keyframes animate {
    0% {
      background-position: -500%;
    }
    100% {
      background-position: 500%;
    }
  }

  * {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  }
</style>
<body>
<h1>Chào mừng đến với Tourism's handbook v1.0</h1>
<p style="text-align: center">Nhấn vào <a href="/cities">đây</a> để bắt đầu sử dụng Tourism's handbook !</p>
</body>
</html>
