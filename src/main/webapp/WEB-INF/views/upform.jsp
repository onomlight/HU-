<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>UPLOAD FILES</h1>

<form action="/sample/post.do" method="post" enctype="multipart/form-data">
	<input type="file" name=files><br>
	<input type="file" name=files><br>
	<input type="file" name=files><br>
	<input type="file" name=files><br>
	<input type="submit" value="upload">

</form>


</body>
</html>