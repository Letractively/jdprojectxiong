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
<table width="100%">
<tbody>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listVacuumCleanerProduct.brandLabel}"></h:outputLabel>
		</td>
			
		<td class="selected-new" width="80%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationVacuumCleaner.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
			
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listVacuumCleanerProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationVacuumCleaner.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
					<span class="top-product-navigation-option">#{priceRange.description}</span>
					<a4j:actionparam value="#{priceRange.min}" name="priceRangeMin"/>
					<a4j:actionparam value="#{priceRange.max}" name="priceRangeMax"/>
					<a4j:actionparam value="#{priceRange.description}" name="priceRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="供电方式:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="powerSupplyTypeItemsLabel" styleClass="current-selected" value="#{listVacuumCleanerProduct.powerSupplyTypeItemsLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="powerSupplyTypeItem" rowKeyVar="index" value="#{powerSupplyTypeItems}">
				<a4j:commandLink action="#{navigationVacuumCleaner.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,powerSupplyTypeItemsLabel">
					<span class="top-product-navigation-option">#{powerSupplyTypeItem.label}</span>
					<a4j:actionparam value="#{powerSupplyTypeItem.value}" name="powerSupplyTypeItem"/>
					<a4j:actionparam value="#{powerSupplyTypeItem.label}" name="powerSupplyTypeItemLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="类型:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="useTypeItemsLabel" styleClass="current-selected" value="#{listVacuumCleanerProduct.useTypeItemsLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="useTypeItem" rowKeyVar="index" value="#{useTypeItems}">
				<a4j:commandLink action="#{navigationVacuumCleaner.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,useTypeItemsLabel">
					<span class="top-product-navigation-option">#{useTypeItem.label}</span>
					<a4j:actionparam value="#{useTypeItem.value}" name="useTypeItem"/>
					<a4j:actionparam value="#{useTypeItem.label}" name="useTypeItemLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
</tbody>
</table>
</ui:composition>
</jsp:root>

