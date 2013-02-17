package com.moogu.dcs.server.utils;

/**
 * Save information from a specific thread
 * 
 * @author Patrick Santana <patricksan@me.com>
 * 
 */
public class DcsUserThreadLocal {

    private static ThreadLocal<String> user = new ThreadLocal<String>();

    /**
     * Remove the variable
     */
    public static void cleanUser() {
        DcsUserThreadLocal.user.remove();
    }

    /**
     * Get the user from this thread local
     * 
     * @return the user
     */
    public static String getUser() {
        return DcsUserThreadLocal.user.get();
    }

    /**
     * Set the user for this thread local
     * 
     * @param pUser the user
     */
    public static void setUser(String pUser) {
        DcsUserThreadLocal.user.set(pUser);
    }
}
