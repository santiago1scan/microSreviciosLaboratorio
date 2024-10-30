package co.unicauca.edu.core.accesoDatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleEntity {
    private int id;
    private String nombre;
    private String autores;
    private int cantidadAutores;
    private String revista;
    private Integer idConferencia;
    
    public ArticleEntity(){
        
    }

    public ArticleEntity copy(){
        return new ArticleEntity(id, nombre, autores, cantidadAutores, revista, idConferencia);
    }
}
