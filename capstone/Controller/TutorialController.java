package com.example.capstone.Controller;

import com.example.capstone.Model.Tutorial;
import com.example.capstone.Service.TutorialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Tutorial")
@RequiredArgsConstructor
public class TutorialController {
    private  final TutorialService tutorialService;
    @GetMapping("/getTutorial")
    public ResponseEntity getTutorial (){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getTutorial());
    }
    @PostMapping("/addTutorial")
    public ResponseEntity addTutorial(@RequestBody@Valid Tutorial tutorial, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        tutorialService.addTutorial(tutorial);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial add");
    }
    @PutMapping("/updateTutorial/{id}")
    public ResponseEntity updateTutorial(@PathVariable Integer id, @RequestBody@Valid Tutorial tutorial, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        tutorialService.updateTutorial(id, tutorial);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial updated");
    }
    @DeleteMapping("/deleteTutorial/{id}")
    public ResponseEntity deleteTutorial(@PathVariable Integer id){
        tutorialService.deleteTutorial(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial deleted");
    }
    @GetMapping("/getUserID/{user_id}")
    public ResponseEntity getByUserId(@PathVariable Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByUser_id(user_id));
    }
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByTitle(title));
    }
//    @GetMapping("/getFavorites/{favorites}/{User_id}")
//    public ResponseEntity getFavorites(@PathVariable Boolean favorites,@PathVariable Integer User_id){
//        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getFavorites(favorites, User_id));
//    }
    @GetMapping("/getDifficulty_level/{difficulty_level}")
    public ResponseEntity getDifficulty_level(@PathVariable String difficulty_level){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByDifficulty_level(difficulty_level));
    }
    @GetMapping("/getFavorites/{user_id}")
    public ResponseEntity getFavorites(@PathVariable Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getFavorites(user_id));
    }
    @PutMapping("/unFavorites/{user_id}/{id}")
    public ResponseEntity unFavorites(@PathVariable Integer user_id,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.unFavorites(user_id, id));
    }
    @PutMapping("/Favorites/{user_id}/{id}")
    public ResponseEntity Favorites(@PathVariable Integer user_id,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.addFavorites(user_id, id));
    }
    @GetMapping("/countUnFavorites/{user_id}")
    public ResponseEntity countUnfavorites(@PathVariable Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.countUnFavorites(user_id));
    }
    @GetMapping("/countFavorites/{user_id}")
    public ResponseEntity countfavorites(@PathVariable Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.countFavorites(user_id));
    }
    public ResponseEntity getByAuthor(@PathVariable String author){
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByAuthor(author));
    }
}
