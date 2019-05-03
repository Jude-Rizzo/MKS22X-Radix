import java.util.*;

public class test{
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






  public static void main(String[] args){
    int[] data = {1,2,3,4,5,6,7,8,9};
    int[] dd = {9,8,7,6,5,4,3,2,1};
    System.out.println(Arrays.toString(back(data)));
    System.out.println((sorted(data)));
    System.out.println((rsorted(dd)));
  }

}
