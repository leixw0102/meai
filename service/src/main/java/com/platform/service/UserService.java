package com.platform.service;

public interface UserService<T> {
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T registry(T user) throws Exception;
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T login(T user) throws Exception;


	/**
	 * 验证该用户是否存在
	 * @param user
	 * @return
	 * @throws Exception
     */
	public boolean checkAlone(T user) throws Exception;
}
