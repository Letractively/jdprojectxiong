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
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","������ĵ�ַ����Ϊ\""+address.length()+"\"���������50λ��Ҫ��");
				context.addMessage(component.getClientId(context), message);
			}
			if ( isWhitespace(address) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��ַ���ܺ��пո�������������룡");
				context.addMessage(component.getClientId(context), message);
			}
			errorChar = isCharsInBagEx( address, badChar);
			if (errorChar!= ' ' )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������ĵ�ַ" + address+"��Ч,�벻Ҫ�ڵ�ַ�������ַ�" + errorChar + "!����������\n");
				context.addMessage(component.getClientId(context), message);
			}
		}
	}
	public final void emailValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		String email=(String)obj;
		if (email.length()<6)
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�������E-mail����Ϊ\""+email.length()+"\"������6-30λ��Ҫ��");
			context.addMessage(component.getClientId(context), message);
		}
		if (email.length()>30){
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�������E-mail����Ϊ\""+email.length()+"\"������6-30λ��Ҫ��");
			context.addMessage(component.getClientId(context), message);
		}
		if ( isWhitespace(email) )
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�����E-mail�в��ܰ����ո�������������룡\n");
			context.addMessage(component.getClientId(context), message);
		}
		int pos1 = email.indexOf("@");
		int pos2 = email.indexOf(".");
		int pos3 = email.lastIndexOf("@");
		int pos4 = email.lastIndexOf(".");
		if ((pos1 <= 0)||(pos1 ==email.length())||(pos2 <= 0)||(pos2 == email.length()))
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������Ч��E-mail��ַ��\n");
			context.addMessage(component.getClientId(context), message);
	
		}else if( (pos1 == pos2 - 1) || (pos1 == pos2 + 1)
				|| ( pos1 != pos3 )  //find two @
				|| ( pos4 < pos3 ) ) //. should behind the '@'
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������Ч��E-mail��ַ��\n");
			context.addMessage(component.getClientId(context), message);
		}
		if ( !isCharsInBag( email, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@"))
		{
	
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","email��ַ��ֻ�ܰ����ַ�ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.-_@����������\n");
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
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","���������������Ϊ\""+name.length()+"\"���������50λ��Ҫ��");
				context.addMessage(component.getClientId(context), message);
			}
			if ( isWhitespace(name) )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�������ܺ��пո�������������룡");
				context.addMessage(component.getClientId(context), message);
			}
			errorChar = isCharsInBagEx( name, badChar);
			if (errorChar!= ' ' )
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�������������" + name+"��Ч,�벻Ҫ�������������ַ�'" + errorChar + "'!����������\n");
				context.addMessage(component.getClientId(context), message);
			}
		}
	}

	public final void passwordValidate(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		String password=(String)obj;
		if (password.length()<6 || password.length()==0)
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����������볤��Ϊ\""+password.length()+"\"������6-24λ��Ҫ��");
			context.addMessage(component.getClientId(context), message);
		}
		if (password.length()>24){
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����������볤��Ϊ\""+password.length()+"\"������6-24λ��Ҫ��");
			context.addMessage(component.getClientId(context), message);
		}
		if ( isWhitespace(password) )
		{
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����������в��ܰ����ո�������������룡\n");
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
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������ֻ��ų���Ϊ\""+phone.length()+"\"������11-30λ��Ҫ��");
		 		context.addMessage(component.getClientId(context), message);
		    }
			if (phone.length()>30){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������ֻ��ų���Ϊ\""+phone.length()+"\"������11-30λ��Ҫ��");
		 		context.addMessage(component.getClientId(context), message);
		 	}
			if ( isCharsInBag( phone, badChar))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�ֻ����в��ܺ��������ַ���><[]{}?/+=|\\'\":~!@#$%^&`\n");
				context.addMessage(component.getClientId(context), message);
				
			}
			//check user length
			
			if(!isCharsInBag (phone, "0123456789-(),;+"))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�����ֻ����Ƿ�ȫΪ�����ַ�:0123456789-(),;+��");
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
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","���������ϵ�绰����Ϊ\""+phone.length()+"\"������6-30λ��Ҫ��");
		 		context.addMessage(component.getClientId(context), message);
		    }
			if (phone.length()>30){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","���������ϵ�绰����Ϊ\""+phone.length()+"\"������6-30λ��Ҫ��");
		 		context.addMessage(component.getClientId(context), message);
		 	}
			if ( isCharsInBag( phone, badChar))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��ϵ�绰�в��ܺ��������ַ���><[]{}?/+=|\\'\":~!@#$%^&`\n");
				context.addMessage(component.getClientId(context), message);
				
			}
			//check user length
			
			if(!isCharsInBag (phone, "0123456789-(),;+"))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����绰�Ƿ�ȫΪ�����ַ�:0123456789-(),;+��");
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
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������û�������Ϊ\""+schar.length+"\"������6-20λ��Ҫ��");
	 		context.addMessage(component.getClientId(context), message);
	 	}
        if (schar.length>20){
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������û�������Ϊ\""+schar.length+"\"������6-20λ��Ҫ��");
	 		context.addMessage(component.getClientId(context), message);
	 	}
        if ( isWhitespace(s) )
		{
	   		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","������û����в��ܰ����ո�������������룡\n");
	   		context.addMessage(component.getClientId(context), message);
		}
        if (errorChar!=' ')
		{
    		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��������û���\"" + s+"\"����Ч���û���,�벻Ҫ���û����������ַ�\"" + errorChar + "\"!����������Ϸ����û�����\n");
    		context.addMessage(component.getClientId(context), message);
		
		}
        if (!isEnglish(s)){
	 		message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","�û�������ΪӢ�ġ��»��߻����֣�\n");
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
