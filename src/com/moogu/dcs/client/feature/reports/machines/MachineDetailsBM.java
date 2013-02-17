package com.moogu.dcs.client.feature.reports.machines;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.moogu.dcs.shared.model.Machine;

public class MachineDetailsBM extends BaseModel
{
	private static final long serialVersionUID = 2360290936573277373L;

	public transient static final String ID = "machineId";
	public transient static final String NAME = "machineName";
	public transient static final String DESCRIPTION = "machineDescription";
	public transient static final String SITE_ID = "machineSiteId";
	public transient static final String SITE_NAME = "machineSiteName";
	public transient static final String SHIFT_MODEL_ID = "machineModelId";
	public transient static final String CLASS_ID = "machineClassId";
	public transient static final String CLASS_NAME = "machineClassName";
	
	
	public MachineDetailsBM(Machine mTO)
	{
		set(MachineDetailsBM.ID, mTO.getMachineId());
		set(MachineDetailsBM.NAME, mTO.getMachineName());
		set(MachineDetailsBM.DESCRIPTION, mTO.getMachineDescription());
		set(MachineDetailsBM.SITE_ID, mTO.getMachineSite().getSiteId());
		set(MachineDetailsBM.SITE_NAME, mTO.getMachineSite().getSiteName());
		set(MachineDetailsBM.SHIFT_MODEL_ID, mTO.getShiftModel().getShiftModelId());
		set(MachineDetailsBM.CLASS_ID, mTO.getMachineClass().getMachineClassId());
		set(MachineDetailsBM.CLASS_NAME, mTO.getMachineClass().getMachineClassName());
	}
	
	public int getMachineId() {
		return get(MachineDetailsBM.ID);
	}

	public void setMachineId(int machineId) {
		set(MachineDetailsBM.ID,machineId);
	}

	public String getMachineName() {
		return get(MachineDetailsBM.NAME);
	}

	public void setMachineName(String machineName) {
		set(MachineDetailsBM.NAME, machineName);
	}

	public String getMachineDescription() {
		return get(MachineDetailsBM.DESCRIPTION);
	}

	public void setMachineDescription(String machineDescription) {
		set(MachineDetailsBM.DESCRIPTION, machineDescription);
	}
	
	public int getMachineSiteId() {
		return get(MachineDetailsBM.SITE_ID);
	}

	public void setMachineSiteId(int siteId) {
		set(MachineDetailsBM.SITE_ID, siteId);
	}
	
	public String getSiteName() {
		return get(MachineDetailsBM.SITE_NAME);
	}

	public void setSiteName(String siteName) {
		set(MachineDetailsBM.SITE_NAME, siteName);
	}
	
	public String getMachineClassName() {
		return get(MachineDetailsBM.CLASS_NAME);
	}

	public void setMachineClassName(String className) {
		set(MachineDetailsBM.CLASS_NAME, className);
	}
	
	public int getMachineShiftModelId() {
		return get(MachineDetailsBM.SHIFT_MODEL_ID);
	}

	public void setMachineShiftModelId(int shiftModelId) {
		set(MachineDetailsBM.SHIFT_MODEL_ID, shiftModelId);
	}
	
	public int getMachineClassId() {
		return get(MachineDetailsBM.CLASS_ID);
	}

	public void setMachineClassId(int classId) {
		set(MachineDetailsBM.CLASS_ID, classId);
	}
	
}
