package com.trade.exceptions;

public class TradeExceptions extends Exception{

	private static final long serialVersionUID=1000l;
	
	public TradeExceptions(Exception e) {
		super(e);
	}
	
	public TradeExceptions(String s) {
		super(s);
	}
	
	
}
