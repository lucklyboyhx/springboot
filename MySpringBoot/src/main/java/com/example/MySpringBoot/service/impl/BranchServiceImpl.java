package com.example.MySpringBoot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MySpringBoot.dao.BranchDao;
import com.example.MySpringBoot.model.Branch;
import com.example.MySpringBoot.service.BranchService;
import com.example.MySpringBoot.util.RedisUtilNew;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDao branchDao;
    
//    @Autowired
//    private RedisUtil redisUtil;

	@SuppressWarnings("unchecked")
	@Override
    public List<Branch> list(List<Integer> branchNums) {
    	
    	List<Branch> branchs = new ArrayList<Branch>();
    	if (branchs == null || branchs.size() == 0) {
    		branchs = (List<Branch>) RedisUtilNew.get("TEST_BRANCH");
    		if (branchs != null && branchs.size() > 0) {
    			return branchs;
    		}
			
		}
    	branchs = branchDao.list(branchNums);
    	RedisUtilNew.put("TEST_BRANCH", branchs, 60 * 60);
        return branchs;
    }

}
