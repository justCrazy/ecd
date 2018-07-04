package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.ecd.dao.PersonDao;
import com.ecd.pojo.Person;
import com.ecd.pojo.PersonToRegist;

public class PersonTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	@Rollback(false)
	public void testLogin() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		int num = 0;
		PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
		// 查询测试
//		 Person person = personDao.selectPersonById("1062646428@qq.com");
//		 System.out.println(person);
		// personDao.updatePassword("123456","1062646428@qq.com");
//		 PersonToRegist person = personDao.selectRegistPersonById("1qwre");
//		 System.out.println(person);
		// 删除测试
//		 personDao.deletePerson("1062646428@qq.com");
		// 添加测试
//		Person person = new Person();
//		person.setEmail("1asdawre");
//		person.setPassword("456");
//		person.setName("LYXewerwrwe");
//		person.setGender("wer男");
//		person.setIdentity("1we");
//		person.setPhone("4564we56");
//		System.out.println(person);
//		num = personDao.insertLeo(person);
//		System.out.println(num);
//		 查询所有执法人员
//		 List<Person> person = personDao.selectAllLeo(5);
//		 System.out.println(person);
		//查询待注册人员
//		List<PersonToRegist> person = personDao.selectAllRegistPerson(0);
//		System.out.println(person);
		// 查询执法人员数量
//		 int num = personDao.selectNumOfLeo();
		//// 查询待注册人员数量
//		num = personDao.selectNumOfRegistPerson();
//		 System.out.println(num);
		// 注册操作测试
		PersonToRegist person = new PersonToRegist();
		person.setRegist_person_email("1qwre");
		person.setRegist_person_password("456");
		person.setRegist_person_name("LYXewerwrwe");
		person.setRegist_person_gender("wer男");
		person.setRegist_person_verify("1we");
		person.setRegist_person_phone("4564we56");
		System.out.println(person);
		num = personDao.insertPerson(person);
		System.out.println(num);
		
		//更新密码测试
//		Person person = new Person();
//		person.setEmail("1062646428@qq.com");
//		person.setPassword("4asdasdas");
//		num = personDao.updatePassword(person);
//		System.out.println(num);
		
		//人员信息更新操作
//		Person person = new Person();
//		person.setEmail("1062646428@qq.com");
//		person.setName("水汽");
//		person.setPhone("123456");
//		num = personDao.updatePersonInfo(person);
//		System.out.println(num);
		
		//更新验证码
//		PersonToRegist personToRegist = new PersonToRegist();
//		personToRegist.setRegist_person_email("1qwre");
//		personToRegist.setRegist_person_verify("asdas6");
//		num = personDao.updateVerify(personToRegist);
//		System.out.println(num);
	}
}
