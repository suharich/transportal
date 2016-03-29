var accountManagerApp = angular.module('accountManagerApp', ['ngAnimate']);

accountManagerApp.controller('accountManagerController', function ($scope,$http) {
	
	var urlBase="http://localhost:8080";
	$scope.toggle=true;
	$scope.selection = [];
	$scope.statuses=['ACTIVE','COMPLETED'];
	$scope.priorities=['HIGH','LOW','MEDIUM'];
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	
	//get all tasks and display initially
	$http.get(urlBase+'/accounts').
    	success(function(data) {
	        $scope.accounts = data;
	        for(var i=0;i<$scope.accounts.length;i++){
                if($scope.accounts[i].accStatus=='COMPLETED'){
	           	 $scope.selection.push($scope.accounts[i].accId);
	        }
	        }

    })
        .error(function(data){
            alert('ERROR while get data from service!');
        });

    /*$http.get(urlBase+'/tasks').then(
        function successCallback(response) function(data){
            $scope.tasks = data;
            for(var i=0;i<$scope.tasks.length;i++){
                if($scope.tasks[i].taskStatus=='COMPLETED'){
                    $scope.selection.push($scope.tasks[i].taskId);
    }, function errorCallback(response) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
    });*/
	
	//add a new task
	$scope.addAccount = function addAccount() {
		if($scope.loggin=="" || $scope.email=="" || $scope.accType == "" || $scope.accStatus == ""){
			alert("Insufficient Data! Please provide values for task name, description, priortiy and status");
		}
		else{
		 $http.post(urlBase + '/accounts/insert/' +$scope.loggin+'/'+$scope.email+'/'+$scope.accType+'/'+$scope.accStatus).
		  success(function(data) {
			 alert("Account added");
			 $scope.accounts = data;
			 $scope.loggin="";
			 $scope.email="";
			 $scope.accType="";
			 $scope.accStatus="";
			 $scope.toggle='!toggle';			 
		    });
		}
	};
		
	// toggle selection for a given task by task id
	  $scope.toggleSelection = function toggleSelection(accId) {
	    var idx = $scope.selection.indexOf(accId);

	    // is currently selected
	    if (idx > -1) {
	      $http.post(urlBase + '/accounts/' +accId+'/ACTIVE').
		  success(function(data) {
			 alert("Account unmarked");
			 $scope.accounts = data;
		    });
	      $scope.selection.splice(idx, 1);
	    }

	    // is newly selected
	    else {
	      $http.post(urlBase + '/accounts/' +accId+'/COMPLETED').
		  success(function(data) {
			 alert("Account marked completed");
			 $scope.accounts = data;
		    });
	      $scope.selection.push(accId);
	    }
	  };
	  
	
	// Archive Accounts
	  $scope.archiveAccounts = function archiveAccounts() {
		  $http.post(urlBase + '/accounts/archive/' + $scope.selection).
		  success(function(data) {
			  $scope.accounts = data;
		       alert("Successfully Archived");
		    });
	  };
	
});

//Angularjs Directive for confirm dialog box
accountManagerApp.directive('ngConfirmClick', [
	function(){
         return {
             link: function (scope, element, attr) {
                 var msg = attr.ngConfirmClick || "Are you sure?";
                 var clickAction = attr.confirmedClick;
                 element.bind('click',function (event) {
                     if ( window.confirm(msg) ) {
                         scope.$eval(clickAction);
                     }
                 });
             }
         };
 }]);