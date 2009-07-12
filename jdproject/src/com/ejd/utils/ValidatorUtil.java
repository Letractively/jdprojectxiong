package com.ejd.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public final class ValidatorUtil {
	public ValidatorUtil(){
	}
	public static boolean isWhitespace (String s) {
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
	protected static boolean isCharsInBag (String s, String bag) {
		int i;
		for (i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (bag.indexOf(c) == -1) return false;
		}
		return true;
	}
	protected final char isCharsInBagEx (String s, String bag) {
	    StringBuffer sbuffer=new StringBuffer(s);
        char c=' ',q;
        for (int i = 0; i < sbuffer.length(); i++)
        {
        	q = sbuffer.charAt(i);
        	if (bag.indexOf(q)>-1) {
        		c=q;
        		return c;
        	}
        }
        return c;
    }
	protected final boolean isEmpty(String s)
	{
		return ((s.equals(null)) || (s.length()==0));
	}
	protected final boolean isEnglish(String s)
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
	public final void addressValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		char errorChar;
		String badChar = "><,[]{}?/+=|\\'\":;~!#$%()`";
		String address=(String)obj;
		if(!isEmpty(address)){
			if (address.length()>100){
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的地址长度为\""+address.length()+"\"不满足最多50位的要求");
				context.addMessage(component.getClientId(context), message);
			}
			if ( isWhitespace(address) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","地址不能含有空格符，请重新输入！");
				context.addMessage(component.getClientId(context), message);
			}
			errorChar = isCharsInBagEx( address, badChar);
			if (errorChar!= ' ' )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","，您输入的地址" + address+"无效,请不要在地址中输入字符" + errorChar + "!请重新输入\n");
				context.addMessage(component.getClientId(context), message);
			}
		}
	}
	public final void emailValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		String email=(String)obj;
		if (email.length()<6)
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的E-mail长度为\""+email.length()+"\"不满足6-30位的要求");
			context.addMessage(component.getClientId(context), message);
		}
		if (email.length()>30){
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的E-mail长度为\""+email.length()+"\"不满足6-30位的要求");
			context.addMessage(component.getClientId(context), message);
		}
		if ( isWhitespace(email) )
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的E-mail中不能包含空格符，请重新输入！\n");
			context.addMessage(component.getClientId(context), message);
		}
		int pos1 = email.indexOf("@");
		int pos2 = email.indexOf(".");
		int pos3 = email.lastIndexOf("@");
		int pos4 = email.lastIndexOf(".");
		if ((pos1 <= 0)||(pos1 ==email.length())||(pos2 <= 0)||(pos2 == email.length()))
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请输入有效的E-mail地址！\n");
			context.addMessage(component.getClientId(context), message);
	
		}else if( (pos1 == pos2 - 1) || (pos1 == pos2 + 1)
				|| ( pos1 != pos3 )  //find two @
				|| ( pos4 < pos3 ) ) //. should behind the '@'
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请输入有效的E-mail地址！\n");
			context.addMessage(component.getClientId(context), message);
		}
		if ( !isCharsInBag( email, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@"))
		{
	
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","email地址中只能包含字符ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@请重新输入\n");
			context.addMessage(component.getClientId(context), message);
		}
	}
	
	public final void nameValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		char errorChar;
		String badChar = "><,[]{}?/+=|\\'\":;~!#$%()`";
		String name=(String)obj;
		if(!isEmpty(name)){
			if (name.length()>50){
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的姓名长度为\""+name.length()+"\"不满足最多50位的要求");
				context.addMessage(component.getClientId(context), message);
			}
			if ( isWhitespace(name) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","姓名不能含有空格符，请重新输入！");
				context.addMessage(component.getClientId(context), message);
			}
			errorChar = isCharsInBagEx( name, badChar);
			if (errorChar!= ' ' )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","，您输入的姓名" + name+"无效,请不要在姓名中输入字符'" + errorChar + "'!请重新输入\n");
				context.addMessage(component.getClientId(context), message);
			}
		}
	}

	public final void passwordValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		String password=(String)obj;
		if (password.length()<6 || password.length()==0)
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的密码长度为\""+password.length()+"\"不满足6-24位的要求");
			context.addMessage(component.getClientId(context), message);
		}
		if (password.length()>24){
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的密码长度为\""+password.length()+"\"不满足6-24位的要求");
			context.addMessage(component.getClientId(context), message);
		}
		if ( isWhitespace(password) )
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的密码中不能包含空格符，请重新输入！\n");
			context.addMessage(component.getClientId(context), message);
		}
	}
	
	public final void phoneMobileValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		String badChar = "><[]{}?/+=|\\'\":~!@#$%^&`";
		String phone=(String)obj;
		//Validate the user name
		if(!isEmpty(phone))
		{
			if (phone.length()<11)
		 	{
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的手机号长度为\""+phone.length()+"\"不满足11-30位的要求");
		 		context.addMessage(component.getClientId(context), message);
		    }
			if (phone.length()>30){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的手机号长度为\""+phone.length()+"\"不满足11-30位的要求");
		 		context.addMessage(component.getClientId(context), message);
		 	}
			if ( isCharsInBag( phone, badChar))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","手机号中不能含有以下字符：><[]{}?/+=|\\'\":~!@#$%^&`\n");
				context.addMessage(component.getClientId(context), message);
				
			}
			//check user length
			
			if(!isCharsInBag (phone, "0123456789-(),;+"))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请检查手机号是否全为以下字符:0123456789-(),;+！");
				context.addMessage(component.getClientId(context), message);
			}
		}
	}
	
	public final void phoneValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		String badChar = "><[]{}?/+=|\\'\":~!@#$%^&`";
		String phone=(String)obj;
		//Validate the user name
		if(!isEmpty(phone))
		{
			if (phone.length()<6)
		 	{
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的联系电话长度为\""+phone.length()+"\"不满足6-30位的要求");
		 		context.addMessage(component.getClientId(context), message);
		    }
			if (phone.length()>30){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的联系电话长度为\""+phone.length()+"\"不满足6-30位的要求");
		 		context.addMessage(component.getClientId(context), message);
		 	}
			if ( isCharsInBag( phone, badChar))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","联系电话中不能含有以下字符：><[]{}?/+=|\\'\":~!@#$%^&`\n");
				context.addMessage(component.getClientId(context), message);
				
			}
			//check user length
			
			if(!isCharsInBag (phone, "0123456789-(),;+"))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请检查电话是否全为以下字符:0123456789-(),;+！");
				context.addMessage(component.getClientId(context), message);
			}
		}
	}
	
	public final void userValidate(FacesContext context,UIComponent component,Object obj) {
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
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的用户名长度为\""+schar.length+"\"不满足6-20位的要求");
	 		context.addMessage(component.getClientId(context), message);
	 	}
        if (schar.length>20){
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的用户名长度为\""+schar.length+"\"不满足6-20位的要求");
	 		context.addMessage(component.getClientId(context), message);
	 	}
        if ( isWhitespace(s) )
		{
	   		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的用户名中不能包含空格符，请重新输入！\n");
	   		context.addMessage(component.getClientId(context), message);
		}
        if (errorChar!=' ')
		{
    		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","您输入的用户名\"" + s+"\"是无效的用户名,请不要在用户名中输入字符\"" + errorChar + "\"!请重新输入合法的用户名！\n");
    		context.addMessage(component.getClientId(context), message);
		
		}
        if (!isEnglish(s)){
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","用户名必须为英文、下划线或数字！\n");
	 		context.addMessage(component.getClientId(context), message);
	 		
	 	}
	}
	
	public final boolean isInteger(String sample){
        char[] charArray=sample.toCharArray();
        int index=0;
        if(charArray[0]=='-')
        	index=1;
        for(;index<charArray.length;index++)
        	if(!Character.isDigit(charArray[index]))
        		return false;
        return true;
	}

	public final boolean isFloat(String sample){
        int dot=0;
        char[] charArray=sample.toCharArray();
        int index=0;
        if(charArray[0]=='-') {
        	index=1;
        }
        for(;index<charArray.length;index++){
        	if(!Character.isDigit(charArray[index])&&charArray[index]!='.'){
        		return false; 
            }
            if(charArray[index]=='.'){
            	dot++;
            }
        }
        if(dot<2) {
        	return true;
        } else {
        	return false;
        }
	}


}
