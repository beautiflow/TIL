import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class S_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + tc );
            for(int i = 0 ; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(arr[N-j-1][i]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++){
                    System.out.print(arr[N-i-1][N-j-1]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++){
                    System.out.print(arr[j][N-i-1]);
                }
                System.out.println();
                }
        }
    }
}
