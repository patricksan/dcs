package com.moogu.dcs.server.ws.model;

public class ShiftResult {

	private int machineId;
	private int counterIn;
	private int counterOut;
	private int timeRun;

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getCounterIn() {
		return counterIn;
	}

	public void setCounterIn(int counterIn) {
		this.counterIn = counterIn;
	}

	public int getCounterOut() {
		return counterOut;
	}

	public void setCounterOut(int counterOut) {
		this.counterOut = counterOut;
	}

	public int getTimeRun() {
		return timeRun;
	}

	public void setTimeRun(int timeRun) {
		this.timeRun = timeRun;
	}

}
