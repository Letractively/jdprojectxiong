package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;


public class PhoneExtValidator implements Validator,Serializable {
	protected  boolean isEmpty(String s)
	{
		return ((s.equals(null)) || (s.length()==0));
	}
	protected boolean isCharsInBag (String s, String bag)
	{
	  int i;

	  for (i = 0; i < s.length(); i++)
	  {

	      char c = s.charAt(i);
	      if (bag.indexOf(c) == -1) return false;
	  }
	  return true;
	}
	public void validate(FacesContext context, UIComponent component, Object obj)
	throws ValidatorException {
		// TODO Auto-generated method stub
		String badChar = "><[]{}?/+=|\\'\":~!@#$%^&`";
		String phone=(String)obj;
		//Validate the user name
		if(!isEmpty(phone))
		{   
			if (phone.length()<1)
		 	{
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的分机号长度为\""+phone.length()+"\"不满足1-4位的要求");
		 		throw new ValidatorException(message);
		    }
			if (phone.length()>4){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的分机号长度为\""+phone.length()+"\"不满足1-4位的要求");
		 		throw new ValidatorException(message);
		 	}
			if ( isCharsInBag( phone, badChar))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","分机号中不能含有以下字符：><[]{}?/+=|\\'\":~!@#$%^&`\n");
		 		throw new ValidatorException(message);
				
			}
			//check user length
			
			if(!isCharsInBag (phone, "0123456789-(),;+"))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请检查分机号是否全为以下字符:0123456789-(),;+！");
		 		throw new ValidatorException(message);
			}
		}


	}

}
