package com.appsoft.systerm.Response;

public class ResponseEntity {
	
	private int code;
	
	private String msg;
	
	private Object data;
	
	private int total;

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

	public final int getTotal() {
		return total;
	}

	public final void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ResponseEntity [code=" + code + ", msg=" + msg + ", data=" + data + ", total=" + total + "]";
	}


}
