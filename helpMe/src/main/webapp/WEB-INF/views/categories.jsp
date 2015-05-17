<!doctype html>
<html>
	<head>
		<title>Categories of helpMe</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script src="resources/js/angular.js"></script>
	</head>

	<body ng-app="App">
	Categories of helpMe <br>
	<div ng-controller="Categories" ng-init="refresh()">
		<div ng-repeat="cat in categories">
  			<a ng-href="/helpMe/Category/{{cat.id}}">{{cat.id}}: {{cat.name}}</a>
		</div>
		<br>
		Add new category: <br>
		<form novalidate class="simple-form">
			Name: <input type="text" ng-model="name" />
	    	<input type="submit" ng-click="add(name)" value="Add" />
		</form>
	</div>
	</body>
</html>