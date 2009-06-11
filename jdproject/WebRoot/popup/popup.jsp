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
               var formId = window.openerFormId;
               opener.document.forms[formId][formId + ":state"].value = value;
               window.close();
            }               
         </script>
         <title>Select a state/province</title>
      </head>
      <body>
         <h:form>
            <h:dataTable value="#{bb.states[param.country]}" var="state">
               <h:column>
                  <h:outputLink value="#" 
                     onclick="doSave('#{state}');">
                     <h:outputText value="#{state}" />
                  </h:outputLink>
               </h:column>
            </h:dataTable>
         </h:form>
      </body>
   </f:view>
</html>
</jsp:root>