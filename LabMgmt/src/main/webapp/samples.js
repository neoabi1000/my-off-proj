(function(){

	var app = angular.module("app");

	var SampleController = function($scope, $http){

		$scope.sample = {};
		$scope.samples = [];
		
		var OnSampleListSuccess = function(response){
			$scope.samples = response.data;
		}
		var OnError = function(reason){
			$scope.error = "Could not load the data";
		}

		$scope.refresh = function(){
			$http.get("rest/samples").then(OnSampleListSuccess, OnError);
		};
		
		$scope.config = {
				headers : {
					'Content-Type': 'application/json;'
				}
		}
		
		$scope.add = function(){
			$http.post("rest/samples", $scope.sample,  $scope.config).then(function(response){
				$scope.refresh();
				alert("saved");
			}, function(reason){
				alert("failed");
			});
		}
		
		$scope.refresh();
	};

	app.controller("SampleController", SampleController);

}());