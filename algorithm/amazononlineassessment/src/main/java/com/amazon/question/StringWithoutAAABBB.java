/*
package com.amazon.question;

public class StringWithoutAAABBB {
    private int A ;
    private int B ;


    public String strWithout3a3b(int A, int B) {
        StringBuffer sb =new StringBuffer();
        boolean isPossible = A>B  ?  ((2*B)+2 >=A ? true:false  ) : (2*A)+2 >=B ? true:false ;
        if(!isPossible){
            sb.append("-1");
            return sb.toString();
        }
        if(A>=B)
            return    strWithout3a3b(new Object[]{"A",A} , new Object[]{"B",B} , sb);
        else
            return    strWithout3a3b(new Object[]{"B",B} , new Object[]{"A",A} , sb);

    }

    public String strWithout3a3b(Object[] o1 , Object[] o2, StringBuffer sb){
        if((2*(int)o2[1]+2)==(int)o1[1]){
            while((int)o2[1]>0 || (int)o1[1]>0){
                sb.append(o1[0]+o1[0]+o2[0]);
                ((int)o1[1]) -=2;
                ((int)o2[1])     -=1;
            }
        }else{
            while(o2[1]>0 || o1[1]>0){
                if(o1[1]>1){
                    sb.append(o1[0]+o1[0]);
                    o1[1] -=2;
                }
                if(o2[1]>0){
                    sb.append(o2[0]);
                    o1[1] -=1;
                }

            }
        }
        return sb.toString();
    }
}
*/
