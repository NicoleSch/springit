package com.vega.springit.controller;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LinkController {

  private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

  private LinkRepository linkRepository;

  public LinkController(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  @GetMapping("/")
  public String list(Model model) {
    model.addAttribute("links", linkRepository.findAll());
    return "link/list";
  }

  @GetMapping("link/{id}")
  public String read(@PathVariable Long id, Model model) {
    Optional<Link> link = linkRepository.findById(id);
    if (link.isPresent()) {
      model.addAttribute("link", link.get());
      model.addAttribute("success", model.containsAttribute("success"));
      return "link/view";
    } else {
      return "redirect:/";
    }
  }

  @GetMapping("link/submit")
  public String newLinkForm(Model model) {
    model.addAttribute("link", new Link());
    return "link/submit";
  }

  @PostMapping("link/submit")
  public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      logger.info("Validation errors were found while submitting a new link.");
      model.addAttribute("link", link);
      return "link/submit";
    } else {
      logger.info("Link saved.");
      linkRepository.save(link);
      redirectAttributes
          .addAttribute("id", link.getId())
          .addFlashAttribute("success", true);
      return "redirect:/link/{id}";
    }
  }

}
