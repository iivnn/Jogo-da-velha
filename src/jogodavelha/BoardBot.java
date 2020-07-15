package jogodavelha;

import java.util.Random;

public class BoardBot {
    
    
    public static int[] boardBotMove(Board b){
        int[] v = new int[2];
        switch (b.getRounds()) {
            case 1:
                v[0] = 1;
                v[1] = 1;
                return v;
            case 2:
                if(b.getBoard()[1][1] == 0){
                    v[0] = 1;
                    v[1] = 1;
                    return v;
                }else{
                    return botMoveOnTheCorner(b);
                    }
            case 3:
                return botMoveOnTheCorner(b);
            case 4:
                v = botBlock(b);
                if(v[0] != -1 && v[1] != -1){
                    return v;
                }else{
                    return botMoveRandom(b);
                }
            default:
                v = botWin(b);
                if(v[0] != -1 && v[1] != -1){
                    return v;
                }else{
                    v = botBlock(b);
                    if(v[0] != -1 && v[1] != -1){
                        return v;
                    }else{
                        v = botMoveSmart(b);
                        return v;
                    }
                }
                
                
        }//fim switch
    }
    
    
    private static  int[] botBlock(Board b){
        int[] v = new int[2];
        for(int x=0;x<8;x++){
            if(b.getSum()[x] == -2*b.getValue()){
                switch (x){
                    case 0:
                        if(b.getBoard()[0][0] == 0){
                            v[0] = 0;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[0][1] == 0){
                            v[0] = 0;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[0][2] == 0){
                            v[0] = 0;
                            v[1] = 2;
                            return v;}
                    case 1:
                        if(b.getBoard()[1][0] == 0){
                            v[0] = 1;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[1][2] == 0){
                            v[0] = 1;
                            v[1] = 2;
                            return v;}
                    case 2:
                        if(b.getBoard()[2][0] == 0){
                            v[0] = 2;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[2][1] == 0){
                            v[0] = 2;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[2][2] == 0){
                            v[0] = 2;
                            v[1] = 2;
                            return v;}
                    case 3:
                        if(b.getBoard()[0][0] == 0){
                            v[0] = 0;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[1][0] == 0){
                            v[0] = 1;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[2][0] == 0){
                            v[0] = 2;
                            v[1] = 0;
                            return v;}
                    case 4:
                        if(b.getBoard()[0][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[2][1] == 0){
                            v[0] = 2;
                            v[1] = 1;
                            return v;}
                    case 5:
                        if(b.getBoard()[0][2] == 0){
                            v[0] = 0;
                            v[1] = 2;
                            return v;
                        }else if(b.getBoard()[1][2] == 0){
                            v[0] = 1;
                            v[1] = 2;
                            return v;
                        }else if(b.getBoard()[2][2] == 0){
                            v[0] = 2;
                            v[1] = 2;
                            return v;}
                    case 6:
                        if(b.getBoard()[0][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[2][1] == 0){
                            v[0] = 2;
                            v[1] = 1;
                            return v;}
                    case 7:
                        if(b.getBoard()[2][0] == 0){
                            v[0] = 2;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[0][2] == 0){
                            v[0] = 0;
                            v[1] = 2;
                            return v;}
                }//fim switch
            }
        }//fim do laço
        v[0] = -1;
        v[1] = -1;
        return v;
    }
    
    
    private static  int[] botWin(Board b){
        int[] v = new int[2];
        for(int x=0;x<8;x++){
            if(b.getSum()[x] == 2*b.getValue()){
                switch (x){
                    case 0:
                        if(b.getBoard()[0][0] == 0){
                            v[0] = 0;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[0][1] == 0){
                            v[0] = 0;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[0][2] == 0){
                            v[0] = 0;
                            v[1] = 2;
                            return v;}
                    case 1:
                        if(b.getBoard()[1][0] == 0){
                            v[0] = 1;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[1][2] == 0){
                            v[0] = 1;
                            v[1] = 2;
                            return v;}
                    case 2:
                        if(b.getBoard()[2][0] == 0){
                            v[0] = 2;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[2][1] == 0){
                            v[0] = 2;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[2][2] == 0){
                            v[0] = 2;
                            v[1] = 2;
                            return v;}
                    case 3:
                        if(b.getBoard()[0][0] == 0){
                            v[0] = 0;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[1][0] == 0){
                            v[0] = 1;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[2][0] == 0){
                            v[0] = 2;
                            v[1] = 0;
                            return v;}
                    case 4:
                        if(b.getBoard()[0][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[2][1] == 0){
                            v[0] = 2;
                            v[1] = 1;
                            return v;}
                    case 5:
                        if(b.getBoard()[0][2] == 0){
                            v[0] = 0;
                            v[1] = 2;
                            return v;
                        }else if(b.getBoard()[1][2] == 0){
                            v[0] = 1;
                            v[1] = 2;
                            return v;
                        }else if(b.getBoard()[2][2] == 0){
                            v[0] = 2;
                            v[1] = 2;
                            return v;}
                    case 6:
                        if(b.getBoard()[0][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[2][1] == 0){
                            v[0] = 2;
                            v[1] = 1;
                            return v;}
                    case 7:
                        if(b.getBoard()[2][0] == 0){
                            v[0] = 2;
                            v[1] = 0;
                            return v;
                        }else if(b.getBoard()[1][1] == 0){
                            v[0] = 1;
                            v[1] = 1;
                            return v;
                        }else if(b.getBoard()[0][2] == 0){
                            v[0] = 0;
                            v[1] = 2;
                            return v;}
                }//fim switch
            }
        }//fim do laço
        v[0] = -1;
        v[1] = -1;
        return v;
    }
    
    
    private static int[] botMoveOnTheCorner(Board b){
        int v[] = new int[2];
        Random random = new Random();
        while(true){
            v[0] = random.nextInt(3);
            while(v[0] == 1){
                v[0] = random.nextInt(3);}
            v[1] = random.nextInt(3);
            while (v[1] == 1){
                v[1] = random.nextInt(3);}
            if(b.getBoard()[v[0]][v[1]] == 0){
                return v;
            }
        }
        
    }
    
    
    private static  int[] botMoveRandom(Board b){
        int v[] = new int[2];
        Random random = new Random();
        while(true){
            v[0] = random.nextInt(3);
            v[1] = random.nextInt(3);
            if(b.getBoard()[v[0]][v[1]] == 0){
                return v;}
        }
        
    }
    
    
    private static  int[] botMoveSmart(Board b){
        int[] v = new int[2];
        
        Board p = b;
        int sum = sumAll(b);
        if(b.getValue()>0){
            for(int x=0;x<3;x++){
                for (int y=0; y<3;y++){
                    if(p.getBoard()[x][y] == 0){
                        p = pBoard(b, x, y);
                        if(sumAll(p)>sum){
                            sum = sumAll(p);
                            v[0] = x;
                            v[1] = y;
                            p = b;
                        }
                        p = pBoard(b, y ,x);
                        if(sumAll(p)>sum){
                            sum = sumAll(p);
                            v[0] = y;
                            v[1] = x;
                            p = b;
                        }
                    }
                    p = b;
                }
            }
        }else if(b.getValue()<0){
            for(int x=0;x<3;x++){
                for (int y=0; y<3;y++){
                if(p.getBoard()[x][y] == 0){
                        p = pBoard(b, x, y);
                        if(sumAll(p)<sum){
                            sum = sumAll(p);
                            v[0] = x;
                            v[1] = y;
                            p = b;
                        }
                        p = pBoard(b, y ,x);
                        if(sumAll(p)<sum){
                            sum = sumAll(p);
                            v[0] = y;
                            v[1] = x;
                            p = b;
                        }
                        p = b;
                    }
                
                }
            }
            
        }
        return v;
    }
    
    
    private static  int sumAll(Board b){
        int s = 0;
        for(int z=0;z<8;z++){
           s += b.getSum()[z];
        }
        return s;
        
    }
    
    private  static Board pBoard(Board b,int x, int y){
        Board p = b;
        p.move(x, y);
        return p;
    }
    
}