package com.trip.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		List<Cust> custs = null;
		try {
			custs = service.get();
			for(Cust c:custs) {
				System.out.println(c);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







