package riddler;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author ori
 */
public class RiddlerApp extends ResourceConfig {

    public RiddlerApp() {
        new MessageDao().createTable();
    }
}
