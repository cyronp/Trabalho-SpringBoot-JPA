package models;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public void mostrarTop10() {
        Pageable top10 = PageRequest.of(0, 10);
        List<Object[]> topVideos = avaliacaoRepository.findTopVideosByAvaliacao(top10);

        for (Object[] row : topVideos) {
            Integer id = (Integer) row[0];     // id do vídeo
            String titulo = (String) row[1];   // título do vídeo
            Double media = (Double) row[2];    // média das avaliações

            System.out.println(id + " - " + titulo + " - " + media);
        }
    }
}