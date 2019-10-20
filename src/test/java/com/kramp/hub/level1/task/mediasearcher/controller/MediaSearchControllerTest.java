package com.kramp.hub.level1.task.mediasearcher.controller;


import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.kramp.hub.level1.task.mediasearcher.model.MediaItems;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MediaSearchControllerTest {
    
    @LocalServerPort
    private int port;
    
    TestRestTemplate restTemplate = new TestRestTemplate();
    
	@Test
    public void testGetMedia() throws Exception {
      
        ResponseEntity<MediaItems> response = restTemplate.getForEntity
        		(createURLWithPort("/media") + "?searchString=friends", MediaItems.class);

        assertThat(response.getBody().getTotalItems() == 10, Matchers.is(true));

    }    

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;

    }
	
}
