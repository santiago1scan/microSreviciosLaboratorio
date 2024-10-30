package co.unicauca.edu.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String nombre;
    private String autores;
    private int cantidadAutores;
    private String revista;
    private Integer idConferencia;
    public ArticleDTO(){
        
    }
}
