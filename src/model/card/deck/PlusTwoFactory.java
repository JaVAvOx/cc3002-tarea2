package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.PlusTwoCard;

public class PlusTwoFactory implements ICardDeckFactory {
  private ICardPile deck = new CardPile();
  private Color[] colors = Color.getColors();

  @Override
  public ICardPile createDeck() {
    // TODO Auto-generated method stub
    for (Color c : colors) {
      deck.pushCard(new PlusTwoCard(c));
      deck.pushCard(new PlusTwoCard(c));

    }
    return deck;
  }

}
