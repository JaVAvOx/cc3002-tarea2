package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Symbol;

public class DeckForTestStrategy implements IDeckStrategy {

  ICardPile deck = new CardPile();

  private FactoryForTest factory = new FactoryForTest();

  @Override
  public ICardPile createDeck() {
    // Podemos agregar cartas de a una
    factory.addNumCard(Color.BLUE, Symbol.FIVE);
    factory.addInvertcard(Color.RED);
    factory.addPlusTwoCard(Color.YELLOW);
    factory.addSkipCard(Color.RED);
    factory.addWildColor();
    factory.addWildFour();

    deck.pushCards(factory.createDeck());
    deck.shuffle();
    return deck;
  }

}
