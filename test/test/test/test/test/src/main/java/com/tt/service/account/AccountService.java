package com.tt.service.account;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import com.tt.entity.User;
import com.tt.entity.User1;
import com.tt.repository.TaskDao;
import com.tt.repository.User1Dao;
import com.tt.repository.UserDao;
import com.tt.service.ServiceException;

import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Clock;
import org.springside.modules.utils.Encodes;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	private User1Dao userDao1;
	private TaskDao taskDao;
	private Clock clock = Clock.DEFAULT;
	public List<User1> getAllUser() {
		return (List<User1>) userDao1.findAll();
	}

	public User1 getUser(Long id) {
		return userDao1.findOne(id);
	}

	public User1 findUserByLoginName(String loginName) {
		return userDao1.findByLoginName(loginName);
	}

	@Transactional(readOnly = false)
	public void registerUser(User1 user1) {
		entryptPassword(user1);
		user1.setRoles("user");
		user1.setRegisterDate(clock.getCurrentDate());
		userDao1.save(user1);
	}

	@Transactional(readOnly = false)
	public void updateUser(User1 user1) {
		if (StringUtils.isNotBlank(user1.getPlainPassword())) {
			entryptPassword(user1);
		}
		//user.setFengcheng(fencheng);
		userDao1.save(user1);
	}

	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			throw new ServiceException("不能删除超级管理员用户");
		}
		userDao1.delete(id);
		taskDao.deleteByUser1Id(id);

	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User1 user1) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user1.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user1.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user1.setPassword(Encodes.encodeHex(hashPassword));
	}

	@Autowired
	public void setUserDao(User1Dao userDao1) {
		this.userDao1 = userDao1;
	}

	@Autowired
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}
}
