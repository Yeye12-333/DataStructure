import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author yeye
 * @date 2022/11/6  10:45
 *
 * 二分法题目
 */
public class Dichotomous {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,15,19,20,33,36,45,54,75,94,100,101};
        Boolean num = findNum(arr, 101, 0, arr.length );
        System.out.println(num);
    }

    /**
     * 在一个有序数组中，找某个数是否存在
     * @param arr 有序数组
     */ 
    public static Boolean findNum(int[] arr,int num, int start, int end){
        int left = 0;
        int right = end - 1;
        int middle = (start + end) / 2;
        while (arr[middle] != num  ){
            if(arr[middle] > num){
                right = middle;
            }else {
                left = middle + 1;
            }

            middle = (right + left) / 2;
            if(arr[middle] == num){
                return true;
            }
            if(right == left){
                return false;
            }
        }
        return true;
    }
}
