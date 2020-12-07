package com.zsh.utils;

import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.LayoutScatter;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.Context;

/**
 * @createBy:JesseAndroid
 * @createDate:2020/12/3 16:55
 * @createFor:弹吐司工具类,封装鸿蒙ToastDialog
 * 可弹出普通吐司 自定义布局吐司 指定弹出位置吐司
 **/
public class ToastUtils {

    //LENGTH_X 参数与android吐司一致 单位毫秒
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;

    //Align相关参数都是从LayoutAlignment类赋值来的，方便使用
    public static final int BOTTOM = LayoutAlignment.BOTTOM;
    public static final int CENTER = LayoutAlignment.CENTER;
    public static final int END = LayoutAlignment.END;
    public static final int HORIZONTAL_CENTER = LayoutAlignment.HORIZONTAL_CENTER;
    public static final int LEFT = LayoutAlignment.LEFT;
    public static final int RIGHT = LayoutAlignment.RIGHT;
    public static final int START = LayoutAlignment.START;
    public static final int TOP = LayoutAlignment.TOP;
    public static final int UNSET = LayoutAlignment.UNSET;
    public static final int VERTICAL_CENTER = LayoutAlignment.VERTICAL_CENTER;

    /**
     * 弹吐司
     * @param context 上下文
     * @param msg 吐司信息
     * @param duration 吐司显示时长 单位毫秒
     */
    public static void show(Context context,String msg,int duration){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setText(msg);
        toastDialog.setDuration(duration);
        toastDialog.show();
    }

    /**
     * 弹出短时长吐司
     * @param context 上下文
     * @param msg 吐司消息
     */
    public static void show(Context context,String msg){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setText(msg);
        toastDialog.setDuration(LENGTH_SHORT);
        toastDialog.show();
    }

    /**
     * 弹出自定义布局的吐司
     * @param context 上下文
     * @param layout 自定义吐司布局
     * @param duration 吐司显示时长
     */
    public static void show(Context context, DirectionalLayout layout,int duration){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent(layout);
        toastDialog.setDuration(duration);
        toastDialog.show();
    }

    /**
     * 弹出自定义布局的吐司
     * @param context 上下文
     * @param layoutId 布局Id
     * @param duration 显示时长
     */
    public static void show(Context context, int layoutId,int duration){
        Component component = LayoutScatter.getInstance(context).parse(layoutId,null,false);
        if(!(component instanceof DirectionalLayout)){
            Log.e("Custom layout toast only support DirectionalLayout");
            return;
        }
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent((DirectionalLayout) component);
        toastDialog.setDuration(duration);
        toastDialog.show();
    }

    /**
     * 弹出短时长自定义布局的吐司
     * @param context 上下文
     * @param layout 自定义吐司布局
     */
    public static void show(Context context, DirectionalLayout layout){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent(layout);
        toastDialog.setDuration(LENGTH_SHORT);
        toastDialog.show();
    }

    /**
     * 弹出短时长自定义布局的吐司
     * @param context 上下文
     * @param layoutId 布局Id
     */
    public static void show(Context context, int layoutId){
        Component component = LayoutScatter.getInstance(context).parse(layoutId,null,false);
        if(!(component instanceof DirectionalLayout)){
            Log.e("Custom layout toast only support DirectionalLayout");
            return;
        }
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent((DirectionalLayout) component);
        toastDialog.setDuration(LENGTH_SHORT);
        toastDialog.show();
    }

    /**
     * 可定义吐司的弹出位置
     * @param context 上下文
     * @param msg 吐司信息
     * @param duration 吐司显示时长
     * @param alignment 吐司显示位置
     */
    public static void showAlign(Context context,String msg,int duration,int alignment){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setText(msg);
        toastDialog.setDuration(duration);
        toastDialog.setAlignment(alignment);
        toastDialog.show();
    }

    /**
     * 只显示短时间，可定义吐司的弹出位置
     * @param context 上下文
     * @param msg 吐司信息
     * @param alignment 吐司显示位置
     */
    public static void showAlign(Context context,String msg,int alignment){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setText(msg);
        toastDialog.setDuration(LENGTH_SHORT);
        toastDialog.setAlignment(alignment);
        toastDialog.show();
    }

    /**
     * 可自定义布局和弹出位置
     * @param context 上下文
     * @param layout 自定义布局
     * @param duration 显示时长
     * @param alignment 弹出位置
     */
    public static void showAlign(Context context,DirectionalLayout layout,int duration,int alignment){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent(layout);
        toastDialog.setDuration(duration);
        toastDialog.setAlignment(alignment);
        toastDialog.show();
    }

    /**
     * 弹出自定义布局的吐司,可定义弹出位置
     * @param context 上下文
     * @param layoutId 布局Id
     * @param duration 显示时长
     * @param alignment 弹出位置
     */
    public static void show(Context context, int layoutId,int duration,int alignment){
        Component component = LayoutScatter.getInstance(context).parse(layoutId,null,false);
        if(!(component instanceof DirectionalLayout)){
            Log.e("Custom layout toast only support DirectionalLayout");
            return;
        }
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent((DirectionalLayout) component);
        toastDialog.setDuration(duration);
        toastDialog.setAlignment(alignment);
        toastDialog.show();
    }

    /**
     * 短时间弹出,可自定义布局和弹出位置
     * @param context 上下文
     * @param layout 自定义布局
     * @param alignment 弹出位置
     */
    public static void showAlign(Context context,DirectionalLayout layout,int alignment){
        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setComponent(layout);
        toastDialog.setDuration(LENGTH_SHORT);
        toastDialog.setAlignment(alignment);
        toastDialog.show();
    }

}
