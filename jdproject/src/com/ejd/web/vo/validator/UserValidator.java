package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;


public class UserValidator implements Validator,Serializable   {
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
    protected boolean isEnglish(String s)
    {
    	if(isEmpty(s))
    	{
    		
    		return false;
    	}
    	for(int i=0;i<s.length();i++)
    	{
    		char c=s.charAt(i);
    		if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9')||c=='_')
    		{
    			continue;
    		}
    		else
    		{
    			
    			return false;
    		}
    	}
    	return true;
    }
	public void validate(FacesContext context,UIComponent component,Object obj) {
		char errorChar;
		String  badChar = "><,[]{}?/+=|\\'\":;~!#$%()`";
		FacesMessage message;
		if ((obj==null)){
		    return;
		}
		
		String s=(String)obj;
		char[] schar=s.toCharArray();
		errorChar = isCharsInBagEx( s, badChar); 
		if (schar.length<6 || schar.length==0)
	 	{
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的用户名长度为\""+schar.length+"\"不满足6-30位的要求");
	 		throw new ValidatorException(message);
	 		
	 	}
        if (schar.length>30){
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的用户名长度为\""+schar.length+"\"不满足6-30位的要求");
	 		throw new ValidatorException(message);
	 	}
        if ( isWhitespace(s) )
		{
	   		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的用户名中不能包含空格符，请重新输入！\n");
	 		throw new ValidatorException(message);
			

		}
        if (errorChar!=' ')
		{
    		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的用户名\"" + s+"\"是无效的用户名,请不要在用户名中输入字符\"" + errorChar + "\"!请重新输入合法的用户名！\n");
	 		throw new ValidatorException(message);
		
		}
        if (!isEnglish(s)){
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","用户名必须为英文、下划线或数字！\n");
	 		throw new ValidatorException(message);
	 		
	 	}
	
		
	 	//is s contain whitespace
	 	
	 	
		//is s contain invalid characters
		//Validate the user name
	 	
	}

}
