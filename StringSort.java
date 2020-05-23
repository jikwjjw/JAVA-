package string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StringSort {
	public ArrayList<String> permutationHelp(StringBuilder str) {
		ArrayList<String> result = new ArrayList<String>();
		if (str.length() == 1) {
			result.add(str.toString());
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (i == 0 || str.charAt(i) != str.charAt(0)) {
					char temp = str.charAt(i);
					str.setCharAt(i, str.charAt(0));
					str.setCharAt(0, temp);
					ArrayList<String> newResult = permutationHelp(new StringBuilder(str.substring(1)));
					for (int j = 0; j < newResult.size(); j++) {
						result.add(str.substring(0, 1) + newResult.get(j));
					}
					// ���껹��Ҫ�Ż�ȥ��
					temp = str.charAt(0);
					str.setCharAt(0, str.charAt(i));
					str.setCharAt(i, temp);
				}
			}
			// ��Ҫ����һ���������
			Collections.sort(result);
		}
		return result;
	}

	public ArrayList<String> permutation(String str) {
		StringBuilder strBuilder = new StringBuilder(str);
		ArrayList<String> result = permutationHelp(strBuilder);
		System.out.println(result.toString());
		return result;
	}

	public static void main(String[] args) {
		String str = "abc";
		StringSort sort = new StringSort();
		sort.permutation(str);
	}
}
