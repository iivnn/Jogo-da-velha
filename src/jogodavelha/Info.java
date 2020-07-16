package jogodavelha;

/**
 *
 * @author iivan
 */
public class Info {
    private int playerValue;
    private int wins,loses,ties;
    private String info;

    public Info(int playerValue) {
        this.playerValue = playerValue;
        this.wins = 0;
        this.loses = 0;
        this.ties = 0;
        this.info = "Seja Bem vindo!\n";
    }
    
    public void reset(int playerValue){
        this.playerValue = playerValue;
        this.wins = 0;
        this.loses = 0;
        this.ties = 0;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    public void setPlayerValue(int playerValue) {
        this.playerValue = playerValue;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
}
