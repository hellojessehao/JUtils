package com.zsh.manyutils;

import com.zsh.manyutils.slice.RouteTestAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class RouteTestAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(RouteTestAbilitySlice.class.getName());
    }
}
