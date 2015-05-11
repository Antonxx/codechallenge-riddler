package riddler;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ori
 */

@Path("/message/{name}")
@Service
public class MessageResource {

    private IMessageService messageService;

    @Autowired
    public MessageResource(IMessageService messageService) {
        this.messageService = messageService;
    }
    
    private MessageResource() {
        
    }
    
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public MessageResponse greet(@PathParam("name") String name) {
        return messageService.getGreeting(name);
    }
}
