<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light navbar-dark fixed-top">
		<div class="container">
			<div>
				<i class="fas fa-piggy-bank fa-2x text-success"></i> <span><strong>Spending
						Tracker</strong></span>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="d-flex justify-content-center align-items-center topnav">
			<div id="row" class="mt-5">
				<div>
					<form action="home" method="get">
						<div class="form-check">
							<label class="form-check-label"> <input type="radio"
								id="guest" name="account_id" value="1" checked>Guest
							</label>
						</div>

						<div class="form-check">
							<label class="form-check-label"> <input type="radio"
								id="personal" name="account_id" value="2">Personal
								Account
							</label>
						</div>
						<button type="submit" class="btn btn-outline-primary btn-sm mt-2 ">Confirm</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<small>Copyright &copy;<span id="year"></span>Denys Matsuiev
		</small>
	</div>
	<script>
		$('#year').text(new Date().getFullYear());
	</script>
</body>
</html>