package com.moogu.dcs.server.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

import com.moogu.dcs.shared.utils.DcsSharedException;


public final class DcsExceptionUtils {

    public static DcsSharedException toSharedException(Throwable throwable, String code) {
        if (throwable instanceof DcsSharedException) {
            return (DcsSharedException) throwable;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        printWriter.flush();
        IOUtils.closeQuietly(printWriter);
        String stringStackTrace = stringWriter.toString();
        IOUtils.closeQuietly(stringWriter);

        String causeClassName = throwable.getClass().getName();
        DcsSharedException exception = new DcsSharedException(
                        causeClassName,
                        throwable.getMessage(),
                        code,
                        stringStackTrace);
        return exception;
    }

    public static DcsSharedException toSharedException(Throwable throwable) {
        return toSharedException(throwable, null);
    }

    public static DcsSharedException toSharedException(String errorCode) {
        DcsSharedException exception = new DcsSharedException(null, null, errorCode, null);
        return exception;
    }

}
