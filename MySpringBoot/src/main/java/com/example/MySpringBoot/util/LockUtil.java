package com.example.MySpringBoot.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LockUtil {
	
	private Map<Integer, String> lockMap = new HashMap<Integer, String>();
	private Integer size = 10000;
	{
		for (int i = 0; i < size; i++) {
			lockMap.put(i, new String("lock_" + i));
		}
	}
	
	public String getLock(Integer branchNum) {
		if (branchNum == null) {
			System.out.println("门店编号不能为空");
		}
		int rest = branchNum % size;
		return lockMap.get(rest);
	}

}
