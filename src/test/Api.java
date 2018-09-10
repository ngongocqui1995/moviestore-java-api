package test;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;

import javax.ws.*;

@Path("api")
public class Api {
	@GET
	@Path("getlinkzingtv")
	@Produces(MediaType.TEXT_PLAIN)
	public String getlinkzingtv(@QueryParam("url") String url) {
		XuLy xl = new XuLy();
		String result = xl.getLinkZingTV(url);
	
	    return result;
	}
	
	@GET
	@Path("getlinkanimehay")
	@Produces(MediaType.TEXT_PLAIN)
	public String getlinkanimehay(@QueryParam("url") String url) {
		XuLy xl = new XuLy();
		String result = xl.getLinkAnimeHay(url);
	
	    return result;
	}
	
	@GET
	@Path("getlinkphimmoi")
	@Produces(MediaType.TEXT_PLAIN)
	public String getlinkphimmoi(@QueryParam("url") String url) {
		XuLy xl = new XuLy();
		String result = xl.getLinkPhimMoi(url);
	
	    return result;
	}
}
