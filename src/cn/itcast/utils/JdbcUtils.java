package cn.itcast.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {

	private static DataSource ds;
	
	static{
		InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			
			BasicDataSourceFactory factory=new BasicDataSourceFactory();
			ds=factory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
