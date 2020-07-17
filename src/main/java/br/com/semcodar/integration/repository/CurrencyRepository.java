
package br.com.semcodar.integration.repository;


import br.com.semcodar.integration.configuration.exception.InternalServerError;
import br.com.semcodar.integration.mapping.MNBCurrencyUnits;
import br.com.semcodar.integration.model.Currency;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import wsdl.GetCurrencyUnitsRequestBody;
import wsdl.GetCurrencyUnitsResponseBody;
import wsdl.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class CurrencyRepository extends WebServiceGatewaySupport {

	private ObjectFactory objectFactory = new ObjectFactory();

	private static final Logger log = LoggerFactory.getLogger(CurrencyRepository.class);

	public Currency findCurrencyByName(String currencyName){
		log.info("Requesting currency By name= " + currencyName);
		JAXBElement element = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(createRequest(currencyName), new SoapActionCallback("http://www.mnb.hu/webservices/MNBArfolyamServiceSoap/GetCurrencyUnits"));
		GetCurrencyUnitsResponseBody getCurrencyUnitsResponseBody = (GetCurrencyUnitsResponseBody) element.getValue();
		JAXBElement<GetCurrencyUnitsResponseBody> getCurrencyUnitsResponse = objectFactory.createGetCurrencyUnitsResponse(getCurrencyUnitsResponseBody);
		String xml = getCurrencyUnitsResponse.getValue().getGetCurrencyUnitsResult().getValue();
		Integer value = getValue(xml);
		if(value == null) {
			throw new IllegalArgumentException("Unit Currency "+currencyName+" not found");
		}
		return new Currency(currencyName, value);
	}

	private JAXBElement<GetCurrencyUnitsRequestBody> createRequest(String currencyName) {
		GetCurrencyUnitsRequestBody body = objectFactory.createGetCurrencyUnitsRequestBody();
		body.setCurrencyNames(objectFactory.createGetCurrencyUnitsRequestBodyCurrencyNames(currencyName));

		return objectFactory.createGetCurrencyUnits(body);
	}

	private Integer getValue(String xml){
		try {
			JAXBContext jc = JAXBContext.newInstance(MNBCurrencyUnits.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			MNBCurrencyUnits mnbCurrencyUnits = (MNBCurrencyUnits) unmarshaller.unmarshal(new StringReader(xml));
			ElementNSImpl units = (ElementNSImpl) mnbCurrencyUnits.getUnits();
			if(units.getFirstChild() == null){
				return null;
			}
			return Integer.valueOf(units.getFirstChild().getTextContent());
		} catch (JAXBException e) {
			throw new InternalServerError("Error on GET Currency By Name", e);
		}
	}

}
