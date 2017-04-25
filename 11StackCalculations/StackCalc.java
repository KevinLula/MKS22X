import java.util.*;
public class StackCalc{

    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for(int x = 0; x < tokens.length; x++){
	    if(isOp(tokens[x])){
		values.push(apply(tokens[x],values.pop(),values.pop()));}
	    else{
		values.push(Double.parseDouble(tokens[x]));}
	}
	return values.pop();
    }
    
    private static double apply(String op, Double b, Double a){
	if (op.equals("+")){
	    return a + b;}
	if (op.equals("-")){
	    return a - b;}
	if(op.equals("*")){
	    return a * b;}
	if(op.equals("/")){
	    return a / b;}
	if(op.equals("%")){
	    return a % b;}
	else{
	    throw new IllegalArgumentException();}
    }

    private static boolean isOp(String op){
	return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%"));
    }
}
