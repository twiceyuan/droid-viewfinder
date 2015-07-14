package com.tcxiaoyi.droid.viewfinder.event;

import android.view.View;
import android.view.View.OnClickListener;

import java.lang.reflect.Method;

public class OnAnnotationClickListener implements OnClickListener {
	
	private Object target;
	private Method method;

	public OnAnnotationClickListener(Object target, Method method) {
		this.target = target;
		this.method = method;
	}

	@Override
	public void onClick(View v) {
		if (!method.isAccessible()) {
			method.setAccessible(true);
		}
		try {
			method.invoke(target, v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
