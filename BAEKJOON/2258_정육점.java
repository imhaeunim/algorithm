import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
​
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
​
        List<long[]> meats = new ArrayList<>();
​
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long weight = Long.parseLong(st.nextToken());
            long price = Long.parseLong(st.nextToken());
            meats.add(new long[]{weight, price});
        }
​
        // 가격 오름차순, 가격이 같다면 무게 내림차순 정렬
        meats.sort((a, b) -> {
            if (a[1] == b[1]) return Long.compare(b[0], a[0]);
            return Long.compare(a[1], b[1]);
        });
​
        long totalWeight = 0;
        long totalPrice = 0;
        long minCost = Long.MAX_VALUE;
        long prevPrice = -1;
​
        for (int i = 0; i < N; i++) {
            long weight = meats.get(i)[0];
            long price = meats.get(i)[1];
​
            totalWeight += weight;
​
            if (price == prevPrice) {
                totalPrice += price;
            } else {
                totalPrice = price;
            }
​
            if (totalWeight >= M) {
                minCost = Math.min(minCost, totalPrice);
            }
​
            prevPrice = price;
        }
​
        System.out.println(minCost == Long.MAX_VALUE ? -1 : minCost);
    }
}
​
​