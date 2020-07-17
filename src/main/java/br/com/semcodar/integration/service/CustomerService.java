package br.com.semcodar.integration.service;

import br.com.semcodar.integration.repository.CustomerRepository;
import br.com.semcodar.integration.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    public List<Customer> findAll(){
        return repository.findAll();
    }
}
