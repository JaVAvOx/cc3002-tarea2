package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerListBuilder implements IPlayerListBuilder {
  private ArrayList<IPlayer> players;

  public PlayerListBuilder() {
    players = new ArrayList<IPlayer>();
  }

  @Override
  public void addPlayer(IPlayer player) {
    players.add(player);

  }

  @Override
  public ArrayList<IPlayer> buildPlayerList() {
    return this.players;
  }

}
