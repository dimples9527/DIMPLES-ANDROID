package com.dimples;

import android.os.Bundle;

import com.dimples.base.BaseActivity;
import com.dimples.component.ViewInject;


@ViewInject(LayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
