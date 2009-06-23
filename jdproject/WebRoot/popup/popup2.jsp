<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<html>
   
   <f:view>
      <head>                  
         <script language="javascript">
            function doSave(value) {
               formId = window.openerFormId;
               opener.document.forms[formId][formId + ":state"].value = value;
               window.close();
            }               
         </script>
         <title>Select a state/province</title>
      </head>
      <body>
         <h:form>
            <h:dataTable value="#{bb.statesForCountry}" var="state">
               <h:column>
                  <a4j:commandLink value="#{state}" action="#{bb.popudbclick}"  onclick="doSave('#{state}');">
                  <f:param name="state" value="#{state}"></f:param>
                  <f:param name="viewId" value="#{bb.viewId}"></f:param>
                  <a4j:support event="ondblclick" oncomplete="javascript:window.close();"></a4j:support>
                  
                  </a4j:commandLink>
               </h:column>
            </h:dataTable>
         </h:form>
      </body>
   </f:view>
</html>
</jsp:root>