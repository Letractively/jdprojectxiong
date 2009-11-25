<?xml version="1.0" encoding="UTF-8"?>
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
						<h:inputText value="#{productCreate.product.code}" id="productCode">
							<a4j:support event="onblur" action="#{productCreate.setProductIntroduceFileName}" ajaxSingle="ture" limitToList="true" reRender="introduceFileName"></a4j:support>
                		</h:inputText>
                		<rich:message for="productCode" />
                		<h:outputLabel value="原厂商编码：" for="manufacturerCode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.manufacturerCode}" id="manufacturerCode" maxlength="20">
                    	</h:inputText>
                		<rich:message for="manufacturerCode" />
                		<h:outputLabel value="原厂商：" for="productProviderFullName"></h:outputLabel>
                		<h:panelGroup>
							<h:inputText value="#{productCreate.product.provider.fullName}" id="productProviderFullName">
							<a4j:support action="#{productCreate.setPopupStakeholderSearchName}" event="onblur" ajaxSingle="true" limitToList="true" reRender="productProviderFullName,popupStakeholderSearchName"></a4j:support> 
                    		</h:inputText>
                    		<a4j:jsFunction oncomplete="changeFinishInCreateProduct(data);" name="processSearchStakeholderMethodInCreateProduct"
    						data="#{popupStakeholder.searchName}"
    						actionListener="#{popupStakeholder.ActionListenerTest}"
   						 	action="#{popupStakeholder.valueChange}">

    						
     						<a4j:actionparam name="param1" value="A" assignTo="#{popupStakeholder.statusItem}" />
     						<a4j:actionparam name="param2" value="P" assignTo="#{popupStakeholder.typeItem}" />
     						<a4j:actionparam name="param3" value="productCreate" assignTo="#{popupStakeholder.facesBean}" />
     						<a4j:actionparam name="param4" value="product.provider" assignTo="#{popupStakeholder.propertyOfFacesBean}" />
   							</a4j:jsFunction>
   							<a4j:jsFunction name="processFreshStakeholerInCreateProduct" ajaxSingle="true" limitToList="true" reRender="productProviderFullName">
   						 	</a4j:jsFunction>
                    		<a4j:commandButton value="..." immediate="true" ajaxSingle="true" onclick="searchStakehoderInCreateProductBegin(); return false;"/>
                    	</h:panelGroup>
                		<rich:message for="productProviderFullName" />
						<h:outputLabel value="条码号：" for="barcode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.barcode}" id="barcode" maxlength="50">
                    	</h:inputText>
                		<rich:message for="barcode" />
						<h:outputLabel value="名称：" for="name"></h:outputLabel>
						<h:inputText value="#{productCreate.product.name}" id="name" maxlength="50">
                    	</h:inputText>
                		<rich:message for="name" />
						<h:outputLabel value="图片：" for="imageName"></h:outputLabel>
						<h:panelGroup>
	    					<h:inputText value="#{productCreate.product.imageName}" id="imageName" maxlength="50"/>
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
						<h:inputText value="#{productCreate.product.spec}" id="spec" maxlength="50">
                    	</h:inputText>
                		<rich:message for="spec" />
						<h:outputLabel value="大类：" for="primaryCategoryCode"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.primaryCategoryCode}" id="primaryCategoryCode" immediate="true" valueChangeListener="#{productCreate.changePrimaryCategory}">
							<f:selectItems value="#{productCreate.primaryCategoryCodeItems}"/>
							<a4j:support event="onchange" action="#{productCreate.changeSecondCategoryAndBrand}" reRender="secondCategoryCode" ajaxSingle="true" immediate="true"></a4j:support>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="小类：" for="secondCategoryCode"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.secondCategoryCode}" id="secondCategoryCode">
							<f:selectItems value="#{productCreate.secondCategoryCodeItems}" />
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
                		<h:outputLabel value="品牌：" for="brandId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.brandCode}" id="brandId">
							<f:selectItems value="#{productCreate.brandCodeItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
                		<h:outputLabel value="单位：" for="unitId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.unitId}" id="unitId">
							<f:selectItems value="#{existProductUnit.unitItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="状态：" for="status"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.status}" id="status">
							<f:selectItems value="#{existProductStatus.statusItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						
						<h:outputLabel value="进货价：" for="purchasePrice"></h:outputLabel>
						<h:inputText value="#{productCreate.product.purchasePrice}" id="purchasePrice" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="purchasePrice" />
						<h:outputLabel value="零售价：" for="retailPrice"></h:outputLabel>
						<h:inputText value="#{productCreate.product.retailPrice}" id="retailPrice" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="retailPrice" showSummary="false"/>
						<h:outputLabel value="经销商价：" for="tradePriceOne"></h:outputLabel>
						<h:inputText value="#{productCreate.product.tradePriceOne}" id="tradePriceOne" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="tradePriceOne" />
						<h:outputLabel value="代理商价：" for="tradePriceTwo"></h:outputLabel>
						<h:inputText value="#{productCreate.product.tradePriceTwo}" id="tradePriceTwo" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="tradePriceTwo" />
                		<h:outputLabel value="库存数量：" for="stockLowerNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.currentNumber}" id="currentNumber" minValue="1" maxValue="10000" step="1"/>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="库存下限：" for="stockLowerNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.stockLowerNumber}" id="stockLowerNumber" minValue="1" maxValue="10000" step="1"/>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="库存上限：" for="stockUpperNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.stockUpperNumber }" id="stockUpperNumber" minValue="1" maxValue="100000" step="1"/>
						<h:outputText value=" "></h:outputText>
						<h:outputLabel value="介绍页面：" for="introduceFileName"></h:outputLabel>
						<h:inputText value="#{productCreate.product.introduceFileName}" id="introduceFileName" maxlength="50" readonly="true">
                    	</h:inputText>
                		<rich:message for="introduceFileName" />
						<f:facet name="footer">
							<h:panelGrid columns="2" columnClasses="alight:left">
								<a4j:commandButton type="image" image="/css/images/blank.gif"></a4j:commandButton>
								<a4j:commandButton type="image" image="/css/images/createmyaccount.gif" action="#{productCreate.createProduct}"></a4j:commandButton>
							</h:panelGrid>
						</f:facet>
					</h:panelGrid>
					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	
