//package com.example.MySpringBoot;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.example.MySpringBoot.util.DistributedLock;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = {Application.class})
//@WebAppConfiguration
//public class MybatisCacheTest {
//
////	@Resource
////	private PosItemLogService posItemLogService;
//	
//	@Test
//	public void testLock(){
//	    DistributedLock lock   = new DistributedLock("127.0.0.1:2181","lock");
//        lock.lock();
//        //共享资源
//        if(lock != null)
//         lock.unlock();  
//
//	}
//    
//	static int n = 5000;
//
//    public static void secskill() {
//        System.out.println(--n);
//    }
//
//    public static void main(String[] args) {
//        
//        Runnable runnable = new Runnable() {
//            public void run() {
//                DistributedLock lock = null;
//                try {
//                    lock = new DistributedLock("127.0.0.1:2181", "test1");
//                    lock.lock();
//                    secskill();
//                } finally {
//                    if (lock != null) {
//                        lock.unlock();
//                    }
//                }
//            }
//        };
//
//        for (int i = 0; i < 300; i++) {
//            Thread t = new Thread(runnable);
//            t.start();
//        }
//    }
//
//}
