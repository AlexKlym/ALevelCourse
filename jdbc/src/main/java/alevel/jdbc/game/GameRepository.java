package alevel.jdbc.game;

import alevel.jdbc.common.Repository;
import alevel.jdbc.common.StorageException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public final class GameRepository implements Repository<Game, Long> {
    private final Supplier<Connection> connectionSupplier;

    public GameRepository(Supplier<Connection> connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }


    @Override
    public void save(Game entity) throws StorageException {
        long id_winner = entity.getWinnerId();
        long score = entity.getScore();
        String sql = "INSERT INTO games (id_winner, score) VALUE (?, ?)";
        try (PreparedStatement statement = connectionSupplier.get().prepareStatement(sql)) {
            statement.setLong(1, id_winner);
            statement.setLong(2, score);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    public void addPlayerIntoGame(Game entity) throws StorageException{
        String sql = "INSERT INTO participants (id_games, id_players) VALUE (?, ?)";
        try(PreparedStatement statement = connectionSupplier.get().prepareStatement(sql)){
            for (Long aLong : entity.getPlayerIds()) {
                statement.setLong(1, entity.getId());
                statement.setLong(2, aLong);
                statement.executeUpdate();
            }
        }catch (SQLException e){
            throw new StorageException(e);
        }
    }


    @Override
    public  List<Game> list() throws StorageException {
        String sql = "SELECT id, id_winner, score, id_players " +
                "FROM games g INNER JOIN participants p on g.id = p.id_games;";
        try(PreparedStatement statement = connectionSupplier.get().prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            List<Game>  games = new LinkedList<>();
            Long currentId = null;
            List<Long> players = null;
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                if(!id.equals(currentId)){
                    currentId = id;
                    Long score = resultSet.getLong("score");
                    Long winner = resultSet.getLong("id_winner");
                    players = new LinkedList<>();
                    games.add(new Game(id, winner, score, players));
                }
                players.add(resultSet.getLong("id_players"));
            }
            return games;
        }catch (SQLException e){
            throw new StorageException(e);
        }
    }

    @Override
    public Game get(Long aLong) throws StorageException {
        String sql = "SELECT id, id_winner, score, id_players " +
                "FROM games g INNER JOIN participants p on g.id = p.id_games "+
                "WHERE id = ?";
        Game game = null;
        try(PreparedStatement statement = connectionSupplier.get().prepareStatement(sql)){
            statement.setLong(1, aLong);
            ResultSet resultSet = statement.executeQuery();
            List<Game>  games = new LinkedList<>();
            Long currentId = null;
            List<Long> players = null;
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                if(!id.equals(currentId)){
                    currentId = id;
                    Long score = resultSet.getLong("score");
                    Long winner = resultSet.getLong("id_winner");
                    players = new LinkedList<>();
                    game = new Game(id, winner, score, players);
                }
                players.add(resultSet.getLong("id_players"));
            }
            return game;
        }catch (SQLException e){
            throw new StorageException(e);
        }
    }

    @Override
    public void delete(Game entity) throws StorageException {
        String sql = "DELETE FROM participants WHERE id_players = ?";
        try (PreparedStatement statement = connectionSupplier.get().prepareStatement(sql)) {
            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
