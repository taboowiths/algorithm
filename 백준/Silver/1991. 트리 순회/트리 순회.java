import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int[][] tree;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[129][];

        StringTokenizer st;
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine(), " ");
           int root = st.nextToken().charAt(0);
           int left = st.nextToken().charAt(0);
           int right = st.nextToken().charAt(0);
           tree[root] = new int[] {left, right};
        }

        dfs(65, "preorder");
        sb.append("\n");
        dfs(65, "inorder");
        sb.append("\n");
        dfs(65, "postorder");

        System.out.println(sb.toString());
    }

    public static void dfs (int root, String types) {
        if (root == 46) return;
        if (types.equals("preorder")) sb.append((char) root);
        dfs(tree[root][0], types);
        if (types.equals("inorder")) sb.append((char) root);
        dfs(tree[root][1], types);
        if (types.equals("postorder")) sb.append((char) root);
    }
}
