package com.appsoft.hk.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Root {

	private List<Head> heads;

	private List<Vehispara> stavehisparas;

	public final List<Head> getHeads() {
		return heads;
	}

	@XmlElement(name = "head")
	public final void setHeads(List<Head> heads) {
		this.heads = heads;
	}

	public final List<Vehispara> getStavehisparas() {
		return stavehisparas;
	}

	@XmlElement(name = "vehispara")
	public final void setStavehisparas(List<Vehispara> stavehisparas) {
		this.stavehisparas = stavehisparas;
	}

}
