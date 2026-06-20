package potd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//06/20/26 potd(leetcode)
//(problem of the day)
public class MaximumBuildingHeight {

    public static void main(String[] args) {
        int[][] restrictions = {{2,1},{4,1}};
        int n = 5;
        System.out.println(maxBuilding(n, restrictions));
    }

    public static int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        if (list.get(list.size() - 1)[0] != n) {
            list.add(new int[]{n, n - 1});
        }

        int m = list.size();
        for (int i = 1; i < m; i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];

            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i - 1)[1] + dist
            );
        }
        for (int i = m - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];

            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i + 1)[1] + dist
            );
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            int x = list.get(i - 1)[0];
            int h1 = list.get(i - 1)[1];
            int y = list.get(i)[0];
            int h2 = list.get(i)[1];
            int dist = y - x;
            ans = Math.max(ans, (h1 + h2 + dist) / 2);
        }
        return ans;
    }
}
