package com.digite.service;

import java.sql.SQLException;
import java.util.List;

import com.digite.bean.Flight;
import com.digite.dao.FlightDao;
import com.digite.dao.FlightDaoImpl;

public class FlightServiceImpl implements FlightService {
	private FlightDao dao;
	
	public FlightServiceImpl() {
		dao = new FlightDaoImpl();
	}

	public FlightServiceImpl(FlightDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void save(Flight flight) {
		try {
			dao.persist(flight);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Flight get(int code) {
		try {
			return dao.fetch(code);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Flight> getAll() {
		try {
			return dao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean remove(int code) {
		try {
			return dao.delete(code);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
