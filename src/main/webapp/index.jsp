<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="accountManagerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Account Manager</title>
<link href='resources/css/style.css' rel="stylesheet" type="text/css" />
<link href='resources/css/css/font-awesome.css' rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<script data-require="angular.js@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular.js"></script>
  <script data-require="angular-animate@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular-animate.js"></script>
<script type="text/javascript" src="resources/js/app.js"></script>
</head>
<body>

<div ng-controller="accountManagerController">
<h2 class="page-title">Transportal: Accounts</h2>
	<div id="acc-panel" class="fadein fadeout showpanel panel"  ng-show="toggle">
		<div class="panel-heading">
			<i class="panel-title-icon fa fa-accounts"></i>
			<span class="panel-title">Recent Accounts</span>
			<div class="panel-heading-controls">
				<button ng-click="toggle = !toggle" class="btn-panel">Add New Account</button>
				<button class="btn-panel" confirmed-click="archiveAccounts()" ng-confirm-click="Would you like to archive accounts?">Clear Accounts</button>
			</div>
		</div>
		<div class="panel-body">
			<div class="acc" ng-repeat="account in accounts">
				<span ng-if="account.accType=='HIGH'" class="priority priority-red">
					{{account.accType}}
				</span>
				<span ng-if="account.accType=='MEDIUM'" class="priority priority-yellow">
					{{account.accType}}
				</span>
				<span ng-if="account.accType=='LOW'" class="priority priority-green">
					{{account.accType}}
				</span>
				<div class="action-checkbox">
					<input id="{{account.accId}}" type="checkbox" value="{{account.accId}}" ng-checked="selection.indexOf(account.accId) > -1" ng-click="toggleSelection(account.accId)" />
	  				<label for="{{account.accId}}"></label>
				</div>
				<div ng-if="account.accStatus=='COMPLETED'">
					<a href="#" class="checkedClass">
						{{account.loggin}}
                        <span class="action-status">{{account.email}}</span>
					    <span class="action-status">{{account.accStatus}}</span>
					</a>
				</div>
				<div ng-if="account.accStatus=='ACTIVE'">
					<a href="#" class="uncheckedClass">
						{{account.loggin}}
                        <span class="action-status">{{account.email}}</span>
						<span class="action-status">{{account.accStatus}}</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div id="add-account-panel" class="fadein fadeout addpanel panel" ng-hide="toggle">
		<div class="panel-heading">
			<i class="panel-title-icon fa fa-plus"></i>
			<span class="panel-title">Add Account</span>
			<div class="panel-heading-controls">
				<button ng-click="toggle = !toggle" class="btn-panel">Show All Accounts</button>
			</div>
		</div>
		<div class="panel-body">
			<div class="acc" >
				<table class="add-acc">
					<tr>
						<td>Account login:</td>
						<td><input type="text" ng-model="loggin"/></td>
					</tr>
					<tr>
						<td>Account email:</td>
						<td><input type="text" ng-model="email"/></td>
					</tr>
					<tr>
						<td>Accaunt Status:</td>
						<td>
							<select ng-model="accStatus" ng-options="status as status for status in statuses">
								<option value="">-- Select --</option>						
						     	</select>
						</td>
					</tr>
					<tr>
						<td>Account Type:</td>
						<td>
							<select ng-model="accType" ng-options="priority as priority for priority in priorities">
								<option value="">-- Select --</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><br/><button ng-click="addAccount()" class="btn-panel-big">Add New Account</button></td>
					</tr>
				</table>								
			</div>
		</div>
	</div>
</div>
</body>
</html>