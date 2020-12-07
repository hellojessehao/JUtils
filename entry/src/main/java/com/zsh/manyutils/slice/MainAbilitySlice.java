package com.zsh.manyutils.slice;

import com.zsh.manyutils.ResourceTable;
import com.zsh.manyutils.RouteTestAbility;
import com.zsh.utils.AbilityRouteUtils;
import com.zsh.utils.Log;
import com.zsh.utils.ToastUtils;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.Text;

public class MainAbilitySlice extends AbilitySlice {

    private Text textHello;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        textHello = (Text) findComponentById(ResourceTable.Id_text_helloworld);
        textHello.setClickedListener(component -> {
//            AbilityRouteUtils.routeToAbility(this, RouteTestAbility.class);
//            AbilityRouteUtils.routeToAbilityForResult(this,RouteTestAbility.class,0x01);
//            AbilityRouteUtils.routeToAbility(this,getBundleName(),RouteTestAbility.class.getSimpleName());
//            AbilityRouteUtils.routeToAbility(this,getBundleName(),RouteTestAbility.class.getName());
//            ToastUtils.showAlign(this,"试试这个吐司好不好吃",ToastUtils.LENGTH_LONG,ToastUtils.TOP);
//            ToastUtils.show(this, (DirectionalLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_custom_toast_layout,null,false));
//            ToastUtils.show(this,ResourceTable.Layout_custom_toast_layout,ToastUtils.LENGTH_LONG,ToastUtils.HORIZONTAL_CENTER);
        });
    }

    @Override
    protected void onAbilityResult(int requestCode, int resultCode, Intent resultData) {
        super.onAbilityResult(requestCode, resultCode, resultData);
        if(requestCode == 0x01){
            Log.i("get return from target ability : "+resultData.getStringParam("retData"));
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
