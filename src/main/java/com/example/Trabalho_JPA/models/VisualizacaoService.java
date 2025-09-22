package com.example.Trabalho_JPA.models;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Trabalho_JPA.repositorys.VisualizacaoRepository;

import java.util.List;

@Service
public class VisualizacaoService {
    private final VisualizacaoRepository visualizacaoRepository;

    public VisualizacaoService(VisualizacaoRepository visualizacaoRepository) {
        this.visualizacaoRepository = visualizacaoRepository;
    }

    public void mostrarTop10() {
        Pageable top10 = PageRequest.of(0, 10);
        List<Object[]> topVideos = visualizacaoRepository.findTop10TotalVisualizacoesDesc(top10);

        for (Object[] row : topVideos) {
            Long id = (Long) row[0];
            String titulo = (String) row[1];
            Long totalVisualizacoes = (Long) row[2];

            System.out.println(titulo + " - " + totalVisualizacoes);
        }
    }

    public void mostrarTopPerfil() {
        Pageable top1 = PageRequest.of(0, 1);
        Perfil topPerfil = visualizacaoRepository.findTopPerfil(top1).get(0);

        System.out.println("Perfil com mais visualizações: " + topPerfil.getNome_perfil());
    }

}
