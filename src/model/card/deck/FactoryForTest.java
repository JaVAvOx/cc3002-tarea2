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

/**
 * Factory for cards and deck creation (for testing).
 * @author jgomez
 */

public class FactoryForTest implements ICardDeckFactory {

  /** The deck. */
  ICardPile deck = new CardPile();

  /**
   * Adds a NumericCard to deck.
   *
   * @param c the color
   * @param s the symbol
   */
  public void addNumCard(Color c, Symbol s) {
    deck.pushCard(new NumericCard(c, s));
  }

  /**
   * Adds a InvertCard to deck.
   *
   * @param c the color
   */
  public void addInvertcard(Color c) {
    deck.pushCard(new InvertCard(c));
  }

  /**
   * Adds a SkipCard to deck
   *
   * @param c the color
   */
  public void addSkipCard(Color c) {
    deck.pushCard(new SkipCard(c));
  }

  /**
   * Adds a PlusTwoCard to deck.
   *
   * @param c the color
   */
  public void addPlusTwoCard(Color c) {
    deck.pushCard(new PlusTwoCard(c));
  }

  /**
   * Adds a WildColor to deck.
   */
  public void addWildColor() {
    deck.pushCard(new WildColor());
  }

  /**
   * Adds a WildDrawFourCard to deck.
   */
  public void addWildFour() {
    deck.pushCard(new WildDrawFourCard());
  }


  @Override
  public ICardPile createDeck() {
    return deck;
  }

}
