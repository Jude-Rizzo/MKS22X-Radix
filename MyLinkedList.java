import java.util.*;
public class MyLinkedList<E>{
private int size;
private Node<E> start, end;

public class Node<E>{
  public E val;
  public Node<E> start, end;


  public Node(E value){
    val = value;

  }

  @SuppressWarnings("unchecked")
  public Node(){
    val = null;
  }

  public void setNext(Node<E> yurd){
    end = yurd;
  }

  public void setPrev(Node<E> yeet){
    start = yeet;
  }

  public String toString(){
    return val.toString();
  }


  public E value(){
    return val;
  }


}

public MyLinkedList(){
 size = 0;

}

public int size(){
  if(this == null) return -1;
  return size;
}

public void addFront(Node<E> leon){
  if(size == 0) {
    start = leon;
    end = leon;
    size++;
    return;
  }
  start.setPrev(leon);
  leon.setNext(start);
  start = leon;
  size ++;
}

public void addBack(Node<E> leon){
  if(size == 0) {
    start = leon;
    end = leon;
    size++;
    return;
  }
  end.setNext(leon);
  leon.setPrev(start);
  end = leon;
  size +=1;

}


public E removeFront(){
  if(size == 0) { return null;}
  (start.end).setPrev(null);
  Node<E> val = start;
  start = start.end;
  size --;
  return val.value();

  }

  @SuppressWarnings("unchecked")
  public void clear(){
     start = new Node();
     end = new Node();
     size = 0;
   }


  public E removeBack(){
    if(size == 0) return null;

    if(end.start != null)(end.start).setNext(null);
    Node<E> val = end;
    end = end.start;
    size--;
    System.out.println(val);
    return val.value();

    }

    @SuppressWarnings("unchecked")
    public void addFront(E leon){
      Node n = new Node(leon);
      addFront(n);
    }

    @SuppressWarnings("unchecked")
    public void addBack(E leon){
      Node n = new Node(leon);
      addBack(n);
    }



    public String toString(){
      String ans = "[";
      if(size == 0) return "[]";
      Node<E> n = start;
      while(n != this.end){
        ans += n.toString();
        n = n.end;
      }

      ans += this.end + "]";
      return ans;
    }


    public void extend(MyLinkedList<E> other){
    if (length == 0){
      start = other.start;
      end = other.end;
    }
    else if (other.length > 0){
      end.setNext(other.start);
      end = other.end;
    }
    other.start = null;
    other.end = null;
    length += other.length;
    other.length = 0;
  }




    public static void main(String[] args){
      //start with empty linked MyLinkedList
      MyLinkedList<Integer> leon = new MyLinkedList<Integer>();
      System.out.println(leon.toString());

      for(int i = 0; i < 3; i++){
        leon.addBack(i);
      }
      System.out.println(leon.toString());

    }

}
