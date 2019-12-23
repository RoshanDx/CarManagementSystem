app.config(['$routeProvider', function($routeProvider){

$routeProvider

  .when('/dashboard',{
    templateUrl: 'views/dashboard.html',
    controller: 'MyController'
  })
  .when('/order',{
	templateUrl: 'views/order.html',
	controller: 'orderController'
		
  })  
  .when('/orderdetails',{
	templateUrl: 'views/orderdetails.html',
	controller: 'orderController'
		
  })    
  .when('/customer',{
	templateUrl: 'views/customer.html',
	controller: 'customerController'
		
  })
  .when('/vehicle',{
	templateUrl: 'views/vehicle.html',
	controller: 'vehicleController'
		
  })
  .when('/employee',{
	templateUrl: 'views/employee.html',
	controller: 'employeeController'
		
  })

  .otherwise({
    redirectTo: '/dashboard'
  });

}]);
