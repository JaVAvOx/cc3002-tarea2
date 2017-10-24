package model.card.deck;


import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Symbol;
import model.card.type.WildColor;
import model.card.type.WildDrawFourCard;
import model.card.type.Color;
import model.card.type.InvertCard;
import model.card.type.NumericCard;
import model.card.type.PlusTwoCard;
import model.card.type.SkipCard;

public class FactoryForTest implements ICardDeckFactory {

  ICardPile deck = new CardPile();

  public void addNumCard(Color c, Symbol s) {
    deck.pushCard(new NumericCard(c, s));
  }

  public void addInvertcard(Color c) {
    deck.pushCard(new InvertCard(c));
  }

  public void addSkipCard(Color c) {
    deck.pushCard(new SkipCard(c));
  }

  public void addPlusTwoCard(Color c) {
    deck.pushCard(new PlusTwoCard(c));
  }

  public void addWildColor() {
    deck.pushCard(new WildColor());
  }

  public void addWildFour() {
    deck.pushCard(new WildDrawFourCard());
  }

  @Override
  public ICardPile createDeck() {
    return deck;
  }

}
