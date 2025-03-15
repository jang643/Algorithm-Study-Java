/*
1. 문제 요약: 칸토어 집합 출력, 3^n 문자열 생성하고 문자열의 중간 부분 공백으로 변환
2. 문제 풀이:
    2-1. n 입력 받고 3^n 배열 생성
    2-2. len을 3으로 나누어 3등분, 가운데 부분 공백으로 변경
    2-3. len이 1이면 더이상 분할 x => 종료
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int len = (int) Math.pow(3, n);

            char[] array = new char[len];
            for (int i = 0; i < len; i++) {
                array[i] = '-';
            }

            recursion(0, len, array);
            System.out.println(new String(array));
        }
    }

    private static void recursion(int start, int len, char[] array) {
        if (len == 1) return;

        len /= 3;

        for (int i = start + len; i < start + 2 * len; i++) {
            array[i] = ' ';
        }

        recursion(start, len, array);
        recursion(start + 2 * len, len, array);
    }
}