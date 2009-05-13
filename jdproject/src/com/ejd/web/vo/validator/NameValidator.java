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
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","���������������Ϊ\""+name.length()+"\"���������50λ��Ҫ��");
		 		throw new ValidatorException(message);
		 	}
			if ( isWhitespace(name) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�������ܺ��пո�������������룡");
		 		throw new ValidatorException(message);
			}

			errorChar = isCharsInBagEx( name, badChar);
	    	if (errorChar!= ' ' )
		{
			
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�������������" + name+"��Ч,�벻Ҫ�������������ַ�'" + errorChar + "'!����������\n");
	 		throw new ValidatorException(message);
		}

		}

	}

}
