package com.sven.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author Sven
 * @date 创建时间：2016年10月23日 下午7:23:06
 * @version 1.0
 */
public class RestClient {

	public static void main(String[] argc) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/rest/webapi").path("/hello");

		String result = target.request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(result);
	}
}
