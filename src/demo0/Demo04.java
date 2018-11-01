package demo0;

import java.util.Scanner;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Demo04 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println("请输入你要查找的数字：");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        sc.close();
        if(!find(matrix, target)) {
        	System.out.println("未找到该元素");
        }
    }

    /**
     * 二维数组中
     * @param matrix
     * @param target
     */
	private static boolean find(int[][] matrix, int target) {
		if(matrix == null) {
			return false;
		}
		int p = 0;
		int q = matrix[0].length - 1;
		while(p < matrix.length && q >= 0) {
			if(matrix[p][q] < target) {
				p++;
			}else if(matrix[p][q] > target) {
				q--;
			}else {
				System.out.println("已找到该元素,坐标为["+p+", "+q+"]");
				return true;
			}
		}
		return false;
	}
}
