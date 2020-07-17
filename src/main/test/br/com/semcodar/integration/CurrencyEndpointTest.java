package br.com.semcodar.integration;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CurrencyEndpointTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void shouldReturnCurrencyIfFound() throws Exception {
        String uri = "/rs/currency/BRL";
        String jsonExpected = "{'name':'BRL','value':1}";
        mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }

    @Test
    public void shouldReturnBadRequestIfNotFound() throws Exception {
        String uri = "/rs/currency/AAAAA";
        String jsonExpected = "{'message':'Unit Currency AAAAA not found'}";
        mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(jsonExpected));
    }
}
