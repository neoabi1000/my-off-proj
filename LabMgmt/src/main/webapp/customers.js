angular.module('CustMgmt', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('CustMgmt').controller('CustomerListController', function($scope, $http) {

	$scope.customers = [];

	$http.get("rest/customers")
	.then(function(response){
		$scope.customers = response.data;
	}, function(){
		$scope.error="Somethign went wrong check in browser console";
	});

});


angular.module('CustMgmt').controller('CustomerAddController', function($uibModal, $log, $document, $scope, $http) {
	var $ctrl = this;

	$ctrl.animationsEnabled = true;

	$ctrl.open = function (size, parentSelector) 
	{
		var parentElem = parentSelector ? angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
		var modalInstance = $uibModal.open({
			animation: $ctrl.animationsEnabled,
			ariaLabelledBy: 'modal-title',
			ariaDescribedBy: 'modal-body',
			templateUrl: 'AddCustomerModal.html',
			controller: 'ModalInstanceCtrl',
			controllerAs: '$ctrl',
			size: size,
			appendTo: parentElem,
			resolve: {
				items: function () {
					return $ctrl.items;
				}
			}
		});
	}
});


angular.module('CustMgmt').controller('ModalInstanceCtrl', function ($uibModalInstance, items, $scope, $http) {
	var $ctrl = this;

	$ctrl.config = {
			headers : {
				'Content-Type': 'application/json;'
			}
	}
	$ctrl.data = {
			"name": $ctrl.name,
			"phone": $ctrl.phone,
			"customerType":$ctrl.type,
			"pan": $ctrl.pan
	};


	$ctrl.save = function () {
		$http.post("rest/customers", {
			"name": $ctrl.name,
			"phone": $ctrl.phone,
			"customerType":$ctrl.type,
			"pan": $ctrl.pan
		}, $ctrl.config).then(function(response){
			alert("Saved");
		}, function(error){
			alert("Failed");
		})
		$uibModalInstance.close();
	};

	$ctrl.cancel = function () {
		$uibModalInstance.dismiss('cancel');
	};
});
