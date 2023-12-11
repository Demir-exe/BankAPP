package com.akdenizbank.mls.generic.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class GenericApiResponse {

	private int code;

	private String message;

	private String responsecode;

	private Object object;

	private String resulthashcode;

	public GenericApiResponse() {
		super();
		this.code = -1;
		this.message = "N/A";
		this.responsecode = "N/A";
		this.object = null;
		this.resulthashcode = null;
	}

	public GenericApiResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
		this.responsecode = "N/A";
		this.object = null;
		this.resulthashcode = null;
	}

	public GenericApiResponse(int code, String message, String responsecode) {
		super();
		this.code = code;
		this.message = message;
		this.responsecode = responsecode;
		this.object = null;
		this.resulthashcode = null;
	}

	public GenericApiResponse(int code, String message, String responsecode, Object object) {
		super();
		this.code = code;
		this.message = message;
		this.responsecode = responsecode;
		this.object = object;
		this.resulthashcode = null;
	}

	public GenericApiResponse(int code, String message, String responsecode, Object object, String resulthashcode) {
		super();
		this.code = code;
		this.message = message;
		this.responsecode = responsecode;
		this.object = object;
		this.resulthashcode = resulthashcode;
	}

}
