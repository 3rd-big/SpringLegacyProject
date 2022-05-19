<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sample/exUploadPost" name="newProduct" method="post" enctype="multipart/form-data">
		<div>
			<div>
				<input type="file" id="files" name="files">
			</div>
		</div>
 		<div>
			<div>
				<input type="file" id="files" name="files">
			</div>
		</div>
		<div>
			<div>
				<input type="file" id="files" name="files">
			</div>
		</div>
		<div>
			<div>
				<input type="submit" value="등록">
			</div>
		</div>
	</form>
</body>
</html>