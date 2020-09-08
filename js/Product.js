
var app = angular.module("myApp", [ "ngRoute" ]);
//routing
app.config(function($routeProvider) {
	console.log("vvvvvvvvvvvvvvvv")
	 $routeProvider.when("/cart/:id", {
	        templateUrl :"buy.html",
	        	 controller : "cartCtrl"
	    }).when("/buy/:id", {
     templateUrl : "buy.html",
     controller : "buycontroller"
    		    }).when("/cancel/:id/:cusid", {
    		        templateUrl : "cancel.html",
    		        controller : "cancelcontroller"
    		       		    }).when("/cancelorder/:id/:cusid", {
    		    		        templateUrl : "cancel.html",
    		    		        controller : "cancelordercontroller"
    		    		       		    }).when("/category", {
    		    		       		     templateUrl : "tv.html",
    		    		       		   
    		    		       		    		    }).when("/img/:id", {
    		    		       		     templateUrl : "buy.html",
    		    		       		  controller : "categoryctrl"
    		    		       		    		    })
    			
	
});

    //controller
    
app.controller("myCtrl", function($scope, $http) { 


	 $scope.myWelcome = [];
  $http({
    method : "GET",
      url : "http://localhost:8080/AngularSpring/category"
    	  //response 1
  }).then(function mySuccess(response) {
    $scope.myWelcome = response.data;
 	console.log($scope.myWelcome.categoryid)
 	 $http({
    method : "GET",
      url : "http://localhost:8080/AngularSpring/item/mapoffer"
    	  //response 1
  }).then(function mySuccess(response) {
    $scope.allelectronics= response.data;
  });
 	
 	
 	
 		  //created fun
    $scope.category = function(id) {
    
   	 $scope.myWelcome1 = [];
   	console.log(id)
    $http({
      method : "GET",
        url : "http://localhost:8080/AngularSpring/product/mapping/"+id
  	  //response 2
    }).then(function mySuccess(response) {
      $scope.myWelcome1 = response.data;
   
      $http({
    	    method : "GET",
    	      url : "http://localhost:8080/AngularSpring/item/mapcategory/"+id
    	    	  //response 1
    	  }).then(function mySuccess(response) {
    	    $scope.allelectronics1= response.data;
    	  });
    	 	
   
   	  //created fun
      $scope.product = function(id1) {
      
     	 $scope.myWelcome2 = [];
     	console.log("productid"+id1)
      $http({
        method : "GET",
          url : "http://localhost:8080/AngularSpring/item/mapping/"+id1
          //response 3
      }).then(function mySuccess(response) {
        $scope.myWelcome2 = response.data;
        
        
  
      },
      //error 3
      function myError(response) {
          $scope.myWelcome2 = response.statusText;
        });
        }
     	
        },
    //error 2
    function myError(response) {
      $scope.myWelcome1 = response.statusText;
    });
    }
 	
    
  },
  //error 1
  function myError(response) {
    $scope.myWelcome = response.statusText;
  });
//routing controller

//insert into cart table
  $scope.cartCtrl=function($scope, $routeParams, $http){
	  
	  $scope.car=$routeParams.id;
	console.log("11111111111111")
	  $scope.cart($scope.car);
	
  }
  
  $scope.cart= function(id) {
	  console.log("111111111111112222222222")
      $scope.txt;
      $scope.person = prompt("Please enter your id:", 101);
      if ($scope.person == null || $scope.person == "") {
          $scope.txt = "User cancelled the prompt.";
      } else {
          $scope.txt = $scope.person;
   console.log('http://localhost:8080/AngularSpring/cart/'+id+"/"+$scope. txt);
          $http(
                  {
                	   method : "POST",
           	        url : 'http://localhost:8080/AngularSpring/cart/'+id+"/"+$scope. txt         
                            
                  }).then(function mySuccess(response) {
              $scope.cart1 = (response.data);
              console.log("1111111111111122222222222233333333333")
          }, function myError(response) {
              $scope.cart1 = response.statusText;
          });
      }
  }
  


  
 
  

//insert into the order table
  $scope.buycontroller=function($scope, $routeParams, $http){
	 
	  $scope.buy($routeParams.id);
}
  $scope.buy= function(id) {
   
      $scope.txt;
      $scope.person = prompt("Please enter your id:", 101);
      if ($scope.person == null || $scope.person == "") {
          $scope.txt = "User cancelled the prompt.";
      } else {
          $scope.txt = $scope.person;
       
          $http(
                  {
                	  method : "POST",
          	        url : 'http://localhost:8080/AngularSpring/order/'+id+"/"+$scope.txt             
                            
                  }).then(function mySuccess(response) {
              $scope.buy1 = (response.data);
              

          }, function myError(response) {
              $scope.buy1 = response.statusText;
          });
          $http({
  	        method : "GET",
  	        url : 'http://localhost:8080/AngularSpring/order/mapping/'+id+"/"+$scope.person             
  	    }). then(function mySuccess(response) {
  	      
  	        $scope.order = response.data;
  	    }, function myError(response) {
  	        console.log('failed :::::'+response)
  	        $scope.order = response.statusText;
  	    });
      }
  }
  
  //delete an item in cart
  $scope.cancelcontroller=function($scope, $routeParams, $http){

	  $scope.cancelcart($routeParams.id,$routeParams.cusid);
	 
  }
  $scope.reloadRoute = function() {
	   $route.reload();
	}

  $scope.cancelcart= function(id,cusid) {
   
    
   
          $http(
                  {
                	   method : "DELETE",
           	        url : 'http://localhost:8080/AngularSpring/cart/'+id+"/"+cusid        
                            
                  })
             
                  $scope.cartfunction ();
       
      }
  
  //delete an item in order
  $scope.cancelordercontroller=function($scope, $routeParams, $http){
	
	
	  $scope.cancelorder($routeParams.id,$routeParams.cusid);
  }
  $scope.cancelorder= function(id,cusid) {
	   
	    
	   
      $http(
              {
            	   method : "DELETE",
       	        url : 'http://localhost:8080/AngularSpring/order/'+id+"/"+cusid        
                      
              })
       
              $scope.orderfunction ();

  }

  //view all items in cart button

$scope.cartfunction = function() {
	console.log("cart")
	   $scope. person = prompt("enter the customer id", " ");

	$scope.cartgetall = [];
 
  $http({
    method : "GET",
      url : 'http://localhost:8080/AngularSpring/cart/'+$scope.person   
      //response 3
  }).then(function mySuccess(response) {
    $scope.cartgetall = response.data;
    
    $scope.reloadRoute();
    
   
  })
  }
//view all items in order button
$scope.orderfunction = function() {
	console.log("order")
	   $scope.person = prompt("enter the customer id", " ");

	$scope.ordergetall = [];
 
  $http({
    method : "GET",
      url : 'http://localhost:8080/AngularSpring/order/mappingcust/'+$scope.person    
      //response 3
  }).then(function mySuccess(response) {
    $scope.ordergetall = response.data;
    
    $scope.reloadRoute();  
    
  })
  }
//image category
$scope.categoryctrl=function($scope, $routeParams, $http){
	  console.log("111111111111112222vvvvvvvvvvvvghjjjjjjjjjj222222")
	  
	 
	  $scope.category($routeParams.id);
	
}

$scope.category= function(id) {
	  console.log("111111111111112222222222")
 
   
	  $http({
  	    method : "GET",
  	      url : "http://localhost:8080/AngularSpring/item/mapcategory/"+id
  	    	  //response 1
  	  }).then(function mySuccess(response) {
  	    $scope.category= response.data;
  	  });
    }




});//end of controller
  
  
  
  
  
  

	 




