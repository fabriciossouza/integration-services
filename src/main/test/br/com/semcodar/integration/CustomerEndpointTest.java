package br.com.semcodar.integration;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerEndpointTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void shouldReturnAllCustomers() throws Exception {
        String uri = "/rs/customers";
        String jsonExpected = "[{'id':1,'name':'Jose Maria','cpf':'05249509545','rg':'564565550','age':19},{'id':2,'name':'Felipe Santos','cpf':'73156073741','rg':'54345559','age':24},{'id':3,'name':'Ronaldo Jose','cpf':'49576402891','rg':'8459450004','age':46}]";
        mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }
}
