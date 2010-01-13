<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="headerBackView">
<h:form id="mainheaderform">
<a4j:region id="mainheaderFormRegion" renderRegionOnly="false" selfRendered="true">
				<rich:panel headerClass="panel-header-none-border" bodyClass="panel-documents-none-border">
					<h:panelGrid id="headeronenav" columns="10" columnClasses="panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column">
							<h:outputLink value="www.sohu.com"><h:outputLabel value="eee"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="fff"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="ggg"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="hhh"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="购物车"/></h:outputLink>
							<h:outputLink value="${facesContext.externalContext.requestContextPath}/jspLayout/help/mainHelp.jsf" target="_blank"><h:outputLabel value="帮助中心"/><a4j:support event="onclick" immediate="true"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="登陆"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="注册"/></h:outputLink>
					</h:panelGrid>
					
				</rich:panel>
</a4j:region>
</h:form>
<h:form id="mainheaderotherform">
<DIV class="menu-bar rr" id="navBar">
<DIV class="navigation-wrapper">
<DIV class="navigation clearfix">
<DIV id="logo">
<H1><h:commandLink><h:graphicImage url="/css/images/logo.png" style="width:122;height:35;border: 0px solid #ffffff;"></h:graphicImage></h:commandLink></H1></DIV>
<DIV class="nav-body clearfix">
<DIV class="nav-main">
<DIV class="menu">
<DIV class="menu-title"><A 
href="http://www.renren.com/Home.do?id=739836807"><SPAN>首页</SPAN></A></DIV></DIV>
<DIV class="menu" style="MARGIN: 0px">
<DIV class="menu-title"><A 
href="http://renren.com/profile.do?id=739836807">个人主页</A></DIV></DIV>
<DIV class="menu info-edit">
<DIV class="menu-title"><A 
href="http://i.renren.com/shop/view/home.action?wc=10000">装扮</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title"><A 
href="http://friend.renren.com/myfriendlistx.do">好友</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title with-arrow"><A id="showAppMenu" 
href="http://app.renren.com/app/apps/list?origin=119">应用</A> </DIV></DIV>
<DIV class="menu">
<DIV class="menu-title"><A href="http://game.renren.com/">游戏</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title"><A id="global_inbox_link" 
href="http://msg.renren.com/">站内信</A> </DIV></DIV></DIV>
<DIV class="nav-other">
<DIV class="menu">
<DIV class="menu-title"><A 
href="http://i.renren.com/pay/upgrade?wc=10000">升级VIP</A> </DIV></DIV>
<DIV class="menu">
<DIV class="charge menu-title"><A 
href="http://pay.renren.com/">充值</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title"><A 
href="http://invite.renren.com/Invite.do">邀请</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title" id="optionMenuActive"><A onMouseOver="" 
href="http://renren.com/profile.do?id=739836807&amp;v=info&amp;act=edit">设置</A></DIV></DIV>
<DIV class="menu last">
<DIV class="menu-title"><A 
href="http://www.renren.com/Logout.do?get_check=1714286847">退出</A></DIV></DIV>
<DIV id="navSearch">
<FORM id="globalSearchForm" action="http://browse.renren.com/searchEx.do?from=opensearch" method="post">
<DIV id="search-input"><INPUT class="input-text" id="navSearchInput" tabIndex="1" maxLength="100" size="25" name="q"></INPUT> </DIV>
<DIV id="search-submit"><A class="submit" id="navSearchSubmit" href="http://browse.renren.com/os.do?_lu=9">搜索</A> 
<SPAN class="separator"></SPAN><A class="more" id="searchMenuAction"
href="http://renren.com/profile.do?id=739836807&amp;_hua=64#nogo"></A></DIV></FORM></DIV></DIV></DIV></DIV></DIV></DIV>
</h:form>
</f:subview>		
</jsp:root>	