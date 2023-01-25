package com.trip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Cust;
import com.trip.frame.MyMapper;

@Repository
@Mapper
public interface CustMapper extends MyMapper<String, Cust> {
	public Cust select2(String k) throws Exception;
	public void nickremove(Cust v) throws Exception;
}
