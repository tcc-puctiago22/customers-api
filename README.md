# customers-api
mysql.server start
mvn clean install -DskipTests

http://localhost:8080/customers/actuator

## Operations
This table shows a list of the current supported operations and the ones that still need implementation.

| Operation				   | Code | Implemented |
| ------------------------ | ---- | ----------- |
| equal 				   | eq   |	Yes      	|
| not equal 			   | neq  |	No			|
| greater than 			   | gt	  |	Yes 		|
| greater than or equal to | gte  |	No 			|
| less than 			   | lt	  |	Yes 		|
| less than or equal to	   | lte  |	No 			|
| in 					   | in   |	No 			|
| not in 				   | nin  |	No 			|
| between 				   | btn  |	No 			|
| like 					   | like |	No	 		|

So on a browser you can call the endpoint `http://localhost:8080/customers/v1/providers?query=firstName:eq:John:AND,age:gt:25:AND` and will see the result:


/providers 
    colaborador / prestador
    médicos, enfermeiros, fisioterapeutas, dentistas e outros profissinais da área de saúde

/partners 
    conveniados
    laboratórios, hospitais e clínicas que prestam serviço aos usuários da operadora
          
/associates 
    associado
    clientes

https://github.com/RafaelLeoni/generic-specifications#readme.md