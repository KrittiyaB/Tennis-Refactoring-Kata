
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public boolean isEqualScore() {
        if (m_score1 == m_score2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMorethan3() {
        if (m_score1 >= 4 || m_score2 >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public String setEqualScore() {
        StringBuilder score;
        switch (m_score1) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;
        }
        return score.toString();
    }

    public String setMorethan3Score() {
        int minusResult = m_score1 - m_score2;
        StringBuilder score;
        if (minusResult == 1) {
            score = new StringBuilder("Advantage ").append(player1Name);
        } else if (minusResult == -1) {
            score = new StringBuilder("Advantage ").append(player2Name);
        } else if (minusResult >= 2) {
            score = new StringBuilder("Win for ").append(player1Name);
        } else {
            score = new StringBuilder("Win for ").append(player2Name);
        }
        return score.toString();
    }

    public String setNormalScore() {
        int tempScore;
        StringBuilder score = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
                score.append("-");
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }

    public String getScore() {
        String score;
        if (isEqualScore()) {
            score = setEqualScore();
        } else if (isMorethan3()) {
            score = setMorethan3Score();
        } else {
            score = setNormalScore();
        }
        return score;
    }
}
