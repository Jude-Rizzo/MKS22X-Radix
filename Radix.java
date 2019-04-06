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


        //new stuff

    //ok above sorts them by first digit but also gets the larges number of digits;
    for(int i = 1; i < largestLength; i++){
      //now we are swapping between 2 lists
      if(i %2 == 1){
        //this keeps track of which list were swapping into, if i is odd we swap into buckets2
        buckets2 = new MyLinkedList[10];
        //recreate buckets 2
        for(int j = 0; j < buckets.length; j++){
          //no we gotta go through buckets and put all the numb
        if(buckets[j] != null){
          for(int k = 0; k < buckets[j].size(); k++){

            System.out.println(buckets[j].size());
              System.out.println(buckets[j]);


              Integer num = buckets[j].removeBack().value();
              //System.out.println(num);
              //this is the first element of buckets were gonna be looking at
              if(buckets2[getNthDigit(i, num)] == null) buckets2[getNthDigit(i, num)] = new MyLinkedList<Integer>();
              buckets2[getNthDigit(i, num)].addBack(getNthDigit(i, num));
            }
          }
        }
      }

      if(i % 2 == 0){
        buckets = new MyLinkedList[10];
        //recreate buckets 2
        for(int j = 0; j < buckets2.length; j++){
          //no we gotta go through buckets and put all the numb
          for(int k = 0; k < buckets2[j].size(); k++){

            int num = buckets2[j].removeFront().value();
            //this is the first element of buckets were gonna be looking at
            if(buckets[getNthDigit(i, num)] == null) buckets[getNthDigit(i, num)] = new MyLinkedList<Integer>();
            buckets[getNthDigit(i, num)].addBack(getNthDigit(i, num));

          }

        }
      }
    }
    if(largestLength % 2 == 1) return buckets;
    else return buckets2;


  }
}
