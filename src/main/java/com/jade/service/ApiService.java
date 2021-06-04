package com.jade.service;

import com.jade.model.MysqlConnectionRequest;

public interface ApiService {
	public String getConnectionFromMysql(MysqlConnectionRequest request);
}
