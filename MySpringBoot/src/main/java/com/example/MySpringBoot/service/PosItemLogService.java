package com.example.MySpringBoot.service;

import java.util.List;

import com.example.MySpringBoot.model.PosItemLog;

public interface PosItemLogService {

	List<PosItemLog> readLog(String itemName);
	
	void updateMemo(Long id);

    void updateLog();
}
