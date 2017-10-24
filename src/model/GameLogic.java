package model;

import java.util.ArrayList;

import controller.IController;
import model.card.CardPilesManager;
import model.card.deck.FullDeckStrategy;
import model.card.type.ICard;
import model.player.IPlayerListBuilder;
import model.player.PlayerManager;
import model.player.type.IPlayer;

public class GameLogic implements IGameLogic{
  
  private PlayerManager plyrmngr;
  private CardPilesManager pilemgr = new CardPilesManager(new FullDeckStrategy());
  private int well;
  
  
  public GameLogic(IPlayerListBuilder playerBuilder) {
    this.well = 0;
    this.plyrmngr = new PlayerManager(playerBuilder.buildPlayerList());
    for (IPlayer player : this.plyrmngr.getPlayers()) {
      this.pilemgr.addCardsToPlayer(player, 7);
    }
  }

  @Override
  public boolean hasEnded() {
    return this.getCurrentPlayer().hasWon();
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return plyrmngr.getCurrentPlayer();
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return pilemgr.getCurrentPlayedCard();
  }

  @Override
  public void autoShoutUNO(IController ctrl) {
    if (!this.getCurrentPlayer().hasSaidUNO() && this.getCurrentPlayer().hasOneCard()) {
      this.getCurrentPlayer().setSaidUNO(true);
      ctrl.showMessage(this.getCurrentPlayer().toString() + " grita UNO!");
    }
  }

  @Override
  public void startTurn(IController ctrl) {
    this.autoShoutUNO(ctrl);
    if (!this.isDrawWellEmpty()) {
      plyrmngr.startTurn();
      this.drawCardsFromWell(this.getCurrentPlayer(), ctrl);
      this.resetDrawWell();
    }
    plyrmngr.startTurn();
  }

  @Override
  public void skipPlayer() {
    plyrmngr.skipPlayer();
  }

  @Override
  public void addToDrawWell(int number) {
    well += number;
    
  }

  @Override
  public void resetDrawWell() {
    well = 0;
    
  }

  @Override
  public boolean isDrawWellEmpty() {
    return well == 0;
  }

  @Override
  public void drawCardsFromWell(IPlayer player, IController ctrl) {
    pilemgr.addCardsToPlayer(player, well);
    ctrl.showMessage(this.getCurrentPlayer() + " roba " + well + " cartas.");
    
    
  }

  @Override
  public void invertDirection() {
    plyrmngr.invertDirection();
  }

  @Override
  public boolean playCard(ICard playedCard, IController ctrl) {
    if (!playedCard.isDiscardable()) {
      return true;
    }
    if (!playedCard.isPlayableOver(pilemgr.getCurrentPlayedCard())) {
      ctrl.showMessage("No puedes jugar esa carta! Elige otra:");
      return false;
    }
    pilemgr.discard(playedCard);
    playedCard.executeAction(this, ctrl);
    this.getCurrentPlayer().removeCardFromHand(playedCard);
    return true;
  }

  @Override
  public ICard drawOneCard(IPlayer player) {
    ICard a = pilemgr.drawCard();
    ArrayList<ICard> b = new ArrayList<ICard>();
    b.add(a);
    player.addToHand(b);
    return a;
  }

  @Override
  public void announceWinner(IController ctrl) {
    if (this.getCurrentPlayer().hasWon()) {
      ctrl.showMessage(this.getCurrentPlayer() + " ha ganado!");
    }
    
  }

}
