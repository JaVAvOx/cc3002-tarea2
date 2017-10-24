package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;

public class FullDeckStrategy implements IDeckStrategy {

  ICardPile deck = new CardPile();

  private NumericDeckFactory numFactory = new NumericDeckFactory();
  private PlusTwoFactory plusTwoFactory = new PlusTwoFactory();
  private SkipFactory skipFactory = new SkipFactory();
  private InvertFactory invertFactory = new InvertFactory();
  private WildColorFactory wildColorFactory = new WildColorFactory();
  private WildDrawFourFactory drawFourFactory = new WildDrawFourFactory();


  @Override
  public ICardPile createDeck() {
    deck.pushCards(numFactory.createDeck());
    deck.pushCards(plusTwoFactory.createDeck());
    deck.pushCards(skipFactory.createDeck());
    deck.pushCards(invertFactory.createDeck());
    deck.pushCards(wildColorFactory.createDeck());
    deck.pushCards(drawFourFactory.createDeck());

    deck.shuffle();
    return deck;
  }

}
