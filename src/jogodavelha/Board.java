package jogodavelha;

/**
 *
 * @author iivnn
 */
public class Board {
    private int board[][];
    private int sum[];
    private int value;
    private int rounds;

    public Board() {
        this.board = new int[3][3];
        this.sum = new int[8];
        this.value = 1;
        this.rounds = 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public int[] getSum() {
        return sum;
    }

    public int getValue() {
        return value;
    }

    public int getRounds() {
        return rounds;
    }
    
    public void move(int x, int y){
        if(this.board[x][y]==0){
            this.board[x][y] = this.value;
            this.value *= -1;
            this.rounds += 1;
        }
    }
    
    public void sumAll(){
        //Somas na horizontal e vertical
        for(int x=0;x<3;x++){
            this.sum[x] = 0;
            this.sum[x + 3] = 0;
            for(int y = 0;y<3;y++){
                this.sum[x] += this.board[x][y];
                this.sum[x+3] += this.board[y][x];
            }
        }
        //Somas na diagonal
        this.sum[6] = this.board[0][0] + this.board[1][1] + this.board[2][2];
        this.sum[7] = this.board[0][2] + this.board[1][1] + this.board[2][0];
    }
    
    
    public int findWinner(){
        
        for(int i = 0; i <8;i++){
            if(this.sum[i] == 3){
                return 1;
            }else if(this.sum[i] == -3){
                return -1;
            }
        }
        
        if(this.rounds == 9){
            return 2;
        }else{
            return 0;
        }
    }
}
