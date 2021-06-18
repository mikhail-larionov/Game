import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int pickCard(){
        Scanner scanner = new Scanner(System.in);
        int card = scanner.nextInt();

        if (!checkCardAvailability(card, getCards())){
                throw new IllegalArgumentException();
            }
        return card;
    }
    private boolean checkCardAvailability(int card, List<Integer> cards){
        return cards.contains(card);
    }

}
