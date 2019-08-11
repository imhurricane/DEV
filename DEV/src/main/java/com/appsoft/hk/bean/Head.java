package com.appsoft.hk.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
public class Head {

	private String organ;
	
	private String jkxlh;
	
	private String jkid;
	
	private String sjc;
	
	public final String getOrgan() {
		return organ;
	}
	@XmlElement
	public final void setOrgan(String organ) {
		this.organ = organ;
	}
	public final String getJkxlh() {
		return jkxlh;
	}
	@XmlElement
	public final void setJkxlh(String jkxlh) {
		this.jkxlh = jkxlh;
	}
	public final String getJkid() {
		return jkid;
	}
	@XmlElement
	public final void setJkid(String jkid) {
		this.jkid = jkid;
	}
	public final String getSjc() {
		return sjc;
	}
	@XmlElement
	public final void setSjc(String sjc) {
		this.sjc = sjc;
	}
	
}
