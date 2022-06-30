package com.trade.advice;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trade.dto.ErrorResponseDto;
import com.trade.exceptions.TradeExceptions;

public class TradeAdvice {
	
	@ExceptionHandler(TradeExceptions.class)
	public ResponseEntity<ErrorResponseDto> handleTradeException(TradeExceptions sq){
		ErrorResponseDto errDto = new ErrorResponseDto(sq.getMessage(), LocalDateTime.now(), sq);
		return new ResponseEntity<ErrorResponseDto>(errDto,HttpStatus.OK);
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ErrorResponseDto> handleTradeException(SQLException sq){
		ErrorResponseDto errDto = new ErrorResponseDto(sq.getMessage(), LocalDateTime.now(), sq);
		return new ResponseEntity<ErrorResponseDto>(errDto,HttpStatus.OK);
	}
}
