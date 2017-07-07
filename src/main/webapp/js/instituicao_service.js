var instituicaoService = angular.module('InstituicaoServiceMdl',[]);

instituicaoService.service('InstituicaoService', function($http) {
	
	this.inclui = function(instituicao) {
		return $http.post('http://localhost:8080/formatura/api/v1/instituicoes', instituicao);
	}
	
	this.testa = function(teste) {
		return $http.post('http://localhost:8080/formatura/api/v1/instituicoes', teste);
	}
});