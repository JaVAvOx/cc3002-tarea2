package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.type.ICard;

public class CardPile implements ICardPile {

  private Stack<ICard> stack = new Stack<ICard>();

  @Override
  public int getSize() {
    return stack.size();
  }

  @Override
  public ICard pushCard(ICard newCard) {
    return stack.push(newCard);
  }

  @Override
  public ICard popCard() {
    return stack.pop();
  }

  @Override
  public ICard peekCard() {
    return stack.peek();
  }

  @Override
  public void shuffle() {
    Collections.shuffle(stack);
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public void pushCards(ICardPile otherPile) {
    // TODO Auto-generated method stub
    while (!otherPile.isEmpty()) {
      this.pushCard(otherPile.popCard());
    }

  }

}
