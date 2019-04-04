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
    @SuppressWarnings("unchecked")
  public static MyLinkedList<Integer>[] radixsort(int[] data){
    int largestLength = 0;
    int digit = 0;
    //start with only positives
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    MyLinkedList<Integer>[] buckets2 = new MyLinkedList[10];

    for(int num : data){
      //now we gotta put them into their respective buckets
      if(buckets[getNthDigit(0, num)] == null) buckets[getNthDigit(0, num)] = new MyLinkedList<Integer>();
      //above line gets rid of null pointer errors
      if(countDigits(num) > largestLength) largestLength = countDigits(num) + 1;
      //System.out.println(getNthDigit(0, num));
      buckets[getNthDigit(0, num)].addBack(num);

      }

      //ok above sorts them by first digit but also gets the larges number of digits;
      for(int i = 1; i < largestLength; i++){
        //now we are swapping between 2 lists
        if(i %2 == 1){
          //this keeps track of which list were swapping into, if i is odd we swap into buckets2
         buckets2 = new MyLinkedList[10];
        //recreate buckets 2
        for(int j = 0; j < buckets.length; j++){
          //no we gotta go through buckets and put all the numb
          for(int k = 0; k < buckets[j].size(); k++){

          int num = buckets[j].removeFront().value();
          //this is the first element of buckets were gonna be looking at
          if(buckets2[getNthDigit(i, num)] == null) buckets2[getNthDigit(i, num)] = new MyLinkedList<Integer>();
          buckets2[getNthDigit(i, num)].addBack(getNthDigit(i, num));
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
