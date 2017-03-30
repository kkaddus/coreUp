package net.core.applicationContext.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
/**설정 파일 접근 방법 **/
/*
 * 1.location 지정방법 2.classpath 이용방법
 */
// @ContextConfiguration(locations =
// {"file:src/main/resources/applicationContext.xml"})
// @ContextConfiguration(locations =
// {"file:src/main/resources/net/coreApp/provision/applicationContext.xml"})
// @ContextConfiguration("classpath*:net/coreApp/provision/applicationContext.xml")
@ContextConfiguration(locations = {
		"file:src/main/resources/net/coreApp/provision/applicationContext.xml",
		"file:src/main/resources/net/coreApp/provision/context-datasource.xml",
		"file:src/main/resources/net/coreApp/provision/context-sqlmap.xml",
		"file:src/main/resources/net/coreApp/provision/context-transaction.xml",
		"file:src/main/resources/net/coreApp/provision/context-aspect.xml"})
public abstract class ApplicaitonContextProvision {
	@Autowired
	protected ApplicationContext context;

}
