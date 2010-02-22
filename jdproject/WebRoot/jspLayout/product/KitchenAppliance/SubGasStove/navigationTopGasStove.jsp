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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listGasStoveProduct.brandLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationGasStove.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listGasStoveProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationGasStove.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
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
			<h:outputLabel value="燃烧器个数:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="numberRangeLabel" styleClass="current-selected" value="#{listGasStoveProduct.numberRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="numberRange" rowKeyVar="index" value="#{numberRangeList}">
				<a4j:commandLink action="#{navigationGasStove.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,numberRangeLabel">
					<span class="top-product-navigation-option">#{numberRange.description}</span>
					<a4j:actionparam value="#{numberRange.min}" name="numberRangeMin"/>
					<a4j:actionparam value="#{numberRange.max}" name="numberRangeMax"/>
					<a4j:actionparam value="#{numberRange.description}" name="numberRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="适用气源:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="gasTypeLabel" styleClass="current-selected" value="#{listGasStoveProduct.gasTypeLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="gasType" rowKeyVar="index" value="#{gasTypeItems}">
				<a4j:commandLink action="#{navigationGasStove.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,gasTypeLabel">
					<span class="top-product-navigation-option">#{gasType.label}</span>
					<a4j:actionparam value="#{gasType.value}" name="gasType"/>
					<a4j:actionparam value="#{gasType.label}" name="gasTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="安装方式:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="fitTypeLabel" styleClass="current-selected" value="#{listGasStoveProduct.fitTypeLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="fitType" rowKeyVar="index" value="#{fitTypeItems}">
				<a4j:commandLink action="#{navigationGasStove.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,fitTypeLabel">
					<span class="top-product-navigation-option">#{fitType.label}</span>
					<a4j:actionparam value="#{fitType.value}" name="fitType"/>
					<a4j:actionparam value="#{fitType.label}" name="fitTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	</tbody>
</table>

</ui:composition>
</jsp:root>

