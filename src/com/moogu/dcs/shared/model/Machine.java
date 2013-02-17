package com.moogu.dcs.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Machine implements Serializable, IsSerializable
{
	private static final long serialVersionUID = 3205924997601617897L;

	private int machineId;
	
	private String machineName;
	
	private String machineDescription;
	
	private Site machineSite;
	
	private MachineClass machineClass;
	
	private ShiftModel shiftModel;
	
	private List<MachineState> machineStates = new ArrayList<MachineState>();
	
	private MachineState lastMachineState;

	private List<ShiftResult> shiftResults = new ArrayList<ShiftResult>();

	public Machine()
	{
		
	}
	
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

	public Site getMachineSite() {
		return machineSite;
	}

	public void setMachineSite(Site machineSite) {
		this.machineSite = machineSite;
	}

	public MachineClass getMachineClass() {
		return machineClass;
	}

	public void setMachineClass(MachineClass machineClass) {
		this.machineClass = machineClass;
	}

	public ShiftModel getShiftModel() {
		return shiftModel;
	}

	public void setShiftModel(ShiftModel shiftModel) {
		this.shiftModel = shiftModel;
	}

	public List<MachineState> getMachineStates() {
		return machineStates;
	}

	public void setMachineStates(List<MachineState> machineStates) {
		this.machineStates = machineStates;
	}

	public List<ShiftResult> getShiftResults() {
		return shiftResults;
	}

	public void setShiftResults(List<ShiftResult> shiftResults) {
		this.shiftResults = shiftResults;
	}

	public MachineState getLastMachineState() {
		return lastMachineState;
	}

	public void setLastMachineState(MachineState lastMachineState) {
		this.lastMachineState = lastMachineState;
	}
}
