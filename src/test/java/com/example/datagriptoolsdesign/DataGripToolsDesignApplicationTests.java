package com.example.datagriptoolsdesign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DataGripToolsDesignApplicationTests {

	@Autowired
	DataSource datasource;

	@Test
	void contextLoads() throws SQLException {
		System.out.println(datasource.getClass());
		System.out.println(datasource.getConnection());
		System.out.println("数据库连接");

	}

}
