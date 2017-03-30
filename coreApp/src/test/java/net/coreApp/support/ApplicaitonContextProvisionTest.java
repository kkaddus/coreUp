package net.coreApp.support;

import net.core.applicationContext.test.ApplicaitonContextProvision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import net.coreApp.domain.security.User;

public class ApplicaitonContextProvisionTest extends
		ApplicaitonContextProvision {
	private static final Logger log = LoggerFactory
			.getLogger(ApplicaitonContextProvisionTest.class);

	// DI 주입 방법
	// 1.autowired를 이용한 주입 방법
	// 2.resource(name="myBatisDao")을 이용한 주입 방법 -> @Service(name="") 또는
	// @Repository(name="") 로 지정된 객체를 주입 한다.

	/*************************** db1(security) test *****************************/

	// @Autowired

	/*
	 * @Resource(name = "myBatisSecurityDao") private MyBatisSecuriyDao sucDao;
	 * 
	 * @Test public void db1Test() { // 1. spring + mybatis + junit test case
	 * log.debug("spring + mybatis + junit test!!!!"); assertNotNull(sucDao);
	 * net.coreApp.domain.security.User user = sucDao.getMember("test1");
	 * log.debug("user {} :" + user);
	 * 
	 * }
	 */

	/*************************** db2(application) test *****************************/

	// @Autowired

	/*
	 * @Resource(name = "myBatisDao") private MyBatisUserDao userDao;
	 * 
	 * @Test public void db2Test() { // 1. spring + mybatis + junit test case
	 * log.debug("spring + mybatis + junit test!!!!"); assertNotNull(userDao);
	 * try { net.coreApp.domain.users.User user = userDao.findById("javajigi");
	 * log.debug("user {} :" + user); } catch (Exception e) { }
	 * 
	 * }
	 */

	/********************** service test ************************/

	/*@Resource(name = "userMngService")
	private SecurityService service;

	@Test
	public void db2Test() { // 1. spring + mybatis + junit test case
		log.debug("spring + mybatis + junit test!!!!");
		assertNotNull(service);
		try {
			net.coreApp.domain.application.User user = service.findById("javajigi",
					null);
		} catch (Exception e) {
		}
	}*/

}
