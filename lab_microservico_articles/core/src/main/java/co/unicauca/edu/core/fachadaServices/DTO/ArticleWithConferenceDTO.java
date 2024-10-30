package co.unicauca.edu.core.fachadaServices.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ArticleWithConferenceDTO{
    ArticleDTO article;
    List<ConferenceDTO> conferences;
}
