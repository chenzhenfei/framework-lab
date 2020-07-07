package com.tsshare.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author chenzhenfei
 * @title: LabBfs
 * @projectName framework-lab
 * @description: 广度搜索 -  朋友圈 - 新写法模板
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
        LabBfsIsland labBfs = new LabBfsIsland();
        int bfsNew = labBfs.bfsNew(M);
        System.out.println(bfsNew);
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
                queue.add(intD);
                queue.add(intU);
                queue.add(intL);
                queue.add(intR);
            }
        }
    }


}
