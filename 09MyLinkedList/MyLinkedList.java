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

 //   public String toString(){
   // }

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

/*    public int indexOf(int value){
    }

    public void add(int index, int value){
    }

    public int remove(int index){
    }*/

    
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

}
