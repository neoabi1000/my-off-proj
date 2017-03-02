(function(){
	var app = angular.module("routeSample1",["ngRoute"]);
	app.config(function($routeProvider){
		$routeProvider
		.when("/", {templateUrl:"main.htm"})
		.when("/london", {templateUrl:"london.htm"})
		.when("/paris", {templateUrl:"paris.htm"});
	});
})();
