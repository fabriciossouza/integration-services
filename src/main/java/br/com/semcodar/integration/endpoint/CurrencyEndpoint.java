package br.com.semcodar.integration.endpoint;

import br.com.semcodar.integration.model.Currency;
import br.com.semcodar.integration.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rs")
public class CurrencyEndpoint {

    private CurrencyService service;

    @Autowired
    public CurrencyEndpoint(CurrencyService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/currency/{name}")
    public ResponseEntity<Currency> findById(@PathVariable final String name) {
        Currency currency = service.findById(name);
        return ResponseEntity.ok(currency);
    }
}
