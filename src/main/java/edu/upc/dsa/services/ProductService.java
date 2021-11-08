package edu.upc.dsa.services;


import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/Products", description = "Endpoint to Track Service")
@Path("/Products")
public class ProductService {

    private ProductManager scenario;

    public ProductService() {
        scenario = ProductManagerImpl.getInstance();
        scenario.addProduct(new Product("agua", 1, 10));
        scenario.addProduct(new Product("llet", 2, 5));
        scenario.addProduct(new Product("pa", 0.5, 15));
        scenario.addProduct(new Product("patata", 3, 8));
        scenario.addProduct(new Product("donut", 2.2, 20));
        scenario.addProduct(new Product("cafe", 5.0, 18));
        scenario.addProduct(new Product("bocata", 6.4, 13));

        scenario.addUser("Laura", "123");
        scenario.addUser("Alba", "231");
        scenario.addUser("Pau", "321");

        Order order = new Order(scenario.getUser("Pau"));
        order.addLP(new Product("pa", 0.5, 4));
        order.addLP(new Product("donut",2.2,2));
        order.addLP(new Product("cafe",5.0,1));
        order.addLP(new Product("bocata",6.4,1));
        scenario.doOrder(order);
    }



    @POST
    @ApiOperation(value = "Add a new product", notes = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {

        if (product.getName()==null || product.getAmount()==0 ) return Response.status(500).entity(product).build();
        this.scenario.addProduct(product);
        return Response.status(201).entity(product).build()  ;

    }

    @POST
    @ApiOperation(value = "Create a new Order", notes = "Create a new Order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Order.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/doOrder/")
    @Consumes(MediaType.APPLICATION_JSON)

    public Response doOrder(Order order) {
        Order order2 = new Order(this.scenario.getUser(order.user.getName()));
        if (order2.getUser() == null) return Response.status(500).entity(order).build(); // solo funciona con usuarios ya establecido mas arriba!
        this.scenario.doOrder(order2);
        return Response.status(201).entity(order).build();
    }

    @GET
    @ApiOperation(value = "Get products by price", notes = "Get products by price")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/ProductsByPrice/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByPrice() {
        List<Product> list = scenario.getProductsByPrice();
        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(list) {};
        if (list.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get products by Sales", notes = "Get products by sales")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/ProductsBySales/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsBySales() {
        List<Product> list = scenario.getProductsBySales();
        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(list) {};
        if (list.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get order by users", notes = "Get order by users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = OrderTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })

    @Path("/OrderByUsers/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersByUser(@PathParam("user") String user) {
        List<Order> list = scenario.getOrdersByUser(user);
        if (list.size() == 0) return Response.status(404).build();

        System.out.println(list.toArray());
        //
        List<OrderTO> aux = new ArrayList<OrderTO>();

        for (Order o: list) {
            aux.add(new OrderTO(o));
        }



        GenericEntity<List<OrderTO>> entity = new GenericEntity<List<OrderTO>>(aux) {};
        return Response.status(201).entity(entity).build()  ;

        /*
        GenericEntity<List<Track>> entity = new GenericEntity<List<Track>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;
        */

    }

/*
    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })

    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }



    @PUT
    @ApiOperation(value = "New order", notes = "New order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }
*/




}