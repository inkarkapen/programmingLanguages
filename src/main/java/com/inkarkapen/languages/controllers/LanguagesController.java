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
	@RequestMapping("/{index}")
	public String findLanguage(Model model, @PathVariable("index") int index) {
		model.addAttribute("language", langService.findOneLang(index));
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
	@RequestMapping("/delete/{index}")
	public String delete(@PathVariable("index") int index) {
		langService.deleteLang(index);
		return "redirect:/";
	}
	@RequestMapping("/edit/{index}")
	public String edit(@PathVariable("index") int index, Model model) {
		Language language = langService.findOneLang(index);
		if(language != null) {
			model.addAttribute("language", language);
			model.addAttribute("index", index);
			return "edit.jsp";
		}
		return "redirect:/";
	}
	@PostMapping("/edit/{index}")
	public String editLang(@PathVariable("index") int index, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()){
			return "edit.jsp";
		}
		langService.updateLang(index, language);
		return "redirect:/";
	}
}
