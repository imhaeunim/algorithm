import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
​
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
​
        ArrayList<long[]> meats = new ArrayList<>();
​
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long weight = Long.parseLong(st.nextToken());
            long price = Long.parseLong(st.nextToken());
            meats.add(new long[]{weight, price});
        }
​
        meats.sort((a, b) -> {
            if (a[1] == b[1]) return Long.compare(b[0], a[0]);
            return Long.compare(a[1], b[1]);
        });
​
        long totalWeight = meats.get(0)[0];
        long totalPrice = meats.get(0)[1];
        long minCost = Long.MAX_VALUE;
​
        for (int i = 1; i < N; i++) {
​
            totalWeight += meats.get(i)[0];
​
            if (meats.get(i)[1] == meats.get(i-1)[1]) {
                totalPrice += meats.get(i)[1];
            } else {
                totalPrice = meats.get(i)[1];
            }
​
            if (totalWeight >= M) {
                minCost = Math.min(minCost, totalPrice);
            }
​
        }
​
        System.out.println(minCost == Long.MAX_VALUE ? -1 : minCost);
    }
}
​
​