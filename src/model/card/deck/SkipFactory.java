package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.SkipCard;

public class SkipFactory implements ICardDeckFactory {
  private ICardPile deck = new CardPile();
  private Color[] colors = Color.getColors();
  @Override
  public ICardPile createDeck() {
    // TODO Auto-generated method stub
    for (Color c : colors) {
      deck.pushCard(new SkipCard(c));
      deck.pushCard(new SkipCard(c));
      
    }
    return deck;
  }

}
