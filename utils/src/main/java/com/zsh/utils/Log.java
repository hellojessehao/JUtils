package com.zsh.utils;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

/**
 * @createBy:JesseAndroid
 * @createDate:2020/12/3 15:29
 * @createFor:封装华为HiLog
 **/
public class Log {

    private static final String TAG = "zsh";

    private static final int DOMAIN = 0x01;

    private static final HiLogLabel LOG_LABLE = new HiLogLabel(HiLog.LOG_APP, DOMAIN, TAG);


    public static void i(String message) {

        HiLog.info(LOG_LABLE, "%{public}s", message);

    }


    public static void e(String message) {

        HiLog.error(LOG_LABLE, "%{public}s", message);

    }


    public static void d(String message) {

        HiLog.debug(LOG_LABLE, "%{public}s", message);

    }


    public static boolean isDebug() {

        return HiLog.isLoggable(DOMAIN, TAG, HiLog.DEBUG);

    }

}
