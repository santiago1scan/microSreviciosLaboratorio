package co.unicauca.edu.core_conferencia.fachadaService.service;

import java.util.List;

import co.unicauca.edu.core_conferencia.fachadaService.DTO.ConferenceDTO;

public interface IConferenceService {
    ConferenceDTO getConference(int id);
    List<ConferenceDTO> getAllConferences();
    ConferenceDTO createConference(ConferenceDTO article);
    ConferenceDTO updateConference(int id,ConferenceDTO article);
    ConferenceDTO deleteConference(int id);
    List<ConferenceDTO> getConferenceByArticleID(int id);
}
