package br.com.semcodar.integration.service;

import br.com.semcodar.integration.configuration.SoapClientConfiguration;
import br.com.semcodar.integration.model.Currency;
import br.com.semcodar.integration.repository.CurrencyRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private CurrencyRepository repository;

    public CurrencyService(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfiguration.class);
        this.repository = context.getBean(CurrencyRepository.class);
    }

    public Currency findById(String currencyName){
        return repository.findCurrencyByName(currencyName);
    }
}
