
package br.com.semcodar.integration.configuration;

import br.com.semcodar.integration.repository.CalculatorRepository;
import br.com.semcodar.integration.repository.CurrencyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPaths("wsdl");
		return marshaller;
	}

	@Bean
	public CalculatorRepository calculator(Jaxb2Marshaller marshaller) {
		CalculatorRepository repository = new CalculatorRepository();
		repository.setDefaultUri("http://www.dneonline.com/calculator.asmx?wsdl");
		repository.setMarshaller(marshaller);
		repository.setUnmarshaller(marshaller);
		return repository;
	}

	@Bean
	public CurrencyRepository currency(Jaxb2Marshaller marshaller) {
		CurrencyRepository currencyRepository = new CurrencyRepository();
		currencyRepository.setDefaultUri("http://www.mnb.hu/arfolyamok.asmx?wsdl=wsdl0");
		currencyRepository.setMarshaller(marshaller);
		currencyRepository.setUnmarshaller(marshaller);
		return currencyRepository;
	}

}
