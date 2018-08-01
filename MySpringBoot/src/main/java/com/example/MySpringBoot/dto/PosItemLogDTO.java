package com.example.MySpringBoot.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PosItemLogDTO implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -4899280235791247415L;
    private Long posItemLogId;
    private String posItemLogFid;                   //日志流水号
    private Integer storehouseNum;                  //仓库编号
    private Integer branchNum;                      //门店编号
    private Integer itemNum;                        //项目编号
    private String posItemLogItemCode;              //项目代码
    private String posItemLogItemName;              //项目名称
    private String posItemLogItemUnit;              //计量单位
    private Boolean posItemLogInoutFlag;            //进出标记 true：进 false：出
    private String posItemLogBillNo;                //参考单据号
    private Integer posItemLogBillDetailNum;        //参考单据明细编号
    private String posItemLogOperator;              //操作员
    private Date posItemLogOperateTime;             //操作时间
    private String posItemLogSummary;               //摘要
    private BigDecimal posItemLogItemAmount;        //调整数量
    private Date posItemLogDate;                    //调整日期
    private BigDecimal posItemLogItemAssistAmount;  //调整辅助数量
    private BigDecimal posItemLogMoney;             //调整金额 posItemLogItemAmount * posItemLogItemPrice
    private String posItemLogItemAssistUnit;        //辅助计量单位
    private String posItemLogItemSpec;              //规格
    private Integer posItemLogItemCategory;         //商品类别
    private BigDecimal posItemLogItemPrice;         //调整库存单价 如果是出库，需要重新计算为当前库存成本，入库则为单据传过来的价格
    
    private BigDecimal posItemLogItemBalance;       //调整前数量
    private String posItemLogMemo;                  //备注
    private BigDecimal posItemLogCostPrice;         //调整前成本单价
    private BigDecimal posItemLogItemAssistBalance; //调整前辅助数量
    private String posItemLogBizday;                //索引日期
    
    private BigDecimal posItemLogItemAssistPrice;   //辅助单价（称重单价）
    
    private String posItemLogLotNum;
    
    private Date posItemLogOrderOperateDate;		//单据操作时间
    
    private Date posItemLogDailySettlementNum;		//日结编号
    
    private BigDecimal posItemLogCostMoney;
    
    private Integer departmentNum;
    
    public String getPosItemLogFid() {
        return posItemLogFid;
    }

    public void setPosItemLogFid(String posItemLogFid) {
        this.posItemLogFid = posItemLogFid;
    }

    public Integer getStorehouseNum() {
        return storehouseNum;
    }

    public void setStorehouseNum(Integer storehouseNum) {
        this.storehouseNum = storehouseNum;
    }

    public Integer getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(Integer branchNum) {
        this.branchNum = branchNum;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public String getPosItemLogItemCode() {
        return posItemLogItemCode;
    }

    public void setPosItemLogItemCode(String posItemLogItemCode) {
        this.posItemLogItemCode = posItemLogItemCode;
    }

    public String getPosItemLogItemName() {
        return posItemLogItemName;
    }

    public void setPosItemLogItemName(String posItemLogItemName) {
        this.posItemLogItemName = posItemLogItemName;
    }

    public String getPosItemLogItemUnit() {
        return posItemLogItemUnit;
    }

    public void setPosItemLogItemUnit(String posItemLogItemUnit) {
        this.posItemLogItemUnit = posItemLogItemUnit;
    }

    public Boolean getPosItemLogInoutFlag() {
        return posItemLogInoutFlag;
    }

    public void setPosItemLogInoutFlag(Boolean posItemLogInoutFlag) {
        this.posItemLogInoutFlag = posItemLogInoutFlag;
    }

    public String getPosItemLogSummary() {
        return posItemLogSummary;
    }

    public void setPosItemLogSummary(String posItemLogSummary) {
        this.posItemLogSummary = posItemLogSummary;
    }

    public Date getPosItemLogDate() {
        return posItemLogDate;
    }

    public void setPosItemLogDate(Date posItemLogDate) {
        this.posItemLogDate = posItemLogDate;
    }

    public BigDecimal getPosItemLogItemPrice() {
        return posItemLogItemPrice;
    }

    public void setPosItemLogItemPrice(BigDecimal posItemLogItemPrice) {
        this.posItemLogItemPrice = posItemLogItemPrice;
    }

    public BigDecimal getPosItemLogItemBalance() {
        return posItemLogItemBalance;
    }

    public void setPosItemLogItemBalance(BigDecimal posItemLogItemBalance) {
        this.posItemLogItemBalance = posItemLogItemBalance;
    }

    public BigDecimal getPosItemLogItemAmount() {
        return posItemLogItemAmount;
    }

    public void setPosItemLogItemAmount(BigDecimal posItemLogItemAmount) {
        this.posItemLogItemAmount = posItemLogItemAmount;
    }

    public String getPosItemLogOperator() {
        return posItemLogOperator;
    }

    public void setPosItemLogOperator(String posItemLogOperator) {
        this.posItemLogOperator = posItemLogOperator;
    }

    public Date getPosItemLogOperateTime() {
        return posItemLogOperateTime;
    }

    public void setPosItemLogOperateTime(Date posItemLogOperateTime) {
        this.posItemLogOperateTime = posItemLogOperateTime;
    }

    public String getPosItemLogMemo() {
        return posItemLogMemo;
    }

    public void setPosItemLogMemo(String posItemLogMemo) {
        this.posItemLogMemo = posItemLogMemo;
    }

    public String getPosItemLogBillNo() {
        return posItemLogBillNo;
    }

    public void setPosItemLogBillNo(String posItemLogBillNo) {
        this.posItemLogBillNo = posItemLogBillNo;
    }

    public Integer getPosItemLogBillDetailNum() {
        return posItemLogBillDetailNum;
    }

    public void setPosItemLogBillDetailNum(Integer posItemLogBillDetailNum) {
        this.posItemLogBillDetailNum = posItemLogBillDetailNum;
    }

    public BigDecimal getPosItemLogCostPrice() {
        return posItemLogCostPrice;
    }

    public void setPosItemLogCostPrice(BigDecimal posItemLogCostPrice) {
        this.posItemLogCostPrice = posItemLogCostPrice;
    }

    public String getPosItemLogItemAssistUnit() {
        return posItemLogItemAssistUnit;
    }

    public void setPosItemLogItemAssistUnit(String posItemLogItemAssistUnit) {
        this.posItemLogItemAssistUnit = posItemLogItemAssistUnit;
    }

    public BigDecimal getPosItemLogItemAssistBalance() {
        return posItemLogItemAssistBalance;
    }

    public void setPosItemLogItemAssistBalance(BigDecimal posItemLogItemAssistBalance) {
        this.posItemLogItemAssistBalance = posItemLogItemAssistBalance;
    }

    public BigDecimal getPosItemLogItemAssistAmount() {
        return posItemLogItemAssistAmount;
    }

    public void setPosItemLogItemAssistAmount(BigDecimal posItemLogItemAssistAmount) {
        this.posItemLogItemAssistAmount = posItemLogItemAssistAmount;
    }

    public String getPosItemLogItemSpec() {
        return posItemLogItemSpec;
    }

    public void setPosItemLogItemSpec(String posItemLogItemSpec) {
        this.posItemLogItemSpec = posItemLogItemSpec;
    }
   
    public Integer getPosItemLogItemCategory() {
        return posItemLogItemCategory;
    }

    public void setPosItemLogItemCategory(Integer posItemLogItemCategory) {
        this.posItemLogItemCategory = posItemLogItemCategory;
    }

    public BigDecimal getPosItemLogMoney() {
        return posItemLogMoney;
    }

    public void setPosItemLogMoney(BigDecimal posItemLogMoney) {
        this.posItemLogMoney = posItemLogMoney;
    }

    public String getPosItemLogBizday() {
        return posItemLogBizday;
    }

    public void setPosItemLogBizday(String posItemLogBizday) {
        this.posItemLogBizday = posItemLogBizday;
    }

    public BigDecimal getPosItemLogItemAssistPrice() {
        return posItemLogItemAssistPrice;
    }

    public void setPosItemLogItemAssistPrice(
            BigDecimal posItemLogItemAssistPrice) {
        this.posItemLogItemAssistPrice = posItemLogItemAssistPrice;
    }

	public String getPosItemLogLotNum() {
		return posItemLogLotNum;
	}

	public void setPosItemLogLotNum(String posItemLogLotNum) {
		this.posItemLogLotNum = posItemLogLotNum;
	}

	public Date getPosItemLogOrderOperateDate() {
		return posItemLogOrderOperateDate;
	}

	public void setPosItemLogOrderOperateDate(Date posItemLogOrderOperateDate) {
		this.posItemLogOrderOperateDate = posItemLogOrderOperateDate;
	}

	public Date getPosItemLogDailySettlementNum() {
		return posItemLogDailySettlementNum;
	}

	public void setPosItemLogDailySettlementNum(Date posItemLogDailySettlementNum) {
		this.posItemLogDailySettlementNum = posItemLogDailySettlementNum;
	}

	public BigDecimal getPosItemLogCostMoney() {
		return posItemLogCostMoney;
	}

	public void setPosItemLogCostMoney(BigDecimal posItemLogCostMoney) {
		this.posItemLogCostMoney = posItemLogCostMoney;
	}

	public Integer getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(Integer departmentNum) {
		this.departmentNum = departmentNum;
	}

	public Long getPosItemLogId() {
		return posItemLogId;
	}

	public void setPosItemLogId(Long posItemLogId) {
		this.posItemLogId = posItemLogId;
	}
	
}