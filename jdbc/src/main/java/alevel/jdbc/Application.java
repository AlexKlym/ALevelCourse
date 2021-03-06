package alevel.jdbc;

import alevel.jdbc.common.SingleConnectionPool;
import alevel.jdbc.common.StorageException;
import alevel.jdbc.game.Game;
import alevel.jdbc.game.GameRepository;
import alevel.jdbc.player.Player;
import alevel.jdbc.player.PlayerRepository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Supplier;

public final class Application {
    public static void main(String[] args) {
        Properties connectionProps = new Properties();

        try (InputStream props = Application.class.getResourceAsStream("/datasource.properties")) {
            connectionProps.load(props);
        } catch (IOException e) {
            panic(e);
        }

        String url = connectionProps.getProperty("url");
        try (Connection connection = DriverManager.getConnection(url, connectionProps)) {

            Supplier<Connection> connectionSupplier = new SingleConnectionPool(connection);
            PlayerRepository playerRepository = new PlayerRepository(connectionSupplier);
            GameRepository gameRepository = new GameRepository(connectionSupplier);

            Scanner scanner;
            String command;
            String commandList = "Commands: " +
                    "\npa  - add players" +
                    "\npls - list players" +
                    "\nga  - add games" +
                    "\ngls - list games" +
                    "\nq   - exit";
            System.out.println(commandList);
            while (true) {
                scanner = new Scanner(System.in);
                System.out.print("> ");
                command = scanner.next().trim().toLowerCase();

                if ("pa".equals(command)) {
                    scanner = new Scanner(System.in);
                    System.out.println("enter player name: ");
                    String name = scanner.nextLine();
                    Player player = new Player(name);
                    playerRepository.save(player);
                } else if ("pls".equals(command)) {
                    for (Player player : playerRepository.list()) {
                        System.out.printf("%d: name = %s; score = %d; rank = %s\n",
                                player.getId(), player.getNickname(), player.getScore(), player.getRank());
                    }
                } else if ("ga".equals(command)) {
                    scanner = new Scanner(System.in);
                    System.out.println("Enter number of participants: ");
                    int partNumber = scanner.nextInt();
                    System.out.println("Enter participants ids: ");
                    List<Long> players = new ArrayList<>(partNumber);
                    for (int i = 0; i < partNumber; i++) {
                        players.add(scanner.nextLong());
                    }
                    System.out.println("Enter winner id: ");
                    Long winnerId = scanner.nextLong();
                    System.out.println("Enter score: ");
                    Long score = scanner.nextLong();

                    gameRepository.save(new Game(null, winnerId, score, players));

                } else if ("gls".equals(command)) {
                    for (Game game : gameRepository.list()) {
                        String gameString = String.valueOf(game.getId()) + ": " +
                                "winner = " +
                                game.getWinnerId() +
                                "; score = " +
                                game.getScore() +
                                "; participants = " +
                                game.getPlayerIds();
                        System.out.println(gameString);
                    }
                } else if ("q".equals(command)) {
                    System.out.println("bye!");
                    break;
                } else {
                    System.out.println(commandList);
                }

            }
        } catch (SQLException | StorageException e) {
            panic(e);
        }
    }

    private static void panic(Throwable e) {
        e.printStackTrace();
        System.exit(1);
    }
}





        /*    try (InputStream props = Application.class.getResourceAsStream("/datasource.properties")) {
            connectionProps.load(props);
        } catch (IOException e) {
            panic(e);
        }




        String url = connectionProps.getProperty("url");
        try (Connection connection = DriverManager.getConnection(url, connectionProps)) {
            Supplier<Connection> connectionSupplier = new SingleConnectionPool(connection);
            GameRepository gameRepository = new GameRepository(connectionSupplier);

            Game game = gameRepository.get(4L);
            System.out.println("{game id: " + game.getId() + " winner id: " + game.getWinnerId() + " score: " +
                    game.getScore() + " participants: " + game.getPlayerIds());


            for (Game game : gameRepository.list()) {
                System.out.println("{game id: " + game.getId() + " winner id: " + game.getWinnerId() + " score: " +
                        game.getScore() + " participants: " + game.getPlayerIds());

            }
            PlayerRepository playerRepository = new PlayerRepository(connectionSupplier);
            for (String playerName : inputPlayerNames()) {
                playerRepository.save(new Player(playerName));
            }
            for (Player player : playerRepository.list()) {
                System.out.println(player);
            }

        } catch (SQLException | StorageException e) {
            panic(e);
        }
    }

    private static List<String> inputPlayerNames() {
        System.out.println("Input player names:");
        Scanner scanner = new Scanner(System.in);
        List<String> names = new LinkedList<>();
        String name;
        while (!(name = scanner.nextLine()).isEmpty()) {
            names.add(name);
        }
        return names;
    }


    public static void panic(Throwable e) {
        e.printStackTrace();
        System.exit(1);
    }
}
*/