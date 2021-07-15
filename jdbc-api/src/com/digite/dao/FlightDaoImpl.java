package com.digite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digite.bean.Flight;
import com.digite.util.JdbcFactory;

public class FlightDaoImpl implements FlightDao {
	
	@Override
	public void persist(Flight flight) throws SQLException {
		String sql = "INSERT INTO flight VALUES (?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, flight.getCode());
			stmt.setString(2, flight.getCarrier());
			stmt.setString(3, flight.getSource());
			stmt.setString(4, flight.getDestination());
			stmt.executeUpdate();
		} finally {
			conn.close();
		}
	}

	@Override
	public Flight fetch(int code) throws SQLException {
		String sql = "SELECT * FROM flight WHERE code=" + code;
		Flight flight = null;
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				flight = new Flight();
				flight.setCode(rs.getInt(1));
				flight.setCarrier(rs.getString(2));
				flight.setSource(rs.getString(3));
				flight.setDestination(rs.getString(4));
			}
			return flight;
		} finally {
			conn.close();
		}
	}

	@Override
	public List<Flight> list() throws SQLException {
		String sql = "SELECT * FROM flight";
		List<Flight> flights = new ArrayList<Flight>();
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				Flight flight = new Flight();
				flight.setCode(rs.getInt(1));
				flight.setCarrier(rs.getString(2));
				flight.setSource(rs.getString(3));
				flight.setDestination(rs.getString(4));
				flights.add(flight);
			}
			return flights;
		} finally {
			conn.close();
		}
	}

	@Override
	public boolean delete(int code) throws SQLException {
		String sql = "DELETE FROM flight WHERE code=" + code;
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			conn.createStatement().executeUpdate(sql);
			return true;
		} finally {
			conn.close();
		}
	}
}
