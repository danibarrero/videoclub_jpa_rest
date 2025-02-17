package org.iesvdm.videoclub.service;

import java.util.List;

import org.iesvdm.videoclub.domain.Categoria;
import org.iesvdm.videoclub.exception.CategoriaNotFoundException;
import org.iesvdm.videoclub.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaService {
    
    private CategoriaRepository categoriaRepository;

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria pelicula) {

        return this.categoriaRepository.findById(id).map( p -> (id.equals(pelicula.getId())  ?
                                                            this.categoriaRepository.save(pelicula) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));

    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(p -> {this.categoriaRepository.delete(p);
                                                        return p;})
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }
}
