public class B_1926{
    static int n;
    static int m;
    static int count;
    static int maxSize;
    static int[][] image;
    static int[][] visited;

    public static void public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        image = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(image[i][j] == 1 && !visited[i][j]){
                    BFS(i,j);
                }
            }
        }
    
    System.out.println(count);
    System.out.println(maxSize);

}

public static void BFS(int x, int y){
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(x, y));

    int area = 0;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    while(!que.isEmpty()){
        Node node = que.poll();
        area++;

        for(int d = 0; d < 4; d++){
            int nx = node.x + dx[d];
            int ny = node.y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                continue;
            }
            if(image[nx][ny] == 1 && !visited[nx][ny]){
                visited[nx][ny] = true;
                que.add(new Node(nx, ny));
            }
        }
    }
    count++;
    if(area > 1){
        area--;
    }
    
    maxSize = Math.max(maxSize, area);
}
}

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}