<!doctype html>
<html>
	<head>
		<title>Categories of helpMe</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script src="/helpMe/resources/js/angular.js"></script>
    	<link rel="stylesheet" href="/helpMe/resources/css/stylesheet.css" type="text/css">
	</head>

	<body ng-app="App">
	<div ng-controller="questionsPerCategory" ng-init="init(${catId})">
		Questions for category {{catId}}<br>
		<table>
		<thead>
			<td>Title</td>
			<td>Author</td>
			<td>Votes</td>
			<td>Categories</td>
			<td></td>
		</thead>
		<tr ng-repeat="question in questions">
			<td>{{question.name}}</td>
			<td>{{question.author.firstName}} {{question.author.lastName}}</td>
			<td>{{question.votes}}</td>
			<td><div ng-repeat="cat in question.categories">{{cat.name}}</div></td>
			<td>
			<input type="submit" ng-click="show(question.id)" value="Show" />
		</td>
		</tr>
		</table>
	</div>
	</body>
</html>