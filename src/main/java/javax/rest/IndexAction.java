package javax.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.rest.entity.MyData;
import javax.servlet.http.HttpServletResponse;

@Path("/")
public class IndexAction {
	@GET
	@Path("/loadMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MyData> loadList(@Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<MyData> datas = new ArrayList<MyData>();
		datas.add(new MyData(1, "test1"));
		datas.add(new MyData(2, "test2"));
		datas.add(new MyData(3, "test3"));
		return datas;
	}

	@POST
	@Path("/putMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public void put(@FormParam("message") String message) {
		MyData myData = new MyData();
		myData.setMessage(message);
		System.out.println("message = " + message);
		// put Message
	}
}
