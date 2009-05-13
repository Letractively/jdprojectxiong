<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<style type="text/css">
		.col1 { vertical-align:top;	}
		.col2 {	vertical-align:top;	width:450px; }
		.wizard { width:400px; }
		.wform td {	vertical-align:top;	}
		.wfcol1 { text-align: right; white-space:nowrap;}
		.wfcol2 { }
		.wfcol3 { }
		.s1row td { height:30px; }
		.rich-message { color:red;	}
		
		.navPanel {
			position:absolute;
			bottom:0;
			height:23px;
			margin:0;
			padding:2px;
		}

	</style>
	<br/>
<h:panelGrid width="100%" columns="2" columnClasses="col1,col2">
		<a4j:keepAlive beanName="stakeholderCreate" />
		<rich:panel styleClass="wizard">
			<f:facet name="header">
			<h:outputText value="Using a4j:include for Wizard-like behaviour" />
			</f:facet>
<h:panelGroup id="pge">
<a4j:include id="in" viewId="/jspLayout/manage/stakeholderCreatePersonCreate.jsp"></a4j:include>

</h:panelGroup>	
		</rich:panel>
	
	</h:panelGrid>
	<br/>	
</jsp:root>	