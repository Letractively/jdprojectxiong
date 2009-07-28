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
<h:panelGrid columns="1" headerClass="header" style="width:100%">
	<f:facet name="header">
		
			<h:outputLabel value="品牌" style="width:100%;font-size: 10pt;text-align: left;"></h:outputLabel>
	</f:facet>	
	
	<a4j:repeat var="brand" rowKeyVar="index" value="#{brands}">
			<tr class="active" onmouseover="this.className='active'">
				<td class="text" width="100%">
					<a4j:commandLink style="display:block;height:20px;background-color : #f5fcff;" action="#{navigationLeft.clickLink}" ajaxSingle="true" immediate="true" limitToList="true" reRender="productList">
						<span style="display:block;padding-top:3px;text-decoration : none; font-weight:bold; color:#7D7D7D;">
							#{brand.brandName}
						</span>
						<a4j:actionparam value="#{brand.id}" name="brandId"/>
						<a4j:actionparam value="#{primaryCategory.id}" name="primaryCategoryId"/>
						<a4j:actionparam value="#{model}" name="model"/>
					</a4j:commandLink>
				</td> 
			</tr>
	</a4j:repeat>
	
</h:panelGrid>
<h:panelGrid columns="1" headerClass="header" style="width:100%">	
	<f:facet name="header">
		<h:outputText value="类别" style="width:100%;font-size: 10pt;text-align: left;"></h:outputText>
	</f:facet>
	
	<a4j:repeat var="secondCategory" rowKeyVar="index" value="#{secondCategorys}">
		<tr class="active" onmouseover="this.className='active'">
			
			<td class="text" width="100%">
				<a4j:commandLink style="display:block;height:20px;background-color : #f5fcff;" action="#{navigationLeft.clickLink}" ajaxSingle="true" immediate="true" limitToList="true" reRender="productList">
					<span style="display:block;padding-top:3px;text-decoration : none; font-weight:bold; color:#7D7D7D;">
						#{secondCategory.categoryName}
					</span>
					<a4j:actionparam value="#{secondCategory.id}" name="secondCategoryId"/>
					<a4j:actionparam value="#{primaryCategoryId}" name="primaryCategoryId"/>
					<a4j:actionparam value="#{model}" name="model"/>
				</a4j:commandLink>
			</td> 
		</tr>
	</a4j:repeat>
	
</h:panelGrid>
<h:panelGrid columns="1" headerClass="header" style="width:100%">	
	<f:facet name="header">
		<h:outputText value="价格区间" style="width:100%;font-size: 10pt;text-align: left;"></h:outputText>
	</f:facet>
	
	<a4j:repeat var="productPrice" rowKeyVar="index" value="#{prices}">
		<tr class="active" onmouseover="this.className='active'">
			
			<td class="text" width="100%">
				<a4j:commandLink style="display:block;height:20px;background-color : #f5fcff;" action="#{navigationLeft.clickLink}" ajaxSingle="true" immediate="true" limitToList="true" reRender="productList">
					<span style="display:block;padding-top:3px;text-decoration : none; font-weight:bold; color:#7D7D7D;">
						#{productPrice.descPrice}
					</span>
					<a4j:actionparam value="#{productPrice.minPrice}" name="minPrice"/>
					<a4j:actionparam value="#{productPrice.maxPrice}" name="maxPrice"/>
					<a4j:actionparam value="#{primaryCategoryId}" name="primaryCategoryId"/>
					<a4j:actionparam value="#{model}" name="model"/>
				</a4j:commandLink>
			</td> 
		</tr>
	</a4j:repeat>
	
</h:panelGrid>
</ui:composition>
</jsp:root>

