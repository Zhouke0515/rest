package com.sven.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven
 * @date 创建时间：2016年10月24日 下午2:10:13
 * @version 1.0
 */
public class ScanDataTest {

	private Client client;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/rest/webapi");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHello() {
		// target = target.path("/hello");
		String result = target.path("/hello").request(MediaType.TEXT_PLAIN)
				.get(String.class);

		assertEquals("hello", result);
	}

	@Test
	public void testGetUser() {
		String username = target.path("/getuser/zhangs")
				.request(MediaType.TEXT_PLAIN).get(String.class);

		assertEquals("zhangs", username);
	}

	@Test
	public void testGetAge() {
		String userInfo = target.queryParam("username", "zhangs")
				.queryParam("age", 20).path("/getage")
				.request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(userInfo);
		assertNotNull(userInfo);
	}

	@Test
	public void testPostData() throws IOException {
		Response response = target.path("/postdata").request(MediaType.TEXT_PLAIN)
				.post(Entity.entity("post data", MediaType.TEXT_PLAIN));
		System.out.println(response);
		System.out.println(response.getStatus());
		System.out.println(response.getStatusInfo());
		System.out.println(response.getStringHeaders());
		InputStream entity = (InputStream) response.getEntity();
		
		int in = 0;
		while((in = entity.read()) !=-1) {
			System.out.print((char)in);
		}
		
		
		assertEquals(200, response.getStatus());
	}

	@Test
	public void testScandata() {
		Entity<String> entity = Entity.entity("PART_NO", MediaType.TEXT_PLAIN);
		Response response = target.path("/scandata").request(MediaType.TEXT_PLAIN)
				.post(entity);
		System.out.println(response);
		System.out.println(response.getStatus());
		System.out.println(response.getStatusInfo());
		assertEquals(200, response.getStatus());
	}
}
