import java.util.*;
public class MyLinkedList{

private class Node<E>{
  public E val;
  public Node<E> start, end;


  public Node(E value){
    val = value;

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


}




}
