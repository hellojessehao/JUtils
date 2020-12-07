package com.zsh.manyutils.slice;

import com.zsh.manyutils.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class RouteTestAbilitySlice extends AbilitySlice {

    private Text textHello;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_route_test);
        textHello = (Text)findComponentById(ResourceTable.Id_text_helloworld);
        textHello.setClickedListener(component -> {
            Intent retIntent = new Intent();
            retIntent.setParam("retData","Hello I'm here waiting for you");
            setResult(retIntent);
        });
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
