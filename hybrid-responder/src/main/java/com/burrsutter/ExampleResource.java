package com.burrsutter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {

    private String hostname =
       System.getenv().getOrDefault("HOSTNAME", "unknown");

    private String cloud =
       System.getenv().getOrDefault("CLOUD_KEY", "unknown");

    private int count = 0;

    @GET
    @Produces(MediaType.TEXT_PLAIN)    
    public String greet() {
        count++;
        StringBuffer response = new StringBuffer();
        response.append("{");
        response.append("\"hello\":\"Aloha\",");
        response.append("\"cloud\":\"" + cloud + "\",");
        response.append("\"pod\":\"" + hostname + "\",");
        response.append("\"count\":" + count);
        response.append("}\n");
        return response.toString();
    }
}