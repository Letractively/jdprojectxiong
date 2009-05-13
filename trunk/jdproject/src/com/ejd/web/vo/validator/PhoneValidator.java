package com.ejd.web.vo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;


public class PhoneValidator implements Validator,Serializable {
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
			if (phone.length()<6)
		 	{
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","���������ϵ�绰����Ϊ\""+phone.length()+"\"������6-30λ��Ҫ��");
		 		throw new ValidatorException(message);
		    }
			if (phone.length()>30){
		 		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","���������ϵ�绰����Ϊ\""+phone.length()+"\"������6-30λ��Ҫ��");
		 		throw new ValidatorException(message);
		 	}
			if ( isCharsInBag( phone, badChar))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","��ϵ�绰�в��ܺ��������ַ���><[]{}?/+=|\\'\":~!@#$%^&`\n");
		 		throw new ValidatorException(message);
				
			}
			//check user length
			
			if(!isCharsInBag (phone, "0123456789-(),;+"))
			{
				FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"������ʾ:","����绰�Ƿ�ȫΪ�����ַ�:0123456789-(),;+��");
		 		throw new ValidatorException(message);
			}
		}


	}

}
