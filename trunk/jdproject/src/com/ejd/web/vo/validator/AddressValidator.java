package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

public class AddressValidator implements Validator,Serializable{
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
		String address=(String)obj;
		if(!isEmpty(address)){
			if (address.length()>100){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的地址长度为\""+address.length()+"\"不满足最多50位的要求");
		 		throw new ValidatorException(message);
		 	}
			if ( isWhitespace(address) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","地址不能含有空格符，请重新输入！");
		 		throw new ValidatorException(message);
			}

			errorChar = isCharsInBagEx( address, badChar);
	    	if (errorChar!= ' ' )
		{
			
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","，您输入的地址" + address+"无效,请不要在地址中输入字符" + errorChar + "!请重新输入\n");
	 		throw new ValidatorException(message);
		}

		}

	}

}