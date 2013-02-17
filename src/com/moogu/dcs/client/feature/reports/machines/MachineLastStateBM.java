package com.moogu.dcs.client.feature.reports.machines;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.moogu.dcs.shared.model.Machine;

public class MachineLastStateBM extends BaseModel
{
	private static final long serialVersionUID = 2360290936573277373L;

	public transient static final String ID = "machineId";
	public transient static final String SPEED = "machineSpeed";
	public transient static final String LAST_STATE = "machineLastState";
	public transient static final String STATE_DATE = "stateCreationDate";
	
	public MachineLastStateBM(Machine mTO)
	{
		set(MachineLastStateBM.ID, mTO.getMachineId());
		set(MachineLastStateBM.SPEED, mTO.getLastMachineState().getMachineSpeed());
		set(MachineLastStateBM.LAST_STATE, mTO.getLastMachineState().getMachineState());
		set(MachineLastStateBM.STATE_DATE, mTO.getLastMachineState().getStateCreationDate());
	}
	
	public int getMachineId() {
		return get(MachineLastStateBM.ID);
	}

	public void setMachineId(int machineId) {
		set(MachineLastStateBM.ID,machineId);
	}
	
	public int getMachineSpeed() {
		return get(MachineLastStateBM.SPEED);
	}

	public void setMachineSpeed(int speed) {
		set(MachineLastStateBM.SPEED, speed);
	}
	
	public String getMachineLastState() {
		return get(MachineLastStateBM.LAST_STATE);
	}

	public void setMachineLastState(String lastState) {
		set(MachineLastStateBM.LAST_STATE, lastState);
	}
	
	public Date getMachineStateCreationDate() {
		return get(MachineLastStateBM.STATE_DATE);
	}

	public void setMachineStateCreationDate(Date stateDate) {
		set(MachineLastStateBM.STATE_DATE, stateDate);
	}
	
}
