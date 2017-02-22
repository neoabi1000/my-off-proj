<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular-animate.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular-sanitize.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="customers.js"></script>

<title>Customer Management</title>
</head>

<body ng-app="CustMgmt">
	<div class="branding">
		<h2>Jyothi Spectro</h2>
		<h2>Manage Customers</h2>
	</div>

	<div ng-controller="CustomerAddController as $ctrl">
	<script type="text/ng-template" id="AddCustomerModal.html">
        <div class="modal-header">
            <h3 class="modal-title" id="modal-title">Add a new customer</h3>
        </div>
        <div class="modal-body" id="modal-body">
            <form>
				Customer Name: <br>
				<input type="text" placeholder="Name" ng-model="$ctrl.name"><br>

				Customer Phone: <br> 
				<input type="text" placeholder="Phone" ng-model="$ctrl.phone"><br>

				Customer's PAN: <br>
				<input type="text" placeholder="PAN" ng-model="$ctrl.pan"><br>

				Customer Type: <br>
				<input type="text" placeholder="Type" ng-model="$ctrl.type"> <br/>
			</form>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="$ctrl.save()">Save</button>
            <button class="btn btn-warning" type="button" ng-click="$ctrl.cancel()">Cancel</button>
        </div>
    </script>
		<button type="button" class="btn btn-default"
			ng-click="$ctrl.open('lg')">Add Customer</button>
	</div>


	<div ng-controller="CustomerListController"> 
		{{error}} {{' Total # of Customers = '+ customers.length}}
		<hr />
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Phone</th>
				<th>PAN</th>
				<th>Type</th>
				<th>Credit Limit</th>

			</tr>
			<tr ng-repeat="customer in customers">
				<td>{{ customer.custId }}</td>
				<td>{{ customer.name }}</td>
				<td>{{ customer.phone }}</td>
				<td>{{ customer.pan }}</td>
				<td>{{ customer.customerType.name }}</td>
				<td>{{ customer.customerType.creditLimit }}</td>
			</tr>
		</table>
	</div>

</body>
</html>