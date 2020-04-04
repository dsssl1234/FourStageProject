package com.great.entity;

/**
 * 日志实体
 * 
 * @author zx
 * 
 */
public class SystemLog {
	private Integer logid;

	private String operationUser;//操作用户

	private String operationType;//操作类型

	private String operationName;//操作内容

	private String operationdate;//操作日期

	private String operationresult;//操作结果

	private String operationIp;//操作ip

	public SystemLog() {
	}

	public SystemLog(Integer logid, String operationUser, String operationType, String operationName, String operationdate, String operationresult, String operationIp) {
		this.logid = logid;
		this.operationUser = operationUser;
		this.operationType = operationType;
		this.operationName = operationName;
		this.operationdate = operationdate;
		this.operationresult = operationresult;
		this.operationIp = operationIp;
	}

	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public String getOperationUser() {
		return operationUser;
	}

	public void setOperationUser(String operationUser) {
		this.operationUser = operationUser;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationdate() {
		return operationdate;
	}

	public void setOperationdate(String operationdate) {
		this.operationdate = operationdate;
	}

	public String getOperationresult() {
		return operationresult;
	}

	public void setOperationresult(String operationresult) {
		this.operationresult = operationresult;
	}

	public String getOperationIp() {
		return operationIp;
	}

	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}


	@Override
	public String toString() {
		return "SystemLog{" +
				"logid=" + logid +
				", operationUser='" + operationUser + '\'' +
				", operationType='" + operationType + '\'' +
				", operationName='" + operationName + '\'' +
				", operationdate='" + operationdate + '\'' +
				", operationresult='" + operationresult + '\'' +
				", operationIp='" + operationIp + '\'' +
				'}';
	}
}
