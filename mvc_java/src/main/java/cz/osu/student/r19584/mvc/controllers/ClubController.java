package cz.osu.student.r19584.mvc.controllers;

import cz.osu.student.r19584.mvc.models.Club;
import cz.osu.student.r19584.mvc.models.League;
import cz.osu.student.r19584.mvc.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ClubController {

    @Autowired
    private Repository repository;

    @GetMapping("/club/addClub/{leagueId}")
    public String getRegisterClubForm(@PathVariable int leagueId, Model model) {
        League league = repository.getLeagueById(leagueId);
        model.addAttribute("league", league);
        return "club/addClub";
    }

    @PostMapping("/club/addClub")
    public RedirectView postAddClub(
            @RequestParam("leagueId") String leagueId,
            @RequestParam("title") String title,
            @RequestParam("city") String city
    ) {
        repository.getLeagueById(Integer.parseInt(leagueId)).addClub(new Club(title, city));
        return new RedirectView("/league/list");
    }
}
