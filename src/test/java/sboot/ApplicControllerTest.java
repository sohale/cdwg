package sboot;

//Note: the package needed is spring-boot-starter-test and NOT spring-test and NOT junit.
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sboot.endpoints.HomePageREST;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        //mvc = MockMvcBuilders.standaloneSetup(new ApplicControllerTest()).build();
        // Wrong class. It should be the endpoint class. Why did this compile then?

        mvc = MockMvcBuilders.standaloneSetup(new HomePageREST()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo
                                ("Welcome to BCwd Web App")
                        //("Greetings from Spring Boot!")
                ));
    }
}