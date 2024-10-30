package co.unicauca.edu.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import co.unicauca.edu.core.fachadaServices.DTO.ConferenceDTO;
import reactor.core.publisher.Mono;

@Service
public class ConferenceService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    private String url;
    public ConferenceService(){
        this.url = "http://localhost:1234/api";
    }

    public List<ConferenceDTO> getConferenceByArticleID(int id){
        Mono<ConferenceDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url+"/conferences/article/"+id)
                .retrieve()
                .bodyToMono(ConferenceDTO[].class);

        ConferenceDTO[] conferenciasArray =   response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}
