package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

public class EmailValidator implements Validator,Serializable {
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
		String email=(String)obj;
		if (email.length()<6)
	 	{
	 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的E-mail长度为\""+email.length()+"\"不满足6-30位的要求");
	 		throw new ValidatorException(message);
	    }
		if (email.length()>30){
	 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的E-mail长度为\""+email.length()+"\"不满足6-30位的要求");
	 		throw new ValidatorException(message);
	 	}
		if ( isWhitespace(email) )
		{
	   		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的E-mail中不能包含空格符，请重新输入！\n");
	 		throw new ValidatorException(message);
		}
		int pos1 = email.indexOf("@");
		int pos2 = email.indexOf(".");
		int pos3 = email.lastIndexOf("@");
		int pos4 = email.lastIndexOf(".");
		if ((pos1 <= 0)||(pos1 ==email.length())||(pos2 <= 0)||(pos2 == email.length()))
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请输入有效的E-mail地址！\n");
	 		throw new ValidatorException(message);
			
		}else if( (pos1 == pos2 - 1) || (pos1 == pos2 + 1)
			  || ( pos1 != pos3 )  //find two @
			  || ( pos4 < pos3 ) ) //. should behind the '@'
			{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请输入有效的E-mail地址！\n");
	 		throw new ValidatorException(message);
			}
		if ( !isCharsInBag( email, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@"))
		{
			
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","email地址中只能包含字符ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@请重新输入\n");
	 		throw new ValidatorException(message);
			
		}


	}

}

