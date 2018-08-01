package com.example.MySpringBoot.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MySpringBoot.conveter.BranchConveter;
import com.example.MySpringBoot.dto.BranchDTO;
import com.example.MySpringBoot.model.Branch;
import com.example.MySpringBoot.model.PosItemLog;
import com.example.MySpringBoot.service.BranchService;
import com.example.MySpringBoot.service.DistRibutLockService;
import com.example.MySpringBoot.service.PosItemLogService;
import com.example.MySpringBoot.util.LockUtil;
import com.example.MySpringBoot.util.RedisUtilNew;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping("/api")
public class AppRestController {

    @Autowired
    private BranchService branchService;
    
    @Autowired
    private DistRibutLockService distRibutLockService;
    
    @Autowired
    private PosItemLogService posItemLogService;
    
    @Resource
    private LockUtil lockUtil; 
    
    public static ThreadLocal<String> t1 = new ThreadLocal<String>();

    @RequestMapping(method = RequestMethod.POST, value = "/branch", consumes="application/json")
    public List<BranchDTO> list(@RequestBody List<Integer> branchNums) {
    	List<Branch> branchs = branchService.list(branchNums);
        return (List<BranchDTO>) BranchConveter.createDTOs(branchs);
    }
    
    //分布式锁
    @RequestMapping(method = RequestMethod.POST, value = "/distributlock")
    public Integer distributLock() {
        Integer branchNum = 10084;
        t1.set(UUID.randomUUID().toString());
        synchronized (lockUtil.getLock(branchNum)) {
            while (!RedisUtilNew.getLock("JEDIS_TEST_LOCK"+ branchNum.toString(), t1.get(), 10)) {
                try {  
                    Thread.sleep(100);
                } catch (InterruptedException e) {  
                    e.printStackTrace();   
                }  
            }
        }
        
        System.out.println("获取锁：" + t1.get());
        try {
            return distRibutLockService.distributLock(branchNum);
        } catch (Exception e) {
            System.out.println("操错失败");
        } finally {
            System.out.println("释放锁：" + t1.get());
            RedisUtilNew.releaseDistributedLock("JEDIS_TEST_LOCK"+ branchNum.toString(), t1.get());
        }
        return null;
        
    }
    
    //分布式锁
    @RequestMapping(method = RequestMethod.POST, value = "/distributlock2")
    public Integer distributLock2() {
        Integer branchNum = 10085;
        t1.set(UUID.randomUUID().toString());
        synchronized (lockUtil.getLock(branchNum)) {
            while (!RedisUtilNew.getLock("JEDIS_TEST_LOCK"+ branchNum.toString(), t1.get(), 10)) {
                try {  
                    Thread.sleep(100);
                } catch (InterruptedException e) {  
                    e.printStackTrace();   
                }  
            }
        }
        
        System.out.println("获取锁：" + t1.get());
        try {
            return distRibutLockService.distributLock(branchNum);
        } catch (Exception e) {
            System.out.println("操错失败");
        } finally {
            System.out.println("释放锁：" + t1.get());
            RedisUtilNew.releaseDistributedLock("JEDIS_TEST_LOCK"+ branchNum.toString(), t1.get());
        }
        return null;
    }
    
  //mybatis二级缓存
    @RequestMapping(method = RequestMethod.POST, value = "/mybatiscache")
    public List<PosItemLog> mybatisCache() {
        List<PosItemLog> posItemLogs = posItemLogService.readLog("盘0反审核");
        System.out.println(">>>>>>>>>>>>>>");
        posItemLogs = posItemLogService.readLog("盘0反审核");
        return posItemLogs;
    }
    
    //缓存移除
    @RequestMapping(method = RequestMethod.POST, value = "/mybatiscache/remove")
    public void mybatisCacheRm() {
        System.out.println("ccc");
        posItemLogService.updateLog();
    }
    
  //分布式锁
    @RequestMapping(method = RequestMethod.POST, value = "/distributlock/int")
    public void distributLockInt() {
        distRibutLockService.distributLockInt();
    }
}
