var contentPath = "http://localhost:8080/jdproject";
function searchStakehoderInCreateProductBegin(){
   processSearchStakeholderMethodInCreateProduct();
}
function changeFinishInCreateProduct(data){
   if (undefined == data || data.length <2) {
	   //do nothing
   } else {
   popup = window.open(contentPath+"/popup/popupStakeholder.jsf",
           "popup", 
           "height=520,width=500,toolbar=no,menubar=no,"
           + "scrollbars=no");               
        //popup.openerFormId = source.form.id;
   popup.focus();
   }
}   
function reFreshStakeholderInCreateProduct(){
	processFreshStakeholerInCreateProduct();
}

function isDoubleValidate(s){
	var patrn=/^[0-9]+(.[0-9]{1,2})?$/; 
	if (!patrn.exec(s)) {
		return false;
	}
	return true;

}
function processFreshShoppingCartInfoBegin() {
	processFreshShoppingCartInfo();
}
function selecteCurrConsignee() {
	selecteCurrConsigneeFunction();
}
