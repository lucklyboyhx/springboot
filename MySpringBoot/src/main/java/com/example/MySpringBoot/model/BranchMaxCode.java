package com.example.MySpringBoot.model;

import java.io.Serializable;

public class BranchMaxCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1179175043570076713L;
	private String branchNum;
	private String itemCode;
	public String getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(String branchNum) {
		this.branchNum = branchNum;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	
}
