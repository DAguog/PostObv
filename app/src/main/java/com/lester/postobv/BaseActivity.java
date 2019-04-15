package com.lester.postobv;

import android.support.v7.app.AppCompatActivity;

import com.lester.lib.forview.IViewObserver;
import com.lester.lib.forview.bean.ViewMsgResult;


public abstract class BaseActivity<T extends ViewMsgResult> extends AppCompatActivity implements IViewObserver<T> {



}
