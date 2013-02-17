package com.moogu.dcs.server.ws;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.moogu.dcs.server.feature.management.DcsServletContextListener;
import com.moogu.dcs.server.feature.reports.MachineRepository;
import com.moogu.dcs.server.model.DbMachineConfiguration;
import com.moogu.dcs.server.model.DbMachineState;
import com.moogu.dcs.server.model.DbShiftConfiguration;
import com.moogu.dcs.server.model.DbShiftResult;
import com.moogu.dcs.server.model.DbSiteConfiguration;
import com.moogu.dcs.server.ws.model.MachineConfiguration;
import com.moogu.dcs.server.ws.model.MachineState;
import com.moogu.dcs.server.ws.model.MapEntryVO;
import com.moogu.dcs.server.ws.model.ShiftConfiguration;
import com.moogu.dcs.server.ws.model.ShiftResult;
import com.moogu.dcs.server.ws.model.SiteConfiguration;

/**
 * That is the implementation for the Web Services in DCS Project. Please, do not move this class to another
 * package, otherwise the Web Services will not work anymore. If you really need to move this class, you also must to
 * update the file deploy.wsdd and server-config.wsdd
 * 
 * @author Fabio Furtado 
 */
public class DcsWS {

    private static final Logger LOG = Logger.getLogger(DcsWS.class);
 
    private static final String OPERATION_NAME = "operationName"; 

    public MapEntryVO[] callOperation(String operationName, String arguments) {
        DcsWS.LOG.info("WebService call: operationName '" + operationName
                        + "' and arguments = '"
                        + arguments
                        + "'");

        try {
            if (DcsWS.OPERATION_NAME.equalsIgnoreCase(operationName)) {
            	
                
                Map<String, String> result = new HashMap<String, String>();
                result.put("name", "First Name");
                result.put("age", "34");
                System.out.println("---- DCS Web Service called ! ----");

                return convertMap(result);
            } else {
                DcsWS.LOG.error("Operation '" + operationName + "' not recognized !");
            }

            DcsWS.LOG.info("End of operation '" + operationName + "' !");
        } catch (final RuntimeException ex) {
            DcsWS.LOG.error("Error when calling operation '" + operationName + "'", ex);
            throw ex;
        }

        return null;
    }
    
    public SiteConfiguration[] getSiteConfiguration() {
    	DcsWS.LOG.info("WebService call: getSiteConfiguration");

    	List<SiteConfiguration> result = new ArrayList<SiteConfiguration>();
    	
    	try {
        	ApplicationContext applicationContext = getApplicationContext();
        	MachineRepository dbr = applicationContext.getBean(MachineRepository.class);
        	List<DbSiteConfiguration> list = dbr.getSiteConfiguration();
        	
        	for (DbSiteConfiguration dsc : list) { 
            	SiteConfiguration sc = new SiteConfiguration();
            	sc.setSiteId(dsc.getSiteId());
            	sc.setSiteName(dsc.getSiteName());
            	result.add(sc);	
        	}        	
        } catch (final RuntimeException ex) {
            DcsWS.LOG.error("Error when calling operation 'getSiteConfiguration'", ex);
            throw ex;
        }
    	
    	return result.toArray(new SiteConfiguration[result.size()]);
    }

    public MachineConfiguration[] getMachineConfiguration() {
    	DcsWS.LOG.info("WebService call: getMachineConfiguration");

    	List<MachineConfiguration> result = new ArrayList<MachineConfiguration>();
    	
    	try {
        	ApplicationContext applicationContext = getApplicationContext();
        	MachineRepository dbr = applicationContext.getBean(MachineRepository.class);
        	List<DbMachineConfiguration> list = dbr.getMachineConfiguration();
        	
        	for (DbMachineConfiguration dmc : list) {         		
        		MachineConfiguration mc = new MachineConfiguration();
        		mc.setMachineId(dmc.getMachineId());
        		mc.setMachineName(dmc.getMachineName());
        		mc.setMachineDescription(dmc.getMachineDescription());
        		mc.setMachineClassId(dmc.getMachineClass().getMachineClassId());
        		mc.setMachineClassName(dmc.getMachineClass().getMachineClassName());
        		mc.setShiftModelId(dmc.getShiftModel().getShiftModelId());
            	mc.setSiteId(dmc.getMachineSite().getSiteId()); 
            	result.add(mc);	
        	}

        } catch (final RuntimeException ex) {
            DcsWS.LOG.error("Error when calling operation 'getMachineConfiguration'", ex);
            throw ex;
        }
    	
    	return result.toArray(new MachineConfiguration[result.size()]);
    }
    
