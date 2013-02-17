package com.moogu.dcs.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;


public class MachineClass implements Serializable, IsSerializable
{
	private static final long serialVersionUID = -8857186197163035292L;

	public MachineClass(int id, String name)
	{
		this.machineClassId = id;
		this.machineClassName = name;
	}
	
	public MachineClass()
	{
		
	}
	
	private int machineClassId;
	
	private String machineClassName;

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
