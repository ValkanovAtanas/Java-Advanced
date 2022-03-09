package exams.februaryTwentySecond.guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > 0) {
            this.roster.add(player);
            this.capacity--;
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (!player.getRank().equals("Member")) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (!player.getRank().equals("Trial")) {
                player.setRank("Trial");
            }
        }
    }

//    public Player[] kickPlayerByClass (String clazz) {
//        Player[] kickedPlayersArray;
//    }
}
