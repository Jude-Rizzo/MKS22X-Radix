import java.util.*;
public class Driver{
  //test MyLinkedList
  public static void main(String[] args){
    //start with empty linked MyLinkedList
  /*  MyLinkedList<Integer> leon = new MyLinkedList<Integer>();
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
  System.out.println(leon); */
  //now testing RadixSort

  //System.out.println(Radix.countDigits(10));
//  System.out.println(Radix.countDigits(10000002) + "should be 8");
  //System.out.println(Radix.getNthDigit(2,222));
  //System.out.println(Radix.getNthDigit(0,1111122223));

  //MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
//  System.out.println(buckets[0] == null);
//  for(int i = 0; i < 10; i++){
//    buckets[i] = new MyLinkedList<Integer>();
//  }
///  buckets[0].addFront(2);
  //System.out.println(buckets[0] + "yurd");

  int[] data = {2,4,2,4,3,6,4,6,8,4,3,5,7,90,7,5,3,5,3,56,4,2,234,2,5,462456,2,7,456,34,5,5345,345,3456,2,6,2};
  //for(int i = 0; i < Radix.radixsort(data).length; i++){
  //  System.out.println(Radix.radixsort(data)[i]);
  //}
  System.out.println(Radix.countDigits(1));



}
}
