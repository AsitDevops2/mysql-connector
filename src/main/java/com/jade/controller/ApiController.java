package com.jade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jade.model.MysqlConnectionRequest;
import com.jade.model.Response;
import com.jade.service.ApiService;

/**
 * @author saklen.mulla
 *
 */
@RestController
@RequestMapping("/api/v1/mysql")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/getConnection")
	public Response getConnectionFromMysql(@RequestBody MysqlConnectionRequest request) {
		String msg=apiService.getConnectionFromMysql(request);
		if(msg.equals("success"))
			return new Response(HttpStatus.OK.value(),"OK" , "Mysql Connection : Success");
		else
			return new Response(HttpStatus.BAD_REQUEST.value(),msg, "Mysql Connection : Failed");
	}
	
}
