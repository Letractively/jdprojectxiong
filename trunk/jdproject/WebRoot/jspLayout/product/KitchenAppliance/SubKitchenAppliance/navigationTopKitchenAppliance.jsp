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
			<h:outputLabel value="品牌:" styleClass="current-selected_label"></h:outputLabel><h:outputLabel id="brandLabel" styleClass="current-selected" value="#{listKitchenApplianceProduct.brandLabel}"></h:outputLabel>
		</td>
			
				<td class="selected-new" width="86%">
					<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
					<a4j:commandLink action="#{navigationKitchenAppliance.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" limitToList="true" reRender="productList,brandLabel,secondCategoryLabel">
						<span class="top-product-navigation-option">
							#{brand.label}
						</span>
						<a4j:actionparam value="#{brand.value}" name="brandCode"/>
						<a4j:actionparam value="#{brand.label}" name="brandLabel"/>
					</a4j:commandLink>
					</a4j:repeat>
				</td> 
			
	</tr>

<tr>
			<td style="PADDING-LEFT: 8px;width:15%;text-align:left;">
				<h:outputLabel value="类别:" styleClass="current-selected_label"></h:outputLabel><h:outputText id="secondCategoryLabel" styleClass="current-selected" value="#{listKitchenApplianceProduct.secondCategoryLabel}"></h:outputText>
			</td>
			<td class="selected-new" width="90%">
				<a4j:repeat var="secondCategory" rowKeyVar="index" value="#{secondCategorys}">
				<a4j:commandLink action="#{navigationKitchenAppliance.clickLink}" ajaxSingle="true" style="CURSOR: pointer;" immediate="true" oncomplete="showText(this)" limitToList="true" reRender="productList,brandLabel,secondCategoryLabel">
					
					
					<h:outputText styleClass="top-product-navigation-option" value="#{secondCategory.label}"></h:outputText>
					<a4j:actionparam value="#{secondCategory.idSecond}" name="secondCategoryCode"/>
					<a4j:actionparam value="#{secondCategory.name}" name="model"/>
					<a4j:actionparam value="#{secondCategory.label}" name="secondCategoryLabel"/>
				</a4j:commandLink>
				</a4j:repeat>
				<script>
					function showText(object){
						object.style.background="#FFFFCC";
					}
					</script>
			</td> 
		</tr>

	
	

</ui:composition>
</jsp:root>

