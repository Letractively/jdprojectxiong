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
		<div class="pnavEx">
		<table border="0" cellpadding="0" cellspacing="0">
			<tbody>
			<tr>
			<td><form method="get" action="http://shop.ebay.com/" name="headerSearch" id="headerSearch">
				<input name="_from" value="R40" type="hidden"></input>
				<input name="_trksid" value="m38" type="hidden"></input>
				<table id="gh_miniSrhBox" class="srchBox" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td class="fc"></td>
							<td><input name="_nkw" size="15" maxlength="300" tabindex="1" id="_nkw" type="text"></input><input value="Search" tabindex="2" type="submit"></input></td>
							<td class="lc"><a id="AdvSearchId" href="http://shop.ebay.com/ebayadvsearch/" rel="nofollow" tabindex="3">Advanced Search</a></td>
						</tr>
					</tbody>
				</table>
				<input id="_naf" disabled="disabled" name="_naf" value="1" type="hidden"></input>
				</form>
			</td>
			<td>
				<table class="pnav" border="0" cellpadding="0" cellspacing="0">
				<tbody>
				<tr>
					<td id="buyitem" class="fc"><a id="Buy" href="http://hub.shop.ebay.com/">Buy</a></td>
					<td id="sellitem" class="nc"><a id="Sell" href="http://sell.ebay.com/sell">Sell</a></td>
					<td id="myebayitem" class="nc"><a id="MyEbay" href="http://my.ebay.com/ws/eBayISAPI.dll?MyEbay&amp;gbh=1" rel="nofollow">My eBay</a></td>
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
		<div class="header">
		<div class="hdrnav">
		</div>
		<a onclick="omniTrackGTnSecFeat('Header', 'SP Logo');" href="http://www.superpages.com/" title="Yellow Pages"><img src="${facesContext.externalContext.requestContextPath}/css/images/logo.jpg" class="logo" alt="Yellow Pages"></img></a>
		
		<br clear="all"></br>
		
		<div class="city">
		<div class="change_city"><h1 style="display: inline; font-size: 100%;">Yellow Pages </h1><a onclick="omniTrackHeaderLinks('Header', 'Change City');" href="javascript:toggleContent(1,%20'changecity');">Change City</a><img src="Yellow%20Pages%20%20Superpages%20Yellow%20Pages,%20Maps,%20Driving%20Directions,%20Weather_files/arrow.png"></img></div>
		</div>
		
		<br clear="all"></br>
		
		<div class="tabs">
		<ul>
		<li class="selected"><a href="http://www.superpages.com/"><span>Businesses</span></a></li><li><script type="text/javascript">displayResLink();</script><a onclick="omniTrackHeaderTabs('People');" href="http://find.person.superpages.com/" rel="nofollow"><span>People</span></a></li><li><script type="text/javascript">displayMapLink();</script><a onclick="omniTrackHeaderTabs('Map');" href="http://yellowpages.superpages.com/mapbasedsearch/mapsearch.jsp?L=" rel="nofollow"><span>Maps</span></a></li><li><a onclick="omniTrackHeaderTabs('Cars');" href="http://cars.superpages.com/#sptab" rel="nofollow"><span>Cars</span></a></li>
		</ul>
		</div>
		
		<div class="form_bar">
		<form action="http://yellowpages.superpages.com/listings.jsp" method="get" id="h_ypform" name="ypform" onsubmit="checkSTYPE(this); if (verifySimple(this)) {omniTrackHeaderSearch();} else {return false;}">
		<input name="CS" value="L" class="hidden" type="hidden"></input><input name="MCBP" value="true" class="hidden" type="hidden"></input><input name="search" value="Find It" class="hidden" type="hidden"></input><input name="SRC" value="" class="hidden" type="hidden"></input><input name="STYPE" value="S" class="hidden" type="hidden"></input>
		<span>What</span>
		<input style="color: rgb(0, 0, 0);" id="what" class="sfield" name="C" size="20" onkeydown="HandleInputEvents('what');changeTxtColor('what',' ');" onfocus="changeTxtColor('where',' ');changeTxtColor('what',' ');" onclick="MM_setTextOfTextfield('what','','');changeTxtColor('what',' ');" type="text"></input>
		<span>Where</span>
		<input style="color: rgb(0, 0, 0);" id="where" class="sfield" name="L" size="20" onkeydown="HandleInputEvents('where');changeTxtColor('where',' ');" onclick="MM_setTextOfTextfield('where','','');changeTxtColor('where',' ');" type="text"></input>
		<input src="Yellow%20Pages%20%20Superpages%20Yellow%20Pages,%20Maps,%20Driving%20Directions,%20Weather_files/search_btn.gif" alt="Search" class="button" type="image"></input>
		</form>  
		</div>
		</div>
	</a4j:region>					
</h:form>
</f:subview>		
</jsp:root>	