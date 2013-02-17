package com.moogu.dcs.client.feature.reports.machines;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.moogu.dcs.shared.model.Machine;

public class MachineNotWorkingBM extends BaseModel
{
	private static final long serialVersionUID = 2360290936573277373L;

	public transient static final String ID = "machineId";
	public transient static final String NAME = "machineName";
	public transient static final String DESCRIPTION = "machineDescription";
	public transient static final String SITE_NAME = "machineSiteName";
	public transient static final String CLASS_NAME = "machineClassName";
	public transient static final String SHIFT_NAME = "machineShiftName";
	public transient static final String LAST_STATE = "machineLastState";
	public transient static final String STATE_DATE = "stateCreationDate";
	
	public MachineNotWorkingBM(Machine mTO)
	{
		set(MachineNotWorkingBM.ID, mTO.getMachineId());
		set(MachineNotWorkingBM.NAME, mTO.getMachineName());
		set(MachineNotWorkingBM.DESCRIPTION, mTO.getMachineDescription());
		set(MachineNotWorkingBM.SITE_NAME, mTO.getMachineSite().getSiteName());
		set(MachineNotWorkingBM.CLASS_NAME, mTO.getMachineClass().getMachineClassName());
		set(MachineNotWorkingBM.SHIFT_NAME, mTO.getShiftModel().getShiftModelName());
		set(MachineNotWorkingBM.LAST_STATE, mTO.getLastMachineState().getMachineState());
		set(MachineNotWorkingBM.STATE_DATE, mTO.getLastMachineState().getStateCreationDate());
	}
	
	public int getMachineId() {
		return get(MachineNotWorkingBM.ID);
	}

	public void setMachineId(int machineId) {
		set(MachineNotWorkingBM.ID,machineId);
	}

	public String getMachineName() {
		return get(MachineNotWorkingBM.NAME);
	}

	public void setMachineName(String machineName) {
		set(MachineNotWorkingBM.NAME, machineName);
	}

	public String getMachineDescription() {
		return get(MachineNotWorkingBM.DESCRIPTION);
	}

	public void setMachineDescription(String machineDescription) {
		set(MachineNotWorkingBM.DESCRIPTION, machineDescription);
	}
	
	public String getMachineSiteName() {
		return get(MachineNotWorkingBM.SITE_NAME);
	}

	public void setMachineSiteName(String siteName) {
		set(MachineNotWorkingBM.SITE_NAME, siteName);
	}
	
	public String getMachineClassName() {
		return get(MachineNotWorkingBM.CLASS_NAME);
	}

	public void setMachineClassName(String className) {
		set(MachineNotWorkingBM.CLASS_NAME, className);
	}
	
	public String getMachineShiftName() {
		return get(MachineNotWorkingBM.SHIFT_NAME);
	}

	public void setMachineShiftName(String shiftName) {
		set(MachineNotWorkingBM.SHIFT_NAME, shiftName);
	}
	
	public String getMachineLastState() {
		return get(MachineNotWorkingBM.LAST_STATE);
	}

	public void setMachineLastState(String lastState) {
		set(MachineNotWorkingBM.LAST_STATE, lastState);
	}
	
	public Date getMachineStateCreationDate() {
		return get(MachineNotWorkingBM.STATE_DATE);
	}

	public void setMachineStateCreationDate(Date stateDate) {
		set(MachineNotWorkingBM.STATE_DATE, stateDate);
	}
	
}
