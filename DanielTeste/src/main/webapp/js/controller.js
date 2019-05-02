angular.module("myApp",[]).controller("PessoaController", function($scope, $http) {
		
		
			$scope.pessoas = [];
			$scope.pessoaForm = {
				id : null,
				nome : "",
				email : "",
				cpf : "",
				ativo : false,
				sexo :"",
				dtNascimento:""
				
			};
			
			_refreshPessoaData();
			
			$scope.salvarPessoa = function(isValid){
				if(isValid){
					
					 var method = "";
	                 var url = "";               
	                 if ($scope.pessoaForm.id == null) {
	                     method = "POST";
	                     url = '/pessoa/';
	                 } else {
	                     
	                     method = "PUT";
	                     url = '/pessoa/'+$scope.pessoaForm.id;
	                 }
	      
	                 $http({
	                     method : method,
	                     url : url,
	                     data : angular.toJson($scope.pessoaForm),
	                     headers : {
	                         'Content-Type' : 'application/json'
	                     }
	                 }).then( _success, _error );
					}
                 };
                 
                 
                 $scope.deletarPessoa = function(pessoa) {
                     $http({
                         method : 'DELETE',
                         url : '/pessoa/' + pessoa.id
                     }).then(_success, _error);
                 };
  
			 function _refreshPessoaData() {
                 $http({
                     method : 'GET',
                     url : 'http://localhost:8080/pessoa/'
                 }).then(function successCallback(response) {
                     $scope.pessoas = response.data;
                 }, function errorCallback(response) {
                     console.log(response.statusText);
                 });
             };
			
			  function _success(response) {
				  _refreshPessoaData();
                  _clearFormData();
              };
       
              function _error(response) {
                  console.log(response.statusText);
              }
       
            
              function _clearFormData() {
                  $scope.pessoaForm.id = null;
                  $scope.pessoaForm.nome = "";
                  $scope.pessoaForm.email = "";
                  $scope.pessoaForm.cpf = null;
                  $scope.pessoaForm.dtNascimento = null;
                  $scope.pessoaForm.sexo = "";
                  $scope.pessoaForm.estadoCivil = "";
                  $scope.pessoaForm.ativo = false;
              };
			
			
                $scope.editPessoa = function(pessoa) {
                	var data = new Date( pessoa.dtNascimento);
                	$scope.pessoaForm.id = pessoa.id;
                    $scope.pessoaForm.nome = pessoa.nome;
                    $scope.pessoaForm.email = pessoa.email
                    $scope.pessoaForm.cpf = pessoa.cpf;
                    $scope.pessoaForm.dtNascimento = data;
                    $scope.pessoaForm.sexo = pessoa.sexo;
                    $scope.pessoaForm.estadoCivil = pessoa.estadoCivil;
                    $scope.pessoaForm.ativo = pessoa.ativo;
                }; 
                
                $scope.buscarPorCpf = function(cpf){
                	 var method = "";
                     var url = ""; 
                     $http({
                         method : 'GET',
                         url : 'http://localhost:8080/pessoa/cpf/' + cpf
                     }).then(function successCallback(response) {
                         $scope.pessoas = response.data;
                     }, function errorCallback(response) {
                         console.log(response.statusText);
                     });                         
                     
                }
                
                $scope.buscarPorNome = function(nome){
               	 var method = "";
                    var url = ""; 
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8080/pessoa/nome/' + nome
                    }).then(function successCallback(response) {
                        $scope.pessoas = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });                         
                    
               }
         
            });

