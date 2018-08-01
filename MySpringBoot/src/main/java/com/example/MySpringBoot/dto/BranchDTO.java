package com.example.MySpringBoot.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class BranchDTO implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6471595658332272499L;

	private Integer branchNum;			//门店编号

	    private String branchCode;			//门店代码

	    private String branchName;			//门店名称

	    private Boolean branchActived;		//是否启用

	    private String branchPostcode;		//邮编

	    private String branchAddr;			//地址

	    private Date branchExpiration;		//授权使用时间
	    
	    private BigDecimal branchLng;
	    
	    private BigDecimal branchLat;
	    
	    private String branchProvince;
	    
	    private String branchCity;
	    
	    private String branchDistrict;
	    
	    private String branchLinkMan;
	    
	    private String branchLinkPhone;
	    
	    private String branchSettlementType;
	    
	    private Date branchClosedTime;
	    
	    private Date branchCreateTime;

		public Integer getBranchNum() {
			return branchNum;
		}

		public void setBranchNum(Integer branchNum) {
			this.branchNum = branchNum;
		}

		public String getBranchCode() {
			return branchCode;
		}

		public void setBranchCode(String branchCode) {
			this.branchCode = branchCode;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public Boolean getBranchActived() {
			return branchActived;
		}

		public void setBranchActived(Boolean branchActived) {
			this.branchActived = branchActived;
		}

		public String getBranchPostcode() {
			return branchPostcode;
		}

		public void setBranchPostcode(String branchPostcode) {
			this.branchPostcode = branchPostcode;
		}

		public String getBranchAddr() {
			return branchAddr;
		}

		public void setBranchAddr(String branchAddr) {
			this.branchAddr = branchAddr;
		}

		public Date getBranchExpiration() {
			return branchExpiration;
		}

		public void setBranchExpiration(Date branchExpiration) {
			this.branchExpiration = branchExpiration;
		}

		public BigDecimal getBranchLng() {
			return branchLng;
		}

		public void setBranchLng(BigDecimal branchLng) {
			this.branchLng = branchLng;
		}

		public BigDecimal getBranchLat() {
			return branchLat;
		}

		public void setBranchLat(BigDecimal branchLat) {
			this.branchLat = branchLat;
		}

		public String getBranchProvince() {
			return branchProvince;
		}

		public void setBranchProvince(String branchProvince) {
			this.branchProvince = branchProvince;
		}

		public String getBranchCity() {
			return branchCity;
		}

		public void setBranchCity(String branchCity) {
			this.branchCity = branchCity;
		}

		public String getBranchDistrict() {
			return branchDistrict;
		}

		public void setBranchDistrict(String branchDistrict) {
			this.branchDistrict = branchDistrict;
		}

		public String getBranchLinkMan() {
			return branchLinkMan;
		}

		public void setBranchLinkMan(String branchLinkMan) {
			this.branchLinkMan = branchLinkMan;
		}

		public String getBranchLinkPhone() {
			return branchLinkPhone;
		}

		public void setBranchLinkPhone(String branchLinkPhone) {
			this.branchLinkPhone = branchLinkPhone;
		}

		public String getBranchSettlementType() {
			return branchSettlementType;
		}

		public void setBranchSettlementType(String branchSettlementType) {
			this.branchSettlementType = branchSettlementType;
		}

		public Date getBranchClosedTime() {
			return branchClosedTime;
		}

		public void setBranchClosedTime(Date branchClosedTime) {
			this.branchClosedTime = branchClosedTime;
		}

		public Date getBranchCreateTime() {
			return branchCreateTime;
		}

		public void setBranchCreateTime(Date branchCreateTime) {
			this.branchCreateTime = branchCreateTime;
		}
	    
	    
}
