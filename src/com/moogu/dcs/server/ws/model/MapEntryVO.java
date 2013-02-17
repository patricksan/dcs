package com.moogu.dcs.server.ws.model;

/**
 * From: http://wiki.apache.org/ws/FrontPage/Axis/DotNetInteropMapInfo
 * 
 * @author fmfurtado
 */
public class MapEntryVO { 
    private String  key; 
    private String  value; 

    public MapEntryVO() { 
    } 

    public MapEntryVO(String key, String value) { 
      this.key   = key; 
      this.value = value; 
    } 

    public String getKey() { 
      return key; 
    } 
    public void setKey(String value) { 
      key = value; 
    } 

    public String getValue() { 
      return value; 
    } 
    public void setValue(String value) { 
      this.value = value; 
    } 
  } 