/**
 * Created by Szymon on 2017-02-14.
 */
(function() {
    'use strict';
    angular.module('app').controller('GroupsController',GroupsController);

    GroupsController.$inject=['$http'];

    function GroupsController($http) {
        var vm = this;
        vm.group = {id:null,name:'', users:[]};
        vm.groups = [];
        vm.users = [];
        vm.getAll=getAll;
        vm.deleteGroup=deleteGroup;
        vm.addGroup=addGroup;
        vm.updateGroup=updateGroup;
        vm.submit=submit;
        vm.editGroup=editGroup;
        vm.getAllUsers=getAllUsers;

        init();

        function init() {
            getAll();
            getAllUsers();
        }

        function getAllUsers(){
            var url = "/users/all";
            $http.get(url).then(function (response) {
                vm.users=response.data;
            });
        }

        function getAll() {
            var url="/groups/all";
            $http.get(url).then(function (response) {
                vm.groups = response.data;
            });
        }

        function deleteGroup(id){
            var url = "/groups/delete/"+id;
            $http.delete(url).then(function (response) {
                vm.groups=response.data;
                getAll();
            });
        }

        function addGroup(newGroup){
            var url="/groups/add";
            $http.post(url,newGroup).then(function (response) {
                vm.groups=response.data;
                getAll();
            });
        }

        function updateGroup(group,id){
            var url="/groups/update/"+id;
            $http.post(url,group).then(function () {
                getAll();
            });
        }

        function editGroup(id){
            for(var i=0;i<vm.groups.length;i++){
                if(vm.groups[i].id===id){
                    vm.group=angular.copy(vm.groups[i]);
                    break;
                }
            }
        }

        function submit() {
            if(vm.group.id===null){
                addGroup(vm.group);
            }
            else {
                updateGroup(vm.group,vm.group.id);
            }
            reset();
        }

        function reset(){
            vm.group={id:null,name:'',users:[]};
        }





    }

})();