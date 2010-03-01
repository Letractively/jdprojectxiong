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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listElectricWaterHeaterProduct.brandLabel}"></h:outputLabel>
		</td>
			
		<td class="selected-new" width="80%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationElectricWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
			
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listElectricWaterHeaterProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationElectricWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
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
			<h:outputLabel value="容积(L):" styleClass="current-selected_label"></h:outputLabel><h:outputText id="volumeRangeLabel" styleClass="current-selected" value="#{listElectricWaterHeaterProduct.volumeRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="volumeRange" rowKeyVar="index" value="#{volumeRangeList}">
				<a4j:commandLink action="#{navigationElectricWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,volumeRangeLabel">
					<span class="top-product-navigation-option">#{volumeRange.description}</span>
					<a4j:actionparam value="#{volumeRange.min}" name="volumeRangeMin"/>
					<a4j:actionparam value="#{volumeRange.max}" name="volumeRangeMax"/>
					<a4j:actionparam value="#{volumeRange.description}" name="volumeRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="功率(W):" styleClass="current-selected_label"></h:outputLabel><h:outputText id="powerRangeLabel" styleClass="current-selected" value="#{listElectricWaterHeaterProduct.powerRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="powerRange" rowKeyVar="index" value="#{powerRangeList}">
				<a4j:commandLink action="#{navigationElectricWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,powerRangeLabel">
					<span class="top-product-navigation-option">#{powerRange.description}</span>
					<a4j:actionparam value="#{powerRange.min}" name="powerRangeMin"/>
					<a4j:actionparam value="#{powerRange.max}" name="powerRangeMax"/>
					<a4j:actionparam value="#{powerRange.description}" name="powerRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="水压(Mpa):" styleClass="current-selected_label"></h:outputLabel><h:outputText id="pressureRangeLabel" styleClass="current-selected" value="#{listElectricWaterHeaterProduct.pressureRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="pressureRange" rowKeyVar="index" value="#{pressureRangeList}">
				<a4j:commandLink action="#{navigationElectricWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,pressureRangeLabel">
					<span class="top-product-navigation-option">#{pressureRange.description}</span>
					<a4j:actionparam value="#{pressureRange.min}" name="pressureRangeMin"/>
					<a4j:actionparam value="#{pressureRange.max}" name="pressureRangeMax"/>
					<a4j:actionparam value="#{pressureRange.description}" name="pressureRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="款式:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="setTypeItemsLabel" styleClass="current-selected" value="#{listElectricWaterHeaterProduct.setTypeItemsLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="setTypeItem" rowKeyVar="index" value="#{setTypeItems}">
				<a4j:commandLink action="#{navigationElectricWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,setTypeItemsLabel">
					<span class="top-product-navigation-option">#{setTypeItem.label}</span>
					<a4j:actionparam value="#{setTypeItem.value}" name="setTypeItem"/>
					<a4j:actionparam value="#{setTypeItem.label}" name="setTypeItemLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
</tbody>
</table>
</ui:composition>
</jsp:root>

