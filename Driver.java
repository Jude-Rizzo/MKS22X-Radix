import java.util.*;
public class Driver{
  //test MyLinkedList
  public static void main(String[] args){
    //start with empty linked MyLinkedList
    MyLinkedList<Integer> leon = new MyLinkedList<Integer>();
    System.out.println(leon.toString());

    for(int i = 0; i < 10; i++){
      leon.addBack(i);
    }
    System.out.println(leon.toString());

    for(int i = 0; i < 5; i++){
      System.out.println(leon.removeFront());

    }
    System.out.println(leon.toString());



  MyLinkedList<Integer> h = new MyLinkedList<Integer>();
  for(int i = 0; i < 5; i++){
    h.addFront(i);
  }
  h.removeBack();
  System.out.println(h);
  leon.extend(h);
  System.out.println(leon);



}
}
