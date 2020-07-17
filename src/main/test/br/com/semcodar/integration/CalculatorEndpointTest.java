package br.com.semcodar.integration;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CalculatorEndpointTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void shouldReturnSumTwoNumbers() throws Exception {
        String uri = "/api/calculate/sum";
        String jsonExpected = "{'n1':10,'n2':5,'total':15}";
        mvc.perform(MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        " \"n1\": 10,\n" +
                        " \"n2\": 5\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }
}
