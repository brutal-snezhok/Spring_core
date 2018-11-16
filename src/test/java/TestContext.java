import beans.Client;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestContext {

    @Test
    public void testPropertyPlaceholderSystemOverride() {
        System.setProperty("client.id", "35");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Client client = ctx.getBean(Client.class);
        ctx.close();

        assertEquals("35", client.getId());
    }
}