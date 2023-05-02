// 삼성 1954
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class S_1954 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] nums = new int[N][N];

            int move = 0;
            int x = 0;
            int y = 0;
            for(int i = 1; i <= N*N; i++){
                nums[x][y] = i;
                if(x + dx[move] >= N || x + dy[move] < 0 || y + dy[move] >= N || y + dy[move] < 0 || nums[x + dx[move]][y + dy[move]] != 0){
                    move = (move + 1) % 4;
                }
                x += dx[move];
                y += dy[move];
            }

            System.out.println("#"+tc);
            for(int i = 0; i < N; i++){
                for(int n : nums[i]){
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        }
    }  
}
