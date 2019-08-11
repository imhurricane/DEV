package com.appsoft.hk.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehispara")
public class Vehispara {

	
	private String license;
	
	private String licensetype;
	
	public final String getLicense() {
		return license;
	}
	@XmlElement
	public final void setLicense(String license) {
		this.license = license;
	}
	public final String getLicensetype() {
		return licensetype;
	}
	@XmlElement
	public final void setLicensetype(String licensetype) {
		this.licensetype = licensetype;
	}
	
}
