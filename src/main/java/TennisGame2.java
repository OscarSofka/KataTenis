
public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)){
            p1Point += 1;
        }
        if (playerName.equals(this.player2Name)){
            p2Point += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (equalsScorePlayers()){
            score = equalPoints();
        }else if (scoreGreaterThan4()){
            score = greaterPoints();
        }else{
            score=getScore(p1Point).concat("-").concat(getScore(p2Point));
        }return score;
    }

    private boolean equalsScorePlayers(){
        return p1Point == p2Point;
    }
    private String equalPoints(){
        switch (p1Point){
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }
    private boolean scoreGreaterThan4(){
        return p1Point >= 4 || p2Point >=4;
    }
    private String advantageScore(int puntos){
        return puntos == 1 ? "Advantage ".concat(player1Name) : "Advantage ".concat(player2Name);
    }
    private String winnerPoints(int puntos){
        return puntos >= 2 ? "Win for ".concat(player1Name) : "Win for ".concat(player2Name);
    }
    private String winScore(int puntos){
        return puntos >= 2 ? "Win for ".concat(player1Name) : "Win for ".concat(player2Name);
    }
    private String greaterPoints(){
        int puntos = p1Point-p2Point;
        switch (puntos){
            case 1: case -1: return advantageScore(puntos);
            default: return winScore(puntos);
        }
    }

    private String getScore(int puntaje){
        switch (puntaje){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }


}