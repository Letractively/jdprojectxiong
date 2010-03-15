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
					<a4j:region id="shoppingCartDataTableRegion" renderRegionOnly="false" selfRendered="true">
					<rich:dataTable id="shoppingCartTable" value="#{shopCart.cart.inventory}" var="inventory" frame="box" columns="9" rowClasses="table-row-odd,table-row-even" columnClasses="shopping-cart-table-column1,shopping-cart-table-column2,shopping-cart-table-column3,shopping-cart-table-column4,shopping-cart-table-column5,shopping-cart-table-column6,shopping-cart-table-column7,shopping-cart-table-column8" cellpadding="1" cellspacing="1" border="0" sortMode="single" width="100%">
						<rich:column sortable="false" style="width:5%;" label="选择">
							<f:facet name="header"><h:outputText value="选择"/></f:facet>
							<h:selectBooleanCheckbox value="#{inventory.selected}"><a4j:support event="onclick" reRender="deleteAllBtn"/></h:selectBooleanCheckbox>
							<f:facet name="footer"><h:commandLink id="deleteAllBtn" value="删除" styleClass="button-default-style" disabled="#{!(shopCart.cart.haveSelected)}" onclick="return confirm('确认删除购物车中选中的商品吗？');"></h:commandLink></f:facet>
						</rich:column>
						<rich:column sortable="false" style="width:42%;" label="商品名称">
							<f:facet name="header"><h:outputText value="商品名称"/></f:facet>
							<h:commandLink action="#{productGlobalNavigation.seeProductDetail}" immediate="true"><h:outputText value="#{inventory.name}"></h:outputText><f:param name="productid" value="#{inventory.id}"></f:param></h:commandLink>
						</rich:column>
						<rich:column sortable="false" style="width:8%;" label="销售价格">
							<f:facet name="header"><h:outputText value="销售价格"/></f:facet>
							<h:outputText value="#{inventory.salesPrice}"></h:outputText>
						</rich:column>
						<rich:column sortable="false" style="width:8%;" label="赠送积分">
							<f:facet name="header"><h:outputText value="赠送积分"/></f:facet>
							<h:outputText value="#{inventory.integration}"></h:outputText>
						</rich:column>
						<rich:column sortable="false" style="width:7%;" headerClass="shopping-cart-table-column-header" label="购买数量">
							<f:facet name="header"><h:outputText value="购买数量"/></f:facet>
							<rich:inputNumberSpinner value="#{inventory.salesQuantity}" step="1" minValue="1" maxValue="300" inputSize="1" style="align:center"><a4j:support event="onchange" reRender="subTotal"/></rich:inputNumberSpinner>
						</rich:column>
						<rich:column sortable="false" style="width:7%;" label="商品状态">
							<f:facet name="header"><h:outputText value="商品状态"/></f:facet>
							<h:outputText value="现货" rendered="#{inventory.currentNumber > 0}"></h:outputText>
							<h:outputText value="需预定" rendered="#{!(inventory.currentNumber > 0)}"></h:outputText>
						</rich:column>
						<rich:column sortable="false" style="width:7%;" selfSorted="false" label="金额小计">
							<f:facet name="header"><h:outputText value="金额小计"/></f:facet>
							<h:outputText id="subTotal" value="#{inventory.salesQuantity * inventory.salesPrice}"></h:outputText>
						</rich:column>
						<rich:column sortable="false" style="width:14%;" selfSorted="false" label="单项操作">
							<f:facet name="header"><h:outputText value="单项操作"/></f:facet>
							<h:panelGroup><a4j:commandLink value="删除" styleClass="button-default-style" onclick="javascript:return confirm('确认删除购物车中该商品吗？');"/><a4j:commandLink value="移入收藏夹" styleClass="button-default-style"/></h:panelGroup>
						</rich:column>
					</rich:dataTable>
					</a4j:region>
				</rich:panel>
				<rich:panel style="width:100%;padding-top: 10px;padding-left: 28px;" headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-none-border">
					<h:commandLink value="继续购物" styleClass="ButtonDefault" immediate="true" ></h:commandLink>
					<h:commandLink value="清空购物车" styleClass="ButtonDefault" onclick="javascript:return confirm('确认清空购物车中所有的商品吗？');"></h:commandLink>
				</rich:panel>
				
			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	