/**
 * 马走日字 从{3，4}遍历8*8是否可能
 */
import java.util.LinkedList;
import java.util.List;
import java.awt.Point;

public class HorseTrans {
    int m = 7;
    int n = 7;
    boolean isFound = false;
    public LinkedList<Point> path = new LinkedList<>();

    public void backTrace(int x, int y, boolean[][] visited, LinkedList<Point> path) {
        // long a = System.currentTimeMillis();
        // boolean isvisited = false;
       
        visited[x][y] = true;
               if (path.size() == m*n) {
            isFound = true;
            for (Point point : path) {
                System.out.println(point);
            }
            return;
        }
        
        Point p = new Point(x, y);
        LinkedList<Point> next = getNextList(p);
        sort(next);
        for (int i = 0; i < next.size(); i++) {
            if (!visited[next.get(i).x][next.get(i).y]) {
                path.add(next.get(i));
                // visited[next.get(i).x][next.get(i).y] = true;

                backTrace(next.get(i).x, next.get(i).y, visited, path);

                path.remove(path.size() - 1);
                // visited[next.get(i).x][next.get(i).y] = false;
                    
            }                
        }
        if (!isFound) {
            visited[x][y] = false;
        }
        // System.out.println(System.currentTimeMillis() - a + "ms");
    }

    // public ArrayList<Point> getNextList(Point curPoint) {
    //     ArrayList<Point> res = new ArrayList<>();
    //     int curX = curPoint.x;
    //     int curY = curPoint.y;
    //     if ((curX - 2 >= 0 && curX - 2 <= m - 1) && (curY - 1 >= 0 && curY - 1 <= n - 1)) {
    //         res.add(new Point(curX - 2, curY - 1));
    //     }
    //     if ((curX - 2 >= 0 && curX - 2 <= m - 1) && (curY + 1 >= 0 && curY + 1 <= n - 1)) {
    //         res.add(new Point(curX - 2, curY + 1));
    //     }
    //     if ((curX + 2 >= 0 && curX + 2 <= m - 1) && (curY - 1 >= 0 && curY - 1 <= n - 1)) {
    //         res.add(new Point(curX + 2, curY - 1));
    //     }
    //     if ((curX + 2 >= 0 && curX + 2 <= m - 1) && (curY + 1 >= 0 && curY + 1 <= n - 1)) {
    //         res.add(new Point(curX + 2, curY + 1));
    //     }
    //     if ((curX - 1 >= 0 && curX - 1 <= m - 1) && (curY - 2 >= 0 && curY - 2 <= n - 1)) {
    //         res.add(new Point(curX - 1, curY - 2));
    //     }
    //     if ((curX - 1 >= 0 && curX - 1 <= m - 1) && (curY + 2 >= 0 && curY + 2 <= n - 1)) {
    //         res.add(new Point(curX - 1, curY + 2));
    //     }
    //     if ((curX + 1 >= 0 && curX + 1 <= m - 1) && (curY - 2 >= 0 && curY - 2 <= n - 1)) {
    //         res.add(new Point(curX + 1, curY - 2));
    //     }
    //     if ((curX + 1 >= 0 && curX + 1 <= m - 1) && (curY + 2 >= 0 && curY + 2 <= n - 1)) {
    //         res.add(new Point(curX + 1, curY + 2));
    //     }
    //     return res;
    // }

    public LinkedList<Point> getNextList(Point curPoint) {
        //创建一个集合存储点
        LinkedList<Point> ps = new LinkedList<>();
        //创建一个point
        Point p1 = new Point();
        //表示马可以走 左上偏左 的位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马可以走 左上偏右 的位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马可以走 右上偏左 的位置
        if ((p1.x = curPoint.x + 1) < m - 1 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马可以走 右上偏右 的位置
        if ((p1.x = curPoint.x + 2) < m && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马可以走 右下偏右 的位置
        if ((p1.x = curPoint.x + 2) < m && (p1.y = curPoint.y + 1) < n) {
            ps.add(new Point(p1));
        }
        //表示马可以走 右下偏左 的位置
        if ((p1.x = curPoint.x + 1) < m && (p1.y = curPoint.y + 2) < n) {
            ps.add(new Point(p1));
        }
        //表示马可以走 左下偏右 的位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < n) {
            ps.add(new Point(p1));
        }
        //表示马可以走 左下偏左 的位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < n) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public void sort(List<Point> ps) {
        
        ps.sort(
                (o1, o2) -> {
                    //获取到o1的下一步的所有位置个数
                    int count1 = getNextList(o1).size();
                    //获取到o2的下一步的所有位置个数
                    int count2 = getNextList(o2).size();
                    if (count1 < count2) {
                        return -1;
                    } else if (count1 == count2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
        );
    }
    
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        HorseTrans ht = new HorseTrans();
        boolean[][] visited = new boolean[ht.m][ht.n];
        visited[3 - 1][4 - 1] = true;
        ht.path.add(new Point(3 - 1,4 - 1));
        ht.backTrace(3 - 1, 4 - 1, visited, ht.path);
        System.out.println(ht.isFound);
        long b = System.currentTimeMillis() - a;
        System.out.println(b+"ms");
    }
}