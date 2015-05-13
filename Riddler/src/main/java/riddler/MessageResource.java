package riddler;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

@Path("/messages")
@Service
public class MessageResource {

    private IMessageService messageService;

    @Autowired
    public MessageResource(IMessageService messageService) {
        this.messageService = messageService;
    }
    
    @POST
    @Path("/names/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Message greet(@PathParam("name") String name) {
        return messageService.greet(name);
    }
    
    @GET
    @Path("/recent")
    @Produces(MediaType.APPLICATION_JSON)
    public RecentMessagesResponse getRecentMessages() {
        return messageService.getRecentMessages();
    }
}
