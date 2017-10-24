package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerManager implements IPlayerManager {
  
  
  private ArrayList<IPlayer> players;
  private int currentPlayer = 0;
  private Direction direction = Direction.COUNTERCLOCKWISE;
  private int nextPlayer = (currentPlayer + direction.getValue());
  
  public PlayerManager(ArrayList<IPlayer> buildPlayerList) {
    // TODO Auto-generated constructor stub
    players = buildPlayerList;
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return players.get(currentPlayer);
  }

  @Override
  public ArrayList<IPlayer> getPlayers() {
    // TODO Auto-generated method stub
    return players;
  }

  @Override
  public void invertDirection() {
    direction = (direction.getValue() == -1) ? Direction.COUNTERCLOCKWISE : Direction.CLOCKWISE;
    this.nextPlayer = (this.currentPlayer + direction.getValue()) % players.size();
    this.nextPlayer = this.nextPlayer < 0 ? this.nextPlayer + this.players.size() : this.nextPlayer;
  }

  @Override
  public void startTurn() {
    this.currentPlayer = this.nextPlayer;
    this.nextPlayer = (this.currentPlayer + direction.getValue()) % players.size();
    this.nextPlayer = this.nextPlayer < 0 ? this.nextPlayer + this.players.size() : this.nextPlayer;
  }

  @Override
  public void skipPlayer() {
    this.nextPlayer = (this.nextPlayer + direction.getValue()) % players.size();
    this.nextPlayer = this.nextPlayer < 0 ? this.nextPlayer + this.players.size() : this.nextPlayer;
  }
}
