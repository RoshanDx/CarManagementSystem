app.controller("vehicleController", function ($scope,$http,dataFactory){
	
	$scope.vehicles = [];
	
	$scope.transmission = [
		{ id: 1,name: 'Manual'}, 
		{ id: 2,name: 'Automatic'}];
	
	$scope.categories = [
		{ id: 1,name: 'Sport'}, 
		{ id: 2,name: 'Luxury'},
		{ id: 3,name: 'Sedan'}];
	
	$scope.vehicleForm = {
			vmanufacturer:"",
			vmodel:"",
			vyear:"",
			vmilleage:"",
			vplate:"",
			vtransmission:$scope.transmission.name,
			vcolor:"",
			vcategory:$scope.categories.name,
			vprice:"",
      };
	
	refreshVehicle();
	
	function refreshVehicle(){
		$http({
		    method: 'GET',
		    url: 'http://localhost:8080/vehicle'
		  }).then(function successCallback(response) {
			  $scope.vehicles = response.data;
		    }, function errorCallback(response) {
		      console.log("ERROR fetching data ");
		    });
	}
	
	$scope.updateVehicle = function(vehicle) {	
		$scope.vehicleForm.vid = vehicle.vid;
		$scope.vehicleForm.vmanufacturer = vehicle.vmanufacturer;
	    $scope.vehicleForm.vmodel = vehicle.vmodel;
	    $scope.vehicleForm.vyear = vehicle.vyear;
	    $scope.vehicleForm.vmilleage = vehicle.vmilleage;
	    $scope.vehicleForm.vplate = vehicle.vplate;
		$scope.vehicleForm.vtransmission = vehicle.vtransmission;	
		$scope.vehicleForm.vcolor = vehicle.vcolor;	
		$scope.vehicleForm.vcategory = vehicle.vcategory;	
		$scope.vehicleForm.vprice = vehicle.vprice;		

	};
	
    $scope.addVehicle = function() {
        
        var method = "";
        var url = "";
        if ($scope.vehicleForm.vid == "") { 
            method = "POST";
            url = '/vehicle';
        } else {
            method = "PUT";
            url = '/vehicle';
        }

        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.vehicleForm),
            headers : {
                 'Content-Type' : 'application/json'
            }
           }).then(function successCallback(response) {
           	alert("Success");
           	refreshVehicle();
           	clearForm();
   	    }, function errorCallback(response) {
   	      console.log("ERROR!");
   	    });
       }

    $scope.deleteVehicle = function(vehicle) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/vehicle/' + vehicle.vid
        }).then(function successCallback(response) {
        	refreshVehicle();
        	console.log("Successfully deleted");
	    }, function errorCallback(response) {
	      console.log("ERROR!");
	    });
    }
    
    function clearForm(){	
    	$scope.vehicleForm.vid = "";
		$scope.vehicleForm.vmanufacturer = "";
	    $scope.vehicleForm.vmodel = "";
	    $scope.vehicleForm.vyear = "";
	    $scope.vehicleForm.vmilleage = "";
	    $scope.vehicleForm.vplate = "";
		$scope.vehicleForm.vtransmission = "";	
		$scope.vehicleForm.vcolor = "";	
		$scope.vehicleForm.vcategory = "";	
		$scope.vehicleForm.vprice = "";		

	};
	
});