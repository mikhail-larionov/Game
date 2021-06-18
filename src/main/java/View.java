import java.util.List;

public class View {
    public void showAttackPhase(String playerName1, String playerName2, List<Integer> cards) {
        System.out.println();
        System.out.println(playerName1 + " атакует, " + playerName2 + " защищается");
        System.out.println(cards);
        System.out.println(playerName1 + " выбирает карту");
    }
    public void showDefensePhase(String playerName, List<Integer> cards){
        System.out.println();
        System.out.println(playerName + " защищается");
        System.out.println(cards);
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
    public void showPickedCard(Player player, int card){
        System.out.println("Игрок " + player.getName() + " выбрал карту " + card);
    }
}
