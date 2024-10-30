package co.unicauca.edu.core.fachadaServices.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {    
    private Integer id;
    private String name;
    private Integer cantMaxArticle;

    public ConferenceDTO(){

    }
}
