package com.moogu.dcs.server.ws.model;

public class ShiftConfiguration {

	private int shiftId;
	private String shiftName;
	private int shiftStart;
	private int shiftLength;
	private int shiftModelId;
	private String shiftModelName;

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public int getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(int shiftStart) {
		this.shiftStart = shiftStart;
	}

	public int getShiftLength() {
		return shiftLength;
	}

	public void setShiftLength(int shiftLength) {
		this.shiftLength = shiftLength;
	}

	public int getShiftModelId() {
		return shiftModelId;
	}

	public void setShiftModelId(int shiftModelId) {
		this.shiftModelId = shiftModelId;
	}

	public String getShiftModelName() {
		return shiftModelName;
	}

	public void setShiftModelName(String shiftModelName) {
		this.shiftModelName = shiftModelName;
	}

}
