package GUI5_HW;

import java.util.Random;

interface IGamer {
    int play();
    String name();
}

class RockPlayer implements IGamer {
    @Override
    public int play() {
        return 0; // Always Rock
    }

    @Override
    public String name() {
        return "Rock Player";
    }
}

class PaperPlayer implements IGamer {
    @Override
    public int play() {
        return 1; // Always Paper
    }

    @Override
    public String name() {
        return "Paper Player";
    }
}

class ScissorsPlayer implements IGamer {
    @Override
    public int play() {
        return 2; // Always Scissors
    }

    @Override
    public String name() {
        return "Scissors Player";
    }
}

class RandomPlayer implements IGamer {
    private final Random random = new Random();

    @Override
    public int play() {
        return random.nextInt(3);
    }

    @Override
    public String name() {
        return "Random Player";
    }
}

class SmartPlayer implements IGamer {
    private int lastMove = -1;
    private int opponentLastMove = -1;

    @Override
    public int play() {
        if (opponentLastMove == -1) {
            Random random = new Random();
            lastMove = random.nextInt(3);
            return lastMove;
        } else {
            if (opponentLastMove == 0) {
                lastMove = 1;
            } else if (opponentLastMove == 1) {
                lastMove = 2;
            } else {
                lastMove = 0;
            }
            return lastMove;
        }
    }

    public void updateOpponentMove(int move) {
        this.opponentLastMove = move;
    }

    @Override
    public String name() {
        return "Smart Player";
    }
}

class Arena {
    private final IGamer player1;
    private final IGamer player2;
    private int scorePlayer1;
    private int scorePlayer2;

    public Arena(IGamer player1, IGamer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public void fight(int numberOfRounds) {
        System.out.println("\n--- Fight between " + player1.name() + " and " + player2.name() + " ---");
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("\nRound " + round + ":");
            int move1 = player1.play();
            int move2 = player2.play();

            if (player1 instanceof SmartPlayer) {
                ((SmartPlayer) player1).updateOpponentMove(move2);
            }
            if (player2 instanceof SmartPlayer) {
                ((SmartPlayer) player2).updateOpponentMove(move1);
            }

            String move1Str = getMoveName(move1);
            String move2Str = getMoveName(move2);
            System.out.println(player1.name() + " plays: " + move1Str);
            System.out.println(player2.name() + " plays: " + move2Str);

            int winner = determineWinner(move1, move2);
            if (winner == 1) {
                System.out.println(player1.name() + " wins the round!");
                scorePlayer1++;
            } else if (winner == 2) {
                System.out.println(player2.name() + " wins the round!");
                scorePlayer2++;
            } else {
                System.out.println("It's a tie!");
            }
        }

        System.out.println("\n--- Fight Result ---");
        System.out.println(player1.name() + " Score: " + scorePlayer1);
        System.out.println(player2.name() + " Score: " + scorePlayer2);

        if (scorePlayer1 > scorePlayer2) {
            System.out.println(player1.name() + " is the overall winner!");
        } else if (scorePlayer2 > scorePlayer1) {
            System.out.println(player2.name() + " is the overall winner!");
        } else {
            System.out.println("The fight is a draw!");
        }
    }

    private String getMoveName(int move) {
        return switch (move) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            case 2 -> "Scissors";
            default -> "Invalid";
        };
    }

    private int determineWinner(int move1, int move2) {
        if (move1 == move2) {
            return 0; // Tie
        } else if ((move1 == 0 && move2 == 2) || // Rock beats Scissors
                (move1 == 1 && move2 == 0) || // Paper beats Rock
                (move1 == 2 && move2 == 1)) { // Scissors beats Paper
            return 1; // Player 1 wins
        } else {
            return 2; // Player 2 wins
        }
    }
}

class Tournament {
    private final IGamer[] players;

    public Tournament(IGamer[] players) {
        this.players = players;
    }

    public void runTournament(int numberOfRounds) {
        System.out.println("\n--- Rock Paper Scissors Tournament ---");
        int numPlayers = players.length;
        if (numPlayers < 2) {
            System.out.println("Not enough players for a tournament.");
            return;
        }
        for (int i = 0; i < numPlayers; i++) {
            for (int j = i + 1; j < numPlayers; j++) {
                Arena arena = new Arena(players[i], players[j]);
                arena.fight(numberOfRounds);
                System.out.println("----------------------------------------");
            }
        }
        System.out.println("--- Tournament Finished ---");
    }
}

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        IGamer rockPlayer = new RockPlayer();
        IGamer paperPlayer = new PaperPlayer();
        IGamer scissorsPlayer = new ScissorsPlayer();
        IGamer randomPlayer = new RandomPlayer();
        IGamer smartPlayer = new SmartPlayer();

        Arena arena1 = new Arena(rockPlayer, paperPlayer);
        arena1.fight(5);

        Arena arena2 = new Arena(randomPlayer, smartPlayer);
        arena2.fight(7);

        IGamer[] participants = {rockPlayer, paperPlayer, scissorsPlayer, randomPlayer, smartPlayer};
        Tournament tournament = new Tournament(participants);
        tournament.runTournament(3);
    }
}
