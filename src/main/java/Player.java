import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    private final List<Integer> cards = initCards();
    private int score = 0;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    private List<Integer> initCards(){
        List<Integer> currCardsArray = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            currCardsArray.add(i);
        }
        return currCardsArray;
    }

    public void removeCard(int card){
        cards.remove((Integer) card);
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void attack(int playersCard){
        removeCard(playersCard);
    }

    public void defense(int playersCard, int opponentsCard){
        if (playersCard < opponentsCard) score += opponentsCard - playersCard;
        removeCard(playersCard);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public abstract int pickCard();
}
