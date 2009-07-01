//var contentPath = ${facesContext.externalContext.requestContextPath};
function searchStakehoderInCreateProductBegin(){
   processSearchStakeholderMethodInCreateProduct();
}
function changeFinishInCreateProduct(data){
   if (undefined == data || data.length <2) {
	   //do nothing
   } else {
   popup = window.open("./popup/popupStakeholder.jsf",
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
