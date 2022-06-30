package com.trade.dto;

import java.time.LocalDateTime;

public class ErrorResponseDto {
	
	private String message;
	private LocalDateTime now;
	private Exception e;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getNow() {
		return now;
	}
	public void setNow(LocalDateTime now) {
		this.now = now;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}
	public ErrorResponseDto(String message, LocalDateTime now, Exception e) {
		super();
		this.message = message;
		this.now = now;
		this.e = e;
	}
	@Override
	public String toString() {
		return "ErrorResponseDto [message=" + message + ", now=" + now + ", e=" + e + "]";
	}
	public ErrorResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
