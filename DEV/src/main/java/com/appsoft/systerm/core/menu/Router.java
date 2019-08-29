package com.appsoft.systerm.core.menu;

import java.util.ArrayList;

public class Router {
	
	private String path;
	
	private String name;
	
	private String component;
	
	private Meta meta;
	
	private ArrayList<Router> children;

	public final String getPath() {
		return path;
	}

	public final void setPath(String path) {
		this.path = path;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getComponent() {
		return component;
	}

	public final void setComponent(String component) {
		this.component = component;
	}

	public final Meta getMeta() {
		return meta;
	}

	public final void setMeta(Meta meta) {
		this.meta = meta;
	}

	public final ArrayList<Router> getChildren() {
		return children;
	}

	public final void setChildren(ArrayList<Router> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Router [path=" + path + ", name=" + name + ", component=" + component + ", meta=" + meta + ", children="
				+ children + "]";
	}
	

}
