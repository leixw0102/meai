package com.platform.dao;


public interface UserDao <T>{
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Long registry(T user) throws Exception;
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T login(T user) throws Exception;

	/**
	 * 通过sql检查用户数据是否存在
	 * @param sql
	 * @return
	 * @throws Exception
     */
	public boolean isExistUser(String sql) throws Exception;

}
