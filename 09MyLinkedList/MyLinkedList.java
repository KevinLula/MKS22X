public class MyLinkedList{
    public LNode head, tail;
    private int size;

    public MyLinkedList(){
	head = null;
	tail = null;
	size = 0;
    }

    public boolean add(int value){
	if(size == 0){
	head = new LNode(value);
	tail = head;
	}
	else{
	LNode a = new LNode(value);
	head.next = a;
	a.prev = head;
	tail = a;
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	int x = 0;
	LNode a = head;
	String res = "";
	while(x < size){
	res += a.value;
	a = a.next;
	x++;
	} 
	return res;
    }

    public int get(int index){
	LNode a = head;
	int res = a.value;
	for(int x = 0; x < index; x++){
	a = a.next;
	}
	return res;
    }

    public int set(int index, int value){
	LNode a = head;
	int res = value;
	int old = 0;
	for(int x = 0; x < index; x++){
	a = a.next;
	}
	old = a.value;
	a.value = res;
	return old;
    }

    public int indexOf(int val){
	LNode a = head;
	int index = -1;
	int lookingFor = a.value;
	for(int x = 0; x < size; x++){
	if(lookingFor == val){
	index = x;
	break;
	// Or make x = size after index = x if dont want to use break
	}
	}
	return index;
    }

    public void add(int index, int value){
	LNode a = new LNode(value);
	LNode b = head;
	int in = 0;
	while(in < index){
	b = b.next;
	in++;
	}
	a.next = b.next;
	b.next.prev = a;
	b.next = a;
	a.prev = b;
    }

    public int remove(int index){
	LNode a = head;
	int in = 0;
	int res = 0;
	while(in < index){
	a = a.next;
	in++;
	}
	res = a.value;
	a.prev.next = a.next;
	a.next.prev = a.prev;
	return res;
    }

	private void remove(LNode Target){
	}

	private LNode getNthNode(int n){
	}

	private void addAfter(LNode location, LNode toBeAdded){
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
	
	public String toString(){
	return value+"";
	}
    }

	public static void main(String [] args){
	MyLinkedList a = new MyLinkedList();
	a.add(0);
	a.add(1);
	a.add(2);
	System.out.println(a.toString());
	}
}


