package co.unicauca.edu.core.controllers;

import co.unicauca.edu.core.fachadaServices.DTO.ArticleDTO;
import co.unicauca.edu.core.fachadaServices.DTO.ArticleWithConferenceDTO;
import co.unicauca.edu.core.fachadaServices.DTO.messageExistDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.edu.core.fachadaServices.services.IArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class ArticleRestControllers {
    @Autowired
    private IArticleService articleService;

    @PostMapping("/articles")
    public ArticleDTO postMethodName(@RequestBody ArticleDTO entity) {
        ArticleDTO objClient = articleService.createArticle(entity);
        return objClient;
    }
    @GetMapping("/conference/article/{id}")
    public ArticleWithConferenceDTO getConferenceByArticle(@PathVariable int id) {
        return articleService.getConferenceByArticle(id);
    }
    

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> getMethodName(@PathVariable int id) {
        ArticleDTO objClient = articleService.getArticle(id);
        if(objClient==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objClient, null, HttpStatus.ACCEPTED);
    }
    @GetMapping("/existArticles")
    public messageExistDTO getMethodName(@RequestParam String idArticle) {
        int IntegerInt = 0;
        try{
            IntegerInt = Integer.parseInt(idArticle);
        }catch(Error e){
            return new messageExistDTO(false);
        }
        ArticleDTO objClient = articleService.getArticle(IntegerInt);
        if(objClient == null)
            return new messageExistDTO(false);
        return new messageExistDTO(true);
    }
    
    @GetMapping("/articles")
    public List<ArticleDTO> getMethodName() {
        return this.articleService.getAllArticles();
    }
    @PutMapping("/articles/{id}")
    public ArticleDTO putMethodName(@PathVariable String id, @RequestBody ArticleDTO entity) {
        ArticleDTO objClient = articleService.updateArticle(Integer.parseInt(id), entity);
        return objClient;
    }
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> deleteMethodName(@PathVariable int id) {
        ArticleDTO objClient = articleService.deleteArticle(id);
        if (objClient==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objClient, null, HttpStatus.ACCEPTED);
    }

    
    
    
}
