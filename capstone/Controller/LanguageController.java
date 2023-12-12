package com.example.capstone.Controller;

import com.example.capstone.Model.Language;
import com.example.capstone.Service.LanguageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;
    @GetMapping("/getLanguage")
    public ResponseEntity getLanguage(){
        return ResponseEntity.status(HttpStatus.OK).body(languageService.getLanguage());
    }
    @PostMapping("/addLanguage")
    public ResponseEntity addLanguage(@RequestBody@Valid Language language, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        languageService.addLanguage(language);
        return ResponseEntity.status(HttpStatus.OK).body("Language add");
    }
    @PutMapping("/updateLanguage/{id}")
    public ResponseEntity updateLanguage(@PathVariable Integer id,@RequestBody@Valid Language language,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        languageService.updateLanguage(id, language);
        return ResponseEntity.status(HttpStatus.OK).body("Language updated");
    }
    @DeleteMapping("/deleteLanguage/{id}")
    public ResponseEntity deleteLanguage(@PathVariable Integer id){
        languageService.deleteLanguage(id);
        return ResponseEntity.status(HttpStatus.OK).body("Language deleted");
    }
    @GetMapping("/getByName/{language_name}")
    public ResponseEntity languageName(@PathVariable String language_name){
        return ResponseEntity.status(HttpStatus.OK).body(languageService.languageName(language_name));
    }
}
