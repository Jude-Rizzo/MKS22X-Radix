public class Radix{


  public static int countDigits(int n){
    int counter = 0;
    while(n/10 > 0){
      n = n/10;
      counter ++;
    }

    return counter;
  }

  public static int getNthDigit(int n,int num){
    int count = 0;

    while(count < n){
      num = num/10;
      count++;
    }
    return  num%10;
  }

  //ABOVE STARTS AT 0 AND GOES RIGHT TO LEFT
  //only returns for sake of testing
  public static void radixsort(int[] data){
    @SuppressWarnings({"rawtypes", "unchecked"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i =0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();
    int count = getMax(data);
    //System.out.println(count);
    int base = 1;
    for(int i = 0; i < count; i++){
      //first pass through the array
      if (i == 0){
        for (int idx = 0; idx < data.length; idx++){
          int digit = (data[idx] / base) % 10;
          //System.out.println(digit);
          //sort the positives
          if (data[idx] >= 0){
            buckets[digit + 10].add(data[idx]);
          }
          //sort the negatives
          else{
            buckets[9 - digit].add(data[idx]);
          }
        }

        temp.clear();
          /**for (int c = 0; c < 20; c++){
            System.out.println(buckets[c].toString());
          }**/
          //use temp and extend the buckets to this
          for (int j = 0; j < 20; j++){
            temp.extend(buckets[j]);
            //System.out.println(temp.toString());
          }
          //System.out.println("reorder #: 1 " + temp.toString());
          //clear the buckets for another pass
          for (MyLinkedList<Integer> m : buckets){
            m.clear();
          }
        }

        else{
       for (int idx = 0; idx < data.length; idx++){
         //get the digit
         int num = temp.removeFront();
         int digit = (num / base) % 10;
         //System.out.println("pass #: " + i + " base: " + base + " num: " + num + " digit: " + digit);
         //sort the positives
         if (num >= 0){
           //System.out.println("pass #: " + i + " base: " + base + " num: " + num + " bucket #: " + (digit + 10) + " digit: " + digit);
           buckets[digit + 10].add(num);
           //System.out.println("bucket: " + (digit+10) + " " + buckets[digit+10].toString());
         }
         //sort the negatives
         else{
           buckets[9 - digit].add(num);
         }
       }


        //new stuff

    //ok above sorts them by first digit but also gets the larges number of digits;
    temp.clear();
        //copy from buckets to temp and extend
        for (int j = 0; j < 20; j++){
          temp.extend(buckets[j]);
        }
        //System.out.println("reorder #: " + (i+1) + " " + temp.toString());
        //clear the buckets for another pass
        for (MyLinkedList<Integer> m : buckets){
          m.clear();
        }
      }
      //increase the base
      base *= 10;
    }
    //copy from linked list to original array
    for (int i = 0; i < data.length; i++){
      data[i] = temp.removeFront();
    }
  }
}


  }
}
