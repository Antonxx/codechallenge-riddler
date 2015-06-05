var app = angular.module('myApp', []);
app.controller('namesCtrl', function($scope, $http) {

    $scope.messageCount = 0;
    $scope.lastMessage = " ";

    $scope.create = function() {
        if($scope.name){
            $http({
                method: 'POST',
                url: '/messages/names/' + $scope.name,
                headers: {'Content-Type': 'text/plain'} ,
                data: {}
                    })  .success(function(data, status, headers, config){})
                        .error(function(data, status, headers, config){
                            alert( "Exception details: " + JSON.stringify({data: data}));
                         });
        }
        $scope.name = "";

    }

    $scope.show = function() {
        $http.get("/messages/recent")
        .success(function(response) {
            $scope.messageCount = response.messageCount;
            $scope.lastMessage = response.lastMessage;
            $scope.messages = response.messages;
            });
    }

});