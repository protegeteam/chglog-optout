package edu.stanford.protege.webprotegeoptout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class OptOutController {

    private final OptOutDataRepository repository;

    @Autowired
    public OptOutController(OptOutDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/opt-out/users/{id}")
    public String projects(Model model, @PathVariable(name = "id") String id) {
        var outInfoQueryResult = repository.findById(id);
        // If we cannot find the record with the id then return a 404 response
        var optOutInfo = outInfoQueryResult.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        updateViewedAtDateTime(optOutInfo);

        var projectInfoComparator = Comparator.comparing(ProjectInfo::getModifiedAt).reversed();
        optOutInfo.getProjects().sort(projectInfoComparator);

        model.addAttribute("optOutInfo", optOutInfo);
        return "optout";
    }

    @GetMapping("/opt-out/confirmation")
    public String confirmation() {
        return "confirmation";
    }

    private void updateViewedAtDateTime(OptOutInfo optOutInfo) {
        optOutInfo.setViewedAt(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()));
        repository.save(optOutInfo);
    }

    @PostMapping("/opt-out")
    public String optoutSubmit(OptOutInfo optOutInfo) {
        repository.save(optOutInfo);
        return "redirect:/opt-out/confirmation";
    }
}
