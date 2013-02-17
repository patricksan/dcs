package com.moogu.dcs.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHIFT_CONFIGURATION")
public class DbShiftConfiguration 
{
	@Id
	@Column(name = "SHIFT_ID")
	private int shiftId;
	
	@Column(name = "SHIFT_NAME")
	private String shiftName;
	
	@Column(name = "SHIFT_START")
	private int shiftStart;
	
	@Column(name = "SHIFT_LENGHT")
	private int shiftLenght;
	
	@ManyToOne
    @JoinColumn(name="SHIFT_MODEL_ID")
	private DbShiftModel shiftModel;

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public int getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(int shiftStart) {
		this.shiftStart = shiftStart;
	}

	public int getShiftLenght() {
		return shiftLenght;
	}

	public void setShiftLenght(int shiftLenght) {
		this.shiftLenght = shiftLenght;
	}

	public DbShiftModel getShiftModel() {
		return shiftModel;
	}

	public void setShiftModel(DbShiftModel shiftModel) {
		this.shiftModel = shiftModel;
	}
}
