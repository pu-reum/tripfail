package com.trip.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Inquiry {
	
	private int inquiryid;
	private String custid;
	private String icate;
	private String icontent;
	private String file;
	private int iprocess;
	private Date rdate;
}
