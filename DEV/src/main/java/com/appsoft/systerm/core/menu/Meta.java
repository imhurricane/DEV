package com.appsoft.systerm.core.menu;

import java.util.ArrayList;

public class Meta {

	private String icon;
	
	private String title;
	
	private ArrayList<String> access;

	public final String getIcon() {
		return icon;
	}

	public final void setIcon(String icon) {
		this.icon = icon;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final ArrayList<String> getAccess() {
		return access;
	}

	public final void setAccess(ArrayList<String> access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Meta [icon=" + icon + ", title=" + title + ", access=" + access + "]";
	}
	
	
}
