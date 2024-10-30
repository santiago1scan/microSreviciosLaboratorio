package co.unicauca.edu.core.fachadaServices.services;

import java.util.List;

import co.unicauca.edu.core.fachadaServices.DTO.ArticleDTO;
import co.unicauca.edu.core.fachadaServices.DTO.ArticleWithConferenceDTO;

public interface IArticleService {
    public ArticleDTO getArticle(int id);
    public List<ArticleDTO> getAllArticles();
    public ArticleDTO createArticle(ArticleDTO article);
    public ArticleDTO updateArticle(int id, ArticleDTO article);
    public ArticleDTO deleteArticle(int id);
    public ArticleWithConferenceDTO getConferenceByArticle(int id); 
}
