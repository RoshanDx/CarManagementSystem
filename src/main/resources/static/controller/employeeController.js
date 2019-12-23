app.controller("employeeController", function($scope, $http,dataFactory) {
	
	$scope.employees = [];

	$scope.employeeForm = {
			empName:"",
			empRole:"",
			empEmail:"",
			empSalary:"",
            empDepartment:""
      };
	
	refreshEmployee();

	function refreshEmployee() {
	$http({
	    method: 'GET',
	    url: 'http://localhost:8080/employee'
	  }).then(function successCallback(response) {
		  $scope.employees = response.data;
	    }, function errorCallback(response) {
	      console.log("ERROR fetching data ");
	    });
	}
	
	$scope.updateEmployee = function(employee) {	
		$scope.employeeForm.empId = employee.empId;
	    $scope.employeeForm.empName = employee.empName;
	    $scope.employeeForm.empSalary = employee.empSalary;
	    $scope.employeeForm.empRole = employee.empRole;
	    $scope.employeeForm.empEmail = employee.empEmail;
		$scope.employeeForm.empDepartment = employee.empDepartment;	    
	    
	};
		
     $scope.addEmployee = function() {
            
         var method = "";
         var url = "";
         if ($scope.employeeForm.empId == "") {
             method = "POST";
             url = '/employee';
         } else {
             method = "PUT";
             url = '/employee';
         }
 
         $http({
             method : method,
             url : url,
             data : angular.toJson($scope.employeeForm),
             headers : {
                  'Content-Type' : 'application/json'
             }
            }).then(function successCallback(response) {
            	alert("Success");
            	clearForm();
            	refreshEmployee();
    	    }, function errorCallback(response) {
    	      console.log("ERROR!");
    	    });
        }
		
		
    //Delete a customer
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/employee/' + employee.empId
        }).then(function successCallback(response) {
        	refreshEmployee();
        	console.log("Successfully deleted");
	    }, function errorCallback(response) {
	      console.log("ERROR!");
	    });
    }
    
    function clearForm(){
		$scope.employeeForm.empId = "";
		$scope.employeeForm.empName = "";
		$scope.employeeForm.empRole = "";
		$scope.employeeForm.empSalary = "";
		$scope.employeeForm.empEmail = "";
		$scope.employeeForm.empDepartment = "";
    };
    

	
});
