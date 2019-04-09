/*
 * Cicero Vieira 2018-12-17
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