/*
 * Cicero Vieira 2019-04-08
 * limitecreditoapp 1.0
 * 
 */
angular.module("crudApp").controller("GeneralController", GeneralController);

GeneralController.inject = [ '$scope', 'Credito' ];


function GeneralController($scope, Credito) {
	
	$scope.creditos = Credito.query();

	$scope.credito = {};
	
	$scope.buttonText="Enviar";	
	
    $scope.change = function(credito) {
	    var l = credito.limite;
	    var r = credito.risco;
	    if(r == 'B'){
	    	v = (l*10)/100;
	    	vj = (l+v);
	    	$scope.credito.porcentagem = 10;
	    	$scope.credito.valorjuros = v; 
	    	$scope.credito.valorcomjuros = vj;
	    }
	    if(r=='C'){
	    	v = (l*20)/100;
	    	vj = (l+v);
	    	$scope.credito.porcentagem = 20;
	    	$scope.credito.valorjuros = v; 
	    	$scope.credito.valorcomjuros = vj;
	    }
	    if(r=='A'){
	    	$scope.credito.porcentagem = 0.00;
	    	$scope.credito.valorjuros = 0.00;
	    	$scope.credito.valorcomjuros = l;
	    }    
	}
	
	$scope.saveCredito = function() {
		if ($scope.credito.id !== undefined) {
			Credito.update($scope.credito, function() {
				$scope.creditos = Credito.query();
				$scope.credito = {};
				$scope.buttonText="Enviar";
			});
		} else {
			Credito.save($scope.credito, function() {
				$scope.creditos = Credito.query();
				$scope.credito = {};
			});
		}
	}

	$scope.updateCreditoInit = function(credito) {
		$scope.buttonText="Atualizar";
		$scope.credito = credito;
	}

	$scope.deleteCredito = function(credito) {
		credito.$delete({id:credito.id}, function() {
			$scope.creditos = Credito.query();
		});
	}
	
	
	
}
