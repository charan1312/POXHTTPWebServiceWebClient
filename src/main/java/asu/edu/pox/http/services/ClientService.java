package asu.edu.pox.http.services;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Service
public class ClientService {

    private WebResource webResource; 
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/POX-FoodMenu-caware1-Eclipse/restservices/FoodItem";
    
    public ClientService() {
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI);
    }
    
    public ClientResponse postFoodItemRequest(String foodItemRequest) throws UniformInterfaceException{
        //String output = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(String.class,foodItemRequest);
        ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(ClientResponse.class,foodItemRequest);
        return clientResponse;
    }
     
    public void close() {
        client.destroy();
    }
}
