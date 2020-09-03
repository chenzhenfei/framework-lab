package com.tsshare.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenzhenfei
 * @title: LabBfs
 * @projectName framework-lab
 * @description: 广度搜索 -  新写法模板, 按照下标去检索
 * @date 2020/7/223:25
 * {1, 1, 0,1},
 * {1, 1, 0,0},
 * {0, 0, 1,0}
 * {1, 0, 0,1}
 * <p>
 * <p>
 * {1,0,0,1,0}
 * {0,0,0,1,0}
 * {1,0,0,0,0}
 * {0,0,1,0,1}
 */
public class LabBfsIsland {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {1, 0, 0, 0, 0}, {0, 0, 1, 0, 1}};

        int[][] M1 = new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {1, 0, 0, 0, 0}, {0, 0, 1, 0, 1}};

        LabBfsIsland labBfs = new LabBfsIsland();
        int bfsNew = labBfs.bfsNew(M);
        int bfsEx = labBfs.bfsEx(M1);

        System.out.println(bfsNew+"::"+bfsEx);
    }

    private int bfsNew(int[][] m) {
        int count = 0;
        int x_len = m.length;
        int y_len = m[0].length;
        for (int i = 0; i < x_len; i++) {
            for (int j = 0; j < y_len; j++) {
                if (m[i][j] == 1) {
                    bfs(m, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int[][] m, int i, int j) {
        int[] i1 = new int[]{i, j};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(i1);
        while (!queue.isEmpty()) {
            int[] r = queue.remove();
            int a = r[0], b = r[1];
            if (a >= 0 && a < m.length && b >= 0 && b < m[0].length && m[a][b] == 1) {
                m[a][b] = 0;
                int[] intU = {a + 1, b};
                int[] intD = {a - 1, b};
                int[] intR = {a, b + 1};
                int[] intL = {a, b - 1};
                queue.add(intR);
                queue.add(intL);
                queue.add(intU);
                queue.add(intD);
            }
        }
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
