public class Radix{


  public static int countDigits(int n){
    int counter = 1;
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
    for(int num : data){
      //now we gotta put them into their respective buckets
      if(countDigits(num) > largestLength) largestLength = countDigits(num);
      buckets[getNthDigit(0, num)].addBack(num);

      }

      return buckets;
    }
  }
