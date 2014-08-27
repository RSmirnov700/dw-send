package com.dyn.api.dw.resources;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.api.ResponseMessage;

@Path("/send")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SendMessageResource {
	
	 @POST
	    public ResponseMessage send(@Valid RequestMessage message) {
	        return new ResponseMessage(1, message.getApiKey(), message.getSubject());
	    }

}
