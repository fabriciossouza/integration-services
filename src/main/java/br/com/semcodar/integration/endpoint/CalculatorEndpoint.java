package br.com.semcodar.integration.endpoint;

import br.com.semcodar.integration.service.CalculatorService;
import br.com.semcodar.integration.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CalculatorEndpoint {

    private CalculatorService service;

    @Autowired
    public CalculatorEndpoint(CalculatorService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/calculate/sum")
    public ResponseEntity<Calculator> findById(@RequestBody Calculator calculator) {
        Calculator calculated = service.calculate(calculator.getN1(), calculator.getN2());
        return ResponseEntity.ok(calculated);
    }
}
