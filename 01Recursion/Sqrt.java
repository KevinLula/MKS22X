public class Sqrt{

    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("sqrt only excepts positive numbers");}
	else{return sqrtHelper(n,1.0);}
    }

    public static double sqrtHelper(double n, double guess){
	if(isCloseEnough(n, guess*guess)){
	    return guess;}
	else{return sqrtHelper(n, (n/guess + guess)/2);}
    }

    public static boolean isCloseEnough(double n, double guessSquared){
	if((n - guessSquared) >= 0){
	    return ((n - guessSquared) < (n * .000000000001));
	}
	else{return ((guessSquared - n) < (n * .000000000001));
	}
    }
}
