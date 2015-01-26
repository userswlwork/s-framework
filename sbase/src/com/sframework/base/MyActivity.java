package com.sframework.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * 主页面栈
 * User: 孙伟力
 * Date: 15/1/26
 * Time: 下午7:12
 */
public class MyActivity extends FragmentActivity {
    Button button;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        PageNavigate.getInstance().init(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageNavigate.getInstance().navigate(BasePage.class);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PageNavigate.getInstance().back();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
