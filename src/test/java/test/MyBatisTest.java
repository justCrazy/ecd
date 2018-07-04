package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ecd.pojo.Person;
public class MyBatisTest {

	@Test
	public void findUserTest() throws IOException {
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		/*
		 * 第一个参数为映射文件的id：namespace + '.' +statement的id
		 * 第二个参数：指定和映射文件中所匹配的parameterType参数
		 */
		Person person = sqlSession.selectOne("test.findUserById", "1062646428@qq.com");
		System.out.println("------------------------------");
		System.out.println(person);
		System.out.println("------------------------------");
		sqlSession.close();
	}
}
