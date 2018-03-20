package com.inkarkapen.languages.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.languages.models.Language;
import com.inkarkapen.languages.repositories.LanguageRepo;

@Service
public class LanguageService {
	private static LanguageRepo languageRepo;
	public LanguageService(LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}
	public List<Language> showAll() {
		return languageRepo.findAll();
	}
	public Language findOneLang(Long id){
		return languageRepo.findById(id).orElse(null);
	}
	public void addLang(@Valid Language language) {
		languageRepo.save(language);
	}
	public void deleteLang(long id) {
		languageRepo.deleteById(id);
	}
	public void updateLang(@Valid Language language) {
		languageRepo.save(language);
	}
}
