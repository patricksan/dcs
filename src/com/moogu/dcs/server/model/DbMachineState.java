package com.moogu.dcs.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "MACHINE_STATE")
public class DbMachineState 
{
	@Id
	@Column(name="MACHINE_STATE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int machineStateId;
	
	@NaturalId
	@ManyToOne
    @JoinColumn(name="MACHINE_ID")
	private DbMachineConfiguration machine;
	
	@NaturalId
	@Column(name = "STATE_CREATION_DATE")
	private Date stateCreationDate;
	
	@NaturalId
	@Column(name = "MACHINE_STATE")
	private int machineState;
	
	@Column(name = "MACHINE_SPEED")
	private int machineSpeed;

	public int getMachineStateId() {
		return machineStateId;
	}

	public void setMachineStateId(int machineStateId) {
		this.machineStateId = machineStateId;
	}

	public DbMachineConfiguration getMachine() {
		return machine;
	}

	public void setMachine(DbMachineConfiguration machine) {
		this.machine = machine;
	}

	public Date getStateCreationDate() {
		return stateCreationDate;
	}

	public void setStateCreationDate(Date stateCreationDate) {
		this.stateCreationDate = stateCreationDate;
	}

	public int getMachineState() {
		return machineState;
	}

	public void setMachineState(int machineState) {
		this.machineState = machineState;
	}

	public int getMachineSpeed() {
		return machineSpeed;
	}

	public void setMachineSpeed(int machineSpeed) {
		this.machineSpeed = machineSpeed;
	}
	
	public String getMachineStateString()
	{
		switch(this.machineState)
		{
			case 0:
				return "Unknown";
			case 1:
				return "Offline";
			case 2:
				return "Stopped";
			case 3:
				return "Starting";
			case 4:
				return "Running";
			case 5:
				return "Error";
			default:
				return "Invalid Status";
		}
	}

}
