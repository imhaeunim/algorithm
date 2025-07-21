import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
​
public class Main {
​
    static class Node {
        
        TreeMap<String, Node> child;
        
        public Node() {
            child = new TreeMap<>();
        }
        
    }
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Node root = new Node();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            
            Node node = root;
            for(int j=0; j<K; j++) {
                String feed = st.nextToken();
                if(!node.child.containsKey(feed)) {
                    node.child.put(feed, new Node());
                }
                node = node.child.get(feed);
            }
        }
        
        printTree(0, root);
        System.out.println(sb);
        
    }
    
    static void printTree(int d, Node root) {
        
        for(String node: root.child.keySet()) {
            for(int i=0; i<d; i++) {
                sb.append("--");
            }
            sb.append(node).append("\n");
            
            printTree(d+1, root.child.get(node));
        }
        
    }
​
}
​