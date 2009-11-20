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
		<td style="width:10%;text-align:right;">
			<h:outputLabel value="品牌:"></h:outputLabel>
		</td>
			
				<td class="selected-new" width="90%">
					<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
					<a4j:commandLink action="#{navigationKitchenAppliance.clickLink}" ajaxSingle="true" immediate="true" limitToList="true" reRender="productList">
						<span class="selected-new-span">
							#{brand.label}
						</span>
						<a4j:actionparam value="#{brand.value}" name="brandCode"/>
					</a4j:commandLink>
					</a4j:repeat>
				</td> 
			
	</tr>

<tr>
			<td style="width:10%;text-align:right;">
				<h:outputText value="类别:"></h:outputText>
			</td>
			<td class="selected-new" width="90%">
				<a4j:repeat var="secondCategory" rowKeyVar="index" value="#{secondCategorys}">
				<a4j:commandLink action="#{navigationKitchenAppliance.clickLink}" ajaxSingle="true" immediate="true" limitToList="true" reRender="productList">
					<span class="selected-new-span">
						#{secondCategory.label}
					</span>
					<a4j:actionparam value="#{secondCategory.idSecond}" name="secondCategoryCode"/>
					<a4j:actionparam value="#{secondCategory.name}" name="model"/>
				</a4j:commandLink>
				</a4j:repeat>
			</td> 
		</tr>

	
	

</ui:composition>
</jsp:root>

