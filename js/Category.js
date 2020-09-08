var app = angular.module("myApp", [ "ngRoute" ]);
// routing
app.config(function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "home.html",

	}).when("/category", {
		templateUrl : "Category.html",
	}).when("/image/:id", {
		templateUrl : "Product.html",
		controller : "categoryctrl"
	}).when("/cart/:id", {
		templateUrl : "Product.html",
		controller : "cartCtrl"
	}).when("/buyproducts/:id", {
		templateUrl : "PlaceOrder.html",
		controller : "placeordercontroller"
	}).when("/buy/:id", {
		templateUrl : "Category.html",
		controller : "buycontroller"
	}).when("/view", {
		templateUrl : "cartcarto.html",
		controller : "viewcartcontroller"
	}).when("/vieworders", {
		templateUrl : "buy.html",
		controller : "vieworderscontroller"
	}).when("/cancel/:id", {
		templateUrl : "cartcarto.html",
		controller : "cancelcontroller"
	}).when("/cancelorder/:id", {
		templateUrl : "buy.html",
		controller : "cancelordercontroller"
	}).when("/signin", {
		templateUrl : "signin.html",

	})

});
var gid = 0;

// controller
app.controller("ExampleController", function($scope, $http) {
	$scope.login1 = function(user) {
		$http({
			method : "POST",
			url : "http://localhost:8080/AngularSpring/login",
			data : {
				"username" : user.name,
				"password" : user.password
			}
		// response 1
		}).then(function mySuccess(response) {
			$scope.myWelcome = response.data;
			gid = $scope.myWelcome;
			if (gid == 0) {
				alert("please enter the correct username and password");
			}
		});
	}
});

app.controller("myCtrl", function($scope, $http) {
	// image category
	$scope.categoryctrl = function($scope, $routeParams, $http) {
		$scope.category($routeParams.id);
	}
	$scope.category = function(id) {
		$http({
			method : "GET",
			url : "http://localhost:8080/AngularSpring/item/mapcategory/" + id
		}).then(function mySuccess(response) {
			$scope.categoryimg = (response.data);

		}, function myError(response) {
			$scope.categoryimg = response.statusText;
		});
	}
	// cart
	// insert into cart table
	$scope.cartCtrl = function($scope, $routeParams, $http) {
		$scope.car = $routeParams.id;
		$scope.cart($scope.car);
	}
	$scope.cart = function(id) {
		if (gid == 0) {
			alert("please login")
		} else {
			$scope.txt = $scope.person;
			$http(
					{
						method : "POST",
						url : 'http://localhost:8080/AngularSpring/cart/' + id
								+ "/" + gid

					}).then(function mySuccess(response) {
				$scope.cart1 = (response.data);
				alert("add to cart");
			}, function myError(response) {
				$scope.cart1 = response.statusText;
			});
		}
	}

	// place order mapping
	$scope.placeordercontroller = function($scope, $routeParams, $http) {
		$scope.placeorder($routeParams.id);
	}
	$scope.placeorder = function(id) {
		if (gid == 0) {
			alert("please login")
		} else {
			$http({
				method : "GET",
				url : 'http://localhost:8080/AngularSpring/item/mapbyid/' + id
			}).then(function mySuccess(response) {
				$scope.order = response.data;
			});
			$http({
				method : "GET",
				url : 'http://localhost:8080/AngularSpring/login/' + gid
			}).then(function mySuccess(response) {
				$scope.cus = response.data;
			});
		}
	}
	// insert into the order table
	$scope.buycontroller = function($scope, $routeParams, $http) {
		$scope.buy($routeParams.id);
	}
	$scope.buy = function(id) {
		$http({
			method : "POST",
			url : 'http://localhost:8080/AngularSpring/order/' + id + "/" + gid
		}).then(function mySuccess(response) {
			$scope.buy1 = (response.data);
			alert("order is placed");
		}, function myError(response) {
			$scope.buy1 = response.statusText;
			alert("error in ordering");
		});
	}

	// delete an item in cart
	$scope.cancelcontroller = function($scope, $routeParams, $http) {
		$scope.cancelcart($routeParams.id);
	}
	$scope.cancelcart = function(id) {
		$http({
			method : "DELETE",
			url : 'http://localhost:8080/AngularSpring/cart/' + id + "/" + gid
		})
		$scope.viewcartcontroller();
	}

	// delete an item in order
	$scope.cancelordercontroller = function($scope, $routeParams, $http) {
		$scope.cancelorder($routeParams.id);
	}
	$scope.cancelorder = function(id) {
		$http({
			method : "DELETE",
			url : 'http://localhost:8080/AngularSpring/order/' + id + "/" + gid

		})
		$scope.vieworderscontroller();
	}
	// view all items in cart button
	$scope.viewcartcontroller = function() {
		if (gid == 0) {
			alert("please login")
		} else {
			$scope.cartgetall = [];
			$http({
				method : "GET",
				url : 'http://localhost:8080/AngularSpring/cart/' + gid
			// response 3
			}).then(function mySuccess(response) {
				$scope.cartgetall = response.data;
			})
		}
	}
	// view all items in order button
	$scope.vieworderscontroller = function() {
		if (gid == 0) {
			alert("please login")
		} else {
			$scope.ordergetall = [];
			$http({
				method : "GET",
				url : 'http://localhost:8080/AngularSpring/order/' + gid
			// response 3
			}).then(function mySuccess(response) {
				$scope.ordergetall = response.data;
			})
		}
	}
});// end of controller

