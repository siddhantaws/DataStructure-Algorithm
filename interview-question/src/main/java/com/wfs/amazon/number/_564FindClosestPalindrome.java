//package com.wfs.amazon.number;
//
//public class _564FindClosestPalindrome {
//
//    private String number;
//
//    private Character [] characterArray;
//
//    public _564FindClosestPalindrome(String number) {
//        this.number = number;
//        this.characterArray =new Character[number.length()];
//        System.arraycopy(number.toCharArray(),0,characterArray,0,characterArray.length);
//    }
//
//    public String nearestPalindromic(String n) {
//        String prevPalimdrom =getPrevPalimdorm(n);
//    }
//
//    private String getPrevPalimdorm(String s){
//        if(s.length()%2==0){
//
//        }else{
//            int l =s.length()/2-1;
//            int r =s.length()/2+1;
//            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
//                l--;r++;
//            }
//            if(l<0 && r>s.length()){
//                int i =Character.getNumericValue(characterArray[characterArray.length/2]);
//                if(i==0){
//                    l =s.length()/2-1;
//                    r =s.length()/2+1;
//                    while(l>=0 && r<s.length() && (int)s.charAt(l)<1))
//                        l--;
//                    if
//
//                }else{
//                    characterArray[characterArray.length/2] =(char)(i-1);
//                    return characterArray.toString();
//                }
//            }
//        }
//    }
//}
