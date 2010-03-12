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
    <title>购物车</title>
    </head>
    <body>
    	<ui:composition template="./shoppingTemplate.jsp">
    		<ui:define id="contentHeader" name="contentHeader">
    				<h:outputText value="我的购物车"></h:outputText>
			</ui:define>
			<ui:define id="shoppingCartContent" name="content">
			<h:form>
				<rich:panel style="width:100%" headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
					<f:facet name="header">
						<h:panelGrid columns="3" style="align:left"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
								<h:outputText value="" style="width:4px"></h:outputText>
								<h:panelGroup>
									<h:outputText value="我已挑选的商品"></h:outputText>
								</h:panelGroup>
								<h:outputText value="" style="width:4px"></h:outputText>
							</h:panelGrid>	
					</f:facet>
					<rich:extendedDataTable id="shoppingCartTable" value="#{shopCart.cart.inventory}" var="inventory">
						<rich:column label="选择">
							<f:facet name="header"><h:outputText value="选择"/></f:facet>
							<h:selectBooleanCheckbox value="#{inventory.selected}"></h:selectBooleanCheckbox>
						</rich:column>
						<rich:column label="图片">
							<f:facet name="header"><h:outputText value="图片"/></f:facet>
							<h:commandLink action="#{productGlobalNavigation.seeProductDetail}" immediate="true"><h:graphicImage value="/productimage/#{inventory.imageName}" styleClass="product-image-in-shopping-cart"/><f:param name="productid" value="#{inventory.id}"></f:param></h:commandLink>
						</rich:column>
						<rich:column label="商品名称">
							<f:facet name="header"><h:outputText value="商品名称"/></f:facet>
							<h:outputText value="#{inventory.name}"></h:outputText>
						</rich:column>
						<rich:column label="销售价格">
							<f:facet name="header"><h:outputText value="销售价格"/></f:facet>
							<h:outputText value="#{inventory.salesPrice}"></h:outputText>
						</rich:column>
						<rich:column label="赠送积分">
							<f:facet name="header"><h:outputText value="赠送积分"/></f:facet>
							<h:outputText value="#{inventory.integration}"></h:outputText>
						</rich:column>
						<rich:column label="购买数量">
							<f:facet name="header"><h:outputText value="购买数量"/></f:facet>
							<h:outputText value="#{inventory.salesQuantity}"></h:outputText>
						</rich:column>
						<rich:column label="商品状态">
							<f:facet name="header"><h:outputText value="商品状态"/></f:facet>
							<h:outputText value="现货" rendered="#{inventory.currentNumber > 0}"></h:outputText>
							<h:outputText value="需预定" rendered="#{!(inventory.currentNumber > 0)}"></h:outputText>
						</rich:column>
						<rich:column label="金额小计">
							<f:facet name="header"><h:outputText value="金额小计"/></f:facet>
							<h:outputText value="#{inventory.salesQuantity * inventory.salesPrice}"></h:outputText>
						</rich:column>
						<rich:column label="单项操作">
							<f:facet name="header"><h:outputText value="单项操作"/></f:facet>
							<h:panelGroup><a4j:commandButton value="删除"/><a4j:commandButton value="移入收藏夹"/></h:panelGroup>
						</rich:column>
					
					</rich:extendedDataTable>
				</rich:panel>
			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	