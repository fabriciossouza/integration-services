package br.com.semcodar.integration.repository;


import br.com.semcodar.integration.model.Calculator;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import wsdl.Add;
import wsdl.AddResponse;

@Component
public class CalculatorRepository extends WebServiceGatewaySupport{

	public Calculator calculate(Integer n1, Integer n2) {
		Add request = new Add();
        request.setIntA(n1);
        request.setIntB(n2);
		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Add"));
		return new Calculator(n1, n2, response.getAddResult());
	}
}
