package com.moogu.dcs.test.common;

import org.apache.commons.lang.StringUtils;

public class PersonalDatabaseConfig {

	public final String userName;

	public final String password;

	public final String urlConnection;

	public PersonalDatabaseConfig() {
		final String envUserName = System.getProperty("dcs.schema.username");

		// Use config defined in environment vars
		if (envUserName != null) {
			System.out.println("Found env property dcs.schema.username = "
					+ envUserName);
			this.userName = envUserName;
			this.password = System.getProperty("dcs.schema.password");
			this.urlConnection = System.getProperty("dcs.schema.url");

			// use default
		} else {
			System.out.println("Env property dcs.schema.username not found");
			this.userName = "root";
			this.password = "";
			this.urlConnection = "jdbc:mysql://localhost/dcs";
		}
		System.out.println("Use db config : " + this);
	}

	public String getHost() {
		return StringUtils.substringAfterLast(this.urlConnection, ":");
	}

	@Override
	public String toString() {
		return "user name = " + this.userName + ", password = " + this.password
				+ ", urlConnection = " + this.urlConnection;
	}
}