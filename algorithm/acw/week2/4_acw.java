/*
1. 문제 요약: 별 찍기
2. 문제 풀이:
    2-1. N입력 받고, NxN 크기의 2차원 배열 선언
    2-2. 모든 배열 *으로 채우기
    2-3. 재귀 호출을 이용해 가운데 공백을 만들고 작은 정사각형을 처리
    2-4. 재귀적으로 반복해 N=1이 될 때까지 진행

 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[][] stars = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stars[i][j] = "*";
            }
        }

        recursive(N, stars, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void recursive(int N, String[][] stars, int r, int c) {
        if (N == 1) return;

        int newN = N / 3;

        for (int i = r + newN; i < r + 2 * newN; i++) {
            for (int j = c + newN; j < c + 2 * newN; j++) {
                stars[i][j] = " ";
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                recursive(newN, stars, r + row * newN, c + col * newN);
            }
        }
    }
}