package alevel.jdbc.game;


import java.util.List;
import java.util.Objects;

public class Game {
    private final Long id;
    private final Long winnerId;
    private final Long score;
    private final List<Long> playerIds;

    public Game(Long id, Long winnerid, Long score, List<Long> playerIds) {
        this.id = id;
        this.winnerId = winnerid;
        this.score = score;
        this.playerIds = playerIds;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(winnerId, game.winnerId) &&
                Objects.equals(score, game.score) &&
                Objects.equals(playerIds, game.playerIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, winnerId, score, playerIds);
    }


    public Long getId() {
        return id;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public Long getScore() {
        return score;
    }

    public List<Long> getPlayerIds() {
        return playerIds;
    }


}
