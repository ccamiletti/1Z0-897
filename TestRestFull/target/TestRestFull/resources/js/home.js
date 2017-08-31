var app=angular.module("app",[]);
  
function PruebaController($scope) {
  $scope.mensaje="Hola Mundo";
}

app.controller("ClienteController",['$scope','$log','$http',function($scope,$log,$http) {
  
	$scope.mensaje="test angular restfull..."
	$scope.salida = "";	
	
	$scope.clientForm = {
	    name : "",
	    address : "",
	    age : ""
    };	
	
	
	$scope.getJson = function () {
		
		 $http({
			    method: 'GET', 
			    url: 'http://localhost:8080/TestRestFull/rest/resourcesA/json'
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	}	

	$scope.getXML = function () {
		
		 $http({
			    method: 'GET', 
			    url: 'http://localhost:8080/TestRestFull/rest/resourcesA/'
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	}	 

	$scope.showClients = function () {
		
		 $http({
			    method: 'GET', 
			    url: 'http://localhost:8080/TestRestFull/rest/admin/clientList'
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	}	 
		
	$scope.insertClient = function () {
		
		console.log($scope.clientForm);
		console.log(angular.toJson($scope.clientForm));
		$http({
			    method: 'POST', 
			    url: 'http://localhost:8080/TestRestFull/rest/admin/',
			    data : angular.toJson($scope.clientForm),
			    headers : {
                    'Content-Type' : 'application/json',
                    'Accept': 'application/json'
                }
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
		}	 
		
}]);
