package com.platform.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.platform.dao.EnterpriseUserDao;
import com.platform.domain.EnterpriseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@Repository("enterpriseUserDao")
public class EnterpriseUserDaoImpl extends BaseDaoImpl implements EnterpriseUserDao {
	private static Logger logger = LoggerFactory.getLogger(EnterpriseUserDaoImpl.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public Long registry(final EnterpriseUser user) throws Exception {
		
		final String sql = "INSERT INTO enterprise_user (user_name,Password,user_key,institution_code,enterprise_name,current_city,contact_name,company_mail"
				+ ",address_detail,create_time" +				
				") " +
				" VALUES (?,?,?,?,?,?,?,?,?,?) ";		
		try{
		    KeyHolder keyHolder = new GeneratedKeyHolder();
		    jdbcTemplate.update(new PreparedStatementCreator() {	      
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException{
		            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		            ps.setString(1, user.getUserName());
		            ps.setString(2, user.getPassword());
		            ps.setString(3, user.getUserKey());
		            ps.setString(4, user.getInstitutionCode());
		            ps.setString(5, user.getEnterpriseName());
		            ps.setLong(6, user.getCurrentCity());
		            ps.setString(7, user.getContactName());
		            ps.setString(8, user.getCompanyMail());
		            ps.setString(9, user.getAddressDetail());
		            ps.setTimestamp(10, new java.sql.Timestamp(user.getTime().getTime()));
		            return ps;
		        }			
		    }, keyHolder);	    
			return keyHolder.getKey().longValue();//jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			 
		
		} catch (Exception e) {
			logger.error("buyerRegister e:" ,e);
		}
		return 0L;
	}
	@Override
	public EnterpriseUser login(EnterpriseUser user) throws Exception {
		List<EnterpriseUser> list= getBySqlRowMapper("select * from enterprise_user where user_name='"+user.getUserName()+"' and  password='"+user.getPassword()+"'",new BeanPropertyRowMapper(EnterpriseUser.class));
		if(null == list || list.size()==0){
			return null;
		}
		return list.get(0);
//		return getIdBySql("select id from enterprise_user where user_name='"+user.getUserName()+"' and  password='"+user.getPassword()+"'");
	}

	@Override
	public boolean isExistUser(String sql) throws Exception {
		return getIdBySql(sql)>0?true:false;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public boolean updateEnterprise(String sql) throws Exception {
		return update(sql);
	}
}
