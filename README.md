PRE-REQUISITO:
1 - JAVA 8
2 - MAVEN > 3


COMO EXECUTAR O PROJETO:
$ mvn clean package
$ mvn spring-boot:run


### OBS
Postam --> Pasta Postam.
Os Testes componente está no diretorio /src/main/test



REQUISITO PROJETO:
- Implementar no projeto a exposição de uma api REST que retorne uma lista de clientes mokada (criar um json de resposta mockado/fake de retorno).
- Implementar uma api que consulte um SOAP que retornará uma moeda, passando como parâmetro nome de uma moeda que será recebido via query param ou path param (decisão fica a critério do candidato).
  *WSDL: http://www.mnb.hu/arfolyamok.asmx?WSDL
  *Metodo / Operação: GetCurrencyUnits
- Entregar as chamadas de teste no Postman

