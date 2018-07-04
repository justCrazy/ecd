package com.ecd.service;

import java.util.List;

import com.ecd.pojo.Person;
import com.ecd.pojo.PersonToRegist;

public interface PersonService {

	//查询所有折法人员
	public  List<Person> selectAll( );
	// 登录功能
	public Person loginPerson(String email);

	// 注册
	public int insertPerson(PersonToRegist personToRegist);

	// 获取验证码
	public String getVerify();

	// 更新验证码到数据库中
	public int updateVerify(PersonToRegist person);

	// 插入验证码到数据库中
	public int insertVerify(PersonToRegist personToRegist);

	// 查询待申请用户
	public PersonToRegist selectRegistPersonById(String email);

	// 查询待注册用户数目
	public int selectNumOfRegistPerson();

	// 查询待注册用户
	public List<PersonToRegist> selectAllRegistPerson(int page);

	// 审批权限操作
	public int insertLeo(Person person);

	// 删除待注册用户操作
	public int deleteRegistPerson(String email);

	// 修改密码操作
	public int updatePassword(Person person);

	// 更新用户信息
	public int updatePersonInfo(Person person);

	// 删除用户操作
	public int deletePerson(String email);

	// 查询所有执法人员信息
	public List<Person> selectAllLeo(int page);

	// 根据查询所有执法人员数量
	public int selectNumOfLeo();

	// 根据查询详细执法人员信息
	public Person selectLeoByEmail(String email);

	// 发送信息
	public void sendText(String vText, String email);
}
