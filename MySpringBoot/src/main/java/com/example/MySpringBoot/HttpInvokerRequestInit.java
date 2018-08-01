package com.example.MySpringBoot;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;

public class HttpInvokerRequestInit {

	@Autowired
    private CloseableHttpClient httpClient;
	
    @Bean    
    public HttpComponentsHttpInvokerRequestExecutor httpInvokerRequestExecutor(){    
        HttpComponentsHttpInvokerRequestExecutor bean = new HttpComponentsHttpInvokerRequestExecutor();         
        //httpClient.setConnectionTimeout(1000);    
        //httpClient.setTimeout(2000);    
        bean.setHttpClient(httpClient);  
        
        return bean;    
    }    
}
