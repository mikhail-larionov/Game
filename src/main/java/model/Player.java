package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    private final List<Card> cards = initCards();
    int score = 0;

    public int getCardsLength() {
        return cardsLength;
    }

    private final int cardsLength = 12;
    private String name;
    public Player(String name) {
        this.name = name;
    }
    public Player() {

    }

    private List<Card> initCards(){
        List<Card> currCardsArray = new ArrayList<>();
        for (int i = 0; i < cardsLength; i++) {
            currCardsArray.add(new Card(i));
        }
        return currCardsArray;
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void attack(Card playersCard){
        removeCard(playersCard);
    }

    public void defense(Card playersCard, Card opponentsCard){
        if (playersCard.compareTo(opponentsCard) < 0) score += opponentsCard.getValue() - playersCard.getValue();
        removeCard(playersCard);
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Card pickCard();
}
