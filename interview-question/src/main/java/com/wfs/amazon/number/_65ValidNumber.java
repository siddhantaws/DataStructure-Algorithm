package com.wfs.amazon.number;

public class _65ValidNumber {

    private String number;

    public _65ValidNumber(String number) {
        this.number = number;
    }

    public boolean isNumber() {
        int l=0;int r=number.length()-1;
        while(l< toString().length() && number.charAt(l)==' ')
            l++;
        while(r>=0 && number.charAt(r)==' ')
            r--;
        if(l>r)
            return false;
        boolean dotFound =false;boolean eFound =false;
        boolean signFound =false;boolean numberFound =false;
        while(l<r){
            if(number.charAt(l)>='0' && number.charAt(l)<='9')
                numberFound = true;
            else if(number.charAt(l)=='e'){
                if(eFound) return false;
                eFound  = true;numberFound =false;
            }else if(number.charAt(l)=='.'){
                if(dotFound || eFound) return false;
                dotFound=true; numberFound=true;
            }else if((number.charAt(l)=='+' || number.charAt(l)=='-') && l>0 && number.charAt(l-1)==' ' ){
                return false;
            }else{
                return false;
            }
            l++;
        }
        return ((dotFound || eFound ) && !numberFound ) ? false : true;
    }


}
