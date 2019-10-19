<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form:form action="create" method="POST" enctype="multipart/form-data">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">First
							Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" id="name"
								placeholder="Name" path="firstName" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Last
							Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" id="description"
								placeholder="Description" path="lastName" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Image</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="file" name="file">
						</div>
					</div>
					<input type="submit" class="btn btn-primary" value="Submit">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>