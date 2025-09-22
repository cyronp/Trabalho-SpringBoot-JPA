package com.example.Trabalho_JPA.models;

import org.springframework.stereotype.Service;
import com.example.Trabalho_JPA.repositorys.VideoRepository;

import java.util.List;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> encontrarVideo(String titulo) {
        return videoRepository.findByTituloContainingOrderByTituloAsc(titulo);
    }
    public List<Video> encontrarVideoByCategoria(Categoria categoria) {
        return videoRepository.findByCategoriaOrderByTituloAsc(categoria);
    }

}


