package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecd.dao.NoticeDao;
import com.ecd.dao.PersonDao;
import com.ecd.pojo.Notice;
import com.ecd.tool.TimeGet;

public class NoticeTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	@Test
	public void test() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		NoticeDao noticeDao = (NoticeDao) applicationContext.getBean("noticeDao");
		// 添加测试
		int num = 0;
//		Notice notice  = new Notice();
//		notice.setNotice_id(1);
//		notice.setContent("aouasddas");
//		notice.setNotice_person("sdfasdasd8");
//		notice.setTitle("asadsdas");
//		notice.setTime(TimeGet.getTime());
//		System.out.println(notice);
//		try {
//			num = noticeDao.insertNotice(notice);
//		} catch (Exception e) {
//			System.out.println(num);
//			throw e;
//		}
//		
//		System.out.println(num);
		// 查询所有的通知
//		List<Notice> noticeList = noticeDao.selectAllNotice(4);
//		 System.out.println(noticeList);
		//查询通知的数量
//		 int num = noticeDao.selectNumOfNotice();
//		 System.out.println(num);
		// 查询单个通知测试
//		 Notice notice = noticeDao.selectNoticeById(8);
//		 System.out.println(notice);
		//删除通知测试
//		try {
//			num  = noticeDao.deleteNotice(8);
//		} catch (Exception e) {
//			System.out.println(num);
//			throw e;
//		}
//		System.out.println(num);
	}

}
