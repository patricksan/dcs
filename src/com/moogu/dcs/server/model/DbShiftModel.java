package com.moogu.dcs.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SHIFT_MODEL")
public class DbShiftModel {

	protected DbShiftModel() {
		// hibernate
	}

	public DbShiftModel(int shiftModelId, String shiftModel) {
		this.shiftModelId = shiftModelId;
		this.shiftModelName = shiftModel;
	}

	public void addShiftConfiguration(DbShiftConfiguration shiftConfiguration) {
		this.shiftConfigurations.add(shiftConfiguration);
	}

	@Id
	@Column(name = "SHIFT_MODEL_ID")
	private int shiftModelId;

	@Column(name = "SHIFT_MODEL_NAME")
	private String shiftModelName;

	// FIXME Do we really need bi-direcinal relationships?
	@OneToMany(mappedBy = "shiftModel")
	private List<DbShiftConfiguration> shiftConfigurations = new ArrayList<DbShiftConfiguration>();

	public int getShiftModelId() {
		return shiftModelId;
	}

	// FIXME Do we really need public setters for everything?
	public void setShiftModelId(int shiftModelId) {
		this.shiftModelId = shiftModelId;
	}

	public String getShiftModelName() {
		return shiftModelName;
	}

	public void setShiftModelName(String shiftModelName) {
		this.shiftModelName = shiftModelName;
	}

	public List<DbShiftConfiguration> getShiftConfigurations() {
		return shiftConfigurations;
	}

	public void setShiftConfigurations(List<DbShiftConfiguration> shiftConfigurations) {
		this.shiftConfigurations = shiftConfigurations;
	}
}
