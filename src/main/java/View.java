import model.Card;
import model.Player;

import java.util.List;

public class View {
    public void showAttackPhase(String playerName1, String playerName2, List<Card> cards) {
        System.out.println();
        System.out.println(playerName1 + " атакует, " + playerName2 + " защищается");
        showCards(cards);
        System.out.println(playerName1 + " выбирает карту");
    }

    public void showDefensePhase(String playerName, List<Card> cards){
        System.out.println();
        System.out.println(playerName + " защищается");
        showCards(cards);
        System.out.println(playerName + " выбирает карту");
    }

    public void showScore(String playerName1, String playerName2, int playerScore1, int playerScore2){
        System.out.println();
        System.out.println("Очки " + playerName1 + " : " + playerScore1);
        System.out.println("Очки " + playerName2 + " : " + playerScore2);
    }

    public void showMessage(String massage){
        System.out.println(massage);
    }

    public void showWinner(String winnerName){
        System.out.println("Победил : " + winnerName);
    }

    public void showPickedCard(Player player, Card card){
        System.out.println("Игрок " + player.getName() + " выбрал карту " + card.getValue());
        for (int i = 0; i < 24; i++) {
            System.out.println("*");
        }
    }

    public void showDefense(Player player, Card card){
        System.out.println("Игрок " + player.getName() + " выбрал карту " + card.getValue());
    }

    public void showWhoseTurn(){
        System.out.println("Кто будет ходить первым \n 1 - вы \n 2 - бот");
    }

    private void showCards(List<Card> cards){
        for (int i = 0; i < cards.size(); i++) {
            if (i < cards.size() - 1) {
                System.out.print(cards.get(i).getValue() + ", ");
            }
            else {
                System.out.print(cards.get(i).getValue());
            }
        }
        System.out.println();
    }
}
