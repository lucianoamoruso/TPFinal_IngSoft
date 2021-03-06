package Crimson.Crimson_core.backend.service;

import Crimson.Crimson_core.Cartelera;
import Crimson.Crimson_core.Funcion;
import Crimson.Crimson_core.Pelicula;
import Crimson.Crimson_core.backend.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarteleraServiceImpl implements CarteleraService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getCartelera() {
        List<Pelicula> cartelera = new ArrayList<Pelicula>();
        Iterable<Pelicula> peliculas = peliculaRepository.findAll();
        for (Pelicula pelicula : peliculas) {
            cartelera.add(pelicula);
        }

        return cartelera;
    }

    @Override
    public void addPelicula(String name, String genero, String clasificacion, List<Funcion> funciones, String trailer, String imagen, String sinopsis) {
        Pelicula pelicula = new Pelicula(name, genero, clasificacion, funciones, trailer, imagen ,sinopsis);

        peliculaRepository.save(pelicula);

    }
}
