package com.tcxiaoyi.droid.viewfinder.utils;

import android.app.Dialog;
import android.view.View;

public class DialogViewFinder implements ViewFinder {

	private Dialog dialog;
	
	public DialogViewFinder(Dialog dialog) {
		this.dialog = dialog;
	}
	@Override
	public View findViewById(int id) {
		return dialog.findViewById(id);
	}
}
