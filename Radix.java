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


  private static int Maximum(int[] data){
    int max = data[0];
    for (int i : data){
      if (i > max) max = i;
    }
    int count = 1;
    while (max >= 10){
      max /= 10;
      count++;
    }
    return count;
  }
  //debuggingg
  public static String linkedString(MyLinkedList<Integer>[] data){
    String output = "";
    for (int i = 10; i < data.length; i++){
      output += data[i].toString() + " ";
    }
    return output;
  }

  public static boolean sorted(int[] data){
    for(int i = 0; i < data.length - 1; i ++){
      if (data[i + 1] < data[i]) return false;
    }
    return true;
  }

  public static boolean rsorted(int[] data){
    for(int i = 0; i < data.length - 1; i ++){
      if (data[i + 1] > data[i]) return false;
    }
    return true;
  }


  public static int[] back(int[] data){
    int[] ans = new int[data.length];
    for(int i = data.length - 1; i > -1; i--){
      ans[data.length - 1 - i] = data[i];
    }
    return ans;
  }

  //ABOVE STARTS AT 0 AND GOES RIGHT TO LEFT
  //only returns for sake of testing
  public static void radixsort(int[] data){
    if(sorted(data)) return;
    if(rsorted(data)){
      int[] ans = back(data);
      for(int i = 0; i < data.length; i++){
        data[i] = ans[i];
      }
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i =0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> storage = new MyLinkedList<Integer>();
    int count = Maximum(data);
    int base = 1;
    for(int i = 0; i < count; i++){
      //pass throuugh oncce for testinf purposes
      if (i == 0){
        for (int index = 0; index < data.length; index++){
          int digit = (data[index] / base) % 10;

          if (data[index] >= 0){
            buckets[digit + 10].addBack(data[index]);
          }
          //sort the negatives
          else{
            buckets[9 - digit].addBack(data[index]);
          }
        }

        storage.clear();

          //use storage and extend the buckets to this
          for (int j = 0; j < 20; j++){
            storage.extend(buckets[j]);

          }

          for (MyLinkedList<Integer> m : buckets){
            m.clear();
          }
        }

        else{
       for (int index = 0; index < data.length; index++){
         //get the digit
         int num = storage.removeFront();
         int digit = (num / base) % 10;
         //System.out.println("pass #: " + i + " base: " + base + " num: " + num + " digit: " + digit);
         //sort the positives
         if (num >= 0){
           //System.out.println("pass #: " + i + " base: " + base + " num: " + num + " bucket #: " + (digit + 10) + " digit: " + digit);
           buckets[digit + 10].addBack(num);
           //System.out.println("bucket: " + (digit+10) + " " + buckets[digit+10].toString());
         }
         //sort the negatives
         else{
           buckets[9 - digit].addBack(num);
         }
       }


        //new stuff

    //ok above sorts them by first digit but also gets the larges number of digits;
    storage.clear();
        //copy from buckets to storage and extend
        for (int j = 0; j < 20; j++){
          storage.extend(buckets[j]);
        }
        //System.out.println("reorder #: " + (i+1) + " " + storage.toString());
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
      data[i] = storage.removeFront();
    }
  }
}
