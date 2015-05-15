angular.module("riddlerApp", []).controller("riddlerController", function ($http) {
    vm = this;

    vm.lastMessage = "";
    vm.messageCount = "";
    vm.messages = "";

    this.submitName = function (name) {
        $http.post("/messages/names/" + name);
    };

    this.getRecent = function () {
        $http.get("/messages/recent").success(function (data) {
            vm.lastMessage = data.lastMessage;
            vm.messageCount = data.messageCount;
            vm.messages = data.messages;
        });
    };
});

