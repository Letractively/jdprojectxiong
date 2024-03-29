package com.ejd.web.vo.richfaces;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.faces.application.Application;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.springframework.aop.ThrowsAdvice;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.richfaces.File;
/**
 * @author Ilya Shaikovsky
 *
 */
public class FileUploadBean{
	
	private ArrayList<File> files = new ArrayList<File>();
	private int uploadsAvailable = 5;
	private boolean autoUpload = false;
	private boolean useFlash = false;
	public int getSize() {
		if (getFiles().size()>0){
			return getFiles().size();
		}else 
		{
			return 0;
		}
	}

	public FileUploadBean() {
	}

	public synchronized void paint(OutputStream stream, Object object) throws IOException {
		stream.write(getFiles().get((Integer)object).getData());
	}
	public synchronized void listener(UploadEvent event) throws Exception{
	    UploadItem item = event.getUploadItem();
	    File file = new File();
	    file.setLength(item.getData().length);
	    file.setName(item.getFileName());
	    file.setData(item.getData());
	    files.add(file);
	    uploadsAvailable--;
	}
	
	public String clearUploadData() {
		files.clear();
		setUploadsAvailable(5);
		return null;
	}
	public String sendUploadData() {
		String path = SpringFacesUtil.getFacesContext().getExternalContext().getRequestServletPath();
		//String path = SpringFacesUtil.getServletContext().getRealPath("/");
		OutputStream out = null;
		if (null != this.getFiles()) {
			for(File tempFile:this.getFiles()) {
				 try {
					 String fileName = tempFile.getName();
					 int place = fileName.lastIndexOf("\\");
					 fileName = fileName.substring(place+1, fileName.length());
					 path=path+"productimage\\" + fileName;
					 path=path.replaceAll("\\\\","/");
					 out = new FileOutputStream(path);
					 out.write(tempFile.getData());
					 out.flush();
					 out.close();
				 } catch (Exception e) {
					 
				 }
			}
		}
		files.clear();
		String dd = path;
		setUploadsAvailable(5);
		return null;
	}
	
	public long getTimeStamp(){
		return System.currentTimeMillis();
	}
	
	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) { 
		this.files = files;
	}

	public int getUploadsAvailable() {
		return uploadsAvailable;
	}

	public void setUploadsAvailable(int uploadsAvailable) {
		this.uploadsAvailable = uploadsAvailable;
	}

	public boolean isAutoUpload() {
		return autoUpload;
	}

	public void setAutoUpload(boolean autoUpload) {
		this.autoUpload = autoUpload;
	}

	public boolean isUseFlash() {
		return useFlash;
	}

	public void setUseFlash(boolean useFlash) {
		this.useFlash = useFlash;
	}

}
