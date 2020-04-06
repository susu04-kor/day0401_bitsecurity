package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferVo {
	//누가 누구에게 얼마를 이체할 건지
	//이것을 하나의 세트로 담을 vo를 만들기
	
	private String from; 	//돈 보내는 사람
	private String to;		//돈 받는 사람
	private int amount;		//송금액, 이체금액
	
}
