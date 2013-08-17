package springcreate.wizards;

import java.util.Collections;

import org.eclipse.core.resources.IProject;

public class SpringMvcJPAProjectWizard extends AbstractNewProjectWizard {


	@Override
	protected void doCreate(IProject project) {
		String name = project.getName();
		addFolder("src/main/java");
		addFolder("src/main/resources");
		addFolder("src/test/java");
		addFolder("src/main/webapp");
		addFolder("src/main/webapp/WEB-INF");
		addFile("pom.xml", "/config/pom-mvc-jpa.xml", Collections.singletonMap("projectName", name));
		addFile("src/main/webapp/WEB-INF/web.xml", "/config/web-jpa.xml");
		addFile("src/main/resources/META-INF/spring/applicationContext.xml", "/config/applicationContext-jpa.xml");
		addFile("src/main/resources/META-INF/persistence.xml", "/config/persistence.xml");
		addFile("src/main/resources/META-INF/spring/database.properties", "/config/database.properties");
		addFile("src/main/webapp/WEB-INF/spring/webmvc-config.xml", "/config/webmvc-config.xml");
		addFile("src/main/java/web/IndexController.java", "/java/IndexController");
		addFile("src/main/webapp/WEB-INF/tiles/layouts.xml", "/config/layouts.xml");
		addFile("src/main/webapp/WEB-INF/pages/resourceNotFound.jsp", "/page/resourceNotFound.jsp");
		addFile("src/main/webapp/WEB-INF/pages/uncaughtException.jsp", "/page/uncaughtException.jsp");
	}
	
	
}
