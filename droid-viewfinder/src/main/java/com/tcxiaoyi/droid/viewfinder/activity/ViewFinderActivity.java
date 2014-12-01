package com.tcxiaoyi.droid.viewfinder.activity;

import java.lang.reflect.Field;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.tcxiaoyi.droid.viewfinder.utils.ViewFinder;
import com.tcxiaoyi.droid.viewfinder.utils.ViewFinderFactory;
import com.tcxiaoyi.droid.viewfinder.utils.ViewFinderHelper;

public class ViewFinderActivity extends Activity
{
	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		initAnnotation();
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		super.setContentView(view, params);
		initAnnotation();
	}

	public void setContentView(View view) {
		super.setContentView(view);
		initAnnotation();
	};

	private void initAnnotation() {
		ViewFinder viewFinder = ViewFinderFactory.create(this);
		Class<?> clazz = getClass();
		do {
			Field[] fields = clazz.getDeclaredFields(); //取得本类中所有的属性
			if (fields != null && fields.length > 0) {
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					ViewFinderHelper.findView(this, field, viewFinder);//对每个属性进行注入
				}
			}
		} while ((clazz = clazz.getSuperclass()) != ViewFinderActivity.class);//进行迭代查找
	}
}
