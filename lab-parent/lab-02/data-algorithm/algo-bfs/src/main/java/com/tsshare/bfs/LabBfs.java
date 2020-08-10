package com.tsshare.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenzhenfei
 * @title: LabBfs
 * @projectName framework-lab
 * @description: 广度搜索
 * @date 2020/7/223:25
 * {1, 1, 0},
 * {1, 1, 0},
 * {0, 0, 1}
 */
public class LabBfs {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[] visit = new int[M.length];
        LabBfs labBfs = new LabBfs();
        int bfs = labBfs.bfs(M, visit);
        System.out.println(bfs);
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
}
