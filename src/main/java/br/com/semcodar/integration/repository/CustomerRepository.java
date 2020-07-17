package br.com.semcodar.integration.repository;

import br.com.semcodar.integration.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {

    private RestTemplate restTemplate;

    @Value("${url.mock.list.customers}")
    private String urlMockCustomer;

    @Autowired
    public CustomerRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Customer> findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Customer>> entity = new HttpEntity<List<Customer>>( headers);

        ResponseEntity<List<Customer>> result = restTemplate.exchange(urlMockCustomer, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});

        if(HttpStatus.OK.equals(result.getStatusCode())){
           return result.getBody();
        }

        throw new RestClientException("Error findAll customer");
    }
}
