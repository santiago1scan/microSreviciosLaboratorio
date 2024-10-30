package co.unicauca.edu.core_conferencia.fachadaService.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.unicauca.edu.core_conferencia.dataAccess.models.ConferenceEntity;
import co.unicauca.edu.core_conferencia.dataAccess.respositories.ConferenceRespository;
import co.unicauca.edu.core_conferencia.fachadaService.DTO.ConferenceDTO;

@Service
public class ConferenceServiceImp implements IConferenceService{

    private ConferenceRespository respository;
    private ModelMapper modelMapper;

    public ConferenceServiceImp(ConferenceRespository respository, ModelMapper mapper){
        this.respository = respository;
        this.modelMapper = mapper;  
    }

    @Override
    public ConferenceDTO getConference(int id) {
        ConferenceEntity conference = respository.getById(id);
        if(conference == null)
            return null;
        return this.modelMapper.map(conference, ConferenceDTO.class);
    }

    @Override
    public List<ConferenceDTO> getAllConferences() {
        List<ConferenceEntity> conferences = respository.getAllConferences();
        if(conferences== null)
            return null;
        return modelMapper.map(conferences, new TypeToken<List<ConferenceDTO>>(){}.getType());
    }

    @Override
    public ConferenceDTO createConference(ConferenceDTO article) {
        ConferenceEntity newConference = this.modelMapper.map(article, ConferenceEntity.class);
        ConferenceEntity conferenceCreated = respository.addConference(newConference);
        if(conferenceCreated == null)
            return null;
        return this.modelMapper.map(conferenceCreated, ConferenceDTO.class);
    }

    @Override
    public ConferenceDTO updateConference(int id, ConferenceDTO article) {
        ConferenceEntity newConference = this.modelMapper.map(article, ConferenceEntity.class);
        ConferenceEntity conferenceCreated = respository.updateConference(id, newConference);
        if(conferenceCreated == null)
            return null;
        return this.modelMapper.map(conferenceCreated, ConferenceDTO.class);
    }

    @Override
    public ConferenceDTO deleteConference(int id) {
        ConferenceEntity conferenceDeleted = respository.deleteById(id);
        if(conferenceDeleted == null)
            return null;
        return this.modelMapper.map(conferenceDeleted, ConferenceDTO.class);
    }

    @Override
    public List<ConferenceDTO> getConferenceByArticleID(int id){
        List<ConferenceEntity> foundConferences = respository.getConferencesByArticleID(id);
        return this.modelMapper.map(foundConferences,new TypeToken<List<ConferenceDTO>>(){}.getType() );
    }
    
}
