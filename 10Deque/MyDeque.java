import java.util.*;
public class MyDeque{
    
    private String[] Deck;
    private int front, back, size;

    public MyDeque(){
	Deck = new String[5];
	front = 0;
	back = 0;
	size = 0;
    }

    private void resize(){
	String[] res = new String[Deck.length * 2];
	for(int x = 0; x < back + 1; x++){
	    res[x] = Deck[x];}
	for(int y = 0; y < size - back; y++){
	    res[res.length - 1 - y] = Deck[Deck.length - 1 - y];
	}
	front = front + Deck.length;
	Deck = res;
    }

   public void addFirst(String str){
	if (str == null){
	    throw new NullPointerException("Cannot add null elements");
	}
	if (size == Deck.length){
	    resize();
	}
	if (size == 0){
		Deck[front] = str;
		size += 1;
	}
        else{ if(front == 0){
		front = Deck.length - 1;
		Deck[front] = str;
		size += 1;
	    }
	    else{
		front -= 1;
		Deck[front] = str;
		size += 1;
	    }
	}
   }

    public void addLast(String str){
	if (str == null){
	    throw new NullPointerException("Cannot add null elements");
	}
	if (size == Deck.length){
	    resize();
	}
	if (size == 0){
	    Deck[back] = str;
	    size += 1;
	}
        else{
	    back += 1;
	    Deck[back] = str;
       	    size +=1;
	}
    }

    public String removeFirst(){
	String element = "";
	if(size == 0){
	    throw new NoSuchElementException("No elements found");
	}
	if(front == Deck.length - 1){
	    element = getFirst();
	    front = 0;
	    Deck[Deck.length - 1] = null;
	    size--;
	}
	else{element = getFirst();
	    Deck[front] = null;
	    front += 1;
	    size--;
	}
	return element;
    }
    
    public String removeLast(){
	String element = "";
	if(size == 0){
	    throw new NoSuchElementException("No elements found");
	}
	if(back == 0){
	    element = getLast();
	    back = Deck.length - 1;
	    Deck[0] = null;
	    size--;
	}
	else{element = getLast();
	    Deck[back] = null;
	    back -= 1;
	    size--;
	}
	return element;
    }

    public String getFirst(){
	String res = "";
	if(size == 0){
	    throw new NoSuchElementException("No elements found");
	}
	res = Deck[front];
	return res;
    }
    
    public String getLast(){
	String res = "";
	if(size == 0){
	    throw new NoSuchElementException("No elements found");
	}
	res = Deck[back];
	return res;
    }

    public int getSize(){
	return size;
    }

    public String toString(){
	String res = "[";
	for(int x = 0; x < Deck.length; x++){
	    if(x + 1 == Deck.length){
		if(Deck[x] == null){		    
		res +=  "null]";
		break;
		}
		else{
		    res += Deck[x] + "]";
		    break;
		}
	    }
	    if(Deck[x] == null){
		res += "null, ";
	    }
	    else{
	    res += Deck[x] + ", ";
	    }
	}
	return res;
    }
	
	public static void main(String[] args){
	MyDeque a = new MyDeque();
	a.addFirst("1");
	a.addFirst("2");
	a.addFirst("3");
	a.addFirst("4");
	a.addFirst("5");
       	a.addFirst("6");
	System.out.println(a.getSize());
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	System.out.println(a);
}
}


