/**
 * Created by Szymon on 2017-02-13.
 */
(function(){
    'use strict';

    angular.module('app').controller('UsersController',UsersController);

    UsersController.$inject = ['$http'];

    function UsersController($http) {
        var vm = this;
        vm.user = {id:null,login:'',password:'',firstName:'',lastName:'',dateOfBirth:'',groups:[]};
        vm.users = [];
        vm.getAll = getAll;
        vm.deleteUser = deleteUser;
        vm.addUser = addUser;
        vm.edit=edit;
        vm.submit=submit;
        vm.updateUser=updateUser;


        init();

        function init() {
            getAll();
        }


        function getAll() {
            var url = "/users/all";
            var users = $http.get(url);

            users.then(function (response) {
                vm.users = response.data;
            });
        }

        function deleteUser(id) {
            var url = "/users/delete/" + id;
            $http.delete(url).then(function (response) {
                getAll();
                vm.users = response.data;
            });
        }


        function addUser(newUser) {
            var url = "/users/add";
            $http.post(url, newUser).then(function (response) {
                vm.users = response.data;
                getAll();
            });
        }

        function updateUser(user,id) {
            var url ="/users/update/" + id;
            $http.post(url,user).then(function(response){
                getAll();
            });
        }

        function edit(id){
            for(var i=0;i<vm.users.length;i++){
                if(vm.users[i].id===id){
                    vm.user=angular.copy(vm.users[i]);
                    break;
                }
            }
        }

        function submit(){
            if(vm.user.id===null){
                addUser(vm.user);
            }
            else{
                updateUser(vm.user,vm.user.id);
            }
            reset();
        }


        function reset() {
            vm.user = {id: null, login: '', password: '', firstName: '', lastName: '', dateOfBirth: ''};
        }

    }

})();