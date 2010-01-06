<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<ui:composition>
	<tr>
		<td style="PADDING-LEFT: 8px;width:14%;text-align:left;">
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listInductionCookerProduct.brandLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="86%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationInductionCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:15%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listInductionCookerProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="90%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationInductionCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
					<span class="top-product-navigation-option">#{priceRange.description}</span>
					<a4j:actionparam value="#{priceRange.min}" name="priceRangeMin"/>
					<a4j:actionparam value="#{priceRange.max}" name="priceRangeMax"/>
					<a4j:actionparam value="#{priceRange.description}" name="priceRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:14%;text-align:left;">
			<h:outputLabel value="面板类型:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="panelTypeLabel" styleClass="current-selected" value="#{listInductionCookerProduct.panelTypeLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="86%">
			<a4j:repeat var="panelType" rowKeyVar="index" value="#{panelTypeItems}">
				<a4j:commandLink action="#{navigationInductionCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,panelTypeLabel">
					<span class="top-product-navigation-option">#{panelType.label}</span>
					<a4j:actionparam value="#{panelType.value}" name="panelType"/>
					<a4j:actionparam value="#{panelType.label}" name="panelTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:14%;text-align:left;">
			<h:outputLabel value="配件:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="fittingLabel" styleClass="current-selected" value="#{listInductionCookerProduct.fittingLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="86%">
			<a4j:repeat var="fitting" rowKeyVar="index" value="#{fittingItems}">
				<a4j:commandLink action="#{navigationInductionCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,fittingLabel">
					<span class="top-product-navigation-option">#{fitting.label}</span>
					<a4j:actionparam value="#{fitting.value}" name="fitting"/>
					<a4j:actionparam value="#{fitting.label}" name="fittingLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	
	

</ui:composition>
</jsp:root>

