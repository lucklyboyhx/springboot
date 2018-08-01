package com.example.MySpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.MySpringBoot.model.PosItemLog;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface PosItemLogDao {

	List<PosItemLog> readLog(@Param("itemName")String itemName);

	void updateMemo(Long id);
}
