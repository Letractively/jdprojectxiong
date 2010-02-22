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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listGasWaterHeaterProduct.brandLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationGasWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listGasWaterHeaterProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationGasWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
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
			<h:outputLabel value="最大容积:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="volumeRangeLabel" styleClass="current-selected" value="#{listGasWaterHeaterProduct.volumeRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="volumeRange" rowKeyVar="index" value="#{volumeRangeList}">
				<a4j:commandLink action="#{navigationGasWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,volumeRangeLabel">
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
			<h:outputLabel value="热水产率:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="yieldRangeLabel" styleClass="current-selected" value="#{listGasWaterHeaterProduct.yieldRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="yieldRange" rowKeyVar="index" value="#{yieldRangeList}">
				<a4j:commandLink action="#{navigationGasWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,yieldRangeLabel">
					<span class="top-product-navigation-option">#{yieldRange.description}</span>
					<a4j:actionparam value="#{yieldRange.min}" name="yieldRangeMin"/>
					<a4j:actionparam value="#{yieldRange.max}" name="yieldRangeMax"/>
					<a4j:actionparam value="#{yieldRange.description}" name="yieldRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="适用气源:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="gasTypeLabel" styleClass="current-selected" value="#{listGasWaterHeaterProduct.gasTypeLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="gasType" rowKeyVar="index" value="#{gasTypeItems}">
				<a4j:commandLink action="#{navigationGasWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,gasTypeLabel">
					<span class="top-product-navigation-option">#{gasType.label}</span>
					<a4j:actionparam value="#{gasType.value}" name="gasType"/>
					<a4j:actionparam value="#{gasType.label}" name="gasTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:20%;text-align:left;">
			<h:outputLabel value="排烟方式:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="smokeTypeLabel" styleClass="current-selected" value="#{listGasWaterHeaterProduct.smokeTypeLabel}"></h:outputLabel>
		</td>
		<td class="selected-new" width="80%">
			<a4j:repeat var="smokeType" rowKeyVar="index" value="#{smokeTypeItems}">
				<a4j:commandLink action="#{navigationGasWaterHeater.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,smokeTypeLabel">
					<span class="top-product-navigation-option">#{smokeType.label}</span>
					<a4j:actionparam value="#{smokeType.value}" name="smokeType"/>
					<a4j:actionparam value="#{smokeType.label}" name="smokeTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	</tbody>
</table>

</ui:composition>
</jsp:root>

