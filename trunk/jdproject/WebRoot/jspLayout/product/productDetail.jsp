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
        .pic-normal {
            width: 120px;
            border: 2px solid #ACBECE;

        }
        .wrap1 {
            width:190px;
            height: 130px;
            float: left;            
        }
</style>
<f:view>
<html>
	<head>
    <title>产品浏览</title>
    </head>
    <body>
    	<ui:composition template="./productTemplate.jsp">
    		<ui:define id="kitchenApplianceLeft" name="left">
    			<ui:include id="kitchenApplianceLeftInclude" src="./navigationProductLeft.jsp">
    			</ui:include>
    		</ui:define>
    		
			<ui:define id="kitchenApplianceContent" name="content">
				<rich:panel style="width:100%" styleClass="panel-none-border" headerClass="panel-header-gray-border" bodyClass="panel-documents-gray-border">
					<f:facet name="header">
						<h:panelGrid columns="3"  cellspacing="0" cellpadding="0" columnClasses="product-detail-panel-grid-header-left,product-detail-panel-grid-header-center,product-detail-panel-grid-header-right">
								<h:outputText value="" style="width:4px"></h:outputText>
								<h:panelGroup>
									<h:outputText value="[#{productInfo.product.brandCode}]#{productInfo.product.name}" styleClass="product-detail-font1"></h:outputText><f:verbatim><br/></f:verbatim>
									<h:outputText value="#{productInfo.product.description}" styleClass="product-detail-font2"></h:outputText>
								</h:panelGroup>
								<h:outputText value="" style="width:4px"></h:outputText>
							</h:panelGrid>
							
						
					</f:facet>
					<h:panelGrid style="width:99%" columns="2" cellspacing="0" cellpadding="0" columnClasses="product-detail-panel-grid-body-column-one,product-detail-panel-grid-body-column-two">
							<a4j:outputPanel>
								<h:graphicImage value="/productimage/#{productInfo.product.imageName}"></h:graphicImage>
							</a4j:outputPanel>
							<h:panelGrid columns="2">
								<h:outputText value="aaa"></h:outputText>
								<h:outputText value="dd"></h:outputText>
							</h:panelGrid>
					</h:panelGrid>
				</rich:panel>
				
    		</ui:define>
    		<ui:define id="kitchenApplianceRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	