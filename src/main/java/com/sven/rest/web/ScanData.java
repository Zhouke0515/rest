package com.sven.rest.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

/**
 * @author Sven
 * @date 创建时间：2016年10月24日 上午12:22:19
 * @version 1.0
 */
@Path("/")
public class ScanData {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test";
	}

	/**
	 * PathPara URL:http://localhost:8080/rest/webapi/getuser/zhangs
	 * 
	 * @param name
	 * @return
	 */
	@GET
	@Path("/getuser")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser(@PathParam("name") String name) {
		return name;
	}

	/**
	 * QueryParam
	 * URL:http://localhost:8080/rest/webapi/getage?username=zhangs&age=25
	 * 
	 * @param username
	 * @param age
	 * @return
	 */
	@GET
	@Path("/getage")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAge(
			@DefaultValue("noName") @QueryParam("username") String username,
			@DefaultValue("26") @QueryParam("age") int age) {
		return "username:" + username + "\n" + "age:" + age;
	}

	@POST
	@Path("/scandata")
	/*
	 * @Consumes 与 @Produces 相反，用来指定可以接受client发送过来的MIME类型，
	 * 同样可以用于class或者method，
	 * 也可以指定多个MIME类型，一般用于 @PUT，@POST 。
	 */
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	/*
	 * @Produces 注释用来指定将要返回给client端的数据标识类型（MIME）。@Produces
	 * 可以作为class注释，也可以作为方法注释，方法的 @Produces 注释将会覆盖class的注释。
	 */
	// POST请求使用Consumers
	public String scandata(@FormParam("PART_NO") String partNo) {
		JSONObject json = new JSONObject();
		json.put("PART_NO", partNo);
		// json.put("date", new Date());
		return json.toString();
	}

	@POST
	@Path("/postdata")
	@Consumes(MediaType.TEXT_PLAIN)
	// POST请求使用Consumers
	public String postdata() {
		return "post method request data";
	}
}
