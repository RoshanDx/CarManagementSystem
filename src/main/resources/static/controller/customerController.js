app.controller("customerController", function($scope, $http,dataFactory) {
	
	$scope.customers = [];
	
	$scope.items = [
		{ id: 1,name: 'Male'}, 
		{ id: 2,name: 'Female'}];

	$scope.customerForm = {
			custName:"",
			custAddress:"",
			custPhone:"",
			custEmail:"",
            custGender:$scope.items.name
      };
	
	refreshCustomer();
  
	// Get all customer
	function refreshCustomer() {
	$http({
	    method: 'GET',
	    url: 'http://localhost:8080/customer'
	  }).then(function successCallback(response) {
		  $scope.customers = response.data;
	    }, function errorCallback(response) {
	      console.log("ERROR fetching data ");
	    });
	}
	//Add customer
//	$scope.addCustomer = function() {
//	$http({
//	    method: 'POST',
//	    url: 'http://localhost:8080/customer',
//	    data: angular.toJson($scope.customerForm),
//        headers: {
//            'Content-Type': 'application/json'
//        }	    
//	  }).then(function successCallback(response) {
//      	console.log("Successfully added");
//	    }, function errorCallback(response) {
//	      console.log("ERROR!");
//	    });
//	};
	
	//Bind the customer data to the input form
	$scope.updateCustomer = function(customer) {	
		$scope.customerForm.custId = customer.custId;
	    $scope.customerForm.custName = customer.custName;
	    $scope.customerForm.custAddress = customer.custAddress;
	    $scope.customerForm.custPhone = customer.custPhone;
	    $scope.customerForm.custEmail = customer.custEmail;
		$scope.customerForm.custGender = customer.custGender;	    
	    
	};
	
	
//	$scope.updatedCustomer = function(customer) {
//		$http({
//		    method: 'PUT',
//		    url: 'http://localhost:8080/customer',
//		    data: angular.toJson($scope.customerForm),
//	        headers: {
//	            'Content-Type': 'application/json'
//	        }	    
//		  }).then(function successCallback(response) {
//	      	console.log("Successfully updated");
//		    }, function errorCallback(response) {
//		      console.log("ERROR!");
//		    });
//		};
		
		
     $scope.addCustomer = function() {            
         var method = "";
         var url = "";
         if ($scope.customerForm.custId == "") {
             //create new customer 
             method = "POST";
             url = '/customer';
         } else {
             //update customer 
             method = "PUT";
             url = '/customer';
         }
 
         $http({
             method : method,
             url : url,
             data : angular.toJson($scope.customerForm),
             headers : {
                  'Content-Type' : 'application/json'
             }
            }).then(function successCallback(response) {
            	alert("Success");
            	clearForm();
            	refreshCustomer();
    	    }, function errorCallback(response) {
    	      console.log("ERROR!");
    	    });
        }
		
		
    //Delete a customer
    $scope.deleteCustomer = function(customer) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/customer/' + customer.custId
        }).then(function successCallback(response) {
        	refreshCustomer();
        	console.log("Successfully deleted");
	    }, function errorCallback(response) {
	      console.log("ERROR!");
	    });
    }
    
    function clearForm(){
		$scope.customerForm.custId = "";
	    $scope.customerForm.custName = "";
	    $scope.customerForm.custAddress = "";
	    $scope.customerForm.custPhone = "";
	    $scope.customerForm.custEmail = "";
		$scope.customerForm.custGender = "";
    	
    };
//        success: function(data, status, headers, config) {
//            toastr.info(data);
//            cb(null, data);
//          },
//          error: function(data, status) {
//            cb(data);
//          }
        
	

	
});
