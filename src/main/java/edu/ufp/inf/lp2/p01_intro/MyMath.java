package edu.ufp.inf.lp2.p01_intro;

public class MyMath {
    public static double fact_for(int n){
        double fact =1;
        if(n==0 || n==1){
            return 1;
        }else{
            for(int i=2; i<=n; i++){
                fact *= i;
            }
        }
        return fact;
    }

    public static double pow_rec(double b, double e){
        if(e==0){
            return 1;
        }else if(e==1){
            return b;
        }
        return b* pow_rec(b, e-1);
    }
}
