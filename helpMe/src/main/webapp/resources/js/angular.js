angular.module('App', [])
.controller('Categories', ['$scope','$http', function($scope, $http) {
	$scope.refresh = function() {
		$http.get('/helpMe/rest/listCategories').
		success(function(data) {
			$scope.categories = data;
		});
	}

	$scope.add = function(name) {
		$http.post('/helpMe/rest/addCategory', name).
		success(function(data) {
			$scope.refresh();
		});
	};

	}])
.controller('questionsPerCategory', ['$scope','$http', '$location', '$window', function($scope, $http, $location, $window) {
	$scope.init = function(id) {
		$scope.catId = id;
		$http.get('/helpMe/rest/questionsPerCategory/' + id)
		.success(function(data) {
			$scope.questions = data;
		});
	}

	$scope.show = function(id) {
		$window.location.href = '/helpMe/Question/' + id;
	}
	}])
.controller('question', ['$scope','$http', function($scope, $http) {
	$scope.init = function(id) {
		$scope.questionId = id;
		$http.get('/helpMe/rest/Question/' + id)
		.success(function(data) {
			$scope.question = data;
		});
		
	$scope.add = function(newAnswer) {
		$http.post('/helpMe/rest/addAnswer/', newAnswer)
		.success(function(data) {
			$scope.question = data;
		});
	}
	}

	}]);