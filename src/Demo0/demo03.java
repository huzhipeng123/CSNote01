package Demo0;

import java.util.*;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class demo03 {
    public static void main(String[] args) {
        System.out.println("请输入数组大小：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[] array = new int[N];
        Random random = new Random();
        for(int i = 0; i < N; i++){
            array[i] = random.nextInt(N);
        }
        System.out.println("原数据>>>>>>>>>>>");
        for(int i : array){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("重复元素>>>>>>>>>>");
//        System.out.println(duplicateOfArray(array));
        System.out.println(duplicateOfList(array));
    }

    /**
     * 利用集合的特性，实现找到其中的重复元素
     * @param array
     * @return
     */
    private static List<Integer> duplicateOfList(int[] array) {
        if(array == null || array.length < 2){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(Integer i : array){
            if(list.contains(i)){
                if(!result.contains(i)){
                    result.add(i);
                }
            }else{
                list.add(i);
            }
        }
        return result;
    }

    /**
     * 遍历数组，找到其中的重复元素
     * @param array
     */
    public static Set<Integer> duplicateOfArray(int[] array) {
        if(array == null || array.length < 2){
            return null;
        }
        Set<Integer> list = new HashSet<>();
        for(int i = 0; i < array.length;){
            if(array[i] != i){
                int number = swap(array, array[i], i);
                if(number != -1){
                    list.add(number);
                    i++;
                }
                continue;
            }else if(array[array[i]] == i && i > array[i]){                 //如果被交换的元素和其所在位置的值相等，说明交换元素是重复的
                list.add(array[i]);
            }
            i++;
        }
        return list;
    }

    /**
     * 交换两数
     * @param array
     * @param i
     * @param j
     */
    private static Integer swap(int[] array, int i, int j) {
        if(array[i] == array[j]){
            return array[i];
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return -1;
    }


}
