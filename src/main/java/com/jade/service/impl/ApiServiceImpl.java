package com.jade.service.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.jade.model.MysqlConnectionRequest;
import com.jade.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	@Override
	public String getConnectionFromMysql(MysqlConnectionRequest request) {
		String connectionStatus="success";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(request.getUrl(),request.getUserName(),request.getPassword());
			
		} catch (ClassNotFoundException|SQLException e) {
			connectionStatus=e.getMessage();
		}
		
		return connectionStatus;
	}

}
