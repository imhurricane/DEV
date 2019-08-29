package com.appsoft.systerm.Response;

public class ResponseEntity {
	
	private int code;
	
	private String msg;
	
	private Object data;

	public final int getCode() {
		return code;
	}

	public final void setCode(int code) {
		this.code = code;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}

	public final Object getData() {
		return data;
	}

	public final void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseEntity [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	

}
