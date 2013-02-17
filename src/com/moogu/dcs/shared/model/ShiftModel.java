package com.moogu.dcs.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;


public class ShiftModel implements Serializable, IsSerializable
{
	private static final long serialVersionUID = -5779799113570737608L;

	public ShiftModel(int id, String name)
	{
		this.shiftModelId = id;
		this.shiftModelName = name;
	}
	
	public ShiftModel()
	{
		
	}
	
	private int shiftModelId;
	
	private String shiftModelName;
	
	public int getShiftModelId() {
		return shiftModelId;
	}

	public void setShiftModelId(int shiftModelId) {
		this.shiftModelId = shiftModelId;
	}

	public String getShiftModelName() {
		return shiftModelName;
	}

	public void setShiftModelName(String shiftModelName) {
		this.shiftModelName = shiftModelName;
	}
}
