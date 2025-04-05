package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    List<List<Integer>> adj = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int pre[] : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] visit = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visit[i]) if (isAcyclic(i, visit, inStack)) return false;
        }
        return true;
    }

    private boolean isAcyclic(int node, boolean[] visit, boolean[] inStack) {
        visit[node] = true;
        inStack[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visit[neighbour]) {
                if (isAcyclic(neighbour, visit, inStack)) return true;
            } else if (inStack[neighbour]) return true;
        }
        inStack[node] = false;
        return false;
    }
}
