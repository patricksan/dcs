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
@Table(name = "SHIFT_RESULT")
public class DbShiftResult 
{
	@Id
	@Column(name="SHIFT_RESULT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shiftResultId;
	
	@NaturalId
	@ManyToOne
    @JoinColumn(name="MACHINE_ID")
	private DbMachineConfiguration machine;
	
	@NaturalId
	@ManyToOne
    @JoinColumn(name="SHIFT_ID")
	private DbShiftConfiguration shift;
	
	@NaturalId
	@Column(name = "SHIFT_RESULT_DATE")
	private Date shiftResultDate;
	
	@Column(name = "COUNTER_IN")
	private int counterIn;
	
	@Column(name = "COUNTER_OUT")
	private int counterOut;
	
	@Column(name = "TIME_RUN")
	private int timeRun;

	public int getShiftResultId() {
		return shiftResultId;
	}

	public void setShiftResultId(int shiftResultId) {
		this.shiftResultId = shiftResultId;
	}

	public DbMachineConfiguration getMachine() {
		return machine;
	}

	public void setMachine(DbMachineConfiguration machine) {
		this.machine = machine;
	}

	public DbShiftConfiguration getShift() {
		return shift;
	}

	public void setShift(DbShiftConfiguration shift) {
		this.shift = shift;
	}

	public Date getShiftResultDate() {
		return shiftResultDate;
	}

	public void setShiftResultDate(Date shiftResultDate) {
		this.shiftResultDate = shiftResultDate;
	}

	public int getCounterIn() {
		return counterIn;
	}

	public void setCounterIn(int counterIn) {
		this.counterIn = counterIn;
	}

	public int getCounterOut() {
		return counterOut;
	}

	public void setCounterOut(int counterOut) {
		this.counterOut = counterOut;
	}

	public int getTimeRun() {
		return timeRun;
	}

	public void setTimeRun(int timeRun) {
		this.timeRun = timeRun;
	}
}
