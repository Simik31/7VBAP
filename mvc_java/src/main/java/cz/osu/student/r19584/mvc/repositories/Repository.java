package cz.osu.student.r19584.mvc.repositories;

import cz.osu.student.r19584.mvc.models.Club;
import cz.osu.student.r19584.mvc.models.League;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repository {
    private static final List<League> leagues = new ArrayList<>();

    static {
        leagues.add(new League("Extraliga 21/22"));
        leagues.get(0).addClub(new Club("Oceláři", "Třinec"));
        leagues.get(0).addClub(new Club("Sparta", "Praha"));
        leagues.get(0).addClub(new Club("Kometa", "Brno"));

        leagues.add(new League("NHL"));
        leagues.get(1).addClub(new Club("Capitals", "Washington "));
        leagues.get(1).addClub(new Club("Penguin", "Pittsburgh "));
    }

    public List<League> getAllLeagues() {
        return new ArrayList<>(leagues);
    }

    public League getLeagueById(int leagueId) {
        return leagues.stream()
                .filter(league -> league.getId() == leagueId)
                .findFirst()
                .get();
    }

    public void addClubToLeague(int leagueId, Club club) {
        leagues.stream()
                .filter(league -> league.getId() == leagueId)
                .findFirst()
                .get()
                .addClub(club);
    }
}
