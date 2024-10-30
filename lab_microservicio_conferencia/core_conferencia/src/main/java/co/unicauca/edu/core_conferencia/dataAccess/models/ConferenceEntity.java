package co.unicauca.edu.core_conferencia.dataAccess.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    private Integer id;
    private String name;
    private Integer cantMaxArticle;
    private List<ArticuloEntity> articles;
    public ConferenceEntity(){}

    public boolean addArticle(ArticuloEntity article){
        return this.articles.add(article);
    }

    public ConferenceEntity copy(){
        return new ConferenceEntity(id, name, cantMaxArticle, articles);
    }
}
