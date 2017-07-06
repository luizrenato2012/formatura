var instituicaoService = angular.module('InstituicaoServiceMdl',[]);

instituicaoService.service('InstituicaoService', function($http) {
	
	this.inclui = function(instituicao) {
		return $http.post('http://localhost:8080/formatura/api/instituicao', instituicao);
	}
});