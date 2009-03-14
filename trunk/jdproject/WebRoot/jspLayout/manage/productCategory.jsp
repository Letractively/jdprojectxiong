<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view id="manageMainView">
<html>
	<head>
    <title>sdsdsdsdsd</title>
    </head>
    <body>
    	<ui:composition template="./manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="productcategoryform">
    				<rich:panel bodyClass="rich-laguna-panel-no-header" style="width:100%">
    				<rich:tabPanel valueChangeListener="#{productCategory.valueChanged}" headerSpacing="5px" immediate="false" tabClass="tabClass" activeTabClass="active_tab" width="80%" switchType="ajax" binding="#{productCategory.tabPanel}" selectedTab="#{productCategory.currentTab}" id="productcategorytabpanel" headerAlignment="left" style="width:96%">
						<f:valueChangeListener type="com.ejd.web.vo.richfaces.TabChangeListener"/>
						<rich:tab id="tabpanelone" switchType="client" ignoreDupResponses="true" disabled="#{productCategory.disabledTabName == 'new'}" name="new" label="新增" immediate="false" labelWidth="80px">
					    	<h:panelGrid id="newpanel" columns="3" rowClasses="table-odd-row,table-even-row" columnClasses="table-odd-column,table-even-column" headerClass="page-header extra-border" footerClass="table-footer" styleClass="table-background" width="96%">
									<f:facet name="header">
                						<h:outputText value="#{productCategory.newProgressString}" id="newProgress"/>
            						</f:facet>
									<h:outputLabel value="类型名称：" for="categoryName"></h:outputLabel>
									<h:inputText value="#{productCategory.newProductCategory.categoryName}" id="categoryName">
										<rich:beanValidator summary="类型有误"/>
                					</h:inputText>
                					<rich:message for="categoryName" />
                					<h:outputLabel value="类型序号：" for="serialNumber"></h:outputLabel>
									<h:inputText value="#{productCategory.newProductCategory.serialNumber}" id="serialNumber" onblur="if(/\D/.test(this.value)){alert('只能输入数字');this.select();}">
                    					<rich:beanValidator summary="序号有误"/>
                    				</h:inputText>
                					<rich:message for="serialNumber" />
                					<h:outputText value="#{productCategory.newProductCategory.categoryName}" id="categoryName2"></h:outputText>
                					<a4j:commandButton action="#{productCategory.success}" reRender="newpanel,categoryName1" value="Submit"/>
                					<h:outputText value=" "></h:outputText>
							</h:panelGrid>
					    
					    </rich:tab>
					    
					    <rich:tab id="tabpaneltwo" switchType="client" ignoreDupResponses="true" disabled="#{productCategory.disabledTabName == 'edit'}" name="edit" label="编辑" immediate="false" labelWidth="80px">
							<h:outputText value="#{productCategory.newProductCategory.categoryName}" id="categoryName1"/>
							<!--<h:outputText value="Nikon D70s" /> -->
							
			
						</rich:tab>
						
					</rich:tabPanel>
					
				<br />
			
        
        					 
        				
    					
    					
    					
        				<table bgcolor="#2f88dc" border="0" cellpadding="1" cellspacing="0" width="96%">
<tbody><tr>
   <td>
   <table bgcolor="#eff7ff" border="0" cellpadding="0" cellspacing="0" width="100%">
   <tbody><tr>
      <td class="lrp" style="border-bottom: 1px solid rgb(47, 136, 220); padding-top: 4px; padding-bottom: 4px;" colspan="2" valign="middle" height="25"><span class="skr">Get advice and learn more about Books.</span></td>      
   </tr>
   <tr bgcolor="white">
      <td class="lp" style="padding-top: 10px;" valign="top" width="50%">
      <span class="d-r"><a href="http://www.epinions.com/book-Topics-All-Buying_Guides">Book Buying Guides</a></span><br/><span class="d-r"><a href="http://www.epinions.com/book-Topics-All-Glossary">Book Glossaries</a></span><br/><span class="d-r"><a href="http://www.epinions.com/book-Topics-All-Best_by_Year">The Best Books by Year</a></span><br/>     
      </td>
      <td class="lrp" style="padding-top: 10px;" valign="top" width="50%">
      <span class="d-r"><a href="http://www.epinions.com/book-Topics-All-Background_Info">Book Background Information</a></span><br/><span class="d-r"><a href="http://www.epinions.com/book-Topics-All-Community">Book Community Advice</a></span><br/><span class="d-r"><a href="http://www.epinions.com/book-Topics-All-How_To">Book How To's</a></span><br/>     
      </td>
   </tr>
   
   
   <tr>
      <td colspan="2" bgcolor="white"><span class="rkr"></span></td>
   </tr>
   </tbody></table>
   </td>
</tr>
</tbody></table>
    				</rich:panel>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	