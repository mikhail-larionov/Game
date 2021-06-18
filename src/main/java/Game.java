import java.util.InputMismatchException;

public class Game {
    private final Player player1 = new HumanPlayer("Misha");
    private final Player player2 = new Bot();
    private final View view = new View();

    boolean gameStatement = true;
    private boolean playerAttack = true;
    public void startGame(){
        while (gameStatement){
            if (player1.getCards().size() == 1){
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
        String winnerName = (player1.getScore() < player2.getScore() ? player1.getName() : player2.getName());
        view.showWinner(winnerName);
    }

    private void makeMove(Player player1, Player player2){
        view.showAttackPhase(player1.getName(), player2.getName(), player1.getCards());
        int attackCard = pickCard(player1);
        view.showPickedCard(player1, attackCard);
        player1.attack(attackCard);
        view.showDefensePhase(player2.getName(), player2.getCards());
        int defenseCard = pickCard(player2);
        view.showPickedCard(player2, defenseCard);
        player2.defense(defenseCard, attackCard);
        view.showScore(player1.getName(), player2.getName(), player1.getScore(), player2.getScore());
    }

    private int pickCard(Player player){
        int card;
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
}

