package co.unicauca.edu.core_conferencia.dataAccess.respositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.unicauca.edu.core_conferencia.dataAccess.models.ArticuloEntity;
import co.unicauca.edu.core_conferencia.dataAccess.models.ConferenceEntity;

@Repository
public class ConferenceRespository {
    private ArrayList<ConferenceEntity> listConferences;
    private int counter;

    public ConferenceRespository(){
        this.listConferences = new ArrayList<>();
        counter=0;
        loadConferences();
    }

    public List<ConferenceEntity> getAllConferences(){
        return this.listConferences;
    }
    public ConferenceEntity getById(int id){
        for(ConferenceEntity conference: this.listConferences)
            if(conference.getId() == id)
                return conference;
        return null;
    }
    public ConferenceEntity addConference(ConferenceEntity conference){
        ConferenceEntity newConference=conference.copy();
        if(this.listConferences.add(newConference)){
            newConference.setId(counter);
            counter++;
            return newConference.copy();
        }
        return null;
    }

    public ConferenceEntity updateConference(int id, ConferenceEntity conference){
        ConferenceEntity newConference = getById(id);
        if (newConference== null)
            return null;
        newConference.setName(conference.getName());
        newConference.setCantMaxArticle(conference.getCantMaxArticle());
        return newConference;
    }

    public ConferenceEntity deleteById(int id){
        ConferenceEntity conferenceToDelete = getById(id);
        if(conferenceToDelete==null)
            return null;
        if(listConferences.remove(conferenceToDelete))
            return conferenceToDelete;
        else return null;
    }

    public List<ConferenceEntity> getConferencesByArticleID(int id){
        List<ConferenceEntity> foundConferences = new ArrayList<>();
        for(ConferenceEntity conference: this.listConferences){
            for(ArticuloEntity article: conference.getArticles()){
                if(article.getId() == id)
                    foundConferences.add(conference);
            }
        }
        return foundConferences;
    }

    private void loadConferences(){
        List<ArticuloEntity> articulos1 =  new ArrayList<>();
        List<ArticuloEntity> articulos2 =  new ArrayList<>();
        List<ArticuloEntity> articulos3 =  new ArrayList<>();
        List<ArticuloEntity> articulos4 =  new ArrayList<>();

        articulos1.add(new ArticuloEntity(1, "Articulo 1", "Miguel", 1,"Unicauca"));
        articulos2.add(new ArticuloEntity(1, "Articulo 1", "Miguel", 1,"Unicauca"));
        articulos3.add(new ArticuloEntity(2, "Articulo 2", "Miguel", 1,"Unicauca"));
        articulos4.add(new ArticuloEntity(2, "Articulo 2", "Miguel", 1,"Unicauca"));

        this.addConference(new ConferenceEntity(1, "Conferencia 1", 100, articulos1));
        this.addConference(new ConferenceEntity(1, "Conferencia 2", 200, articulos2));
        this.addConference(new ConferenceEntity(1, "Conferencia 3", 300, articulos3));
        this.addConference(new ConferenceEntity(1, "Conferencia 4", 400, articulos4));
    }
}
