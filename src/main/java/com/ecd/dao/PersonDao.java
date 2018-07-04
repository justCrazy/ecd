package com.ecd.dao;

import java.util.List;

import com.ecd.pojo.Person;
import com.ecd.pojo.PersonToRegist;

public interface PersonDao {

	/**
	 * 登录操作 操作者：所有操作人员
	 * 
	 * @param email
	 * @return person类 数据库：person
	 */
	// 根据id查询用户信息
	public Person selectPersonById(String email);

	/**
	 * 修改密码操作 操作者：所有操作人员
	 * 
	 * @param String
	 *            email,String password
	 * @return int数据类型 数据库：person
	 */
	// 根据将用户在数据库中的密码字段
	public int updatePassword(Person person);

	/**
	 * 人员信息更新操作 操作者：所有操作人员
	 * 
	 * @param person
	 * @return 数据库：person
	 */
	// 根据更新用户信息到数据库中
	public int updatePersonInfo(Person person);

	/**
	 * 删除用户操作 操作者：环保人员对执法人员进行的操作
	 * 
	 * @param person类
	 * @return 数据库：person
	 */
	// 根据将用户信息数据库删除
	public int deletePerson(String email);

	/**
	 * 查询所有执法人员信息操作 操作者：环保人员
	 * 
	 * @param
	 * @return person类的list 数据库：person
	 */
	// 根据查询所有执法人员信息 备注page为页码，真正传入的是页码乘以5
	public List<Person> selectAllLeo(int page);
	
	/**
	 * 查询所有执法人员信息操作 操作者：环保人员
	 * 
	 * @param
	 * @return person类的list 数据库：person
	 */
	// 根据查询所有执法人员信息 备注page为页码，真正传入的是页码乘以5
	public List<Person> selectAll();

	/**
	 * 查询详细执法人员信息操作 操作者：环保人员
	 * 
	 * @param String
	 *            字符串
	 * @return person类 数据库：person
	 */
	// 根据查询详细执法人员信息
	public Person selectLeoByEmail(String email);

	/**
	 * 查询执法人员数量操作 操作者：环保人员
	 * 
	 * @param
	 * @return int 数据库：person
	 */
	// 根据查询所有执法人员数量
	public int selectNumOfLeo();

	/**
	 * 注册操作 操作者：执法人员申请权限操作
	 * 
	 * @param person类
	 * @return int数据类型 数据库：PersonToRegist
	 */
	// 根据将用户信息插入到数据库中
	public int insertPerson(PersonToRegist personToRegist);

	/**
	 * 查询待注册人员数量操作 操作者：环保人员
	 * 
	 * @param
	 * @return int 数据库：person
	 */
	// 根据查询所有执法人员数量
	public int selectNumOfRegistPerson();

	/**
	 * 查询所有待注册人员信息操作 操作者：环保人员
	 * 
	 * @param
	 * @return person类的list 数据库：person
	 */
	// 根据查询所有执法人员信息 备注page为页码，真正传入的是页码乘以5
	public List<PersonToRegist> selectAllRegistPerson(int page);

	/**
	 * 查询待注册用户操作
	 * 
	 * @param String
	 * @return PersonToRegist 数据库：PersonToRegist
	 */
	public PersonToRegist selectRegistPersonById(String email);

	/**
	 * 更新验证码操作 操作者：执法人员申请权限操作
	 * 
	 * @param PersonToRegist类
	 * @return int数据类型 数据库：PersonToRegist
	 */
	// 根据更新验证码到数据库中
	public int updateVerify(PersonToRegist personToRegist);

	/**
	 * 插入验证码操作 操作者：执法人员申请权限操作
	 * 
	 * @param PersonToRegist类
	 * @return int数据类型 数据库：PersonToRegist
	 */
	// 根据更新验证码到数据库中
	public int insertVerify(PersonToRegist personToRegist);

	/**
	 * 审批权限操作 操作者：环保局人员审批执法人员权限操作
	 * 
	 * @param person类
	 * @return int数据类型 数据库：person
	 */
	// 根据将用户信息插入到数据库中
	public int insertLeo(Person person);

	/**
	 * 删除待注册用户操作 操作者：环保局人员审批执法人员权限操作
	 * 
	 * @param person类
	 * @return int数据类型 数据库：person
	 */
	// 根据将用户信息插入到数据库中
	public int deleteRegistPerson(String email);

}
