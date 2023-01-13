package com.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.dto.Cust;
import com.trip.frame.MyService;

@Service
public class CustService implements MyService<String, Cust>{
	
	@Override
	public void register(Cust v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Cust v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cust get(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cust> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
