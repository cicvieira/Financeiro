/*
 * Cicero Vieira 2019-04-08
 * limitecreditoapp 1.0
 * 
 */
angular.module('crudApp').factory('Credito', Credito);

Credito.$inject = [ '$resource' ];

function Credito($resource) {
	var resourceUrl = 'api/credito/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}
