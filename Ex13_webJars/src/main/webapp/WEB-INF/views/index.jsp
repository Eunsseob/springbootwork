<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/webjars/bootstrap/5.3.8/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/bootstrap/5.3.8/css/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
<title>webJars</title>
</head>
<body>
	<h1>안녕 헬로 jsp</h1>
	<div class="alert alert-primary" role="alert">
  A simple primary alert—check it out!
</div>
<div class="alert alert-secondary" role="alert">
  A simple secondary alert—check it out!
</div>
<div class="alert alert-success" role="alert">
  A simple success alert—check it out!
</div>
<div class="alert alert-danger" role="alert">
  A simple danger alert—check it out!
</div>
<div class="alert alert-warning" role="alert">
  A simple warning alert—check it out!
</div>
<div class="alert alert-info" role="alert">
  A simple info alert—check it out!
</div>
<div class="alert alert-light" role="alert">
  A simple light alert—check it out!
</div>
<div class="alert alert-dark" role="alert">
  A simple dark alert—check it out!
</div>
<button type="button" class="btn btn-primary" onclick="test1();">fadeOut</button>&emsp;
	<button type="button" class="btn btn-outline-warning" onclick="test2();">fadeIn</button>
	<p/>
	<img id="img1" src="/img/짱구1.jpg">
	<script type="text/javascript">
		function test1() {
			$("#img1").fadeOut(1000);
		}
		
		function test2() {
			$("#img1").fadeIn(1000);
		}
	</script>
</body>
</html>