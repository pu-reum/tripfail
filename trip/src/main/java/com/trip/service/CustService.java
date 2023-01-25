package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Cust;
import com.trip.frame.MyService;
import com.trip.mapper.CustMapper;

@Service
public class CustService implements MyService<String, Cust>{
	
	@Autowired
	CustMapper mapper;
	
	@Override
	public void register(Cust v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(Cust v) throws Exception {
		mapper.update(v);
		
	}
	
	public void nickremove(Cust v) throws Exception {
		mapper.nickremove(v);
		
	}

	@Override
	public Cust get(String k) throws Exception {
		return mapper.select(k);
	}
	
	public Cust get2(String k) throws Exception {
		return mapper.select2(k);
	}

	@Override
	public List<Cust> get() throws Exception {
		return mapper.selectall();
	}

}
