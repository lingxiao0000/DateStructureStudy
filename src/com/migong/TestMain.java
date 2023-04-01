package com.migong;

import java.util.Arrays;

/**
 * 迷宫问题
 */
public class TestMain {
    public static void main(String[] args) {
        // 构建地图,1为墙,3为终点
        int [][] maps = new int[10][10];
        Arrays.fill(maps[0], 1);
        Arrays.fill(maps[9],1);
        for (int i = 0;i<maps.length;i++) {
            maps[i][0] = 1;
            maps[i][9] = 1;
        }
        for (int i=0;i<maps[0].length - 3;i++) {
            maps[4][i] = 1;
        }
        for (int i=9;i>3;i--) {
            maps[7][i] = 1;
        }
        maps[8][2] = 1;
        maps[7][2] = 1;
        maps[6][2] = 1;
        maps[8][8] = 3;

        setWay(maps,1,1);

        for (int i = 0;i<maps.length;i++) {
            for (int j = 0;j<maps[0].length;j++) {
                System.out.print(maps[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 走迷宫的递归函数
     * @param map 地图
     * @param x 当前位置行数
     * @param y 当前位置列数
     * @return
     */
    public static boolean setWay(int[][] map,int x,int y) {
        // 如果当前位置是终点位置，直接返回true
        if(map[x][y] == 3) {
            return true;
        }
        // 如果当前位置是墙，直接返回
        else if (map[x][y] == 1) {
            return false;
        }
        // 如果当前位置已经走过，直接返回
        else if (map[x][y] == 2) {
            return false;
        }
        // 如果不是，则要继续走迷宫
        // 制定走迷宫的规则
        // 下->右->左->上
        else {
            // 先将当前位置标志为走到2
            map[x][y] = 2;
            // 往下走
            if (setWay(map,x+1,y)) {
                return true;
            }
            // 往右走
            if (setWay(map,x,y+1)) {
                return true;
            }
            // 往左走
            if (setWay(map,x,y-1)) {
                return true;
            }
            // 往上走
            if (setWay(map,x-1,y)) {
                return true;
            }
            // 如果都走不通，直接返回，同时删除走过标记
            map[x][y] = 0;
            return false;
        }
    }
}
