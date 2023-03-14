package co.prod.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//ojdbc 활용 : db connection객체
// 특징: 객체 생성하고 반환.
//connection 객체: 서버에 미리 생성 (10개)
//DataSource => Resource  가져오는 룩업(찾아오는 작업)
public class DataSource {
	//싱글톤 방식
	private static SqlSessionFactory sqlSessionFactory; //필드
	private DataSource() {}
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream =null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
		
	}
	
}
