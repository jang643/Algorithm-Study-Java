/* 문제 요약: 펠린드롬 판단 확인
 의사 코드:
1. 의사코드 구현하기
2. arr에 숫자 넣을때마다 카운트
3. 카운트와 숫자가 같으면 출력
4. 정렬이 끝났는데도 카운트가 숫자보다 작으면 -1 출력
*/
public class Main {
    static Queue<index> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        for(int i = 0; i < length; i++){
            isPalindrome(br.readLine());
        }

        for(index i : q){
            bw.write(i + "\n");
        }
        bw.flush();
    }

    static void recursion(final String str, int l, int r, int count){
        if(l >= r) q.add(new index(1, count));
        else if(str.charAt(l) != str.charAt(r))  q.add(new index(0,count));
        else recursion(str, l+1, r-1,count + 1);
    }

    static void isPalindrome(final String str){
        recursion(str, 0, str.length()-1, 1);
    }

    static class index{
        int result;
        int count;

        public index(int result, int count){
            this.result = result;
            this.count = count;
        }

        @Override
        public String toString() {
            return result + " " + count;
        }
    }
}