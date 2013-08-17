package springcreate.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

public class SpringMvcWizardPage extends WizardPage {

	protected SpringMvcWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		// System.out.println(composite);

		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
//		layout.marginWidth = 330;
		layout.numColumns = 2;
//		layout.makeColumnsEqualWidth = true;
		
//		Layout
//		FormLayout layout = new FormLayout();
		
//		layout.
		
//		FillLayout layout = new FillLayout();
		
		container.setLayout(layout);

		Label label = new Label(container, SWT.None);
		label.setText("Project Name:");
		Text name = new Text(container, SWT.BORDER);
		name.setSize(320, name.getSize().y);
		Label label2 = new Label(container, SWT.None);
		label2.setText("Top level Package:");
		Text topPackage = new Text(container, SWT.BORDER);
		
		
		setControl(container);
	}
	
	

}
