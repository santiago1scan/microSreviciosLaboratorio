package co.edu.unicauca.infoii.correo.DTOs;

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
    public ArticleDTO(){
        
    }
}
