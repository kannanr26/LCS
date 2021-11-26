package com.java.lcs.model;

import lombok.Data;

@Data
public class LCS {
	public LCS(String[] value, String msg) {
		// TODO Auto-generated constructor stub

		this.value = value;
		this.msg = msg;
	}

	private String msg;
	private String[] value;

}