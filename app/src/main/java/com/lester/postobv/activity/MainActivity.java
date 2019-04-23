package com.lester.postobv.activity;

import android.os.Bundle;

import com.lester.postobv.activity.base.BaseActivity;
import com.lester.postobv.R;
import com.lester.postobv.result.ViewComponentResult;

public class MainActivity extends BaseActivity<ViewComponentResult> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //

    }

    @Override
    public void handle(ViewComponentResult result) {

    }
}
