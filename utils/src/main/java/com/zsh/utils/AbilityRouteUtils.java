package com.zsh.utils;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.app.AbilityContext;

/**
 * @createBy:JesseAndroid
 * @createDate:2020/12/3 14:44
 * @createFor:对页面跳转代码进行封装
 **/
public class AbilityRouteUtils {

    /**
     * 根据Ability的class跳转
     * @param context 传入的context如果不是Ability或AbilitySlice，
     *      *         会调用startAbility二参数的方法，requestCode默认传0x01
     * @param clazz 目标类的class
     */
    public static void routeToAbility(AbilityContext context,Class<? extends Ability> clazz){
        if(clazz == null){
            Log.e("Route failed by clazz is null");
            return;
        }
        Intent intent = genIntent("",clazz.getPackage().getName(),clazz.getName());
        if(context instanceof Ability) ((Ability) context).startAbility(intent);
        else if(context instanceof AbilitySlice) ((AbilitySlice) context).startAbility(intent);
        else context.startAbility(intent,0x01);
    }

    /**
     * 跳转到目标类并请求返回结果
     * @param context 必须传Ability或AbilitySlice类型上下文
     * @param clazz 目标类的class
     * @param requestCode 请求码
     */
    public static void routeToAbilityForResult(AbilityContext context,Class<? extends Ability> clazz,int requestCode){
        if(!(context instanceof Ability) && !(context instanceof AbilitySlice)){
            Log.e("context must be instanceof Ability or AbilitySlice");
            return;
        }
        if(clazz == null){
            Log.e("Route failed by clazz is null");
            return;
        }
        Intent intent = genIntent("",clazz.getPackage().getName(),clazz.getName());
        if(context instanceof Ability) ((Ability) context).startAbilityForResult(intent,requestCode);
        else ((AbilitySlice) context).startAbilityForResult(intent,requestCode);
    }

    /**
     * 跳转到其他设备的目标类
     * @param context 传入的context如果不是Ability或AbilitySlice，
     *      *         会调用startAbility二参数的方法，requestCode默认传0x01
     * @param deviceName 目标设备名
     * @param bundleName 目标类所在包名
     * @param abilityName 目标完整类名或类名
     */
    public static void routeToAbility(AbilityContext context,String deviceName,String bundleName,String abilityName){
        if(TextUtils.isEmpty(deviceName) || TextUtils.isEmpty(bundleName) || TextUtils.isEmpty(abilityName)){
            Log.e("deiviceName,bundle name or ability name is empty");
            return;
        }
        Intent intent = genIntent(deviceName,bundleName,abilityName);
        if(context instanceof Ability) ((Ability) context).startAbility(intent);
        else if(context instanceof AbilitySlice) ((AbilitySlice) context).startAbility(intent);
        else context.startAbility(intent,0x01);
    }

    /**
     * 跳转到其他设备的目标类并等待返回结果
     * @param context 必须传Ability或AbilitySlice类型上下文
     * @param deviceName 目标设备名
     * @param bundleName 目标类所在包名
     * @param abilityName 目标完整类名或类名
     * @param requestCode 请求码
     */
    public static void routeToAbilityForResult(AbilityContext context,String deviceName,String bundleName,String abilityName,int requestCode){
        if(!(context instanceof Ability) && !(context instanceof AbilitySlice)){
            Log.e("context must be instanceof Ability or AbilitySlice");
            return;
        }
        if(TextUtils.isEmpty(deviceName) || TextUtils.isEmpty(bundleName) || TextUtils.isEmpty(abilityName)){
            Log.e("deiviceName,bundle name or ability name is empty");
            return;
        }
        Intent intent = genIntent(deviceName,bundleName,abilityName);
        if(context instanceof Ability) ((Ability) context).startAbilityForResult(intent,requestCode);
        else ((AbilitySlice) context).startAbilityForResult(intent,requestCode);
    }

    /**
     * 路由到目标Ability
     * @param context 传入的context如果不是Ability或AbilitySlice，
     *                会调用startAbility二参数的方法，requestCode默认传0x01
     * @param bundleName 跳转目标类包名
     * @param abilityName 跳转目标完整类名或类名
     */
    public static void routeToAbility(AbilityContext context, String bundleName, String abilityName){
        if(TextUtils.isEmpty(bundleName) || TextUtils.isEmpty(abilityName)){
            Log.e("bundle name or ability name is empty");
            return;
        }
        Intent intent = genIntent("",bundleName,abilityName);
        if(context instanceof Ability) ((Ability) context).startAbility(intent);
        else if(context instanceof AbilitySlice) ((AbilitySlice) context).startAbility(intent);
        else context.startAbility(intent,0x01);
    }

    /**
     * 跳转到目标类并请求返回结果
     * @param context 必须传Ability或AbilitySlice类型上下文
     * @param bundleName 目标类所在包名
     * @param abilityName 目标完整类名或类名
     * @param requestCode 请求码
     */
    public static void routeToAbilityForResult(AbilityContext context,String bundleName,String abilityName,int requestCode){
        if(!(context instanceof Ability) && !(context instanceof AbilitySlice)){
            Log.e("context must be instanceof Ability or AbilitySlice");
            return;
        }
        if(TextUtils.isEmpty(bundleName) || TextUtils.isEmpty(abilityName)){
            Log.e("bundle name or ability name is empty");
            return;
        }
        Intent intent = genIntent("",bundleName,abilityName);
        if(context instanceof Ability) ((Ability) context).startAbilityForResult(intent,requestCode);
        else ((AbilitySlice) context).startAbilityForResult(intent,requestCode);
    }

    /**
     * 根据Action跳转页面
     * @param context 传入的context如果不是Ability或AbilitySlice，
     *      *         会调用startAbility二参数的方法，requestCode默认传0x01
     * @param action 目标页的Action
     */
    public static void routeToAbility(AbilityContext context,String action){
        if(TextUtils.isEmpty(action)){
            Log.e("Route failed by action is empty");
            return;
        }
        Operation operation = new Intent.OperationBuilder()
                .withAction(action)
                .build();
        Intent intent = new Intent();
        intent.setOperation(operation);
        if(context instanceof Ability) ((Ability) context).startAbility(intent);
        else if(context instanceof AbilitySlice) ((AbilitySlice) context).startAbility(intent);
        else context.startAbility(intent,0x01);
    }

    /**
     * 根据参数生成intent实例
     * @param deviceName 设备名
     * @param bundleName 包名
     * @param abilityName 完整类名或类名
     * @return intent
     */
    private static Intent genIntent(String deviceName,String bundleName,String abilityName){
        Operation operation;
        if(abilityName.contains(".")){
            operation = new Intent.OperationBuilder()
                    .withDeviceId(deviceName)
                    .withBundleName(bundleName)
                    .withAbilityName(abilityName)
                    .build();
        }else{
            operation = new Intent.OperationBuilder()
                    .withDeviceId(deviceName)
                    .withBundleName(bundleName)
                    .withAbilityName(bundleName+"."+abilityName)
                    .build();
        }
        Intent intent = new Intent();
        intent.setOperation(operation);
        return intent;
    }

}
