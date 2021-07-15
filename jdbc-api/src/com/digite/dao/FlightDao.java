package com.digite.dao;

import java.sql.SQLException;
import java.util.List;

import com.digite.bean.Flight;

public interface FlightDao {
	
	void persist(Flight flight) throws SQLException;
	
	Flight fetch(int code) throws SQLException;
	
	List<Flight> list() throws SQLException;
	
	boolean delete(int code) throws SQLException;
}
