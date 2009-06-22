<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view id="manageMainView">
<html>
	<head>
    <title>新增产品</title>
    </head>
    <body>
    	<ui:composition template="../manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="productform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}"/></legend>
    			
    				<h:panelGrid id="newpanel" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<h:outputLabel value="产品编码：" for="productCode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.code}" id="cc">
							<rich:beanValidator summary="类型有误"/>
                		</h:inputText>
                		<rich:message for="productCode" />
                		<h:outputLabel value="原厂商编码：" for="manufacturerCode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.manufacturerCode}" id="manufacturerCode">
                    		<rich:beanValidator summary="序号有误"/>
                    	</h:inputText>
                		<rich:message for="manufacturerCode" />
						<h:outputLabel value="条码号：" for="barcode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.barcode}" id="barcode">
                    		<rich:beanValidator summary="序号有误"/>
                    	</h:inputText>
                		<rich:message for="barcode" />
						<h:outputLabel value="名称：" for="name"></h:outputLabel>
						<h:inputText value="#{productCreate.product.name}" id="name">
                    	</h:inputText>
                		<rich:message for="name" />
						<h:outputLabel value="图片：" for="imageName"></h:outputLabel>
						<h:panelGroup>
	    					<h:inputText value="#{productCreate.product.imageName}" id="imageName"/>
	    					<rich:suggestionbox id="suggestionBoxId" for="imageName" tokens=","
	                        rules="#{imageSuggestionBox.rules}"
	                        suggestionAction="#{imageSuggestionBox.autocomplete}" var="result"
	                        fetchValue="#{result.name}"
	                        first="#{imageSuggestionBox.intFirst}"
	                        minChars="0"
	                        shadowOpacity="#{imageSuggestionBox.shadowOpacity}"
	                        border="#{imageSuggestionBox.border}"
	                        width="#{imageSuggestionBox.width}"
	                        height="#{imageSuggestionBox.height}"
	                        shadowDepth="#{imageSuggestionBox.shadowDepth}"
	                        cellpadding="#{imageSuggestionBox.cellpadding}"
	                        usingSuggestObjects="#{imageSuggestionBox.usingSuggestObjects}">
	
	            			<a4j:ajaxListener type="com.ejd.web.vo.listener.AjaxListener"/>
	        				<h:column>
	            				<h:outputText value="#{result.name}"/>
	        				</h:column>
	    					</rich:suggestionbox>
    					</h:panelGroup>
                		<rich:message for="imageName" />
						<h:outputLabel value="规格：" for="spec"></h:outputLabel>
						<h:inputText value="#{productCreate.product.spec}" id="spec">
                    	</h:inputText>
                		<rich:message for="spec" />
						<h:outputLabel value="单位：" for="unitId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.unitId}" id="unitId">
							<f:selectItems value="#{existProductUnit.unitItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						
						<h:outputLabel value="品牌：" for="brandId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.brandId}" id="brandId">
							<f:selectItems value="#{existProductBrand.brandItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="大类：" for="primaryCategoryId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.primaryCategoryId}" id="primaryCategoryId">
							<f:selectItems value="#{existProductCategory.categoryItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="小类：" for="secondCategoryId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.secondCategoryId}" id="secondCategoryId">
							<f:selectItems value="#{existProductCategory.categoryItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="状态：" for="status"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.status}" id="status">
							<f:selectItems value="#{existProductStatus.statusItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						
						<h:outputLabel value="进货价：" for="purchasePrice"></h:outputLabel>
						<h:inputText value="#{productCreate.product.purchasePrice}" id="purchasePrice">
                    	</h:inputText>
                		<rich:message for="purchasePrice" />
						<h:outputLabel value="零售价：" for="retailPrice"></h:outputLabel>
						<h:inputText value="#{productCreate.product.spec}" id="retailPrice">
                    	</h:inputText>
                		<rich:message for="retailPrice" />
						<h:outputLabel value="经销尚价：" for="tradePriceOne"></h:outputLabel>
						<h:inputText value="#{productCreate.product.tradePriceOne}" id="tradePriceOne">
                    	</h:inputText>
                		<rich:message for="tradePriceOne" />
						<h:outputLabel value="代理商价：" for="tradePriceTwo"></h:outputLabel>
						<h:inputText value="#{productCreate.product.spec}" id="tradePriceTwo">
                    	</h:inputText>
                		<rich:message for="tradePriceTwo" />
						<h:outputLabel value="库存下限：" for="stockLowerNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.stockLowerNumber}" id="stockLowerNumber" minValue="1" maxValue="10000" step="1"/>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="库存上限：" for="stockUpperNumber "></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.stockUpperNumber }" id="stockUpperNumber" minValue="1" maxValue="100000" step="1"/>
						<h:outputText value=" "></h:outputText>
						<h:outputLabel value="介绍页面：" for="introduceFileName"></h:outputLabel>
						<h:inputText value="#{productCreate.product.introduceFileName}" id="introduceFileName">
                    	</h:inputText>
                		<rich:message for="introduceFileName" />
					</h:panelGrid>
					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	