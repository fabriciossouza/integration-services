package br.com.semcodar.integration.service;

import br.com.semcodar.integration.configuration.SoapClientConfiguration;
import br.com.semcodar.integration.model.Calculator;
import br.com.semcodar.integration.repository.CalculatorRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private CalculatorRepository repository;

    public CalculatorService(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfiguration.class);
        this.repository = context.getBean(CalculatorRepository.class);
    }

    public Calculator calculate(Integer n1, Integer n2){
        return repository.calculate(n1, n2);
    }
}
