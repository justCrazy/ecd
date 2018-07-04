package com.ecd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ecd.pojo.Person;
import com.ecd.pojo.PersonToRegist;
import com.ecd.service.PersonService;
import com.ecd.tool.EmailCheck;
import com.ecd.tool.EncoderByMd5;
import com.ecd.tool.PageResult;
import com.ecd.tool.Result;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;

	/**
	 * 登录功能
	 * 
	 * @param session
	 * @param email
	 * @param password
	 * @return String
	 */
	@RequestMapping(value = "/loginPerson", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String login( @RequestBody String jsonString,HttpServletRequest request) {
		Person person= JSON.parseObject(jsonString, Person.class);
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
		System.out.println("有趣");
		// 将前端传来的数据封装为person对象
//		Person person = new Person();
//		person.setEmail(email);
//		person.setPassword(password);
		System.out.println("----------------前端传送数据" + person);
		
		// 根据传入的email查询出数据库中的持久checkedPerson
		Person checkedPerson = personService.loginPerson(person.getEmail());
		String password = EncoderByMd5.getMd5(person.getPassword());
		System.out.println(checkedPerson);
		// 如果checkedPerson，证明没有注册
		if (checkedPerson != null) {
			// 如果密码相同，则登录成功
			if (checkedPerson.getPassword().equals(password)) {
				// 将用户信息添加到session中，方便操作
				request.getSession().setAttribute("person", checkedPerson);
				Person person2 = (Person) request.getSession().getAttribute("person");
				System.out.println("--------session中的person-----------    "+person2);
				return Result.success(checkedPerson).toJSONString();
			} else {
				return Result.failed("500", "密码错误，请重新输入，或点忘记密码").toJSONString();
			}
		} else {
			return Result.failed("500", "该用户没有注册，或者注册没被通过，请于管理员联系").toJSONString();
		}
	}

	/**
	 * 注销功能
	 * 
	 * @param session
	 * @param email
	 * @param password
	 * @return String
	 */
	@RequestMapping(value = "/logoutPerson", produces = "application/text;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String logoutPerson(HttpServletRequest request) {
		// 将用户信息添加到session中，方便操作
		request.getSession().invalidate();
		request.getSession().removeAttribute("person");
		return Result.success().toJSONString();
	}

	/**
	 * 注册功能
	 * @param personToRegist
	 * @return
	 */
	@RequestMapping(value = "/registPerson", produces = "application/json;charset=utf-8"
			, method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String registPerson(@RequestBody String jsonString) {
		PersonToRegist personToRegist= JSON.parseObject(jsonString, PersonToRegist.class);
		System.out.println(personToRegist);
		// 获取前端传来的personToRegist对象的属性
		String verify = personToRegist.getRegist_person_verify();
		String email = personToRegist.getRegist_person_email();
		personToRegist.setRegist_person_password(EncoderByMd5.getMd5(personToRegist.getRegist_person_password()));
		// 根据email获取数据库中存储的checkVerify
		String checkVerify = personService.selectRegistPersonById(email).getRegist_person_verify();
		// 如果两个验证码是相同的，则进入下一层的验证，否则返回验证码错误的消息
		if (checkVerify.equals(verify)) {
			// 如果添加操作成功，则返回成功结果，否则返回失败操作
			int num = personService.insertPerson(personToRegist);
			if (num == 1) {
				personService.sendText("注册成功，请等待管理员的审核", email);
				return Result.success().toJSONString();
			} else {
				return Result.failed("500", "注册失败").toJSONString();
			}
		} else {
			return Result.failed("500", "验证码错误").toJSONString();
		}

	}

	/**
	 * 发送验证码
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/sendVerify", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String sendVerify(@RequestBody String jsonString) {
		// 获取前端传过来的email值，并根据email调取数据库中以email为主键的数据
		PersonToRegist personToRegist1= JSON.parseObject(jsonString, PersonToRegist.class);
		System.out.println(personToRegist1);
		String email = personToRegist1.getRegist_person_email();
		if (!EmailCheck.checkEmaile(email)) {
			System.out.println("--------------------------------邮箱错误");
			return Result.failed("500", "邮箱错误").toJSONString();
		}
		PersonToRegist dataSource = personService.selectRegistPersonById(email);
		System.out.println("-------------传输的email：" + email);
		System.out.println("-------------是数据库中的数据：" + dataSource);
		// 获得verify字符串
		String verify = personService.getVerify();
		PersonToRegist personToRegist = new PersonToRegist();
		// 编辑发送件其他信息
		String vText = "您的验证码信息为：  " + verify;
		System.out.println("验证码信息：" + vText);
		// 将email和verify封装入person实体类中
		personToRegist.setRegist_person_email(email);
		personToRegist.setRegist_person_verify(verify);
		System.out.println("-------------生成的信息："+personToRegist);
		// 如果数据库中存在以email为主键的数据，则采用insertVerify操作，否则采用updateVerify操作
		if (dataSource != null) {
			// 先将verify数据更新至数据库后，再发送验证码最后发送成功的json文件
			personService.updateVerify(personToRegist);
			personService.sendText(vText, email);
			System.out.println("email存在，更新操作");
			return Result.success().toJSONString();
		} else {
			// 采用insertVerify操作将verify插入到数据库中
			personService.insertVerify(personToRegist);
			personService.sendText(vText, email);
			System.out.println("email不存在，插入操作");
			return Result.success().toJSONString();
		}

	}

	/**
	 * 查询所有待注册用户
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/queryAllRegistPerson" , produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String queryAllRegistPerson(int page) {
		// 查询待注册用户信息
		System.out.println("----------页码" + page);
		List<PersonToRegist> data = personService.selectAllRegistPerson(page);
		// 查询待注册用户数量
		int num = personService.selectNumOfRegistPerson();
		System.out.println(data);
		return PageResult.success(data, num / 5, num, page).toJSONString();
	}

	/**
	 * 根据email主键查询单个待注册用户详细信息
	 * 
	 * @param session
	 * @param email
	 * @return 返回数据：
	 */
	@RequestMapping(value = "/queryRegistPersonById", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String queryRegistPersonById(String email) {
		// 根据email查询数据
		System.out.println("-------------前端传送的：" + email);
		PersonToRegist data = personService.selectRegistPersonById(email);
		System.out.println(data);
		// 返回数据
		return Result.success(data).toJSONString();

	}

	/**
	 * 分配权限给待注册用户详细信息
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/grantRegistPersonById", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String grantRegistPersonById(String email) {
		// 根据email查询待注册用户数据
		PersonToRegist data = personService.selectRegistPersonById(email);
		Person person = new Person();
		// 封装person的属性
		person.setEmail(data.getRegist_person_email());
		person.setPassword(data.getRegist_person_password());
		person.setName(data.getRegist_person_name());
		person.setGender(data.getRegist_person_gender());
		person.setIdentity("1");
		person.setPhone(data.getRegist_person_phone());
		// 执行添加操作
		int num = personService.insertLeo(person);
		if (num == 1) {
			// 删除该条数据
			personService.deleteRegistPerson(email);
			personService.sendText("您的申请已经获得了批准！你可以用该邮箱登录系统了", email);
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "分配权限失败").toJSONString();
		}

	}

	/**
	 * 删除待注册用户信息
	 * 
	 * @param session
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/deleteRegistPerson", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String deleteRegistPerson(String email) {
		// 执行删除操作
		int num = personService.deleteRegistPerson(email);
		if (num == 1) {
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "删除失败").toJSONString();
		}

	}

	/**
	 * 查询所有执法人员
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/queryAllLeo", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String queryAllLeo(int page) {
		System.out.println("-------------------------------------" + page);
		// 查询待注册用户信息
		List<Person> data = personService.selectAllLeo(page);
		// 查询待注册用户数量
		int num = personService.selectNumOfRegistPerson();
		return PageResult.success(data, num / 5, num, page).toJSONString();
	}

	/**
	 * 查询所有执法人员
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/queryAll", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String queryAll() {
		// 查询待注册用户信息
		List<Person> data = personService.selectAll();
		// 查询待注册用户数量
		return Result.success(data).toJSONString();
	}
	
	/**
	 * 根据email主键查询所有待注册用户详细信息
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/queryLeoById", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String queryLeoById(HttpSession session, String email) {
		// 根据email查询数据
		Person data = personService.selectLeoByEmail(email);
		// 返回数据queryLeoById
		return Result.success(data).toJSONString();

	}

	/**
	 * 根据email主键更改密码信息
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	@CrossOrigin
	public String updatePassword(@RequestBody String jsonString) {
		Person person= JSON.parseObject(jsonString, Person.class);
		// 根据email更新数据
		int num = personService.updatePassword(person);
		if (num == 1) {
			// 发送验证码
			personService.sendText("您已成功更改了密码，下次请使用新密码登录！", person.getEmail());
			return Result.success().toJSONString();
		} else {
			return Result.failed().toJSONString();
		}
	}

	/**
	 * 根据email主键更改用户的信息
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/updatePersonInfo")
	@ResponseBody
	@CrossOrigin
	public String updatePersonInfo( @RequestBody String jsonString) {
		Person person= JSON.parseObject(jsonString, Person.class);
		System.out.println("-----------------" + person);
		// 根据传入的person对象进行更新操作
		int num = personService.updatePersonInfo(person);
		if (num == 1) {
			return Result.success().toJSONString();
		} else {
			return Result.failed().toJSONString();
		}
	}

	/**
	 * 删除执法人员信息
	 * 
	 * @param session
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/deleteLeo", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String deleteLeo(String email) {
		// 执行删除操作
		int num = personService.deletePerson(email);
		if (num == 1) {
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "删除失败").toJSONString();
		}

	}
}
