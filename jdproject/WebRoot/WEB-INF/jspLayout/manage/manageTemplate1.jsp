<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<html>
<head>
<meta http-equiv="Content-Type" content="text/xhtml; charset=UTF-8"/>
<title>
	<ui:insert name="title"/>
</title>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/common.css"/>
 
</head>

<body>
<ui:insert name="manageheader">
	<f:subview id="manageheaderview">
		<ui:include src="${facesContext.externalContext.requestContextPath}/WEB-INF/jspLayout/manage/manageHeader.jsp" />
	</f:subview>
</ui:insert>
<table class="left_menu" cellpadding="0" cellspacing="0" border="0">
<tbody>
	<tr>
		<td>
			<ui:include src="/templates/include/references.xhtml" />
			<div class="menu_separator">
				&nbsp;
			</div>
			<ui:include src="/templates/include/components-navigation.xhtml" />
		</td>
	</tr>
</tbody>
</table>

<h:graphicImage value="#{componentNavigator.currentComponent.captionImage}" 
	rendered="#{componentNavigator.hasCurrentComponent}" height="40" alt="" border="0" styleClass="component_name"/>

<table cellpadding="0" cellspacing="0" border="0" class="content_container" width="100%">
<tbody>
	<tr>
		<td>
			<div class="content_container_left_brick"></div>
		</td>
		<td width="100%" class="content_container_pdddings">
<!-- tabpanel begin -->
		<ui:insert name="body">Body</ui:insert>
<!-- tabpanel end -->	
		<rich:spacer style="height:10px;" />
		<rich:separator style="height:1px" />	
		<div style="float:right;" class="footer-text">#{environment.version}</div>
		<div style="float:none">
			<a href="http://jboss.com/index.html?module=bb&amp;op=viewtopic&amp;t=104575"
				 style="color:#000; display:block"  class="footer-text">RichFaces. Most Important Links</a>
		</div>
		</td>
	</tr>
</tbody>
</table>

</body>
</html>		
</jsp:root>	