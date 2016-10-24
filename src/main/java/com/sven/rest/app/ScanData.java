package com.sven.rest.app;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/** 
 * @author  Sven 
 * @date 创建时间：2016年10月23日 下午6:32:00 
 * @version 1.0 
 */
@Path("/scandata")
public class ScanData {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String appRest() {
		return "appRest";
	}
}
