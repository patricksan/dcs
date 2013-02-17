package com.moogu.dcs.shared.model;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MachineState implements Serializable, IsSerializable
{
	private static final long serialVersionUID = 8682497057215760618L;

	private Machine machine;
	
	private Date stateCreationDate;
	
	private String machineState;
	
	private int machineSpeed;
	
	public MachineState()
	{
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Date getStateCreationDate() {
		return stateCreationDate;
	}

	public void setStateCreationDate(Date stateCreationDate) {
		this.stateCreationDate = stateCreationDate;
	}

	public String getMachineState() {
		return machineState;
	}

	public void setMachineState(String machineState) {
		this.machineState = machineState;
	}

	public int getMachineSpeed() {
		return machineSpeed;
	}

	public void setMachineSpeed(int machineSpeed) {
		this.machineSpeed = machineSpeed;
	}
}
