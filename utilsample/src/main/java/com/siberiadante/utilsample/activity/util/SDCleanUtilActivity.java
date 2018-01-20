package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;

import com.siberiadante.androidutil.util.SDCacheUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

public class SDCleanUtilActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdclean_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDCleanUtil");
        final StringBuilder builder = new StringBuilder();
        String totalCacheSize = null;
        try {
            totalCacheSize = SDCacheUtil.getTotalCacheSize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.append("获取当前APP缓存：").append(totalCacheSize);
    }
}
