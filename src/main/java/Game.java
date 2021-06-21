import consts.Phase;
import model.Bot;
import model.Card;
import model.HumanPlayer;
import model.Player;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Phase phase = Phase.DEFENSE;
    private final Player player1 = new HumanPlayer();
    private final Player player2 = new Bot(phase);
    private final View view = new View();
    boolean gameStatement = true;
    private boolean playerAttack = true;
    Scanner scanner = new Scanner(System.in);

    public void startGame(){
        while (gameStatement){
            if (player1.getCards().size() == 1 || player2.getCards().size() == 1){
                gameStatement = false;
            }
            if (playerAttack){
                makeMove(player1, player2);
                playerAttack = false;
            }
            else {
                makeMove(player2, player1);
                playerAttack = true;
            }
        }
        String winnerName;
        if (player1.getScore() > player2.getScore()) {
            winnerName = player2.getName();
        }
        else if (player1.getScore() < player2.getScore())
            winnerName = player1.getName();
        else {
            winnerName = "Ничья!";
        }
        view.showWinner(winnerName);
    }

    private void makeMove(Player player1, Player player2){
        view.showAttackPhase(player1.getName(), player2.getName(), player1.getCards());
        phase = Phase.ATTACK;
        Card attackCard = pickCard(player1);
        view.showPickedCard(player1, attackCard);
        player1.attack(attackCard);
        view.showDefensePhase(player2.getName(), player2.getCards());
        phase = Phase.DEFENSE;
        if (player2 instanceof Bot){
            ((Bot) player2).addInfoAboutOpponent(attackCard);
        }
        Card defenseCard = pickCard(player2);
        view.showDefense(player2, defenseCard);
        player2.defense(defenseCard, attackCard);
        if (player1 instanceof Bot){
            ((Bot) player1).addInfoAboutOpponent(defenseCard);
        }
        view.showScore(player1.getName(), player2.getName(), player1.getScore(), player2.getScore());
        view.showMessage("Нажмите enter чтобы продолжить....");
        if (player2.getCards().size() > 0) {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Card pickCard(Player player){
        Card card;
        try {
             card = player.pickCard();
        }
        catch (IllegalArgumentException e){
            view.showMessage("Выбрана неправильная карта, попробуйте еще раз");
            return pickCard(player);
        }
        catch (InputMismatchException e){
            view.showMessage("Введен некорректный символ, попробуйте еще раз");
            return pickCard(player);
        }
        return card;
    }

    public void initGame() {
        view.showMessage("Введите ваше имя");
        player1.setName(scanner.nextLine());
        view.showWhoseTurn();
        while (true) {
            int turn = scanner.nextInt();
            if (turn == 2) {
                phase = Phase.ATTACK;
                playerAttack = false;
                break;
            }
            else if (turn == 1){
                break;
            }
            view.showMessage("Введено некорректное значение попробуйте еще раз");
        }
    }
}

