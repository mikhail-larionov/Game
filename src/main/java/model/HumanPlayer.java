package model;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer() {

    }

    @Override
    public Card pickCard(){
        Scanner scanner = new Scanner(System.in);
        Card card = new Card(scanner.nextInt());

        if (!checkCardAvailability(card, getCards())){
                throw new IllegalArgumentException();
            }
        return card;
    }

    private boolean checkCardAvailability(Card card, List<Card> cards){
        return cards.contains(card);
    }

}
