package com.appsoft.systerm.core.menu;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.appsoft.systerm.core.menu.meta.Meta;
@Entity
@DynamicUpdate
@DynamicInsert
public class Router  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "faceset_generator")
	@GenericGenerator(name = "faceset_generator", strategy = "uuid")
	private String menuId;
	
	private String path;
	
	private String name;
	
	private String component;
	
	private String metaId;
	
	private Meta meta;
	
	private String parentId;
	
//	@Column(insertable = false,columnDefinition = "int default 1")
	private int xh;
		
	public int getXh() {
		return xh;
	}


	public void setXh(int xh) {
		this.xh = xh;
	}


	public Meta getMeta() {
		return meta;
	}


	public void setMeta(Meta meta) {
		this.meta = meta;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	private ArrayList<Router> children;
	
	private int level;


	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getComponent() {
		return component;
	}


	public void setComponent(String component) {
		this.component = component;
	}



	public ArrayList<Router> getChildren() {
		return children;
	}


	public void setChildren(ArrayList<Router> children) {
		this.children = children;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getMetaId() {
		return metaId;
	}


	public void setMetaId(String metaId) {
		this.metaId = metaId;
	}


	@Override
	public String toString() {
		return "Router [menuId=" + menuId + ", path=" + path + ", name=" + name + ", component=" + component
				+ ", metaId=" + metaId + ", meta=" + meta + ", parentId=" + parentId + ", children=" + children
				+ ", level=" + level + "]";
	}


}
