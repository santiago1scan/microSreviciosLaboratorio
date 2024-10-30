package co.unicauca.edu.core_conferencia.dataAccess.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloEntity {
    private int id;
    private String nombre;
    private String autores;
    private int cantidadAutores;
    private String revista;
    
    public ArticuloEntity(){
        
    }

    public ArticuloEntity copy(){
        return new ArticuloEntity(id, nombre, autores, cantidadAutores, revista);
    }
}
