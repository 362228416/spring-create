package springcreate.wizards;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;

public class MavenProjectUtils {
	
	public static void makeProject(IProject project) throws Exception {
		project.setDefaultCharset("UTF-8", null);

		IFolder src = project.getFolder("src");
		IFolder main = project.getFolder("src/main");
		IFolder test = project.getFolder("src/test");
		IFolder src1 = project.getFolder("src/main/java");
		IFolder src2 = project.getFolder("src/main/resources");
		IFolder src3 = project.getFolder("src/test/java");
		IFile pom = project.getFile("pom.xml");
		
		src.create(true, false, null);
		main.create(true, false, null);
		test.create(true, false, null);
		src1.create(true, false, null);
		src2.create(true, false, null);
		src3.create(true, false, null);
		pom.create(getResource("/config/pom"), true, null);
	}
	
	private static InputStream getResource(String resource) {
		return SpringProjectWizard.class.getResourceAsStream(resource);
	}
	
}
