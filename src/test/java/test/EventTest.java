package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecd.dao.EventDao;
import com.ecd.pojo.Event;
import com.ecd.tool.TimeGet;
import com.ecd.tool.UUIDGet;

public class EventTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void test() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		EventDao eventDao = (EventDao) applicationContext.getBean("eventDao");
		// 添加测试
		int num = 0;
//		Event event = new Event();
////		event.setEvent_id(UUIDGet.getUUID());
//		event.setEvent_description("天然气泄漏事故");
//		event.setEvent_address("重邮食堂");
//		event.setEvent_time("2018.5.5");
//		event.setEvent_person("曹先生");
//		event.setEvent_finish_person("sadasda");
//		event.setEvent_logging_time(TimeGet.getTime());
//		event.setEvent_grade("重大事故");
//		System.out.println(event);
//		try {
//			num = eventDao.insertEvent(event);
//		} catch (Exception e) {
//			System.out.println(num);
//			throw e;
//		}
//		System.out.println(num);
		
		//删除事件测试
//		num = eventDao.deleteEventById("21213");
//		System.out.println(num);
		
		//查看所有事件操作
//		List<Event> event = eventDao.selectAllEvent(0);
//		System.out.println(event);
		
		//查询事件总数目
//		num = eventDao.selectNumOfEvent();
//		System.out.println(num);
		
		//查询单个事件
//		Event event = eventDao.selectEventById("af9cf97b501311e8ad73c4346b4b53dd");
//		System.out.println(event);
		
		//修改事件信息
//		Event event = new Event();
//		event.setEvent_id("a229823982244e1ab4885a6b6cfaa2b6");
//		event.setEvent_summary("mission success");
//		event.setEvent_finish_person("李四");
//		event.setEvent_time(TimeGet.getTime());
//		num = eventDao.updateEventById(event);
//		System.out.println(num);
		
		
	}
}
