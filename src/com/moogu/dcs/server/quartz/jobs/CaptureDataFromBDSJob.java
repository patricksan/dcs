package com.moogu.dcs.server.quartz.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CaptureDataFromBDSJob extends QuartzJobBean 
{
	/** for log */
	private final static Logger logger = Logger
			.getLogger(CaptureDataFromBDSJob.class.getName());
	
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException 
	{
		//TODO  do the actual call to the service
		logger.debug("Calling Data Capture from DBS Service.");
		
	}
}
