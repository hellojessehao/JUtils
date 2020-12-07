package com.zsh.utils;

import ohos.agp.components.Component;
import ohos.agp.components.Text;

/**
 * @createBy:JesseAndroid
 * @createDate:2020/12/3 14:48
 * @createFor:仿Android TextUtils
 **/
public class TextUtils {

    /**
     * 检测文字控件字符是否为空
     * @param component Text或TextField
     * @return 为空返回true 不为空返回false
     */
    public static boolean isEmpty(Component component){
        if(!(component instanceof Text)){
            return true;
        }
        if(((Text)component).getText() == null || ((Text)component).getText().equals("")){
            return true;
        }
        return false;
    }

    /**
     * 检测字符串是否为空
     * @param charSequence 字符串
     * @return 为空返回true 不为空返回false
     */
    public static boolean isEmpty(CharSequence charSequence){
        if(charSequence == null || charSequence.equals("")){
            return true;
        }
        return false;
    }

}
