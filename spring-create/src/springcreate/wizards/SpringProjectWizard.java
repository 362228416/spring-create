package springcreate.wizards;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class SpringProjectWizard extends BasicNewProjectResourceWizard {
	
	private IProject project;

	public SpringProjectWizard() {
		System.out.println("spring project wizard create");
	}
	
	@Override
	public boolean canFinish() {
		boolean finish = super.canFinish();
		return finish;
	}
	
	
	
	@Override
	public IProject getNewProject() {
		if (project == null) {
			project = super.getNewProject();
		}
		return project;
	}
	
	@Override
	public boolean performFinish() {
		boolean finish = super.performFinish();
		IProject p = getNewProject();
		IFolder src = p.getFolder("src");
		IFolder main = p.getFolder("src/main");
		IFolder test = p.getFolder("src/test");
		
		
		IFolder src1 = p.getFolder("src/main/java");
		IFolder src2 = p.getFolder("src/main/resources");
		IFolder src3 = p.getFolder("src/test/java");
		
		IFile file = p.getFile("src/main/resources/applicationContext.xml");
		IFile app = p.getFile("src/main/java/App.java");
		IFile pom = p.getFile("pom.xml");
		
		try {
			p.setDefaultCharset("UTF-8", null);
			src.create(true, false, null);
			main.create(true, false, null);
			test.create(true, false, null);
			src1.create(true, false, null);
			src2.create(true, false, null);
			src3.create(true, false, null);
			file.create(getResource("/config/applicationContext.xml"), true, null);
			app.create(getResource("/java/App"), true, null);
			pom.create(getResource("/config/pom.xml"), true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return finish;
	}
	
	
	private static InputStream getResource(String resource) {
		return SpringProjectWizard.class.getResourceAsStream(resource);
	}
	
	public static void main(String[] args) throws IOException {
		InputStream in = getResource("applicationContext.xml");
		System.out.println(in);
		in.close();
	}
	
	

}
