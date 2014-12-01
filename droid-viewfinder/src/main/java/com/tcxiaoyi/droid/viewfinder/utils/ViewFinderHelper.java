package com.tcxiaoyi.droid.viewfinder.utils;

import java.lang.reflect.Field;

import android.app.Activity;
import android.view.View;

import com.tcxiaoyi.droid.viewfinder.annotation.FindViewById;

public class ViewFinderHelper {
	
	public static void findView(Activity target) {
		findView(target, ViewFinderFactory.create(target));
	}
	public static void findView(Object target, View view) {
		findView(target, ViewFinderFactory.create(view));
	}
	
	public static void findView(Object target, ViewFinder viewFinder) {
		Class<?> clazz = target.getClass();

		Field[] fields = clazz.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				findView(target, field, viewFinder);
			}
		}
	}
	
	public static void findView(Object target, Field field, ViewFinder viewFinder) {
		
		if (field.isAnnotationPresent(FindViewById.class)) { //判断是否由findViewById的Annotation声明
			
			if (!field.isAccessible()) {//设置私有属性外部可访问
				field.setAccessible(true);
			}

			int id = field.getAnnotation(FindViewById.class).value();
			View view = viewFinder.findViewById(id);

			//如果找不到控件,id不存在
			if(view==null){
				throw new NullPointerException(field.getName()+"不存在 id为"+id+"的控件声明");
			}
			//如果是类型转换错误
			if(!field.getType().isInstance(view)){
				throw new ClassCastException("要注入的类型:"+field.getType()+",而目标类型:"+view.getClass());
			}

			try {
				field.set(target, view);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
