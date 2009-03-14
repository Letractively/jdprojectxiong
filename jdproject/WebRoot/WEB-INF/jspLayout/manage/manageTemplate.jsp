<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xhtml; charset=UTF-8"/>
<title>
	<ui:insert name="title"/>
</title>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/common.css"/>
 
</head>

<body>
<div class="xkb" align="center">

<table border="0" cellspacing="0" width="100%">
    <tbody><tr>
        <td class="rkb" align="right" valign="middle" width="50%" nowrap="nowrap">
        	<ui:insert name="manageheader">
				<f:subview id="manageheaderview">
					<ui:include src="${facesContext.externalContext.requestContextPath}/WEB-INF/jspLayout/manage/manageHeader.jsp" />
				</f:subview>
			</ui:insert>
		</td>
    </tr>
</tbody></table>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tbody>
		<tr>
			<td width="180" height="894" valign="top" bgcolor="#eff7ff" style="border-left: 1px solid rgb(187, 214, 239); padding-left: 10px;">
            left
			</td>
<!--right -->
			<td valign="top">
			right<!-- right-->
			</td>
		</tr>
	</tbody>
</table>
<table cellpadding="4" cellspacing="0" width="100%">
	<tbody>
		<tr>
			<td align="center" bgcolor="white" width="100%">
			</td>
		</tr>
	</tbody>
</table>
<f:verbatim>
</f:verbatim>
<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
	<tbody>
		<tr>
			<td align="center" width="100%">
			</td>
		</tr>
	</tbody>
</table>
</div>

</body>
</html>
</f:view>		
</jsp:root>	