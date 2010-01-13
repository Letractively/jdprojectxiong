function isDoubleValidate(s){
	var patrn=/^[0-9]+(.[0-9]{1,2})?$/; 
	if (!patrn.exec(s)) {
		return false;
	}
	return true;

}
