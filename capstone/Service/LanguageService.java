package com.example.capstone.Service;

import com.example.capstone.ApiException.ApiException;
import com.example.capstone.Model.Language;
import com.example.capstone.Repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;
    public List<Language> getLanguage(){
        return languageRepository.findAll();
    }
    public void addLanguage(Language language){
        languageRepository.save(language);
    }
    public void updateLanguage(Integer id,Language language){
        Language oldLanguage=languageRepository.findLanguageById(id);
        if(oldLanguage==null){
            throw new ApiException("Language not found");

        }
        oldLanguage.setLanguage_name(language.getLanguage_name());
        oldLanguage.setLanguage_description(language.getLanguage_description());
        oldLanguage.setVersion(language.getVersion());
        languageRepository.save(oldLanguage);
    }
    public void deleteLanguage(Integer id){
        Language language=languageRepository.findLanguageById(id);
        if(language==null){
            throw new ApiException("Language not found");
        }
        languageRepository.delete(language);
    }
    public Language languageName(String language_name){
        Language languageName=languageRepository.findLanguageByLanguage_name(language_name);
        if(language_name==null){
            throw new ApiException("language Name not found");
        }
        return languageName;
    }
}
