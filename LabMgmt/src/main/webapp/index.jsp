<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular-route.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular-animate.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular-sanitize.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="app.js"></script>
<script src="customers.js"></script>
<script src="samples.js"></script>
</head>

<body ng-app="app">

	<h1>Jyothi Spectro</h1>

	<div class="navbar">
		<h2>Navigation</h2>
		<a href="#!/dashboard">Dashboard</a> <a href="#!/customers">Customers</a>
		<a href="#!/samples">Samples</a> <a href="#!/workorders">Work
			Orders</a> <a href="#!/delivery">Delivery</a>
	</div>

	<div ng-view></div>

</body>

</html>
