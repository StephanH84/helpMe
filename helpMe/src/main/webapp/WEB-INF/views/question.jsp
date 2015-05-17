<!doctype html>
<html>
	<head>
		<title>Categories of helpMe</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script src="/helpMe/resources/js/angular.js"></script>
    	<link rel="stylesheet" href="/helpMe/resources/css/stylesheet.css" type="text/css">
	</head>

	<body ng-app="App">
	<div ng-controller="question" ng-init="init(${questionId})">
		Question {{questionId}}
		<table>
			<thead>
				<td>Title</td>
				<td>Author</td>
				<td>Votes</td>
				<td>Content</td>
			</thead>
			<tr>
				<td>{{question.name}}</td>
				<td>{{question.author.firstName}} {{question.author.lastName}}</td>
				<td>{{question.votes}}</td>
				<td>{{question.text}}</td>
			</tr>
		</table>
		<br>
		Answers:<br>
		<table>
			<thead>
				<td>Author</td>
				<td>Votes</td>
				<td>Content</td>
			</thead>
			<tr ng-repeat="answer in question.answers">
				<td>{{answer.author.firstName}} {{answer.author.lastName}}</td>
				<td>{{answer.votes}}</td>
				<td>{{answer.text}}</td>
			</tr>
		</table>
		Add answer:
		<div ng-init="newAnswer = null">
			<label for="authorEdit">Author ID:</label>
			<input id="authorEdit" type="text" ng-model="newAnswer.authorId" />
		
			<label for="answerEdit">Content:</label>
			<textarea id="answerEdit" ng-model="newAnswer.answerContent"></textarea>
			
	    	<input type="submit" ng-click="add(newAnswer)" value="Add answer" />
		</div>
	</div>
	</body>
</html>