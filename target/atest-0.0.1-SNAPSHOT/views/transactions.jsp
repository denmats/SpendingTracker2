<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions Page</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
<link href="css/style.css" rel="stylesheet"/>
  
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-light navbar-dark fixed-top">
		<div class="container">
			<div>
				<i class="fas fa-piggy-bank fa-2x text-success"></i>
				<span><strong>Spending Tracker</strong></span>
			</div>
			<div>
				<h3>
					<span class="badge badge-secondary">${account.getName()}</span>
				</h3>
			</div>
			<form action="${path}/home">
				<input type="hidden" name="account_id" value="${account.getAccount_id()}">
				<button type="submit" class="btn btn-outline-secondary">Back</button>
			</form>		
		</div>
	</nav>
	
	<div class="container mt-2">
		<div class="row mt-3">
			
			<h3 class="display-6 mt-5 text-success">Transactions Page</h3>
			
			
			<table class="table table-bordered table-striped text-center m-2">
			
			<tr>
				<td>
					<table class="table table-bordered">
					<thead>
					<tr class="d-flex justify-content-around">
						<th >OPERATION</th>
						<th >AMOUNT, <span>&#122;&#322;</span></th>
						<th >DATE</th>
						<th >ACTIONS</th>
					</tr>
				</thead>
				</table>
				</td>
			</tr>
			<tr>
				<td>
					<div class="scrollable_table">
						<table class="table table-bordered table-striped text-center">
						<c:forEach items="${account.getTx()}" var="transaction">
						<tr>	
							<td >${transaction.getOperation().toUpperCase()}</td>
							<c:choose>
						        <c:when test = "${transaction.getType() ne 'expense'}">
						            <td class="text-success">${transaction.getAmount()}</td>
						        </c:when>
						        <c:otherwise>
						            <td class="text-danger">${transaction.getAmount()}</td>
						        </c:otherwise>
						    </c:choose>
							<td >${transaction.getDate_tx()}</td>
							<td >
								<a href="${pageContext.request.contextPath}/updateTransaction?id=${transaction.getId()}&account_account_id=${account.getAccount_id()}">EDIT</a>
								|
								<a href="${pageContext.request.contextPath}/deleteTransaction?id=${transaction.getId()}&account_id=${account.getAccount_id()}" >DELETE</a>
							</td>
					</tr>
					</c:forEach>
					</table>
					</div>
				</td>
			</tr>
						
					</table>
					
				</div>
		</div>
		
	<p><small class="text-success">${message}</small></p>
	<div class="footer">
  		<small>Copyright &copy;<span id="year"></span>Denys Matsuiev</small>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script>$('#year').text(new Date().getFullYear());</script>
</body>
</html>