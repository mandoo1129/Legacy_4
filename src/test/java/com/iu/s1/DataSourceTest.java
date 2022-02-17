package com.iu.s1;

import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSourceTest extends MyJunitTest{

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSession session;
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(datasource.getConnection());
	}
	
	public void sessionTest() {
		assertNotNull(session);
		
	}
}
