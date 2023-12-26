public class Player {
    private String playerName;
    private GameClasses gameClass;

    public Player(String playerName, GameClasses gameClass) {
        this.playerName = playerName;
        this.gameClass = gameClass;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameClasses getGameClass() {
        return gameClass;
    }

    public void setGameClass(GameClasses gameClass) {
        this.gameClass = gameClass;
    }
}
