package com.tcxiaoyi.droid.viewfinder.utils;

import android.app.Activity;
import android.view.View;

public class ActivityViewFinder implements ViewFinder {

	private Activity activity;
	
	public ActivityViewFinder(Activity activity) {
		this.activity = activity;
	}
	@Override
	public View findViewById(int id) {
		return activity.findViewById(id);
	}

}
