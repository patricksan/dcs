package com.moogu.dcs.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MACHINE_CLASS")
public class DbMachineClass 
{
	@Id
	@Column(name = "MACHINE_CLASS_ID")
	private int machineClassId;
	
	@Column(name = "MACHINE_CLASS_NAME")
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
