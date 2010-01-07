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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listElectronicOvenProduct.brandLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="86%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationElectronicOven.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:15%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listElectronicOvenProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="90%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationElectronicOven.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
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
			<h:outputLabel value="加热方式:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="hotTypeLabel" styleClass="current-selected" value="#{listElectronicOvenProduct.hotTypeLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="86%">
			<a4j:repeat var="hotType" rowKeyVar="index" value="#{hotTypeItems}">
				<a4j:commandLink action="#{navigationElectronicOven.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,hotTypeLabel">
					<span class="top-product-navigation-option">#{hotType.label}</span>
					<a4j:actionparam value="#{hotType.value}" name="hotType"/>
					<a4j:actionparam value="#{hotType.label}" name="hotTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	

</ui:composition>
</jsp:root>

