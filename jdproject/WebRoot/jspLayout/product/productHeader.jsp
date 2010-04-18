<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich"
xmlns:c="http://java.sun.com/jstl/core">
<script>
	function showmessage() {
		alert("message");
	}
</script>
<f:subview id="productHeaderMainView">
<h:form id="productHeaderMainform"> 
	<a4j:region id="productHeaderRegion" renderRegionOnly="false" selfRendered="true">
		<a4j:jsFunction name="processFreshShoppingCartInfo" ajaxSingle="true" limitToList="true" reRender="pgshoppingcart">
   		</a4j:jsFunction>
		<div id="navigation"><span class="ebay">
		<div id="gnheader" class="gbhdr">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
			<tr>
				<td>
				<div style="display: none;" id="playground"></div>
				<div id="cobrandHeader"></div>
				<div id="dynamicmenu-hdrCtr" class="hdrCtr">
					<table class="logobar" border="0" cellpadding="0" cellspacing="0" width="100%">
						<tbody>
						<tr>
						<td class="logoimg" width="1%" valign="bottom"><a href="http://www.ebay.com/" rel="nofollow"><img src="${facesContext.externalContext.requestContextPath}/css/images/icons/logo.gif" alt="From collectibles to cars, buy and sell all kinds of items on eBay" border="0" width="110" height="45"></img></a></td>
						<td class="mr" width="2%" valign="bottom"><span class="greeting"><a4j:outputPanel rendered="#{null == currentUser.userInfo}">欢迎光临! 请<a href="${facesContext.externalContext.requestContextPath}/jspLayout/common/customerLogin.jsf" tabindex="-1" rel="nofollow">登录</a> 或 <a href="${facesContext.externalContext.requestContextPath}/jspLayout/common/customerRegister.jsf" tabindex="-1" id="registerLink" rel="nofollow">注册</a>.<!-- END: GREETING:SIGNEDOUT --></a4j:outputPanel><a4j:outputPanel rendered="#{null != currentUser.userInfo}">亲爱的#{currentUser.userInfo.shortName} 欢迎您回来![<h:commandLink id="longOutLink" action="#{currentUser.loginOutAction}" value="安全退出" style="color:#f26522;font-size:12px;font-weight:bold;"></h:commandLink>]</a4j:outputPanel><span id="bta"></span></span></td>
						<td id="rbt" valign="bottom"><span class="coupon"></span></td>
						<td align="right" valign="bottom"><div class="addllinks"><a href="http://pages.ebay.com/sitemap.html">收藏本站</a></div></td>
						</tr>
						</tbody>
					</table>
					<div class="header-navigation-panel">
					<h:panelGrid columns="5" cellpadding="0" cellspacing="0" styleClass="header-navigation-panel-grid" columnClasses="header-navigation-panel-grid-column-two,header-navigation-panel-grid-column-three,header-navigation-panel-grid-column-four,header-navigation-panel-grid-column-five">
						<h:panelGroup>
							<rich:dropDownMenu value="所有分类 " submitMode="ajax" direction="bottom-right"  jointPoint="td" event="onmouseover" showDelay="10">
                			<rich:menuGroup value="#{headerTabPanel.kitchenAppliance.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.kitchenAppliance.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="kitchenApplianceMainMenuName" value="#{headerTabPanel.kitchenAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.householdAppliance.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.householdAppliance.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="householdApplianceMainMenuName" value="#{headerTabPanel.householdAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
               				<rich:menuGroup value="#{headerTabPanel.personalCare.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.personalCare.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="personalCareMainMenuName" value="#{headerTabPanel.personalCare.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.healthDevice.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.healthDevice.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="healthDeviceMainMenuName" value="#{headerTabPanel.healthDevice.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.majorAppliance.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.majorAppliance.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="majorApplianceMainMenuName" value="#{headerTabPanel.majorAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.phoneDigital.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.phoneDigital.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="phoneDigitalMainMenuName" value="#{headerTabPanel.phoneDigital.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.computerNetwork.mainMenu.label}" direction="bottom-right">
                    			
                    			<c:forEach items="#{headerTabPanel.computerNetwork.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="ajax">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="computerNetworkMainMenuName" value="#{headerTabPanel.computerNetwork.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			</rich:dropDownMenu>
						</h:panelGroup>
						<h:panelGroup id="twothree">
							<h:outputLabel value="ID:"></h:outputLabel>
							<h:inputText styleClass="search-input" value=""></h:inputText>
							<h:commandButton styleClass="search-submit" value="搜索"></h:commandButton>
						</h:panelGroup>
					    <a4j:outputPanel id="pgshoppingcart">
					    	<h:commandLink action="shoppingCart"><h:outputLabel value="购物车中有"/><h:outputLabel value="#{shopCart.cart.inventoryQuantityTotal}"></h:outputLabel><h:outputLabel value="件商品,合计金额:"/><h:outputLabel value="#{shopCart.cart.inventoryPriceTotal}"></h:outputLabel></h:commandLink><h:outputLink value=""><h:outputLabel value="去结算>"/></h:outputLink>
					    	<rich:toolTip followMouse="true" direction="top-right" showDelay="50" styleClass="tooltip" onmouseover="processFreshShoppingCartInfoBegin();return false;">
					    			<h:outputLabel id="inventoryQuantityTotalIntt" value="#{shopCart.cart.inventoryQuantityTotal}"/>
					    			<h:outputLabel id="inventoryPriceTotalIntt" value="#{shopCart.cart.inventoryPriceTotal}"/>
					    	</rich:toolTip>
					    </a4j:outputPanel>
					    <h:panelGroup></h:panelGroup>
						</h:panelGrid>
					</div>
					<div class="snav">
						<div class="snavE">
							<div class="snavW" id="dynamicmenu-snavW">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tbody>
										<tr>
											<td class="snav" width="1%">
												<h:panelGrid columns="100" border="0" cellpadding="0" cellspacing="0" styleClass="" columnClasses="fc,nc">
													<h:outputLink><h:outputText value="首页"/></h:outputLink>
													<h:outputLink><h:outputText value="首页"/></h:outputLink>
													<h:outputLink><h:outputText value="首页"/></h:outputLink>
													<h:outputLink><h:outputText value="首页"/></h:outputLink>
													<h:outputLink><h:outputText value="首页"/></h:outputLink>
													<h:outputLink><h:outputText value="首页"/></h:outputLink>	
												</h:panelGrid>
											</td>
											<td class="poweredBy" width="1%">
												<div style="height: 0px; display: none;" id="rtm_html_876"></div>
											</td>
											<td class="poweredBy" width="100%">
												<div style="height: 0px; display: none;" id="rtm_html_912"></div>
											</td>
                            				<td class="poweredBy" align="right" width="1%"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
		
					<div class="pnavEx">
						<table border="0" cellpadding="0" cellspacing="0">
						<tbody>
						<tr>
						<td><form method="get" action="http://shop.ebay.com/" name="headerSearch" id="headerSearch">
						<input name="_from" value="R40" type="hidden"></input><input name="_trksid" value="m38" type="hidden"></input>
						<table id="gh_miniSrhBox" class="srchBox" border="0" cellpadding="0" cellspacing="0">
						<tbody>
						<tr>
						<td class="fc"></td>
						<td><input name="_nkw" size="15" maxlength="300" tabindex="1" id="_nkw" type="text"></input><input value="Search" tabindex="2" type="submit"></input></td>
						<td class="lc"><a id="AdvSearchId" href="http://shop.ebay.com/ebayadvsearch/" rel="nofollow" tabindex="3">Advanced Search</a></td>
						</tr>
						</tbody>
						</table>
						<input id="_naf" disabled="disabled" name="_naf" value="1" type="hidden"></input></form>
						</td>
						<td>
							<table class="pnav" border="0" cellpadding="0" cellspacing="0">
							<tbody>
							<tr>
							<td id="buyitem" class="fc"><a class="" id="Buy" href="http://hub.shop.ebay.com/">Buy</a></td>
							<td id="sellitem" class="nc"><a class="" id="Sell" href="http://sell.ebay.com/sell">Sell</a></td>
							<td id="mycenteritem" class="nc"><a class="" id="ManageCenter" href="${facesContext.externalContext.requestContextPath}/jspLayout/customer/mainCustomer.jsf" rel="nofollow">管理中心</a></td>
							<td id="communityitem" class="nc"><a id="Community" href="http://hub.ebay.com/community">Community</a></td>
							<td id="helpitem" class="lc"><a id="Help" href="${facesContext.externalContext.requestContextPath}/jspLayout/help/mainHelp.jsf">帮助中心</a></td>
							</tr>
							</tbody>
							</table>
						</td>
						<td><div></div></td>
						</tr>
						</tbody>
						</table>
					</div>
				</div>
			<div style="visibility: hidden; position: absolute;" id="Community-menu" class="dynmenu"></div>
			<div style="visibility: hidden; position: absolute;" id="Help-menu" class="dynmenu"></div>
			<div></div>
			<div style="display: none;" id="dynMenuCtr">
			<table border="0" cellpadding="0" cellspacing="0">
			<tbody>
			<tr>
				<td class="dynmenubrdr">aaaaaa</td>
			</tr>
			<tr>
				<td>
					<div class="crnrlc"><div class="crnrnc"><div class="crnrfc"></div></div></div>
				</td>
			</tr>
			</tbody>
			</table>
			</div>
			</td>
		</tr>
		</tbody>
	</table>
	</div>
	</span>
	</div>
	</a4j:region>					
</h:form>
</f:subview>		
</jsp:root>	