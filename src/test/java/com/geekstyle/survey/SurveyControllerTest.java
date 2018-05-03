package com.geekstyle.survey;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.geekstyle.survey.model.survey.Survey;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyControllerTest {

	@LocalServerPort
    private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testInsertSurvey() throws Exception {
        Survey survey = new Survey();
        survey.setName("John");
        assertThat(restTemplate.postForEntity("http://localhost:" + port + "/survey", survey, HashMap.class).toString()).contains("John");
    }
}