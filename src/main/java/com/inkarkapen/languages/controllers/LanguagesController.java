package com.inkarkapen.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inkarkapen.languages.models.Language;
import com.inkarkapen.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService langService;
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	@RequestMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("language", new Language());
		List<Language> languages = langService.showAll();
		model.addAttribute("languages", languages);
		return "dashboard.jsp";
	}
	@RequestMapping("/{id}")
	public String findLanguage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", langService.findOneLang(id));
		model.addAttribute("id", id);
		return "showLang.jsp";
	}
	
	@PostMapping("/new")
	public String newLang(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(!result.hasErrors()) {
			langService.addLang(language);
			return "redirect:/";
		}
		return "dashboard.jsp";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		langService.deleteLang(id);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = langService.findOneLang(id);
		if(language != null) {
			model.addAttribute("language", language);
			model.addAttribute("id", id);
			return "edit.jsp";
		}
		return "redirect:/";
	}
	@PostMapping("/edit/{id}")
	public String editLang(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()){
			return "edit.jsp";
		}
		langService.updateLang(language);
		return "redirect:/";
	}
}
