
package org.example.spring6.controller;

import org.example.spring6.dto.ClubActivityRequest;
import org.example.spring6.service.ClubActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/activities")
public class ClubActivityWebController {

    private final ClubActivityService service;

    public ClubActivityWebController(ClubActivityService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("activities", service.findAll());
        return "activities/list";
    }

    // 활동 등록 화면
    @GetMapping("/new")
    public String form() {
        return "activities/form";
    }

    // 활동 등록 처리
    @PostMapping
    public String create(@ModelAttribute ClubActivityRequest request) {
        service.create(request);
        return "redirect:/activities";
    }
}
