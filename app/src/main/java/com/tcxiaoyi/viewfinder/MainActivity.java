package com.tcxiaoyi.viewfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.tcxiaoyi.droid.viewfinder.annotation.FindViewById;
import com.tcxiaoyi.droid.viewfinder.utils.ViewFinderHelper;

public class MainActivity extends AppCompatActivity {

    @FindViewById(R.id.tv_main)
    TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewFinderHelper.findView(this);
        Toast.makeText(this, tv_main.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
