package demo0;

import java.util.Scanner;


/**
 * 将一个字符串中的空格替换成 "%20"。
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你想要替换的字符串：");
		String str = sc.nextLine();
		sc.close();
		System.out.println("替换后字符串："+replaceString(str));
	}

	/**
	 * 用数组实现
	 * 替换字符串中的非数字，字母的字符
	 * @param str
	 */
	private static String replaceString(String str) {
		if(str == null) {
			return null;
		}
		int count = 0;
		char[] array = str.toCharArray();
		for(char c : array) {
			if(c >= 'A' && c <= 'Z' 
					|| c >= 'a' && c <= 'z' 
					|| c >= '0' && c <= '9') {
				
			}else {
				count++;
			}
		}
		char[] result = new char[array.length + count * 2];
		int i = array.length - 1;
		int j = result.length - 1;
		while(i >= 0) {
			if(array[i] >= 'A' && array[i] <= 'Z' 
					|| array[i] >= 'a' && array[i] <= 'z' 
					|| array[i] >= '0' && array[i] <= '9') {
				result[j] = array[i];
				i--;
				j--;
			}else {
				String number = Integer.toHexString(array[i]);
				StringBuffer sb = new StringBuffer();
				sb.append("%");
				if(number.length() < 2) {
					sb.append('0');
				}
				sb.append(number);
				char[] ch = sb.toString().toCharArray();
				for(int k = ch.length - 1; k >= 0; k--) {
					result[j] = ch[k];
					j--;
				}
				i--;
			}
		}
		return new String(result);
	}
	
}
