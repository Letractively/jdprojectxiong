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
<f:subview id="productHeaderMainView">
<h:form id="productHeaderMainform"> 
	<a4j:region id="productHeaderRegion" renderRegionOnly="false" selfRendered="true">
		<div id="GlobalNavigation"><span class="ebay">
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
						<td class="logoimg" width="1%" valign="bottom"><a href="http://www.ebay.com/" rel="nofollow"><img src="i_files/logoEbay_x45.gif" alt="From collectibles to cars, buy and sell all kinds of items on eBay" border="0" width="110" height="45"></img></a></td>
						<td class="mr" width="2%" valign="bottom"><span class="greeting"><!-- BEGIN: GREETING:SIGNEDOUT -->Welcome! <a href="https://signin.ebay.com/ws/eBayISAPI.dll?SignIn" tabindex="-1" rel="nofollow" onclick="return vjo.darwin.core.greetings.VjGreetingsServer.handleClick('https://signin.ebay.com/ws/eBayISAPI.dll?SignIn',event);">Sign in</a> or <a href="https://scgi.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo" tabindex="-1" id="registerLink" rel="nofollow">register</a>.<!-- END: GREETING:SIGNEDOUT --><span id="bta"></span></span></td>
						<td id="rbt" valign="bottom"><span class="coupon"></span></td>
						<td align="right" valign="bottom"><div class="addllinks"><a href="http://pages.ebay.com/sitemap.html">Site Map</a></div></td>
						</tr>
						</tbody>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tbody>
						<tr>
						<td class="brnd1"></td>
						</tr>
						</tbody>
					</table>
					

					<div class="snav">
						<div class="snavE">
							<div class="snavW" id="dynamicmenu-snavW">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tbody>
										<tr>
											<td class="snav" width="1%">
												<table border="0" cellpadding="0" cellspacing="0">
													<tbody>
														<tr>
															<td id="browsecategoriesitem" class="fc"><a class="" id="BrowseCategories" href="http://shop.ebay.com/allcategories/all-categories">首页</a></td>
															<td id="ebaymotorsitem" class="nc"><a title="Buy and sell cars, trucks, vehicle parts, and accessories." href="http://www.motors.ebay.com/">Motors</a></td>
															<td id="ebaystoresitem" class="nc"><a title="Find more of what you love." href="http://stores.ebay.com/">Stores</a></td>
															<td id="ebaydealsitem" class="lc"><a title="Great items, deep discounts, and free shipping!" href="http://deals.ebay.com/deals">Daily Deal</a></td>
														</tr>
													</tbody>
												</table>
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
							<td id="myebayitem" class="nc"><a class="" id="MyEbay" href="http://my.ebay.com/ws/eBayISAPI.dll?MyEbay&amp;gbh=1" rel="nofollow">My eBay</a></td>
							<td id="communityitem" class="nc"><a id="Community" href="http://hub.ebay.com/community">Community</a></td>
							<td id="helpitem" class="lc"><a id="Help" href="http://pages.ebay.com/help/index.html">Help</a></td>
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
				<td class="dynmenubrdr">##1##</td>
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