package org.iesvdm.videoclub;

import java.util.HashSet;
import java.util.Locale.Category;

import org.iesvdm.videoclub.domain.Categoria;
import org.iesvdm.videoclub.domain.Idioma;
import org.iesvdm.videoclub.domain.Pelicula;
import org.iesvdm.videoclub.repository.CategoriaRepository;
import org.iesvdm.videoclub.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.var;

@SpringBootTest
class VideoclubApplicationTests {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    void contextLoads() {

        Categoria categoria = this.categoriaRepository.findById((long) 3).orElse(null);

        Idioma idioma = Idioma.builder().id(4L).build();

        Pelicula pelicula = Pelicula.builder().titulo("Misión imposible")
                                                .descripcion("Fantasmada de acción")
                                                .idioma(idioma)
                                                .categorias(new HashSet<Categoria>())
                                                .build();

        pelicula.getCategorias().add(categoria);

        // Tanto creacion como actualizacion todo a traves de repository.save(entity)
        peliculaRepository.save(pelicula);

    }
}
