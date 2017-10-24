package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.NumericCard;
import model.card.type.Symbol;

public class NumericDeckFactory implements ICardDeckFactory {
  private ICardPile deck = new CardPile();
  private Symbol[] symbols = Symbol.getNumeric();
  private Color[] colors = Color.getColors();
  @Override
  public ICardPile createDeck() {
    // TODO Auto-generated method stub
    for (Color c : colors) {
      for (int i = 1; i< symbols.length; i++) {
        deck.pushCard(new NumericCard(c, symbols[i]));
        deck.pushCard(new NumericCard(c, symbols[i]));
      }
      
      deck.pushCard(new NumericCard(c, symbols[0]));
      
    }
    deck.shuffle();
    return deck;
  }

}
