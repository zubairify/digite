package com.digite.service;
import java.util.List;

import com.digite.bean.Flight;

public interface FlightService {
	
	void save(Flight flight);
	
	Flight get(int code);
	
	List<Flight> getAll();
	
	boolean remove(int code);
}
