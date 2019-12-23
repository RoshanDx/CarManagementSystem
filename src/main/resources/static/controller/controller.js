
app.controller("MyController", function($scope, $http) {

  $http.get("database/test.json").success(function(data) {
    $scope.DetailArray = data.data;
  }).error(function(data) {
    console.log("there was an error");
  });

  $scope.deleteItem = function(x) {
    //splice the array
    //find the actual position of the element in the array using indexOf
    $scope.DetailArray.splice($scope.DetailArray.indexOf(x), 1);
  }

  $scope.Condition = [{
    Id: 1,
    Name: 'Good'
  }, {
    Id: 2,
    Name: 'Moderate'
  }, {
    Id: 3,
    Name: 'Low'
  }];

  $scope.Status = [{
    Id: 1,
    Name: 'Available'
  }, {
    Id: 2,
    Name: 'Booked'
  }, {
    Id: 3,
    Name: 'Sold'
  }];

  $scope.addCar = function() {

    $scope.DetailArray.push({
      manufacturer: $scope.new.manufacturer,
      model: $scope.new.model,
      price: parseInt($scope.new.price),
      quality: $scope.selectedItem.Name,
      plate: $scope.new.plate,
      status: $scope.selectedStatus.Name,

    });
    $scope.new.manufacturer = "";
    $scope.new.model = "";
    $scope.new.price = "";
    $scope.selectedItem = "";
    $scope.new.plate = "";
    $scope.selectedStatus = "";
  }
});
