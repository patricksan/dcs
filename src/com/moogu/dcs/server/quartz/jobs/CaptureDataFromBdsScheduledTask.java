package com.moogu.dcs.server.quartz.jobs;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CaptureDataFromBdsScheduledTask
{
	/** for log */
	private final static Logger logger = Logger
			.getLogger(CaptureDataFromBdsScheduledTask.class.getName());
	
	@Scheduled(fixedRate=50000000)
	protected void executeFixedRate()
	{
		//TODO  do the actual call to the service
		logger.debug("Calling Data Capture from DBS Service. scheduled with fix rate.");
		
	}
	
	@Scheduled(cron="0 0 12 * * ?")
	protected void executeCronExpression()
	{
		//TODO  do the actual call to the service
		logger.debug("Calling Data Capture from DBS Service. Scheduled with Cron Expression.");
		
	}
}
