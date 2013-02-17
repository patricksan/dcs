package com.moogu.dcs.server.ws.model;

public class MachineConfiguration {

	private int machineId;
	private String machineName;
	private String machineDescription;
	private int siteId;
	private int shiftModelId;
	private int machineClassId;
	private String machineClassName;

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getMachineDescription() {
		return machineDescription;
	}

	public void setMachineDescription(String machineDescription) {
		this.machineDescription = machineDescription;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getShiftModelId() {
		return shiftModelId;
	}

	public void setShiftModelId(int shiftModelId) {
		this.shiftModelId = shiftModelId;
	}

	public int getMachineClassId() {
		return machineClassId;
	}

	public void setMachineClassId(int machineClassId) {
		this.machineClassId = machineClassId;
	}

	public String getMachineClassName() {
		return machineClassName;
	}

	public void setMachineClassName(String machineClassName) {
		this.machineClassName = machineClassName;
	}

}
