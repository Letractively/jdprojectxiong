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
    				<rich:panel bodyClass="rich-laguna-panel-no-header">
    					
        					 
        <rich:toolBar height="34" itemSeparator="line" width="96%">
            <rich:toolBarGroup>
            	<h:commandLink action="#{managePanelMenu.updateCurrent}" immediate="true">
            		<f:param name="current" value="productcategory"/>
              		<h:graphicImage id="edit" value="/css/images/edit.gif" style="border:0"/>
              	</h:commandLink>
              	<h:commandLink action="#{managePanelMenu.updateCurrent}" value="New" immediate="true">
              		<f:param name="current" value="productcategory"/>
              	</h:commandLink>
            </rich:toolBarGroup>
            <rich:toolBarGroup>                       
              <h:graphicImage id="find" value="/css/images/find.gif" />
              <h:outputLabel value="Find" for="find" />
            </rich:toolBarGroup>
            <rich:toolBarGroup>                       
              <h:graphicImage id="filter" value="/css/images/filter.gif" />
              <h:outputLabel value="Filter" for="filter" />
            </rich:toolBarGroup>
        </rich:toolBar>
        
        					 
        				
    					
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