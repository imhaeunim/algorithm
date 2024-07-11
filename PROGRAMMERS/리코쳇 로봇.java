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
                        visited[cx][cy] = visited[cur[0]][cur[1]]+1;
                        if(map[cx][cy] == 'G') {
                            answer = Integer.max(answer,visited[cur[0]][cur[1]]);
                        }
                        break;
                    }
                    
                }
                
            }
            
        }
        
        return answer;
    }
}