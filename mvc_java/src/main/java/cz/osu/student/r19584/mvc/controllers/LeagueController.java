package cz.osu.student.r19584.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import cz.osu.student.r19584.mvc.models.League;
import cz.osu.student.r19584.mvc.repositories.Repository;

@Controller
public class LeagueController {

    @Autowired
    private Repository repository;

    @GetMapping("/league/list")
    public String getLeagueList(Model model) {
        List<League> listOfLeagues = repository.getAllLeagues();
        model.addAttribute("listOfLeagues", listOfLeagues);
        return "league/list";
    }

    @GetMapping("/league/{leagueId}")
    public String getLeagueById(@PathVariable int leagueId, Model model) {
        League league = repository.getLeagueById(leagueId);
        model.addAttribute("league", league);
        return "league/id";
    }

    @GetMapping("/league/addLeague")
    public String getAddLeague() {
        return "league/addLeague";
    }

    @PostMapping("/league/addLeague")
    public RedirectView postAddLeague(@RequestParam("title") String title) {
        repository.addLeague(new League(title));
        return new RedirectView("/league/list");
    }
}
