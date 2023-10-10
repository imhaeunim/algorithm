package com.ssafy.problem.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1244_S4_스위치켜고끄기_임하은 {

	
	
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();

	    int[] onoff = new int[N];
	    
	    for(int i=0; i<N;i++) {
	    	onoff[i]=sc.nextInt();
	    }
	    
	        int member = sc.nextInt();
	        for (int i=0; i<member;i++)
	        {
	            int gener =sc.nextInt();
	            int idx=sc.nextInt();


	 
	            if (gener ==1) {
	                int mul = N/idx;
	                int cur=idx-1;
	                for(int j=0; j<mul; j++) {
	                    if(onoff[cur]==0) {
	                        onoff[cur]=1;
	                        cur +=idx;
	                    }else {
	                        onoff[cur]=0;
	                        cur +=idx;
	                    }
	                }
	                
		        }else {
		        	int same=1;
		        	idx--;
		        	
		        	while(idx-same>=0 && idx+same<N) {
		
		        			if(onoff[idx-same]==onoff[idx+same]) {
		        				if(onoff[idx-same]==0) {
		                            onoff[idx-same]=1;
		                            onoff[idx+same]=1;
		                            same++;
		        				}else {
		        					onoff[idx-same]=0;
		                            onoff[idx+same]=0;
		                            same++;
		        				}
		        				
		        			}else {
		        				break;
		        			}
		        	
		        	}
		        	if(onoff[idx]==0) {
		                onoff[idx]=1;
		        	}else {
		        		onoff[idx]=0;
		        	}
		        }
	            if(i==N) {
	            	break;
	            }
	        }

	        for(int i =0; i<N;i++) {
	        	System.out.printf(onoff[i]+" ");
	        	if((i+1)%20==0) {
	        		System.out.println();
	        	}
	        }

		}

}
