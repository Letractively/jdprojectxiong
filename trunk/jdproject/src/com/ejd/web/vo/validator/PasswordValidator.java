package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

public class PasswordValidator implements Validator,Serializable {
	protected boolean isWhitespace (String s)
	{
	  String  whitespace = " \t\n\r";
	  int i;
	  for (i = 0; i < s.length(); i++)
	   {
	       char c = s.charAt(i);
	       if (whitespace.indexOf(c) >= 0)
		   {
			  
	    	   return true;
			  
		   }
	   }

	     return false;
	}
	
	public void validate(FacesContext context, UIComponent component, Object obj)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String password=(String)obj;
		if (password.length()<6 || password.length()==0)
	 	{
	 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����������볤��Ϊ\""+password.length()+"\"������6-24λ��Ҫ��");
	 		throw new ValidatorException(message);
	    }
		if (password.length()>24){
	 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����������볤��Ϊ\""+password.length()+"\"������6-24λ��Ҫ��");
	 		throw new ValidatorException(message);
	 	}
		if ( isWhitespace(password) )
		{
	   		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����������в��ܰ����ո�������������룡\n");
	 		throw new ValidatorException(message);
		}
		

	}

}
