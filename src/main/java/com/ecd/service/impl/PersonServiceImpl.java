package com.ecd.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecd.dao.PersonDao;
import com.ecd.pojo.Person;
import com.ecd.pojo.PersonToRegist;
import com.ecd.service.PersonService;
import com.ecd.tool.MessageSend;
import com.ecd.tool.VerifyCode;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	/**
	 * 登录操作 返回：Person
	 */
	public Person loginPerson(String email) {
		return personDao.selectPersonById(email);
	}

	/**
	 * 注册操作 返回是否插入成功
	 */
	public int insertPerson(PersonToRegist personToRegist) {
		return personDao.insertPerson(personToRegist);
	}

	/**
	 * 获取验证码
	 */
	@Override
	public String getVerify() {

		try {
			return VerifyCode.getVText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新验证码操作
	 */
	public int updateVerify(PersonToRegist personToRegist) {
		return personDao.updateVerify(personToRegist);
	}

	/**
	 * 插入验证码操作
	 */
	public int insertVerify(PersonToRegist personToRegist) {
		System.out.println("service层-------------"+personToRegist);
		return personDao.insertVerify(personToRegist);
	}

	/**
	 * 查询待注册用户详细信息
	 */
	public PersonToRegist selectRegistPersonById(String email) {
		return personDao.selectRegistPersonById(email);
	}

	/**
	 * 查询待注册用户数量
	 */
	@Override
	public int selectNumOfRegistPerson() {
		return personDao.selectNumOfRegistPerson();
	}

	/**
	 * 查询待注册用户的list
	 */
	@Override
	public List<PersonToRegist> selectAllRegistPerson(int page) {
		return personDao.selectAllRegistPerson((page - 1) * 5);
	}

	/**
	 * 审批权限操作 返回是否插入成功
	 */
	public int insertLeo(Person person) {
		return personDao.insertLeo(person);
	}

	/**
	 * 删除待注册用户操作 返回是否插入成功
	 */
	public int deleteRegistPerson(String email) {
		return personDao.deleteRegistPerson(email);
	}

	/**
	 * 修改密码操作 返回是否更新成功
	 */
	public int updatePassword(Person person) {
		return personDao.updatePassword(person);
	}

	/**
	 * 更新用户信息 返回是否更新成功
	 */
	public int updatePersonInfo(Person person) {
		return personDao.updatePersonInfo(person);
	}

	/**
	 * 删除用户操作 返回是否删除成功
	 */
	public int deletePerson(String email) {
		return personDao.deletePerson(email);
	}

	/**
	 * 查询所有执法人员 返回list<Person> 输入页码数
	 */
	public List<Person> selectAllLeo(int page) {
		return personDao.selectAllLeo((page - 1) * 5);
	}

	/**
	 * 查询所有执法人员数量 返回数量
	 */
	public int selectNumOfLeo() {
		return personDao.selectNumOfLeo();
	}

	/**
	 * 根据email查询详细执法人员信息 返回person类
	 */
	public Person selectLeoByEmail(String email) {
		return personDao.selectLeoByEmail(email);
	}

	/**
	 * 发送信息
	 */
	public void sendText(String vText, String email) {

		try {
			MessageSend.sendMessage(vText, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> selectAll() {
		return personDao.selectAll();
	}

}
