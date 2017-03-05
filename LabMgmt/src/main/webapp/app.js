(function(){

	var app = angular.module("app", ["ngRoute", "ngAnimate", "ngSanitize", "ui.bootstrap"]);

	app.config(function($routeProvider){
		$routeProvider
		.when("/dashboard", {templateUrl:"dashboard.jsp"})
		.when("/customers", {templateUrl:"customer.jsp", controller:"CustomerController"})
		.when("/samples", {templateUrl:"samples.jsp", controller:"SampleController"})
		.when("/workorders", {templateUrl:"workOrders.jsp"})
		.when("/delivery", {templateUrl:"delivery.jsp"})
		.otherwise({redirectTo:"/dashboard"});
	});
}());
