public class MyLinkedList{
    public LNode start, end;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public boolean add(int value){
    }

    public int size(){
	return size;
    }

    public toString(){
    }

    public int get(){
    }

    public int set(){
    }

    public int indexOf(int value){
    }

    public void add(int index, int value){
    }

    public int remove(int index){
    }

    
    private class LNode{
	public LNode next;
	public int value;

	public LNode(){
	    next = null;
	    value = 0;
	}

	public LNode(int v, LNode n){
	    value = v;
	    LNode = n;
	}
    }

}
