package com.counter.model;
import java.sql.Date;

public class CounterVO implements java.io.Serializable{
	
	private Integer counterNo;
    private String counterAccount;
    private String counterName;
    private String counterPassword;
    private String counterAddress;
    private String counterPhone;
    private String counterUid;
    private String counterEmail;
    private String counterUbn;
    private String counterCName;
    private Integer counterTypeNo;
    private String counterInform;
    private byte[] counterPic;
    private Integer counterStatus;
    
	public CounterVO() {
		super();
	}

	public Integer getCounterNo() {
		return counterNo;
	}

	public void setCounterNo(Integer counterNo) {
		this.counterNo = counterNo;
	}

	public String getCounterAccount() {
		return counterAccount;
	}

	public void setCounterAccount(String counterAccount) {
		this.counterAccount = counterAccount;
	}

	public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	public String getCounterPassword() {
		return counterPassword;
	}

	public void setCounterPassword(String counterPassword) {
		this.counterPassword = counterPassword;
	}

	public String getCounterAddress() {
		return counterAddress;
	}

	public void setCounterAddress(String counterAddress) {
		this.counterAddress = counterAddress;
	}

	public String getCounterPhone() {
		return counterPhone;
	}

	public void setCounterPhone(String counterPhone) {
		this.counterPhone = counterPhone;
	}

	public String getCounterUid() {
		return counterUid;
	}

	public void setCounterUid(String counterUid) {
		this.counterUid = counterUid;
	}

	public String getCounterEmail() {
		return counterEmail;
	}

	public void setCounterEmail(String counterEmail) {
		this.counterEmail = counterEmail;
	}

	public String getCounterUbn() {
		return counterUbn;
	}

	public void setCounterUbn(String counterUbn) {
		this.counterUbn = counterUbn;
	}

	public String getCounterCName() {
		return counterCName;
	}

	public void setCounterCName(String counterCName) {
		this.counterCName = counterCName;
	}

	public Integer getCounterTypeNo() {
		return counterTypeNo;
	}

	public void setCounterTypeNo(Integer counterTypeNo) {
		this.counterTypeNo = counterTypeNo;
	}

	public String getCounterInform() {
		return counterInform;
	}

	public void setCounterInform(String counterInform) {
		this.counterInform = counterInform;
	}

	public byte[] getCounterPic() {
		return counterPic;
	}

	public void setCounterPic(byte[] counterPic) {
		this.counterPic = counterPic;
	}

	public Integer getCounterStatus() {
		return counterStatus;
	}

	public void setCounterStatus(Integer counterStatus) {
		this.counterStatus = counterStatus;
	}

}
