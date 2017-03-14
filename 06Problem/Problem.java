import java.util.ArrayList;
public class Problem{

    public static ArrayList<String> combination(String s){
	ArrayList<String> words = new ArrayList<String>();
	combinationH(s, words, "", 0);
	return words;
    }
    private static void combinationH(String s, ArrayList<String> words, String a, int b){
	int num = 0;
	for(int x = 0; x < words.size(); x++){
	    if(a.equals(words.get(x))){
		num += 1;
	    }
	}
	if(num == 0){
	    words.add(a);
	}
	if(b < s.length()){
	    combinationH(s, words, a + s.charAt(b), b + 1);
	    combinationH(s, words, a, b + 1);
	}
    }

    public static void main(String[] args){
	System.out.println(combination("abc"));
    }
}
