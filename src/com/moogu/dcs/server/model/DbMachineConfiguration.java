package com.moogu.dcs.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MACHINE_CONFIGURATION")
public class DbMachineConfiguration 
{
	@Id
	@Column(name = "MACHINE_ID")
	private int machineId;
	
	@Column(name = "MACHINE_NAME")
	private String machineName;
	
	@Column(name = "MACHINE_DESCRIPTION")
	private String machineDescription;
	
	@ManyToOne
    @JoinColumn(name="SITE_ID")
	private DbSiteConfiguration machineSite;
	
	@ManyToOne
    @JoinColumn(name="MACHINE_CLASS_ID")
	private DbMachineClass machineClass;
	
	@ManyToOne
    @JoinColumn(name="SHIFT_MODEL_ID")
	private DbShiftModel shiftModel;
	
	@OneToMany
	@JoinColumn(name="MACHINE_ID")
	private List<DbMachineState> machineStates = new ArrayList<DbMachineState>();

	@OneToMany
	@JoinColumn(name="MACHINE_ID")
	private List<DbShiftResult> shiftResults = new ArrayList<DbShiftResult>();
	
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

	public DbSiteConfiguration getMachineSite() {
		return machineSite;
	}

	public void setMachineSite(DbSiteConfiguration machineSite) {
		this.machineSite = machineSite;
	}

	public DbMachineClass getMachineClass() {
		return machineClass;
	}

	public void setMachineClass(DbMachineClass machineClass) {
		this.machineClass = machineClass;
	}

	public DbShiftModel getShiftModel() {
		return shiftModel;
	}

	public void setShiftModel(DbShiftModel shiftModel) {
		this.shiftModel = shiftModel;
	}

	public List<DbMachineState> getMachineStates() {
		return machineStates;
	}

	public void setMachineStates(List<DbMachineState> machineStates) {
		this.machineStates = machineStates;
	}

	public List<DbShiftResult> getShiftResults() {
		return shiftResults;
	}

	public void setShiftResults(List<DbShiftResult> shiftResults) {
		this.shiftResults = shiftResults;
	}

}
