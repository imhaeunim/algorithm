class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        // int answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int cur, int sum){
        if(cur == numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(numbers, target, cur+1, sum+numbers[cur]);
        dfs(numbers, target, cur+1, sum-numbers[cur]);
    }
}