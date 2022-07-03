# syss-test

=========================================================================================================



***Ferramentas usadas para o teste***

==>       Java 8, Spring Boot 2.7.1 e MongoDB.

***Instruções para executar o programa e algumas explicações***

==>       Para executar o programa, importe a pasta "syssemployeesystem" para alguma
IDE de desenvolvimento Java como Eclipse ou Spring Tool Suite e (faça os imports, se for necessário) execute a classe **SyssemployeesystemApplication.java** desse diretório: **/syssemployeesystem/src/main/java/com/syss/syssemployessystem/SyssemployeesystemApplication.java**

==>       No diretório **/syssemployeesystem/src/main/resources/application.properties**, está a configuração **spring.data.mongodb.uri=mongodb://localhost:27017/syssemployees** que define um endereço padrão para um banco de dados NoSQL MongoDB com o nome de **syssemployees** e um collection chamado **employee**(definido na classe **Employee.java**), os testes funcionaram com o banco conectado e registrando os dados passados pelo Postman e também sem o banco, caso teste sem o banco, apenas delete o endereço **spring.data.mongodb.uri=mongodb://localhost:27017/syssemployees** em **application.properties** que funcionará perfeitamente. 

==>       Recomento que use o Postman para fazer os testes, pois nele, está funcionando as 4 operações básicas do CRUD (GET, POST, PUT(UPDATE) e DELETE), insira o localhost que aparecerá no terminal após executar o programa, geralmente por padrão, o localhost está definido na porta 8080. Os dados dos funcionários estarão no formato JSON, para inserir um novo funcionário ou atualizar seus dados, use esse formato no body:

{
    "id": "String",
    "name": "String",
    "email": "String",
    "department": "String",
    "salary": Double,
    "birth_date": "String"
}

==>       Em **/syssemployeesystem/src/main/java/com/syss/syssemployessystem/controller/EmployeeController.java** está o código definindo os paths para a execução dos métodos da API, ficou definido assim:

GET: http://localhost:(porta)/employees         (Lista todos os funcionários)
POST: http://localhost:(porta)/employees        (Insere um novo funcionário)
PUT(UPDATE) http://localhost:(porta)/id         (Atualiza os dados de um funcionário por id)
GET: http://localhost:(porta)/id                (Retorna os dados de um funcionário por id)
DELETE: http://localhost:(porta)/id             (Deleta os dados de um funcionário por id)


***Bugs e erros***

==>      Infelizmente, devido a alguns erros, certas requisições não puderam ser implementadas, como a busca por maior/menor idade e salário, pois os métodos sempre retornavam erro 400 no Postman. Tentei implementar no Swagger(http://localhost:8080/swagger-ui/index.html#/), porém estão funcionando apenas as operações GET e POST.


==>      A autenticação não deu certo, o Postman não deixava as operações POST, PUT(UPDATE) e DELETE serem realizadas, por conta disso, criei uma classe em **/syssemployeesystem/src/main/java/com/syss/syssemployessystem/config/EmployeeConfig.java** que desabilita o CSRF e permite novamente que essas operações sejam realizadas. Quando executar o programa, o terminal retornará uma senha para a autenticação para um usuário padrão "user", mas ela não será necessária.


=========================================================================================================
