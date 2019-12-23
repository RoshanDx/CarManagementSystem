app.factory('dataFactory',function($http) {
	
    var dataFactory = {};

    dataFactory.getOrders = function () {
        return $http.get('http://localhost:8080/order');
    };
    
    dataFactory.getVehicles = function () {
        return $http.get('http://localhost:8080/vehicle');
    };
    
    dataFactory.getCustomers = function () {
        return $http.get('http://localhost:8080/customer');
    };
    
    dataFactory.getEmployees = function () {
        return $http.get('http://localhost:8080/employee');
    };

    return dataFactory;
});