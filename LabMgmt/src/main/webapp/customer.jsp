<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.js"></script>
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
	<div class="n">
		<h2>Jyothi Spectro</h2>
		<h2>Manage Customers</h2>
	</div>
	<div>{{msg}}</div>
	<div ng-controller="CustomerController">

		<script type="text/ng-template" id="AddCustomerModal.html">
        <div class="modal-header">
            <h3 class="modal-title" id="modal-title">Add a new customer</h3>
        </div>
        <div class="modal-body" id="modal-body">
            <form ng-submit="save()">
				Customer Name: 	<br> <input type="text" required placeholder="Name" 	ng-model="name">	<br>
				Customer Phone: <br> <input type="text" required placeholder="Phone" 	ng-model="phone">	<br>
				Customer PAN: 	<br> <input type="text" 		 placeholder="PAN" 		ng-model="pan">		<br>
				Customer Type:	<br> 
				<select ng-model="typeId">
					<option ng-repeat="customerType in customerTypes"
					value="{{customerType.type}}">{{customerType.name}}</option>
				</select>
				<div class="modal-footer">
            		<button class="btn btn-primary" type="submit">Save</button>
            		<button class="btn btn-warning" type="button" ng-click="$ctrl.cancel()">Cancel</button>
        		</div>
			</form>
        </div>
    </script>
		<button type="button" class="btn btn-default" ng-click="open('sm')">Add
			Customer</button>

		<hr />
		{{error}} {{' Total # of Customers = '+ customers.length}}
		<hr />
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>PAN</th>
					<th>Type</th>
					<th>CreatedOn</th>
					<th>CreatedBy</th>
					<th>LastUpdatedOn</th>
					<th>LastUpdatedBy</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="customer in customers | orderBy: 'lastUpdatedOn':true">
					<td><input type="checkbox" ng-model="selected">
					<td>{{ customer.custId }}</td>
					<td>{{ customer.name }}</td>
					<td>{{ customer.phone }}</td>
					<td>{{ customer.pan }}</td>
					<td>{{ customer.customerTypeName }}</td>
					<td>{{ customer.createdOn }}</td>
					<td>{{ customer.createdBy }}</td>
					<td>{{ customer.lastUpdatedOn }}</td>
					<td>{{ customer.lastUpdatedBy }}</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>