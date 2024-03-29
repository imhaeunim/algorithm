        
        while(!queue.isEmpty()) {
            int[] cur =  queue.poll();
            System.out.println(Arrays.toString(cur));
            // System.out.println(visited[cur[0]][cur[1]]);
            
            for(int d=0; d<4; d++) {
                int cx = cur[0];
                int cy = cur[1];
                while(cx+dx[d]>=0 && cx+dx[d]<board.length &&
                     cy+dy[d]>=0 && cy+dy[d]<board[0].length()) {
                    
                    cx+=dx[d];
                    cy+=dy[d];
                    if(map[cx][cy]=='D') {
                        if(visited[cx-dx[d]][cy-dy[d]]==0){
                            System.out.printf("%d %d\n",cx-dx[d],cy-dy[d]);
                            queue.add(new int[] {cx-dx[d],cy-dy[d]});
                            visited[cx-dx[d]][cy-dy[d]] = visited[cur[0]][cur[1]]+1;
                            if(map[cx-dx[d]][cy-dy[d]] == 'G') {
                                answer = Integer.max(answer,visited[cur[0]][cur[1]]);
                            }
                        }
                        break;
​
                    }else if(cx+dx[d]<0 || cy+dy[d]<0 || 
                             cx+dx[d]>=board.length || cy+dy[d]>=board[0].length()) {
                        if(visited[cx][cy]!=0) break;
                        queue.add(new int[] {cx,cy});
                        System.out.printf("%d %d\n",cx,cy);
                        visited[cx][cy] = visited[cur[0]][cur[1]]+1;
                        if(map[cx][cy] == 'G') {
                            answer = Integer.max(answer,visited[cur[0]][cur[1]]);
                        }
                        break;
                    }
​
                    
                }
            }
                
​
            
        }
        