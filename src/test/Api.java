package test;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;

import java.util.ArrayList;

import javax.ws.*;

@Path("api")
public class Api {
	@GET
	@Path("getlinkbilutv")
	@Produces(MediaType.TEXT_PLAIN)
	public String getlinkbilutv(@QueryParam("url") String url) {
		XuLy xl = new XuLy();
		ArrayList<String> result = xl.getLinkBiLuTV(url);
		String json = xl.covertFromStringToJson(result);
		
	    return json;
	}

	@GET
	@Path("getlinkanimehay")
	@Produces(MediaType.TEXT_PLAIN)
	public String getlinkanimehay(@QueryParam("url") String url) {
		XuLy xl = new XuLy();
		String result = xl.getLinkAnimeHay(url);
	
	    return result;
	}
}