    public ShiftConfiguration[] getShiftConfiguration() {
    	DcsWS.LOG.info("WebService call: getShiftConfiguration");

    	List<ShiftConfiguration> result = new ArrayList<ShiftConfiguration>();
    	
    	try {
        	ApplicationContext applicationContext = getApplicationContext();
        	MachineRepository dbr = applicationContext.getBean(MachineRepository.class);
        	List<DbShiftConfiguration> list = dbr.getShiftConfiguration();
        	
        	for (DbShiftConfiguration dsc : list) { 
        		ShiftConfiguration sc = new ShiftConfiguration();
            	sc.setShiftId(dsc.getShiftId());
            	sc.setShiftName(dsc.getShiftName());
            	sc.setShiftLength(dsc.getShiftLenght());
            	sc.setShiftStart(dsc.getShiftStart());
            	sc.setShiftModelId(dsc.getShiftModel().getShiftModelId());
            	sc.setShiftModelName(dsc.getShiftModel().getShiftModelName());
            	result.add(sc);	
        	}        	
        } catch (final RuntimeException ex) {
            DcsWS.LOG.error("Error when calling operation 'getShiftConfiguration'", ex);
            throw ex;
        }
    	
    	return result.toArray(new ShiftConfiguration[result.size()]);
    }
    
    public MachineState[] getMachineActualStates(int siteId) {
    	DcsWS.LOG.info("WebService call: getMachineActualStates");

    	List<MachineState> result = new ArrayList<MachineState>();
    	
    	try {
        	ApplicationContext applicationContext = getApplicationContext();
        	MachineRepository dbr = applicationContext.getBean(MachineRepository.class);
        	List<DbMachineState> list = dbr.getMachineActualStates(siteId);
        	
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:mm");
        	for (DbMachineState dms : list) { 
        		MachineState ms = new MachineState();
            	ms.setMachineId(dms.getMachine().getMachineId());
            	ms.setState(dms.getMachineState());
            	ms.setSpeed(dms.getMachineSpeed());
            	ms.setDateCreated(sdf.format(dms.getStateCreationDate()));

            	result.add(ms);	
        	}        	
        } catch (final RuntimeException ex) {
            DcsWS.LOG.error("Error when calling operation 'getMachineActualStates'", ex);
            throw ex;
        }
    	
    	return result.toArray(new MachineState[result.size()]);
    }
    
	public ShiftResult[] getShiftResults(int siteId, int shiftId, String date) throws Exception {
    	DcsWS.LOG.info("WebService call: getShiftResults");

    	List<ShiftResult> result = new ArrayList<ShiftResult>();
    	
    	try {
        	ApplicationContext applicationContext = getApplicationContext();
        	MachineRepository dbr = applicationContext.getBean(MachineRepository.class);
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	List<DbShiftResult> list = dbr.getShiftResults(siteId, shiftId, sdf.parse(date));

        	for (DbShiftResult dsr : list) { 
        		ShiftResult sr = new ShiftResult();
            	sr.setMachineId(dsr.getMachine().getMachineId());
            	sr.setCounterIn(dsr.getCounterIn());
            	sr.setCounterOut(dsr.getCounterOut());
            	sr.setTimeRun(dsr.getTimeRun());
            	result.add(sr);	
        	}        	
        } catch (final Exception ex) {
            DcsWS.LOG.error("Error when calling operation 'getShiftResults'", ex);
            throw ex;
        }
    	
    	return result.toArray(new ShiftResult[result.size()]);		
	}
    
	public ShiftResult[] getLatestShiftResults(int siteId, int shiftId) throws Exception {
    	DcsWS.LOG.info("WebService call: getLastestShiftResults");

    	List<ShiftResult> result = new ArrayList<ShiftResult>();
    	
    	try {
        	ApplicationContext applicationContext = getApplicationContext();
        	MachineRepository dbr = applicationContext.getBean(MachineRepository.class);
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	List<DbShiftResult> list = dbr.getLastestShiftResults(siteId, shiftId);

        	for (DbShiftResult dsr : list) { 
        		ShiftResult sr = new ShiftResult();
            	sr.setMachineId(dsr.getMachine().getMachineId());
            	sr.setCounterIn(dsr.getCounterIn());
            	sr.setCounterOut(dsr.getCounterOut());
            	sr.setTimeRun(dsr.getTimeRun());
            	result.add(sr);	
        	}        	
        } catch (final Exception ex) {
            DcsWS.LOG.error("Error when calling operation 'getLastestShiftResults'", ex);
            throw ex;
        }
    	
    	return result.toArray(new ShiftResult[result.size()]);		
	}
	
	private ApplicationContext getApplicationContext() {
		final MessageContext msgContext = MessageContext.getCurrentContext();
		final ServletContext servletContext = ((HttpServlet) msgContext.getProperty(HTTPConstants.MC_HTTP_SERVLET)).getServletContext();
		return (ApplicationContext) servletContext.getAttribute(DcsServletContextListener.APP_CONTEXT_NAME);
	}
    
    private MapEntryVO[] convertMap(Map<String, String> mapToConvert) { 
        MapEntryVO[] result = new MapEntryVO[mapToConvert.size()]; 
        
        int index = 0;
        for (Map.Entry<String, String> entry : mapToConvert.entrySet()) { 
          result[index++] = new MapEntryVO(entry.getKey(),entry.getValue()); 
        } 

        return result; 
      } 

}
