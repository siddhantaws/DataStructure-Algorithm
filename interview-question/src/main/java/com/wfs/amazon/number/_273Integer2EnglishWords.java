package com.wfs.amazon.number;

public class _273Integer2EnglishWords {
    private int num ;

    public _273Integer2EnglishWords(int num) {
        this.num = num;
    }

    public String numberToWords() {
        boolean bilion = num/1000000000>=1 ? true :false;
        boolean milion = num/1000000>=1 ? true : false;
        boolean thousand = num/1000>=1 ? true : false;
        boolean hundred = num/1000>=1 ? true : false;
        StringBuilder sb  =new StringBuilder();
        if(bilion)
            sb.append(getInWord(num/1000000000));sb.append("Billion ");
        if(milion)
            sb.append(getInWord(num/1000000));sb.append("Million ");
        if(thousand)
            sb.append(getInWord(num/1000000));sb.append("Thousand ");
        if(hundred)
            sb.append(getInWord(num/1000));
        return sb.toString();
    }
    private String getInWord(int num){
        StringBuilder sb =new StringBuilder();
        if(num>=1 && num<=19){
            return getWord(num);
        }else if(num>=20 && num<=99){
            sb.append(twoDigitStr(num));
            if(num%10>0)
                sb.append(getWord(num%10));
        }else {
            return threeDigit(num);
        }
        return sb.toString();
    }

    String oneDigit(int num){
        return getWord(num);
    }

    String twoDigitStr(int n){
        int num = n/10;
        switch(num){
            case 2 :
                return "twenty";
            case 3 :
                return "thirty";
            case 4 :
                return "fourty";
            case 5 :
                return "fifty";
            case 6 :
                return "sixty";
            case 7 :
                return "sevty";
            case 8 :
                return "eighty";
            case 9 :
                return "ninty";
        }
        return "";
    }

    String threeDigit(int num){
        StringBuilder sb =new StringBuilder(oneDigit(num/100));
        int twoDigit =  (num%100);
        int oneDigit =  (num%10);
        if(twoDigit>0)
            sb.append(twoDigitStr(twoDigit));
        if(oneDigit>0)
            sb.append(getWord(oneDigit));
        return sb.toString();
    }

    String getWord(int num){
        switch(num){
            case 0 :
                return "zero";
            case 1 :
                return "one";
            case 2 :
                return "two";
            case 3 :
                return "three";
            case 4 :
                return "four";
            case 5 :
                return "five";
            case 6 :
                return "six";
            case 7 :
                return "seven";
            case 8 :
                return "eight";
            case 9 :
                return "nine";
            case 10 :
                return "ten";
            case 11 :
                return "eleven";
            case 12 :
                return "theleve";
            case 13 :
                return "thirteen";
            case 14 :
                return "fourteen";
            case 15 :
                return "fifteen";
            case 16 :
                return "sixteen";
            case 17 :
                return "sevenen";
            case 18 :
                return "eighten";
            case 19 :
                return "ninten";

        }
        return "";
    }
}
