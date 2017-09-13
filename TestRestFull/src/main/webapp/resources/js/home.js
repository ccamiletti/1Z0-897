var app=angular.module("app",[]);
  
function PruebaController($scope) {
  $scope.mensaje="Hola Mundo";
}

app.controller("ClienteController",['$location','$scope','$log','$http',function($location, $scope,$log,$http) {
	
	$scope.uri = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/TestRestFull';
	
	
	$scope.mensaje="test angular restfull...";
	$scope.salida = "";	
	$scope.find = "";
	$scope.clientForm = {
	    name : "",
	    address : "",
	    age : "",
	    phone : "",
	    dni: ""
    };	
	
	
	$scope.getJson = function () {
		
		 $http({
			    method: 'GET', 
			    url: $scope.uri + '/rest/resourcesA/json'
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	};	

	$scope.getXML = function () {
		
		 $http({
			    method: 'GET', 
			    url: $scope.uri + '/rest/resourcesA/'
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	};

	$scope.showClients = function () {
		
		 $http({
			    method: 'GET', 
			    url: $scope.uri + '/rest/admin/clientList'
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	};	 
		
	$scope.insertClient = function () {
		
		console.log($scope.clientForm);
		console.log(angular.toJson($scope.clientForm));
		$http({
			    method: 'POST', 
			    url: $scope.uri + '/rest/admin/createClient',
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
	};	 

	$scope.updateClient = function (id) {
		
		$http({
			    method: 'PUT', 
			    url: $scope.uri + '/rest/admin/'+id,
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
	};	 

	$scope.cleanClients = function () {
		
		$http({
			    method: 'GET', 
			    url: $scope.uri + '/rest/admin/cleanList',
			    data : angular.toJson($scope.clientForm),
			    
			  }).success(function(data, status, headers, config) {
				  $scope.salida = "Datos elimidos";
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	};	 

	$scope.findClient = function () {
		
		$http({
			    method: 'POST', 
			    url: $scope.uri + '/rest/admin/findClient',
     			data: 'id='+$scope.find
			    
			  }).success(function(data, status, headers, config) {
				  $scope.clientForm.name = data.name;
				  $scope.clientForm.address = data.address;
				  $scope.clientForm.age = data.age;
				  $scope.clientForm.phone = data.phone;
				  $scope.clientForm.dni = data.dni;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	};
	
	$scope.deleteClient = function (id) {
		
		$http({
			    method: 'DELETE', 
			    url: $scope.uri + '/rest/admin/deleteClient/'+id
			    
			  }).success(function(data, status, headers, config) {
				  $scope.salida = data;
			  }).error(function(data, status, headers, config) {
			      alert("Ha fallado la petición. Estado HTTP:"+status);
			  });
	};	 
		
}]);
