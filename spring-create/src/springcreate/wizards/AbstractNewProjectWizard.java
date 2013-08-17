package springcreate.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

import utils.IOUtils;

public abstract class AbstractNewProjectWizard extends BasicNewProjectResourceWizard {
	
	protected static InputStream getResource(String resource) {
		return SpringProjectWizard.class.getResourceAsStream(resource);
	}
	
	protected IFolder addFolder(String folderName) {
		checkParent(folderName);
		IProject p = getNewProject();
		IFolder targetFolder = p.getFolder(folderName);
//		createFolder(targetFolder);
		return targetFolder;
	}
	
	public void createFolder(IFolder folder) {
		try {
			folder.create(true, false, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean performFinish() {
		boolean finish = super.performFinish();
		doCreate(getNewProject());
		return finish;
	}
	
	protected void doCreate(IProject project) {}
	
	private void checkParent(String fileName) {
		IProject p = getNewProject();
		String[] folders = fileName.split("/");
//		for (String f : folders) {
//			IFolder folder = p.getFolder(f);
//			if (!folder.exists()) {
//				createFolder(folder);
//			}
//		}
		StringBuffer name = new StringBuffer();
		for (int i = 0; i < folders.length; i++) {
			for (int j = 0; j <= i; j++) {
				name.append("/" + folders[j]);
			}
			String fullName = name.toString();
			IFolder folder = p.getFolder(fullName);
			if (!folder.exists()) {
				createFolder(folder);
			}
			name.setLength(0);
		}
	}
	
	public void createFile(IFile file, InputStream in) {
		try {
			file.create(in, true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected IFile addFile(String fileName, InputStream in) {
		if (fileName.contains("/")) {
			String parent = fileName.substring(0, fileName.lastIndexOf("/"));
			checkParent(parent);
		}
		IFile file = getNewProject().getFile(fileName);
		createFile(file, in);
		System.out.println(file.exists());
		return file;
	}
	
	protected IFile addFile(String fileName, InputStream in, Map<String,String> map) {
		if (fileName.contains("/")) {
			String parent = fileName.substring(0, fileName.lastIndexOf("/"));
			checkParent(parent);
		}
		String content = IOUtils.toString(in);
		for (String key : map.keySet()) {
			content = content.replaceAll(key, map.get(key));
		}
		in = new ByteArrayInputStream(content.getBytes());
		IFile file = getNewProject().getFile(fileName);
		createFile(file, in);
		System.out.println(file.exists());
		return file;
	}
	
	protected IFile addFile(String fileName, String resource, Map<String, String> map) {
		return addFile(fileName, getResource(resource), map);
	}
	
	protected IFile addFile(String fileName, String resource) {
		return addFile(fileName, getResource(resource));
	}
	
	
	
}
