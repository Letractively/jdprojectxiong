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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listVentilatorProduct.brandLabel}"></h:outputLabel>
		</td>
			
		<td class="selected-new" width="80%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationVentilator.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
			
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listVentilatorProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationVentilator.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
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
			<h:outputLabel value="排风量:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="windRangeLabel" styleClass="current-selected" value="#{listVentilatorProduct.windRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="windRange" rowKeyVar="index" value="#{windRangeList}">
				<a4j:commandLink action="#{navigationVentilator.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,windRangeLabel">
					<span class="top-product-navigation-option">#{windRange.description}</span>
					<a4j:actionparam value="#{windRange.min}" name="windRangeMin"/>
					<a4j:actionparam value="#{windRange.max}" name="windRangeMax"/>
					<a4j:actionparam value="#{windRange.description}" name="windRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="功率(W):" styleClass="current-selected_label"></h:outputLabel><h:outputText id="powerRangeLabel" styleClass="current-selected" value="#{listVentilatorProduct.powerRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="powerRange" rowKeyVar="index" value="#{powerRangeList}">
				<a4j:commandLink action="#{navigationVentilator.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,powerRangeLabel">
					<span class="top-product-navigation-option">#{powerRange.description}</span>
					<a4j:actionparam value="#{powerRange.min}" name="powerRangeMin"/>
					<a4j:actionparam value="#{powerRange.max}" name="powerRangeMax"/>
					<a4j:actionparam value="#{powerRange.description}" name="powerRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
</tbody>
</table>
	
	

</ui:composition>
</jsp:root>

