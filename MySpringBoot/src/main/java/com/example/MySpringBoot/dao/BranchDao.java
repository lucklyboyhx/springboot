package com.example.MySpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.MySpringBoot.model.Branch;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface BranchDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
	List<Branch> list(@Param("branchNums")List<Integer> branchNums);
}
