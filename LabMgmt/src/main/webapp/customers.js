
(function(){
	var custMgmtModule = angular.module('CustMgmt', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

	var CustomerController = function($rootScope, $scope, $http, $uibModal, $log, $document) {

		$scope.customers = [];

		$rootScope.refresh = function(){
			$http.get("rest/customers")
			.then(function(response){
				$scope.customers = response.data;
			}, function(){
				$scope.error="Somethign went wrong check in browser console";
			});
		};

		$rootScope.open = function (size, parentSelector) 
		{
			var parentElem = parentSelector ? angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
			var modalInstance = $uibModal.open({
				animation: true,
				ariaLabelledBy: 'modal-title',
				ariaDescribedBy: 'modal-body',
				templateUrl: 'AddCustomerModal.html',
				controller: 'ModalInstanceController',
				size: size,
				appendTo: parentElem,
				resolve: {
					items: function () {
						return $scope.items;
					}
				}
			});
		}

		$rootScope.refresh();
	};

	var ModalInstanceController = function ($uibModalInstance, items, $scope, $rootScope, $http) {
		
		$http.get("rest/customerTypes")
		.then(function(response){
			$scope.customerTypes = response.data;
		}, function(){
			$scope.error="Somethign went wrong check in browser console";
		});

		$scope.config = {
				headers : {
					'Content-Type': 'application/json;'
				}
		}

		$scope.save = function () {
			$http.post("rest/customers", {
				"name": $scope.name,
				"phone": $scope.phone,
				"customerTypeId":$scope.typeId,
				"pan": $scope.pan
			}, $scope.config).then(function(response){
				$rootScope.refresh();
				alert("Saved");
			}, function(error){
				alert("Failed");
			})
			$uibModalInstance.close();
		};

		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
	};

	custMgmtModule.controller('CustomerController', ['$rootScope', '$scope', '$http', '$uibModal', '$log', '$document', CustomerController]);
	custMgmtModule.controller('ModalInstanceController', ['$uibModalInstance', 'items', '$scope', '$rootScope', '$http', ModalInstanceController]);

})();
