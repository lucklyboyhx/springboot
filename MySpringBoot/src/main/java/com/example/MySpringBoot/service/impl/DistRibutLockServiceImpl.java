package com.example.MySpringBoot.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MySpringBoot.dao.BranchMaxCodeDao;
import com.example.MySpringBoot.service.DistRibutLockService;
import com.example.MySpringBoot.util.RedisUtilNew;

@Service("distRibutLockService")
public class DistRibutLockServiceImpl implements DistRibutLockService{

	@Autowired
	private BranchMaxCodeDao branchMaxCodeDao;
	
	public static ThreadLocal<String> t1 = new ThreadLocal<String>();

	@Override
	public Integer distributLock(Integer branchNum) {
	    Integer itemCode = branchMaxCodeDao.readCode(branchNum);
        if (itemCode == null) {
            itemCode = 10000;
            branchMaxCodeDao.save(branchNum, itemCode);
        }else {
            itemCode = itemCode + 1;
        }
        branchMaxCodeDao.upateCode(branchNum, itemCode);
        System.out.println(itemCode);
        return itemCode;
	}

	private static int count= 0;
    @Override
    public void distributLockInt() {
        for(int i=0; i<1000; i++){

            new Thread(new Runnable() {

                @Override

                public void run() {
                    add();
                }

            }).start();

        }

    }
    
    public static void add(){
        t1.set(UUID.randomUUID().toString());
            while (!RedisUtilNew.getLock("JEDIS_TEST_LOCK_INT", t1.get(), 10)) {
              try {  
                  Thread.sleep(200);
              } catch (InterruptedException e) {  
                  e.printStackTrace();   
              }  
          }
        
        for (int j = 0; j < 10; j++) {
            count++;
        }
        System.out.println(DistRibutLockServiceImpl.count);
        RedisUtilNew.releaseDistributedLock("JEDIS_TEST_LOCK_INT", t1.get());
    }
}
