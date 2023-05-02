public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] nums = new int[N][N];

            int dir = 0;
            int r = 0;
            int c = 0;

            for(int i = 1; i <= N*N; i++){
                nums[r][c] = i;
                if(r + dx[dir] >= N || r + dy[dir] < 0 || c + dy[dir] >= N || c + dy[dir] < 0 || nums[r + dx[dir]][c + dy[dir]] != 0){
                    dir = (dir + 1) % 4;
                }

                r += dx[dir];
                c += dy[dir];

            }

            SYstem.out.println("#" + tc);
            for(int i = 0; i < N; i++){
                for(int n : nums[i]){
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        }
    }
    
}
