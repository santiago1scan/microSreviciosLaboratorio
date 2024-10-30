package co.unicauca.edu.core_conferencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.edu.core_conferencia.fachadaService.DTO.ConferenceDTO;
import co.unicauca.edu.core_conferencia.fachadaService.DTO.MessageExistDTO;
import co.unicauca.edu.core_conferencia.fachadaService.service.IConferenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class ConferenceRestController {
    @Autowired
    private IConferenceService conferenceService;

    @PostMapping("/conferences")
    public ConferenceDTO createConference(@RequestBody ConferenceDTO newConference) {
        ConferenceDTO createdConference = conferenceService.createConference(newConference);
        return createdConference;
    }
    
    @GetMapping("/conferences")
    public List<ConferenceDTO> getMethodName() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/conferences/article/{id}")
    public List<ConferenceDTO> getMethodName(@PathVariable int id) {
        return conferenceService.getConferenceByArticleID(id);
    }
    

    @GetMapping("/conferences/exist/{id}")
    public MessageExistDTO existConference(@PathVariable int id) {
        ConferenceDTO conference = conferenceService.getConference(id);
        return new MessageExistDTO(conference!=null);
    }

    @GetMapping("/conferences/countArticles/{id}")
    public ResponseEntity<Integer> cantidadArticlesConferences(@PathVariable int id) {
        ConferenceDTO conference = conferenceService.getConference(id);
        if(conference == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(conference.getCantMaxArticle(), null, HttpStatus.ACCEPTED);
    }
    
    
    
}
