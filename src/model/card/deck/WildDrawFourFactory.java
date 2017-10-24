package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.WildDrawFourCard;

public class WildDrawFourFactory implements ICardDeckFactory {

  private ICardPile deck = new CardPile();

  @Override
  public ICardPile createDeck() {
    // TODO Auto-generated method stub
    for (int i = 0; i<4;i++) {
      deck.pushCard(new WildDrawFourCard());
      
    }
    return deck;
  }

}
