package com.example.postobv;

import android.os.Bundle;

import com.example.postobv.result.ViewComponentResult;

public class MainActivity extends BaseActivity<ViewComponentResult> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void handle(ViewComponentResult result) {

    }
}
