package exams.februaryTwentySecond.guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayersList = new ArrayList<>();
        for (int i = 0; i < this.roster.size(); i++) {
            if(this.roster.get(i).getClazz().equals(clazz)) {
                kickedPlayersList.add(this.roster.get(i));
                this.roster.remove(i);
                i--;
            }
        }
        return kickedPlayersList.toArray(new Player[kickedPlayersList.size()]);
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (Player player : this.roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
