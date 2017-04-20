import java.util.*;
import java.io.*;
public class MyLinkedList implements Iterable<Integer>{

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }

    public class MyLinkedListIterator implements Iterator<Integer>{
	MyLinkedList L;
	LNode a;

	public MyLinkedListIterator(MyLinkedList x){
	    L = x;
	    a = x.head;
	}

	public boolean hasNext(){
	    return !(a == null);
	}

	public Integer next(){
	    if(hasNext()){
		int x = a.value;
		a = a.next;
		return x;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }


    
    public LNode head, tail;
    private int size;

    public MyLinkedList(){
	head = null;
	tail = null;
	size = 0;
    }

    public boolean add(int value){
	add(size, value);
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	LNode a = head;
	String res = "[";
	while(a != null){
	res += a.value;
	if(a.next != null){
	    res += ",";
	}
	a = a.next;
	} 
	return res + "]";
    }

    public int get(int index){
	if(index < size && index >= 0){
	    return getNthNode(index).value;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public int set(int index, int value){
	if(index < size && index >= 0){
	    LNode a = getNthNode(index);
	    int old = a.value;
	    a.value = value;
	    return old;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public int indexOf(int val){
	LNode a = head;
	int index = -1;
	int lookingFor = a.value;
	for(int x = 0; x < size; x++){
	if(lookingFor == val){
	    return x;
	}
	}
	return index;
    }

    public void add(int index, int value){
	if(index <= size && index >= 0){
	    if(size == 0){
		head = new LNode(value);
		tail = head;
	    }
	    else if(index == 0){
		LNode a = new LNode(value, null, head);
		head.prev = a;
		head = head.prev;
	    }
	    else if(index ==size){
		LNode a = new LNode(value, tail, null);
		tail.next = a;
		tail = tail.next;
	    }
	    else{
		LNode previous = getNthNode(index - 1);
		LNode nex = previous.next;
		previous.next = new LNode(value, previous, nex);
		nex.prev = previous.next;
	    }
	    size += 1;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public int remove(int index){
	if(index < size && index >= 0){
	    LNode a = getNthNode(index);
	    LNode previous = a.prev;
	    LNode nex = a.next;
	    if(index > 0){
		previous.next = nex;
	    }
	    else{
		head = nex;
	    }
	    if(index < size - 1){
		nex.prev = previous;
	    }
	    else{
		tail = previous;
	    }
	    size -= 1;
	    return a.value;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

	private void remove(LNode Target){
	    LNode a = Target;
	    LNode previous = Target.prev;
	    LNode nex = Target.next;

	    previous.next = nex;
	    nex.prev = previous;
	    size -= 1;
	}

	private LNode getNthNode(int n){
	    if(n < size && n >= 0){
	    LNode a = head;
	    LNode b = null;
	    int x = 0;
	    while(x < size()){
		if(x == n){
		    b = a;
		    x = size() + 1;
		}
		else{
		    a = a.next;
		}
		x++;
	    }
	    return b;
	}
	    else{
		throw new IndexOutOfBoundsException();
	    }
	}
	

	private void addAfter(LNode location, LNode toBeAdded){
	    if(location.next != null){
		toBeAdded.next = location.next;
		toBeAdded.prev = location;
		location.next = toBeAdded.next;
	    }
	    else{
		toBeAdded.next = null;
		toBeAdded.prev = location;
		location.next = toBeAdded;
		tail = toBeAdded;
	    }
	    size += 1;
	}


    
    private class LNode{
	public LNode next, prev;
	public int value;

	public LNode(){
	    next = null;
	    prev = null;
	    value = 0;
	}

	public LNode(int v){
	    next = null;
	    prev = null;
	    value = v;
	}

	public LNode(int v, LNode p, LNode n){
	    value = v;
	    next = n;
	    prev = p;
	}
	
	public String toString(){
	return value+"";
	}
    }
}


