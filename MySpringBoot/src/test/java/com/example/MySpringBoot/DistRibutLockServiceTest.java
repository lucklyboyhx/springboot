package com.example.MySpringBoot;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.MySpringBoot.service.DistRibutLockService;
import com.example.MySpringBoot.util.DateUtil;

//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
public class DistRibutLockServiceTest{
	
	@Resource
	private DistRibutLockService distRibutLockService;
	@Test
	public void testLock(){
		System.out.println(DateUtil.getMillisStr());
		for (int i = 0; i < 2; i++) {
//			Integer code = distRibutLockService.distributLock(10084);
//			System.out.println(code);
			new Thread(){
				@Override
				public void run(){
					System.out.println("aaa");
//					distRibutLockService.distributLock(10084);
				}
			}.start();
		}
		System.out.println(DateUtil.getMillisStr());
	}
	
	class MyThread extends Thread{  
	    //2):在A类中覆盖Thread类中的run方法.  
	    public void run() {  
	        //3):在run方法中编写需要执行的操作
	    	System.out.println(111);
	    	Integer code = distRibutLockService.distributLock(10084);
	    	System.out.println(code);
	    }  
	} 
	
	@Autowired
    private CallBackSender sender;

 

    @Test
    public void topic() throws Exception {

        sender.send("topic.baqgl.admin.1", "测试消息");

    }
}
