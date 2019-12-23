app.controller("orderController", function ($scope,$http,dataFactory){
	
	$scope.orders=[];
	$scope.vehicles=[];
	$scope.customers=[];
	$scope.employees=[];
	
	getOrders();

    function getOrders() {
        dataFactory.getOrders()
            .then(function (response) {
                $scope.orders = response.data;
            }, function (error) {
            	console.log("ERROR fetching data ");
            });
    }
    
    getVehicles();
    
    function getVehicles() {
        dataFactory.getVehicles()
            .then(function (response) {
                $scope.vehicles = response.data;
            }, function (error) {
            	console.log("ERROR fetching data ");
            });
    }
    
    getCustomers();
    
    function getCustomers() {
        dataFactory.getCustomers()
            .then(function (response) {
                $scope.customers = response.data;
            }, function (error) {
            	console.log("ERROR fetching data ");
            });
    }
    
    getEmployees();    
    function getEmployees() {
    	dataFactory.getEmployees()
            .then(function (response) {
                $scope.employees = response.data;
            }, function (error) {
            	console.log("ERROR fetching data ");
            });
    }
    

    
 /////////////////////////////////////////////////////
    $scope.selectVehicle={};
    
    //add to cart
    $scope.cartProduct = [];
    $scope.finalTotal = 0;
    $scope.addToCart = function () {

        $scope.cp = {};
        $scope.cp = $scope.selectVehicle;
        $scope.cp.subTotal =$scope.cp.vprice;
        

        if ($scope.cartProduct.length === 0) {
            $scope.cartProduct.push($scope.cp);
            $scope.finalTotal += $scope.cp.subTotal;
            
        } else if ($scope.cartProduct.length > 0) {
            for (var i = 0; i < $scope.cartProduct.length; i++) {
                if ($scope.cartProduct[i].vid === $scope.cp.vid) {
                    alert("Item already available in Cart");
                    break;
                }
            }
            if (i === $scope.cartProduct.length) {
                $scope.cartProduct.push($scope.cp);
                $scope.finalTotal += $scope.cp.subTotal;
            }
        } 

    };
    
    $scope.getTotalAmount = function() {
    var i=0,sum = 0;
    	for (i=0; i < $scope.orders.length; i++) {
    		sum += +$scope.orders[i].total;
    	}
    	return sum;
    }
    
    $scope.removeProduct = function (product) {
    	$scope.finalTotal -= product.vprice;
        $scope.removableProduct = product;
        $scope.value = -1;
        $scope.value = $scope.cartProduct.indexOf($scope.removableProduct);
        if ($scope.value >= 0) {
            $scope.cartProduct.splice($scope.value, 1);
        }
        
        
    };
   
    //Add order
    $scope.checkOut = function () {
    	
        $scope.order = {
                "date": $scope.date,
                "total":  $scope.finalTotal,
                "vehicles":  $scope.cartProduct,
                "customer": $scope.selectCustomerName,
                "employee": $scope.selectEmployee
            }
        
        
        $http({
    	    method: 'POST',
    	    url: 'http://localhost:8080/order',
    	    data: angular.toJson($scope.order),
            headers: {
                'Content-Type': 'application/json'
            }	    
    	  }).then(function successCallback(response) {
    		  alert("Success");
    	    }, function errorCallback(response) {
    	      console.log(response);
    	    });

    };

    //Delete order
    $scope.deleteOrder = function(order) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/order/' + order.oid
        }).then(function successCallback(response) {
        	getOrders();
        	console.log("Successfully deleted");
	    }, function errorCallback(response) {
	      console.log("ERROR!");
	    });
    }

});