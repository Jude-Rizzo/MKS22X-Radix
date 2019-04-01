public class MyLinkedList<E>{
   private int size;
   public Node start,end;


public MyLinkedList(){
  size = 0;
}

public int size(){
  return size;
}

public Node getStart(){
  return start;
}

public Node getEnd(){
  return end;
}

public boolean add(E value){
  if(start == null){
    start = new Node(value);
    end = start;
    size ++;
    return true;
  }
  Node x = new Node(value);
  end.setNext(x);
  end = x;
  size ++;
  return true;
}

public String toString(){
  if(size == 0){
    return "[]";
  }
  String ans = "[";
Node n = start;
while(n != end){
  ans += n;
  ans += ", ";
  n = n.next();
}
ans = ans + end + "]";
return ans;
}

private Node getnthnode(int n){
  if(n >= size || n < 0) throw new IndexOutOfBoundsException();
  int counter = 0;
  Node now = start;
  while(counter < n){
    now = now.next();
    counter ++;
  }
  return now;
}

public E get(int index){
  Node n = getnthnode(index);
  return n.getData();
}

public E set(int index, E value){
  Node n = getnthnode(index);
  return n.setData(value);
}

public boolean contains(E value){
  Node n = start;
  int counter = 0;
  while(counter < size){
    if(n.getData() == value) return true;
    n = n.next();
    counter ++;
  }
  return false;
}

public int indexOf(E value){
  Node n = start;
  int counter = 0;
  while(counter < size){
    if(n.getData() == value) return counter;
    n = n.next();
    counter ++;
  }
  return -1;
}

  public void add(int index, E value){
    if (index > size || index < 0) throw new IndexOutOfBoundsException();
    Node n = new Node();
    n.setData(value);
    if (size == 0 || index == size){
      this.add(value);
      size--;
    }
    if (index == 0 && size != 0){
      Node helper = start;
      start = n;
      start.setNext(helper);
      helper.setPrev(start);
    }
    if (index > 0 && index < size){
      Node prevNode = getnthnode(index-1);
      Node oldNode = getnthnode(index);
      prevNode.setNext(n);
      oldNode.setPrev(n);
      n.setNext(oldNode);
      n.setPrev(prevNode);
    }
    size++;
  }

  @SuppresWarnings("unchecked")
  public void extend(MyLinkedList l){
    end.setNext(l.start);
    l.start.setPrev(end);
    end = l.end;

  }

  public E remove(int index){
    if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
    if(index == 0){
      E x = start.getData();
      start = start.next();
      start.setPrev(null);
      size -= 1;
      return x;
    }
    if(index == size - 1){
      E x = end.getData();
      end = end.prev();
      end.setNext(null);
      size -= 1;
      return x;
    }
    Node n = getnthnode(index);
    E x = n.getData();
    Node prev = n.prev();
    Node next = n.next();
    prev.setNext(next);
    next.setPrev(prev);
    size -= 1;
    return x;
  }

  public boolean remove(E value){
    if(!this.contains(value)) return false;
    int i = this.indexOf(value);
    this.remove(i);
    return true;
  }


//PRIVATE CLASS
//
//
  private class Node{
    private E data;
    private Node next,prev;

    public Node(E data){
      this.data = data;
    }
    public Node(){

    }


    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }

    public void setNext(Node other){
      next = other;
    }

    public void setPrev(Node other){
      prev = other;
    }
    public E getData(){
      return data;
    }
    public E setData(E i){
      E x = data;
      data = i;
      return x;
    }
    public String toString(){
      return "" + data;
    }


}


}
