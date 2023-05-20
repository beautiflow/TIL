import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, -1, 0, 1};
    static char[][] board;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());

            String answer = "NO";

            board = new char[N][N];

            for(int i = 0; i < N; i++){
                String str = br.readLine();
                for(int j = 0; j < N; j++){
                    if(board[i][j] == 'o'){
                        for(int dir = 0; dir < 4; dir++){
                            int cnt = counting(i, j, dir);
                            if(cnt == 5){
                                answer = "YES";
                                break;
                                 }
                            }
                        }
                    }

                }
        System.out.println("#"+tc+" "+answer);
            }

        }

        private static int counting(int i, int j, int dir){
            int cnt = 1;
            int dirX = i;
            int dirY = j;

            for(int k = 0; k < 4; k++){
                dirX = dirX + dx[dir];
                dirY = dirY + dy[dir];

                if(dirX >= 0 && dirX < N && dirY >= 0 && dirY < N && board[dirX][dirY] == 'o'){
                    cnt++;
                }
                else{
                    break;
                }
            }
            return cnt;
        }
  }
    


