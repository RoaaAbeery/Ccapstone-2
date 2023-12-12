package com.example.capstone.Service;

import com.example.capstone.ApiException.ApiException;
import com.example.capstone.Model.Language;
import com.example.capstone.Model.Tutorial;
import com.example.capstone.Model.User;
import com.example.capstone.Repository.LanguageRepository;
import com.example.capstone.Repository.TutorialRepository;
import com.example.capstone.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService {
    private final TutorialRepository tutorialRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;

    public List<Tutorial> getTutorial() {
        return tutorialRepository.findAll();
    }

    public void addTutorial(Tutorial tutorial) {
        Language language = languageRepository.findLanguageById(tutorial.getLanguage_id());
        User user = userRepository.findUsersById(tutorial.getUser_id());
        if (user == null) {
            throw new ApiException("User id not found");
        }
        if (language == null) {
            throw new ApiException("Language id not found");
        }
        tutorialRepository.save(tutorial);
    }

    public void updateTutorial(Integer id, Tutorial tutorial) {
        Language language = languageRepository.findLanguageById(tutorial.getLanguage_id());
        User user = userRepository.findUsersById(tutorial.getUser_id());
        Tutorial oldTutorial = tutorialRepository.findTutorialById(id);

        if (language == null) {
            throw new ApiException("Language id not found");
        }
        if (user == null) {
            throw new ApiException("User id not found");
        }
        if (oldTutorial == null) {
            throw new ApiException("Tutorial id not found");
        }

        oldTutorial.setTutorial_description(tutorial.getTutorial_description());
        oldTutorial.setTitle(tutorial.getTitle());
        oldTutorial.setContent(tutorial.getContent());
        oldTutorial.setAuthor(tutorial.getAuthor());
        oldTutorial.setDifficulty_level(tutorial.getDifficulty_level());
        oldTutorial.setFavorites(tutorial.getFavorites());
        tutorialRepository.save(oldTutorial);
    }

    public void deleteTutorial(Integer id) {
        Tutorial tutorial = tutorialRepository.findTutorialById(id);
        if (tutorial == null) {
            throw new ApiException("Tutorial not found");
        }
        tutorialRepository.delete(tutorial);
    }

    public List<Tutorial> getByUser_id(Integer user_id) {
        List<Tutorial> tutorial = tutorialRepository.findTutorialByUser_id(user_id);
        if (tutorial == null) {
            throw new ApiException("user id not found");
        }
        return tutorial;
    }

    public Tutorial getByTitle(String title) {
        Tutorial tutorial = tutorialRepository.findTutorialByTitle(title);
        if (tutorial == null) {
            throw new ApiException("Title not found");
        }
        return tutorial;
    }


    public List<Tutorial> getByDifficulty_level(String difficulty_level) {
        List<Tutorial> tutorials = tutorialRepository.findTutorialByDifficulty_level(difficulty_level);
        if (tutorials == null) {
            throw new ApiException("not found");
        }
        return tutorials;
    }

    public List<Tutorial> getFavorites(Integer user_id) {
        List<Tutorial> tutorial = tutorialRepository.findByUser_idAndFavoritesIsTrue(user_id);
        if (tutorial == null) {
            throw new ApiException("user id not found");
        }
        return tutorial;
    }

    public Tutorial unFavorites(Integer user_id, Integer id) {
        Tutorial tutorial = tutorialRepository.findTutorialByUser_idAndId(user_id, id);
        if (tutorial == null) {
            throw new ApiException("Tutorial not found");
        }
        if (tutorial.getFavorites() == true) {
            tutorial.setFavorites(false);
            tutorialRepository.save(tutorial);
        }
        return tutorial;
    }
    public Tutorial addFavorites(Integer user_id, Integer id){
        Tutorial tutorial = tutorialRepository.findTutorialByUser_idAndId(user_id, id);
        if (tutorial == null) {
            throw new ApiException("Tutorial not found");
        }
        if (tutorial.getFavorites() == false) {
            tutorial.setFavorites(true);
            tutorialRepository.save(tutorial);
        }
        return tutorial;
    }
public String countUnFavorites(Integer user_id){
        Integer tutorial=tutorialRepository.countByFavoritesIsFalse(user_id);
        if(tutorial==null){
            throw new ApiException("user id not found");
        }
        return "The Number of UnFavorites Tutorials :"+tutorial ;
}
    public  String countFavorites(Integer user_id){
        Integer tutorial=tutorialRepository.countByFavoritesIsTrue(user_id);
        if(tutorial==null){
            throw new ApiException("user id not found");
        }
        return "The Number of Favorites Tutorials :"+tutorial ;
    }
    public List<Tutorial> getByAuthor(String author){
       List<Tutorial> tutorial=tutorialRepository.findTutorialByAuthor(author);
        if(tutorial==null){
            throw new ApiException("Author not found");
        }
        return tutorial;
    }
}
