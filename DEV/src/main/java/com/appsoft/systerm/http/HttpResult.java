package com.appsoft.systerm.http;

public class HttpResult {
	
	public HttpResult(int code, String body) {
		super();
		this.code = code;
		this.body = body;
	}

	// 响应的状态码
	private int code;
	
	// 响应的响应体
	private String body;

	public final int getCode() {
		return code;
	}

	public final void setCode(int code) {
		this.code = code;
	}

	public final String getBody() {
		return body;
	}

	public final void setBody(String body) {
		this.body = body;
	}

	
}
