package com.tsshare.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenzhenfei
 * @title: LabBfs
 * @projectName framework-lab
 * @description: 广度搜索 - 朋友圈问题
 * @date 2020/7/223:25
 * {1, 1, 0},
 * {1, 1, 0},
 * {0, 0, 1}
 *
 *
 * //
 *
 * {1, 1, 0,1},
 * {1, 1, 0,0},
 * {0, 0, 1,0}
 * {1, 0, 0,1}
 */
public class LabBfs {
    public static void main(String[] args) {
//        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int[][] M = new int[][]{{1, 1, 0,1}, {1, 1, 0,0}, {0, 0, 1,0},{1, 0, 0,1}};
        int[][] M1 = new int[][]{{1, 1, 0,1}, {1, 1, 0,0}, {0, 0, 1,0},{1, 0, 0,1}};

        int[] visit = new int[M.length];
        LabBfs labBfs = new LabBfs();
        int bfs = labBfs.bfs(M, visit);

        int bfsNew = labBfs.bfsEx(M1);
        System.out.println(bfs+"::"+bfsNew);
    }

    private int bfs(int[][] m, int[] visit) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            if (visit[i] == 0) {
                q.add(i);
                while (!q.isEmpty()) {
                    int tmp = q.remove();
                    visit[tmp] = 1;
                    for (int j = 0; j < m.length; j++) {
                        if (m[tmp][j] == 1 && visit[j] == 0) {
                            q.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 拆分子的计算
     * @return
     * @param m
     */
    private int bfsEx(int[][] m){
        int count  =0;
        int x_len =m.length;
        int y_len =m[0].length;
        for (int i = 0; i <x_len ; i++) {
            for (int j = 0; j <y_len ; j++) {
                if(m[i][j]==1){
                    bfsChild(m,i,j);
                    count++;
                }
            }
        }
        return count;
    }


    private void bfsChild(int[][] m, int i, int j) {
        int[] index=new int[]{i,j};
        Queue<int[]> queue =new LinkedList<>();
        queue.offer(index);
        while(!queue.isEmpty()){
            int[] remove = queue.remove();
            int x =remove[0],y =remove[1];
            if(x>=0&&x<m.length&&y>=0&&y<m[0].length&&m[x][y]==1){
                m[x][y]=0;
                int[] xUp={x+1,y};
                int[] xDown ={x-1,y};
                int[] xRight ={x,y+1};
                int[] xLeft ={x,y-1};
                queue.offer(xDown);
                queue.offer(xUp);
                queue.offer(xRight);
                queue.offer(xLeft);
            }
        }

    }


}
