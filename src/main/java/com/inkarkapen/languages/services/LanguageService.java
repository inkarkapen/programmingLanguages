package com.inkarkapen.languages.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import com.inkarkapen.languages.models.Language;

@Service
public class LanguageService {
	List<Language> languages = new ArrayList<Language>(Arrays.asList(
			new Language("Java", "James Gosling", "1.8"),
			new Language("Python", "Guido van Rossum", "3.6"),
			new Language("JavaScript", "Brendan Eich", "1.9")
			));
	public List<Language> showAll() {
		return languages;
	}
	public Language findOneLang(int index){
		if(index >= languages.size()) {
			return null;
		}
		return languages.get(index);
	}
	public void addLang(@Valid Language language) {
		languages.add(language);
	}
	public void deleteLang(int index) {
		if(index < languages.size()) {
			languages.remove(index);
		}
	}
	public void updateLang(int index, Language language) {
		if(index < languages.size()) {
			languages.set(index, language);
		}
	}
}
