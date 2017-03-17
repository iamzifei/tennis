public class Match {

    private Player player1;
    private Player player2;

    public Match(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public void pointWonBy(String player) {
        if (player.equals(player1.getName())) {
            player1.winPoint();
        } else if (player.equals(player2.getName())) {
            player2.winPoint();
        }
    }

    public String score() {
        if (player1.getPoint() >= 3 && player2.getPoint() >= 3) {
            if (player1.getPoint() - player2.getPoint() >= 2) {
                return "1-0";
            } else if (player2.getPoint() - player1.getPoint() >= 2) {
                return "0-1";
            } else if (player1.getPoint() == player2.getPoint()) {
                return "0-0, Deuce";
            } else {
                return "0-0, Advantage " + getLeadPlayer().getName();
            }
        } else {
            return "0-0, " + player1.getScore() + "-" + player2.getScore();
        }
    }

    private Player getLeadPlayer() {
        return (player1.getPoint() > player2.getPoint()) ? player1 : player2;
    }
}