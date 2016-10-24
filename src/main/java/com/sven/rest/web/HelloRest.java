package com.sven.rest.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/** 
 * @author  Sven 
 * @date 创建时间：2016年10月23日 上午1:31:08 
 * @version 1.0 
 */

@Path("/hello")
public class HelloRest{

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}
}
