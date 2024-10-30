package co.unicauca.edu.core.accesoDatos.repositories;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.edu.core.accesoDatos.models.ArticleEntity;

@Repository
public class ArticleRepository {
    private ArrayList<ArticleEntity> articles;
    private int counter;
    public ArticleRepository(){
        this.articles =  new ArrayList<>();
        counter=0;
        cargarClientes();
    }

    public List<ArticleEntity> getAllArticles(){
        return articles;
    }

    public ArticleEntity getById(int id){
        for (ArticleEntity article : articles) 
            if (article.getId() == id) 
                return article;    
        return null;
    }

    public ArticleEntity addArticle(ArticleEntity article){
        ArticleEntity newArticle = article.copy();
        if(articles.add(newArticle)){
            newArticle.setId(counter + 1);
            counter++;
            return newArticle;
        }else return null;
    }

    public ArticleEntity updateArticleById(int id, ArticleEntity article){
        ArticleEntity articleToUpdate = getById(id);
        if(articleToUpdate == null)
            return null;
        articleToUpdate.setNombre(article.getNombre());
        articleToUpdate.setAutores(article.getAutores());
        articleToUpdate.setCantidadAutores(article.getCantidadAutores());
        articleToUpdate.setRevista(article.getRevista());
        return articleToUpdate;
    }

    public ArticleEntity deleteById(int id){
        ArticleEntity articleToDelete = getById(id);
        if(articleToDelete == null)
            return null;
        if(articles.remove(articleToDelete))
            return articleToDelete;
        else return null;
    }

    private void cargarClientes(){
        this.addArticle( new ArticleEntity(1, "Articulo 1", "Autor 1", 1, "Revista 1", 1));
        this.addArticle( new ArticleEntity(2, "Articulo 2", "Autor 2", 1, "Revista 2",1));
        this.addArticle( new ArticleEntity(3, "Articulo 3", "Autor 3", 1, "Revista 3",2));
        this.addArticle( new ArticleEntity(4, "Articulo 4", "Autor 4", 1, "Revista 4",2));
    }
}
