package com.tcxiaoyi.droid.viewfinder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.tcxiaoyi.droid.viewfinder.annotation.FindViewById;
import com.tcxiaoyi.droid.viewfinder.utils.ViewFinderHelper;

public class HelloViewFinderActivity2 extends Activity {
	
	@FindViewById(value=R.id.tip)
	private TextView text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFinderHelper.findView(this);
        System.out.println(text.getText());
    }
}

