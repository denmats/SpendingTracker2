<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Income Page</title>
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
			<form action="/home">
				<input type="hidden" name="account_id" value="${account.getAccount_id()}">
				<button type="submit" class="btn btn-outline-secondary">Back</button>
			</form>		
		</div>
	</nav>
	<div class="container mt-2">
		<div class="row">
			<div class="col-md-8 mt-3">
			<h3 class="display-6 mt-5" style="color:green">Add Income</h3>
				<form action="saveTransaction" method="get" class="needs-validation" novalidate>
					<div class="form-group">
						<label>Income</label>
						<select class="form-control" name="operation" required>
										<option value="${transaction.getOperation()}">${transaction.getOperation()}</option>
										<option value="salary">Salary</option>
										<option value="extra">Extra</option>
						</select>
						<small class="form-text text-muted">Select type of income from the list</small>
					</div> 
						<div class="form-group">
							<label>Amount</label>
							<input class="form-control" type="text" name="amount" value="${transaction.getAmount()}" placeholder="Enter amount" required>
						</div>
					<div class="form-group">
						<label>Date</label>
						<input class="form-control" type="date" name="date_tx" value="${transaction.getDate_tx()}" placeholder="Enter date" required>
					</div>
					<div class="form-group">
						<label>Account Name</label>
						<input class="form-control" type="text" name="accountName" value="${account.getName()}" readonly>
					</div>
					 	
					<input type="hidden" name="type" value="income">
					<input type="hidden" name="id" value="${transaction.getId()}">
					<input type="hidden" name="account_account_id" value="${account.getAccount_id()}">
					
					<button type="submit" class="btn btn-outline-success">Submit</button>
					
				</form>
			</div>
		</div>
	</div>
	
	<div class="footer">
  		<small>Copyright &copy;<span id="year"></span>Denys Matsuiev</small>
	</div>
	
	<script>
		var form = document.querySelector('.needs-validation');
		
		form.addEventListener('submit',function(event){
			if(form.checkValidity()===false){
				event.preventDefault();
				event.stopPropagation();
			}
			form.classList.add('was-validated');
		});
	</script>
	
</body>
</html>