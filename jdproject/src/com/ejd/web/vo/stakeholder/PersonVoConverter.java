/**
 * License Agreement.
 *
 * Rich Faces - Natural Ajax for Java Server Faces (JSF)
 *
 * Copyright (C) 2007 Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */


package com.ejd.web.vo.stakeholder;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/** 
 * @author Nick Belaevski
 * @since 3.3.0
 */
public class PersonVoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (value == null || value.length() == 0) {
			return null;
		}
		
		String[] split = value.split(":");
		PersonVo personVo = new PersonVo();
		if (null != split[0] & !"".equals(split[0])) {
			personVo.setName(split[0]);
		}
		if (null != split[1] & !"".equals(split[1])) {
			personVo.setId(Integer.valueOf(split[1]));
		}
		if (null != split[2] & !"".equals(split[2])) {
			personVo.setAge(Integer.valueOf(split[2]));
		}
		if (null != split[3] & !"".equals(split[3])) {
			personVo.setSex(split[3]);
		}
		if (null != split[4] & !"".equals(split[4])) {
			personVo.setPhone(split[4]);
		}
		if (null != split[5] & !"".equals(split[5])) {
			personVo.setTax(split[5]);
		}
		if (null != split[6] & !"".equals(split[6])) {
			personVo.setMobile(split[6]);
		}
		if (null != split[7] & !"".equals(split[7])) {
			personVo.setEmail(split[7]);
		}
		if (null != split[8] & !"".equals(split[8])) {
			personVo.setAddress(split[8]);
		}
		if (null != split[9] & !"".equals(split[9])) {
			personVo.setPrincipalship(split[9]);
		}
		if (null != split[10] & !"".equals(split[10])) {
			personVo.setRemark(split[10]);
		}
		if (null != split[11] & !"".equals(split[11])) {
			personVo.setSortOrder(Integer.valueOf(split[11]));
		}
		if (null != split[12] & !"".equals(split[12])) {
			personVo.setSelected(Boolean.valueOf(split[12]));
		}
		return personVo;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String blank = "";
		if (value == null) {
			return "";
		}

		PersonVo personVo = (PersonVo) value;
		blank = blank + ((null == personVo.getName() || "".equals(personVo.getName()))?"":personVo.getName()) + ":" ;
		blank = blank + ((null == personVo.getId())?"":personVo.getId().toString()) + ":";
		blank = blank + ((null == personVo.getAge())?"":personVo.getAge().toString()) + ":";
		blank = blank + ((null == personVo.getSex())?"":personVo.getSex()) + ":";
		blank = blank + ((null == personVo.getPhone())?"":personVo.getPhone()) + ":";
		blank = blank + ((null == personVo.getTax())?"":personVo.getTax()) + ":";
		blank = blank + ((null == personVo.getMobile())?"":personVo.getMobile()) + ":";
		blank = blank + ((null == personVo.getEmail())?"":personVo.getEmail()) + ":";
		blank = blank + ((null == personVo.getAddress())?"":personVo.getAddress()) + ":";
		blank = blank + ((null == personVo.getPrincipalship())?"":personVo.getPrincipalship()) + ":";
		blank = blank + ((null == personVo.getRemark())?"":personVo.getRemark()) + ":";
		blank = blank + ((null == personVo.getSortOrder())?"":personVo.getSortOrder().toString()) + ":";
		blank = blank + ((null == Boolean.valueOf(personVo.isSelected())?"false":(String.valueOf(personVo.isSelected()))));
		return blank;
	}

}
