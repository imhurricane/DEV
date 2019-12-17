package com.appsoft.systerm.core.menu.meta;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Meta  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "faceset_generator")
	@GenericGenerator(name = "faceset_generator", strategy = "uuid")
	private String metaId;

	private String icon;
	
	private String title;
	
	private ArrayList<String> access;
	
	private boolean notCache;

	public String getMetaId() {
		return metaId;
	}

	public void setMetaId(String metaId) {
		this.metaId = metaId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getAccess() {
		return access;
	}

	public void setAccess(ArrayList<String> access) {
		this.access = access;
	}

	public boolean isNotCache() {
		return notCache;
	}

	public void setNotCache(boolean notCache) {
		this.notCache = notCache;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Meta [metaId=" + metaId + ", icon=" + icon + ", title=" + title + ", access=" + access + ", notCache="
				+ notCache + "]";
	}

}
