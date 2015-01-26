package com.sframework.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * User: 孙伟力
 * Date: 15/1/26
 * Time: 下午7:02
 */
public class BasePage extends Fragment {

    View viewRoot = null;
    TextView textView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.page, container, false);
        textView = (TextView) viewRoot.findViewById(R.id.textview);
        textView.setText("page:" + PageNavigate.getInstance().getStackLength());
        return viewRoot;
    }
}
