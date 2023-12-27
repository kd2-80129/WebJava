package doas;

import pojos.Player;

public interface PlayerDao {
	void addNewPlayer(Player newPlayer, Integer teamId);
}
