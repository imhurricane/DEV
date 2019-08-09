package com.appsoft.systerm.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class PojoVo {
	
	@Excel(name = "url地址", orderNum = "1", width = 20)
	private String url;
	@Excel(name = "编码", orderNum = "2", width = 20)
	private String code;
	
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final String getCode() {
		return code;
	}
	public final void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "PojoVo [url=" + url + ", code=" + code + "]";
	}
	
}
