package sboot;



        import static org.hamcrest.Matchers.equalTo;
        import static org.junit.Assert.assertThat;

        import java.net.URL;
        import java.util.HashMap;
        import java.util.Map;

        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.test.IntegrationTest;
        import org.springframework.boot.test.SpringApplicationConfiguration;
        import org.springframework.boot.test.TestRestTemplate;
        import org.springframework.http.HttpEntity;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpMethod;
        import org.springframework.http.ResponseEntity;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import org.springframework.test.context.web.WebAppConfiguration;
        import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Applic.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
/**
 * Created by sohail on 19/05/15.
 */
public class FullStackTest1Homepage_Test_Disabled {
    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        System.out.println("-------------------------------------------------  "+this.base );
        template = new TestRestTemplate();
        //template = new TestRestTemplate("user","password");
    }

    @Test
    public void getHello() throws Exception {
        //ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        ResponseEntity<String> response1 = template.getForEntity(base.toString(), String.class);
        System.out.println("----------------::::::-\n\n" + response1 + "\n\nstatus code=" + response1.getStatusCode() + "\n---------------------\n");
        //new TestRestTemplate("user","password").getForEntity()
        Map<String,String> cred = new HashMap<String, String>();
        cred.put("username", "user");
        cred.put("password", "password");
        //new TestRestTemplate().getForEntity(base, HttpMethod.GET, cred);
        //new TestRestTemplate().getForEntity(base, new HttpEntity<Void>(new HttpHeaders()), cred);


        //ResponseEntity<String> z = new TestRestTemplate().getForEntity(base.toString(), String.class, cred);  /DENIED
        ResponseEntity<String> z = template.getForEntity(base.toString(), String.class, cred);
        System.out.println("-==========::-responseentry=\n\n" + z+ "\n body=\n"+z.getBody()+"\n\n---------------------\n");

        z = template.getForEntity(base.toString(), String.class, cred);
        System.out.println(z+ "\n body=\n"+z.getBody()+"\n\n___________\n");



        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        System.out.println("-----------------\n\ngoing to test\n\n\n---------------------\n");
        assertThat(response.getBody(), equalTo("Welcome to BCwd Web App"));
        System.out.println("-----------------\n\ntested\n\n\n---------------------\n");
    //Expected: "Welcome to BCwd Web App" but: was "<html><head><title>Login Page</title></head><body onload='document.f.username.focus();'>\n<h3>Login with Username and Password</h3><form name='
    }
}