package edu.stanford.protege.webprotegeoptout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-02-11
 */
@Controller
@RequestMapping("/opt-out")
public class OptOutController {

    private final OptOutDataRepository repository;

    @Autowired
    public OptOutController(OptOutDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/{id}")
    public String projects(Model model, @PathVariable(name = "id") String id) {
        var outInfoQueryResult = repository.findById(id);

        // If we cannot find the record with the id then return a 404 response
        var optOutInfo = outInfoQueryResult.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        updateViewedAtDateTime(repository, optOutInfo);

        sortProjectList(optOutInfo);

        model.addAttribute("optOutInfo", optOutInfo);
        return "optout";
    }

    @PostMapping("/users/{id}")
    public String optoutSubmit(@PathVariable(name = "id") String id, OptOutInfo optOutInfo) {
        if(!optOutInfo.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ids do not match");
        }
        repository.save(optOutInfo);
        return "redirect:" + id + "/confirmation";
    }
    
    @GetMapping("/users/{id}/confirmation")
    public String confirmation() {
        return "confirmation";
    }


    @GetMapping("/details")
    public String optoutDetails() {
        // Forwarding to static page
        return "forward:/opt-out/details/index.html";
    }

    private static void sortProjectList(OptOutInfo optOutInfo) {
        var projectInfoComparator = Comparator.comparing(ProjectInfo::getModifiedAt).reversed();
        optOutInfo.getProjects().sort(projectInfoComparator);
    }

    private static void updateViewedAtDateTime(OptOutDataRepository repository, OptOutInfo optOutInfo) {
        optOutInfo.setViewedAt(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()));
        repository.save(optOutInfo);
    }
}
