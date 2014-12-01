package com.tcxiaoyi.droid.viewfinder;

import android.os.Bundle;
import android.widget.TextView;

import com.tcxiaoyi.droid.viewfinder.activity.ViewFinderActivity;
import com.tcxiaoyi.droid.viewfinder.annotation.FindViewById;

public class HelloViewFinderActivity extends ViewFinderActivity {
	
	@FindViewById(value=R.id.tip)
	private TextView text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(text.getText().toString());
    }
}

