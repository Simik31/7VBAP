package cz.osu.student.r19584.mvc.controllers;

import cz.osu.student.r19584.mvc.models.League;
import cz.osu.student.r19584.mvc.repositories.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @GetMapping("/league/id/{id}")
    public String getLeagueById(@PathVariable int id, Model model) {
        League league = repository.getLeagueById(id);
        model.addAttribute("league", league);
        return "league/id";
    }
}
