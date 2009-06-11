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
         <title>A Simple Java Server Faces Application</title>
      </head>
      <body>
         <h:form id="mainform">
            <p>
               Welcome to 
               <h:outputText value="#{bb.state}"/>!
            </p>
            <h:commandButton value="Technique 1" action="technique1"/>
            <h:commandButton value="Technique 2" action="technique2"/>
         </h:form>
      </body>      
   </f:view>
</html>
</jsp:root>