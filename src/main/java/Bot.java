public class Bot extends Player{
    public Bot() {
        super("Bot");
    }

    @Override
    public int pickCard() {
        return getCards().get(0);
    }
}
