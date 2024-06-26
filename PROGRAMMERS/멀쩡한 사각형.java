class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        int n=0;
        if(w>h) n=gcd(w,h);
        else n=gcd(h,w);
        
        answer = (long)w*h-(w/n+h/n-1)*n;
        
        return answer;
    }
    
    public int gcd(int x, int y) {
        if(y==0) return x;
        return gcd(y,x%y);
    }
}