package model;

import java.util.ArrayList;
import java.util.List;
import consts.Phase;
import static consts.Phase.ATTACK;
import static consts.Phase.DEFENSE;


public class Bot extends Player{
    List<Card> opponentsUsedCards = new ArrayList<>();
    Phase phase;

    public Bot(Phase phase) {
        super("Bot");
        this.phase = phase;
    }

    @Override
    public Card pickCard() {
        if (phase == ATTACK){
            return calculateAttackCard();
        }
        else
            return calculateDefenseCard();
    }

    @Override
    public void attack(Card playersCard) {
        super.attack(playersCard);
        phase = DEFENSE;
    }

    @Override
    public void defense(Card playersCard, Card opponentsCard){
        if (playersCard.compareTo(opponentsCard) < 0)
            score += opponentsCard.getValue() - playersCard.getValue();
        removeCard(playersCard);
        phase = ATTACK;
    }

    public void addInfoAboutOpponent(Card opponentsDefenseCard){
        opponentsUsedCards.add(opponentsDefenseCard);
    }

    private Card calculateAttackCard(){
        if (opponentsUsedCards.size() > 3 && getAverageValueOfOpponentsCards() > getCardsLength() / 2 - 1) {
                return getCards().get(getCards().size() - 1);
        }
        else {
            return getCards().get(getCards().size() / 2);
        }
    }

    private Card calculateDefenseCard(){
        if (opponentsUsedCards.size() > 3 && getAverageValueOfOpponentsCards() > getCardsLength() / 2 - 1) {
                return getNumberLowerThanAverage();
        }
        else {
            return getCards().get(getCards().size() / 2);
        }
    }

    private Card getNumberLowerThanAverage(){
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getValue() > getCardsLength() / 4){
                if (i > 0) {
                    return getCards().get(i - 1);
                }
            }
        }
        return getCards().get(0);
    }

    private int getAverageValueOfOpponentsCards(){
        int sum = 0;
        for (Card opponentsUsedCard : opponentsUsedCards) {
            sum += opponentsUsedCard.getValue();
        }
        return sum;
    }

}
