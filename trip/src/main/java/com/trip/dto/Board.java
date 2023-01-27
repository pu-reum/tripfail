package com.trip.dto;

import java.time.LocalDate;
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
public class Board {
	private int postid;
	private int cateid;
	private String custid;
	private String title;
	private String content;
	private int highpostid;
	private int hit;
	private LocalDate rdate;
	private String catename;
	
	
	public Board(int postid, int cateid, String custid, String title, String content, LocalDate rdate, String catename) {
		super();
		this.postid = postid;
		this.cateid = cateid;
		this.custid = custid;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.catename=catename;
	}
	
}
