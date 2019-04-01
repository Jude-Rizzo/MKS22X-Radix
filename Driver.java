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

  }

}
