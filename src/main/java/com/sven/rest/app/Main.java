package com.sven.rest.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;

/** 
 * @author  Sven 
 * @date 创建时间：2016年10月23日 下午6:31:11 
 * @version 1.0 
 */
public class Main {

    public static void main(String[] argc) throws IllegalArgumentException, IOException {  
        final String baseUri = "http://localhost:9998/";  
        final Map<String, String> initParams = new HashMap<String, String>();  
        initParams.put("jersey.config.server.provider.packages",  
                "com.sven.rest.app");  
        System.out.println("Starting grizzly...");  
        HttpServer server  = GrizzlyWebContainerFactory.create(baseUri, initParams); 
        System.out.println(String.format(  
                "Jersey app started with WADL available at %sapplication.wadl\n"  
                        + "Try out %shelloworld\nHit enter to stop it...",  
                baseUri, baseUri));  
        System.in.read();  
        server.shutdown();
        System.exit(0);  
    }
}
