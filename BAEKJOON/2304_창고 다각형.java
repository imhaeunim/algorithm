import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
​
        ArrayList<int[]> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
​
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }
​
        arr.sort((o1, o2) -> o1[0] - o2[0]);
​
        int maxH = 0;
        int maxIdx = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)[1] > maxH) {
                maxH = arr.get(i)[1];
                maxIdx = i;
            }
        }
​
        int answer = 0;
​
        int curH = arr.get(0)[1];
        int curX = arr.get(0)[0];
        for (int i = 1; i <= maxIdx; i++) {
            int x = arr.get(i)[0];
            int h = arr.get(i)[1];
            if (h >= curH) {
                answer += (x - curX) * curH;
                curH = h;
                curX = x;
            }
        }
​
        curH = arr.get(arr.size() - 1)[1];
        curX = arr.get(arr.size() - 1)[0];
        for (int i = arr.size() - 2; i >= maxIdx; i--) {
            int x = arr.get(i)[0];
            int h = arr.get(i)[1];
            if (h >= curH) {
                answer += (curX - x) * curH;
                curH = h;
                curX = x;
            }
        }
​
        answer += maxH;
​
        System.out.println(answer);
    }
​
}
​