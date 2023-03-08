package co.dev.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource { //싱글톤 클래스.
	private static SqlSessionFactory SqlSessionFactory;
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
	
	//커넥션풀을 사용하여 서버의 속도처리를 좋게함.
	//풀에 담아서 반환하고 처리하고 반환하고 처리하는 방식
		
	String resource = "config/mybatis-config.xml"; //바티스에 대한 환경파일이 담겨있음
	InputStream inputStream=null;
	try {
		inputStream = Resources.getResourceAsStream(resource);
	}catch(IOException e) {
		e.printStackTrace();
	}
	SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
	return SqlSessionFactory; //sqlsession 여러개 담고 있는 pool; 
	}

}
