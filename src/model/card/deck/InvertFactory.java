package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.InvertCard;

public class InvertFactory implements ICardDeckFactory {
  private ICardPile deck = new CardPile();
  private Color[] colors = Color.getColors();
  @Override
  public ICardPile createDeck() {
    // TODO Auto-generated method stub
    for (Color c : colors) {
      deck.pushCard(new InvertCard(c));
      deck.pushCard(new InvertCard(c));
      
    }
    return deck;
  }

}
