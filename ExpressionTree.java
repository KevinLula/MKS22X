public class ExpressionTree{

    private char op;
    private double value;
    private ExpressionTree left, right;

    public ExpressionTree(double value){
	this.value = value;
	op = '~';
    }

    public ExpressionTree(char op, ExpressionTree l, ExpressionTree r){
	this.op = op;
	left = l;
	right = r;
    }

    public char getOp(){
	return op;
    }

    private double getValue(){
	return value;
    }

    private ExpressionTree getLeft(){
	return left;
    }

    private ExressionTree getRight(){
	return right;
    }

    private boolean isOp(){
	return hasChildren();
    }

    private boolean isValue(){
	return !hasChildren();
    }

    private boolean hasChildren(){
	return left != null && right != null;
    }

    public String toString(){
	if(isValue()){
	    return getValue() + "";
	}
	else{ return "(" + getLeft() + getOp() + getRight() + ")";}
    }

    public String toStringPostFix(){
	if(isValue()){
	    return getValue + "";
	}
	else{ return getLeft().toStringPostFix() + getRight().toStringPostFix() + getOp() + ""; }
    }

    public String toStringPreFix(){
	if(isValue()){
	    return getValue() + "";
	}
	else{ return getOp() + getLeft().toStringPreFix() + getRight().toStringPreFix() + "";
	}
    }

    public double evaluate(){
 
