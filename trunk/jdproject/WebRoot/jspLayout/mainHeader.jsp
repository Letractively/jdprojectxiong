<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="mainHeaderSubView">
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/divstyle.css"/>
<div class="header">
<div class="headerwarp">
<h1 class="logo"><a href="index.php"><img src="${facesContext.externalContext.requestContextPath}/css/images/icons/logo.gif?" alt="5G/五季网络" /></a></h1>
<ul class="menu">
<li><a href="${facesContext.externalContext.requestContextPath}/index.jsf"><span class="menu_a">首页</span></a></li>
<li><h:outputLink><h:outputText value="商品浏览" styleClass="menu_a"/></h:outputLink></li>
<li><h:outputLink value="${facesContext.externalContext.requestContextPath}/jspLayout/help/mainHelp.jsf"><h:outputText value="帮助中心" styleClass="menu_a"/></h:outputLink></li>
<li><h:outputLink><h:outputText value="询问" styleClass="menu_a"/></h:outputLink></li>
</ul>

<div class="nav_account">
<a href="do.php?ac=3c7495bde72b124b806ed64fb89785db" class="login_thumb"><img 
height="20" src="${facesContext.externalContext.requestContextPath}/css/images/icons/noavatar_small.gif" width="20"/></a>
欢迎您<br/>
<a href="do.php?ac=71ee30ae117cddace55bd01714904227">登录</a> | 
<a href="do.php?ac=3c7495bde72b124b806ed64fb89785db">注册</a>
</div>
</div>
</div>

</f:subview>
</jsp:root>