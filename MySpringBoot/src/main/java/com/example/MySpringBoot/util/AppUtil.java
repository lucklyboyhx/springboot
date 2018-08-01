package com.example.MySpringBoot.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

public class AppUtil {

	@Autowired    
	private static HttpComponentsHttpInvokerRequestExecutor httpInvokerRequestExecutor; 
	 
	@Value("${service.remoteurl}")
	private static String serviceUrl; //支付服务器地址
	private static Map<String, HttpInvokerProxyFactoryBean> httpInvokerProxyFactoryBeans = new HashMap<String, HttpInvokerProxyFactoryBean>();

	
	@SuppressWarnings("rawtypes")
	public static Object createServiceObject(Class cls, String serviceUrl) {
		if (serviceUrl == null) {
			serviceUrl = AppUtil.serviceUrl;
		}

		HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = httpInvokerProxyFactoryBeans
				.get(cls.getSimpleName() + "|" + serviceUrl);
		if (httpInvokerProxyFactoryBean == null) {
			httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
			httpInvokerProxyFactoryBean.setServiceInterface(cls);
			String className = cls.getSimpleName();
			String pre = className.substring(0, 1);
			String last = className.substring(1);
			httpInvokerProxyFactoryBean
					.setServiceUrl(serviceUrl + pre.toLowerCase() + last);
			
			httpInvokerProxyFactoryBean
					.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor);
			httpInvokerProxyFactoryBean.afterPropertiesSet();
			httpInvokerProxyFactoryBeans.put(
					cls.getSimpleName() + "|" + serviceUrl,
					httpInvokerProxyFactoryBean);
		}
		return httpInvokerProxyFactoryBean.getObject();

	}
}
