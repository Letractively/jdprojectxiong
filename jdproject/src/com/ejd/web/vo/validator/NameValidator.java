package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;


public class NameValidator implements Validator,Serializable {

	protected  boolean isEmpty(String s)
	{
		return ((s.equals(null)) || (s.length()==0));
	}
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
    protected char isCharsInBagEx (String s, String bag)
    {
    	StringBuffer sbuffer=new StringBuffer(s);
        char c=' ',q;
      for (int i = 0; i < sbuffer.length(); i++)
      {
    	q = sbuffer.charAt(i);
    	if (bag.indexOf(q)>-1)
    	{   c=q;
            return  c;
    	}
      }
      return c;
    }
	public void validate(FacesContext context, UIComponent component, Object obj)
			throws ValidatorException {
		// TODO Auto-generated method stub
		char errorChar;
		String badChar = "><,[]{}?/+=|\\'\":;~!#$%()`";
		String name=(String)obj;
		if(!isEmpty(name)){
			if (name.length()>50){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的姓名长度为\""+name.length()+"\"不满足最多50位的要求");
		 		throw new ValidatorException(message);
		 	}
			if ( isWhitespace(name) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","姓名不能含有空格符，请重新输入！");
		 		throw new ValidatorException(message);
			}

			errorChar = isCharsInBagEx( name, badChar);
	    	if (errorChar!= ' ' )
		{
			
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","，您输入的姓名" + name+"无效,请不要在姓名中输入字符'" + errorChar + "'!请重新输入\n");
	 		throw new ValidatorException(message);
		}

		}

	}

}
