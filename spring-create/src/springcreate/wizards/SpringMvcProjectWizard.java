package springcreate.wizards;

import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Composite;

public class SpringMvcProjectWizard extends AbstractNewProjectWizard {

	// @Override
	// public IWizardPage getStartingPage() {
	// return new SpringMvcWizardPage("New Spring Mvc Project");
	// // IWizardPage page = super.getStartingPage();
	// // Control control = page.getControl();
	// // System.out.println(control);
	// // IWizard wizard = page.getWizard();
	// // IWizardPage startingPage = wizard.getStartingPage();
	// // IWizardContainer wizardContainer = wizard.getContainer();
	// // Composite composite = new Composite(null, SWT.ALL);
	// // page.createControl(composite);
	// // new Text(composite, SWT.BORDER);
	// //
	// // return page;
	// //
	// }

	@Override
	public void addPages() {
		super.addPages();
//		System.out.println(getPageCount());
//		IWizardPage[] ps = getPages();
//		System.out.println(ps[0]);
//		System.out.println(ps[1]);
//		System.out.println();
//		addPage(new SpringMvcWizardPage("New Spring Mvc Project"));

	}
	
	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
//		
//		System.out.println(pageContainer);
//		IWizardPage startingPage = getStartingPage();
//		System.out.println(startingPage);
//		Control control = startingPage.getControl();
//		
//		new Text(pageContainer, SWT.BORDER);
		
	}

	@Override
	public boolean performFinish() {
		boolean finish = super.performFinish();
		String name = getNewProject().getName();
		addFolder("src/main/java");
		addFolder("src/main/resources");
		addFolder("src/test/java");
		addFolder("src/main/webapp");
		addFolder("src/main/webapp/WEB-INF");
		addFile("pom.xml", "/config/pom-mvc.xml", Collections.singletonMap("projectName", name));
		addFile("src/main/webapp/WEB-INF/web.xml", "/config/web-jpa.xml");
		addFile("src/main/resources/META-INF/spring/applicationContext.xml", "/config/applicationContext.xml");
		addFile("src/main/webapp/WEB-INF/spring/webmvc-config.xml", "/config/webmvc-config.xml");
		addFile("src/main/java/web/IndexController.java", "/java/IndexController");
		addFile("src/main/webapp/WEB-INF/tiles/layouts.xml", "/config/layouts.xml");
		addFile("src/main/webapp/WEB-INF/pages/resourceNotFound.jsp", "/page/resourceNotFound.jsp");
		addFile("src/main/webapp/WEB-INF/pages/uncaughtException.jsp", "/page/uncaughtException.jsp");
		return finish;
	}

	@Override
	public IProject getNewProject() {
		IProject project = super.getNewProject();
		return project;
	}

}
