package br.com.semcodar.integration.endpoint;

import br.com.semcodar.integration.model.Customer;
import br.com.semcodar.integration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rs")
public class CustomerEndpoint {

    private CustomerService service;

    @Autowired
    public CustomerEndpoint(CustomerService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public ResponseEntity<List<Customer>> findById() {
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok(customers);
    }
}
