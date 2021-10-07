package cz.osu.student.r19584.mvc.models;

import java.util.ArrayList;
import java.util.List;

public class League {
    private static int next_id = 0;

    private final int id;
    private final String title;
    private final List<Club> clubs;

    public League(String title) {
        this.id = next_id++;
        this.title = title;
        this.clubs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void addClub(Club club) {
        clubs.add(club);
    }
}
