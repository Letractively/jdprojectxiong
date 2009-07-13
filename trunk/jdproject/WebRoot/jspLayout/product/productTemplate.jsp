<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="manageTemplateView">
<script src="${facesContext.externalContext.requestContextPath}/css/common.js" type="text/javascript"></script>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/common.css"/>
<h:panelGrid columns="1" style="width:100%;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<ui:insert name="manageOneHeader">
		<f:subview id="manageHeaderOneView">
			<ui:include src="./productHeaderOne.jsp" />
		</f:subview>
	</ui:insert>
	<ui:insert name="manageTwoHeader">
		<f:subview id="manageHeaderTwoView">
			<ui:include src="./productHeaderTwo.jsp" />
		</f:subview>
	</ui:insert>
	<h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0" style="width:100%;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<h:panelGrid columns="3" cellpadding="0" cellspacing="0" border="0" styleClass="headerStyle" columnClasses="headerLeftRightStyle,headerMiddleStyle,headerLeftRightStyle">
	    <ui:insert name="manageHeaderMainLeft">
	    	<f:subview id="manageHeaderMainView1">
	    		<h:graphicImage url="/css/images/spacer.gif" style="width:100%; height:1"></h:graphicImage>
	    	</f:subview>
	    </ui:insert>
		<ui:insert name="manageHeaderMainMiddle">
			<f:subview id="manageHeaderMainView2">
				<ui:include src="./productHeader.jsp" />
			</f:subview>
		</ui:insert>
		<ui:insert name="manageHeaderMainRight">
			<f:subview id="manageHeaderMainView3">
	    		<h:graphicImage url="/css/images/spacer.gif" style="width:100%; height:1"></h:graphicImage>
	    	</f:subview>
	    </ui:insert>
	</h:panelGrid>
	<h:panelGrid bgcolor="#bbd6ef" width="100%" style=" height:28;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px"><h:outputText value=" "/></h:panelGrid>
	</h:panelGrid>
</h:panelGrid>

<h:panelGrid columns="1" style="width:100%">
	<ui:insert name="content">
		<f:subview id="manageContentView">
			
			<h:outputText value="sdfddfdfdfdffdfdsasasasasasasasasas"></h:outputText>
			
		</f:subview>
	</ui:insert>

</h:panelGrid>
<table cellpadding="4" cellspacing="0" width="100%">
<tbody><tr>
<td align="center" bgcolor="white" width="100%"></td></tr>
</tbody></table>
bbb<br/>
<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody><tr>
<td align="center" width="100%"><p>ccc</p></td>
</tr>
</tbody>
</table>
</f:subview>		
</jsp:root>	