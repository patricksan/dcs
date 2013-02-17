package com.moogu.dcs.client.common;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.moogu.dcs.client.RemoteServicePool;

/**
 * Enumeration that represents the type of logging. 
 */
public class ClientLog {

    public enum Type implements IsSerializable {
        DEBUG, WARN, INFO, ERROR, AUDIT;
    }

    /**
     * Log in the LOG4J a DEBUG message
     * 
     * @param pMessage the message to be logged
     */
    public static void debug(String pMessage) {
        RemoteServicePool.getCommonModule().log(Type.DEBUG, pMessage, new DcsAsyncCallback<Void>() {

            /**
             * @see com.moogu.dcs.client.common.DcsAsyncCallback#onCustomSuccess(java.lang.Object)
             */
            @Override
            public void onCustomSuccess(Void result) {
                /** do nothing */
            }
        });
    }

    /**
     * Log in the LOG4J a ERROR message
     * 
     * @param pMessage the message to be logged
     */
    public static void error(String pMessage) {
        RemoteServicePool.getCommonModule().log(Type.ERROR, pMessage, new DcsAsyncCallback<Void>() {

            /**
             * @see com.moogu.dcs.client.common.DcsAsyncCallback#onCustomSuccess(java.lang.Object)
             */
            @Override
            public void onCustomSuccess(Void result) {
                /** do nothing */
            }
        });
    }

    /**
     * Log in the LOG4J a INFO message
     * 
     * @param pMessage the message to be logged
     */
    public static void info(String pMessage) {
        RemoteServicePool.getCommonModule().log(Type.INFO, pMessage, new DcsAsyncCallback<Void>() {

            /**
             * @see com.moogu.dcs.client.common.DcsAsyncCallback#onCustomSuccess(java.lang.Object)
             */
            @Override
            public void onCustomSuccess(Void result) {
                /** do nothing */
            }
        });
    }

    /**
     * Log in the LOG4J a WARN message
     * 
     * @param pMessage the message to be logged
     */
    public static void warn(String pMessage) {
        RemoteServicePool.getCommonModule().log(Type.WARN, pMessage, new DcsAsyncCallback<Void>() {

            /**
             * @see com.moogu.dcs.client.common.DcsAsyncCallback#onCustomSuccess(java.lang.Object)
             */
            @Override
            public void onCustomSuccess(Void result) {
                /** do nothing */
            }
        });
    }
}
