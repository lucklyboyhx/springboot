package com.example.MySpringBoot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MySpringBoot.dao.PosItemLogDao;
import com.example.MySpringBoot.model.PosItemLog;
import com.example.MySpringBoot.service.PosItemLogService;

@Service("posItemLogService")
public class PosItemLogServiceImpl implements PosItemLogService{

	@Resource
	private PosItemLogDao posItemLogDao;
	
	@Override
	@Transactional
	public List<PosItemLog> readLog(String itemName) {
		long begin = System.currentTimeMillis();
		List<PosItemLog> posItemLogs1 = posItemLogDao.readLog(itemName);
		long end = System.currentTimeMillis();
		long begin1 = System.currentTimeMillis();
		List<PosItemLog> posItemLogs2 = posItemLogDao.readLog(itemName);
		long end1 = System.currentTimeMillis();
		System.out.println("首次请求/二级缓存请求时间：" + (end - begin) + "ms" + "    size:" + posItemLogs1.size());
		System.out.println("一级缓存请求时间：" + (end1 - begin1) + "ms" + "   size:" + posItemLogs2.size());
		return posItemLogs1;
	}

	@Override
	public void updateMemo(Long id) {
		posItemLogDao.updateMemo(id);
	}

    @Override
    public void updateLog() {
        updateMemo(308614L);
    }

}
