package main;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

@Path("/hello")
public class MyResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
      return "Jersey Jetty example.";
  }

  @Path("/{username}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public User hello(@PathParam("username") String name) {

      User obj = new User();
      obj.setId(new Random().nextInt(1000));
      obj.setName(name);
      return obj;
  }

  @Path("/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> helloList() {

      List<User> list = new ArrayList<User>();

      User obj1 = new User();
      obj1.setId(new Random().nextInt(1000));
      obj1.setName(new Faker().name().firstName());
      list.add(obj1);

      User obj2 = new User();
      obj2.setId(new Random().nextInt(1000));
      obj2.setName(new Faker().name().firstName());
      list.add(obj2);

      return list;
  }
//  protected HashMap <String[], Integer> getNewData()
//  {
//      //////////////////////////////////////////
//      HashMap<String[], Integer> result = new HashMap<String[], Integer>();
//      Faker faker;
//      int temp = 0;
//      while(temp < 10)
//      {
//          faker = new Faker();
////          String name = faker.name().fullName();
//          String firstName = faker.name().firstName();
//          String lastName = faker.name().lastName();
////          String streetAddress = faker.address().streetAddress();
////          result.put(firstName, new Random().nextInt(10000000) + 1000000);
//          result.put(new String[]{firstName, lastName}, new Random().nextInt(10000000) + 1000000);
//          temp++;
//      }
//      return result;
//  }
}
