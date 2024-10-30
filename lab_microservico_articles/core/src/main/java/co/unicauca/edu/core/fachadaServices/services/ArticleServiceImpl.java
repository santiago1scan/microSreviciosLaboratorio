package co.unicauca.edu.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.unicauca.edu.core.accesoDatos.models.ArticleEntity;
import co.unicauca.edu.core.accesoDatos.repositories.ArticleRepository;
import co.unicauca.edu.core.fachadaServices.DTO.ArticleDTO;
import co.unicauca.edu.core.fachadaServices.DTO.ArticleWithConferenceDTO;
import co.unicauca.edu.core.fachadaServices.DTO.ConferenceDTO;
import co.unicauca.edu.core.rabbitMQ.MessageProducer;

@Service
public class ArticleServiceImpl implements IArticleService {

    private ArticleRepository repository;
    private ConferenceService conferenceService;
    private final MessageProducer messageProducer;

    private ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepository repository, ModelMapper modelMapper, ConferenceService conferenceService, MessageProducer messageProducer) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.conferenceService = conferenceService;
        this.messageProducer = messageProducer;
    }

    @Override
    public ArticleDTO getArticle(int id) {
        ArticleEntity articles = repository.getById(id);
        if(articles == null)
            return null;
        ArticleDTO articleDTO = this.modelMapper.map(articles, ArticleDTO.class);
        
        return articleDTO;
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        List<ArticleEntity> articles = repository.getAllArticles();
        List<ArticleDTO> articlesDTO = modelMapper.map(articles, new TypeToken<List<ArticleDTO>>(){}.getType());
        
        return articlesDTO;
    }

    @Override
    public ArticleDTO createArticle(ArticleDTO article) {
        ArticleEntity newArticle = this.modelMapper.map(article, ArticleEntity.class);
        ArticleEntity articleCreated = repository.addArticle(newArticle);
        if(articleCreated == null)
            return null;
        messageProducer.sendMessage(article);
        return this.modelMapper.map(articleCreated, ArticleDTO.class);
    }

    @Override
    public ArticleDTO updateArticle(int id, ArticleDTO article) {
        ArticleEntity articleToUpdate = this.modelMapper.map(article, ArticleEntity.class);
        ArticleEntity articleUpdated = repository.updateArticleById(id, articleToUpdate);
        if(articleUpdated == null)
            return null;
        return this.modelMapper.map(articleUpdated, ArticleDTO.class);
    }

    @Override
    public ArticleDTO deleteArticle(int id) {
        ArticleEntity articleDeleted = repository.deleteById(id);
        if(articleDeleted == null){

            return null;
        }
        else return this.modelMapper.map(articleDeleted, ArticleDTO.class);
    }
    
    @Override
    public ArticleWithConferenceDTO getConferenceByArticle(int id){

        ArticleDTO article = this.modelMapper.map(repository.getById(id), ArticleDTO.class);

        if(article == null)
            return null;

        List<ConferenceDTO> conferences = conferenceService.getConferenceByArticleID(id);

        ArticleWithConferenceDTO response = new ArticleWithConferenceDTO(article, conferences);
        
        return response;
    }

}
