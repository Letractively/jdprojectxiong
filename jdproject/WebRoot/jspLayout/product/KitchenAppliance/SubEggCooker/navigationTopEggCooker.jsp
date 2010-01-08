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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listEggCookerProduct.brandLabel}"></h:outputLabel>
		</td>
			
		<td class="selected-new" width="86%">
			<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
				<a4j:commandLink action="#{navigationEggCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel">
					<span class="top-product-navigation-option">#{brand.label}</span>
					<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
			
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:15%;text-align:left;">
			<h:outputLabel value="价格:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="priceRangeLabel" styleClass="current-selected" value="#{listEggCookerProduct.priceRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="90%">
			<a4j:repeat var="priceRange" rowKeyVar="index" value="#{priceRangeList}">
				<a4j:commandLink action="#{navigationEggCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,priceRangeLabel">
					<span class="top-product-navigation-option">#{priceRange.description}</span>
					<a4j:actionparam value="#{priceRange.min}" name="priceRangeMin"/>
					<a4j:actionparam value="#{priceRange.max}" name="priceRangeMax"/>
					<a4j:actionparam value="#{priceRange.description}" name="priceRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:15%;text-align:left;">
			<h:outputLabel value="额定容量(个):" styleClass="current-selected_label"></h:outputLabel><h:outputText id="volumeRangeLabel" styleClass="current-selected" value="#{listEggCookerProduct.volumeRangeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="90%">
			<a4j:repeat var="volumeRange" rowKeyVar="index" value="#{volumeRangeList}">
				<a4j:commandLink action="#{navigationEggCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,volumeRangeLabel">
					<span class="top-product-navigation-option">#{volumeRange.description}</span>
					<a4j:actionparam value="#{volumeRange.min}" name="volumeRangeMin"/>
					<a4j:actionparam value="#{volumeRange.max}" name="volumeRangeMax"/>
					<a4j:actionparam value="#{volumeRange.description}" name="volumeRangeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>
	<tr>
		<td style="PADDING-LEFT: 8px;width:15%;text-align:left;">
			<h:outputLabel value="控制方式:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="timeTypeLabel" styleClass="current-selected" value="#{listEggCookerProduct.timeTypeLabel}"></h:outputText>
		</td>
		<td class="selected-new" width="90%">
			<a4j:repeat var="timeType" rowKeyVar="index" value="#{timeTypeItems}">
				<a4j:commandLink action="#{navigationEggCooker.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,timeTypeLabel">
					<span class="top-product-navigation-option">#{timeType.label}</span>
					<a4j:actionparam value="#{timeType.value}" name="timeType"/>
					<a4j:actionparam value="#{timeType.label}" name="timeTypeLabel"/>
				</a4j:commandLink>
			</a4j:repeat>
		</td> 
	</tr>

	
	

</ui:composition>
</jsp:root>

