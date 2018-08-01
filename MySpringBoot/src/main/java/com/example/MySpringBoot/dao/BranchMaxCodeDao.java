package com.example.MySpringBoot.dao;

import org.apache.ibatis.annotations.Param;

public interface BranchMaxCodeDao {

	Integer readCode(Integer branchNum);
	
	void upateCode(@Param("branchNum")Integer branchNum, @Param("itemCode")Integer itemCode);

	void save(@Param("branchNum")Integer branchNum, @Param("itemCode")Integer itemCode);
}
