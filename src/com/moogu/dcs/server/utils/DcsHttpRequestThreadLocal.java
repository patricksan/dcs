package com.moogu.dcs.server.utils;

import javax.servlet.http.HttpServletRequest;

public class DcsHttpRequestThreadLocal {

    private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();

    public static void clean() {
        DcsHttpRequestThreadLocal.request.remove();
    }

    public static HttpServletRequest get() {
        return DcsHttpRequestThreadLocal.request.get();
    }

    public static void set(HttpServletRequest request) {
        DcsHttpRequestThreadLocal.request.set(request);
    }
}
