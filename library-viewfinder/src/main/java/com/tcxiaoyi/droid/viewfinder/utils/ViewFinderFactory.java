package com.tcxiaoyi.droid.viewfinder.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

public class ViewFinderFactory {
	
	public static ViewFinder create(Activity activity){
		return new ActivityViewFinder(activity);
	}
	public static ViewFinder create(Dialog dialog){
		return new DialogViewFinder(dialog);
	}
	
	public static ViewFinder create(View view){
		return new ViewViewFinder(view);
	}
}
