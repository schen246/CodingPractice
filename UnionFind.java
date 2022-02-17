public class UnionFind {
    int[] parent;

    public UnionFind(int len) {
        parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        if (parent[p] == p) {
            return p;
        }
        parent[p] = find(parent[p]);
        return parent[p];
    }

    public boolean union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i != j) {
            parent[i] = j;
            return true;
        }
        return false;
    }
}
