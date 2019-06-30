package Crimson.Crimson_core.RestApp;

import Crimson.Crimson_core.Cartelera;
import Crimson.Crimson_core.Dummys.DataLoader;
import Crimson.Crimson_core.Funcion;
import Crimson.Crimson_core.JSON_Classes.DatosPeliUser;
import Crimson.Crimson_core.JSON_Holders.HPelicula;
import Crimson.Crimson_core.JSON_Holders.HSala;
import Crimson.Crimson_core.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CrimsonController {

    private static final String template = "Esta es:";
    @Autowired
    private Intermodelo intermodelo;

//    @PostConstruct
//    public void initialize() {
//        DataLoader loader = new DataLoader();
//        Cartelera cartelera = new Cartelera();
//        loader.crearSetDeDatos(cartelera);
//        DataManager dataManager = new DataManager(cartelera);
//        Intermodelo intermodelo = new Intermodelo(dataManager);
//    }

//    @RequestMapping("/cartelera")
//    public List<HPelicula> getCartelera() {
//
//    }

    @RequestMapping("/pelicula")
    public List<HPelicula> getPelicula() {
        HSala sala = new HSala(3, null, 30, 0, "2D");
        HPelicula peli = new HPelicula("Aladdin", 0001, "Aventura Romantica", "ATP", "Aladdin (Mena Massoud) es un adorable pero desafortunado ladronzuelo enamorado de la hija del Sultán, la princesa Jasmine (Naomi Scott). Para intentar conquistarla, acepta el desafío de Jafar (Marwan Kenzari), que consiste en entrar a una cueva en mitad del desierto para dar con una lámpara mágica que le concederá todos sus deseos. Allí es donde Aladdín conocerá al Genio (Will Smith), dando inicio a una aventura como nunca antes había imaginado", sala);
        List<HPelicula> lista = new ArrayList<>();
        lista.add(peli);
        return lista;
    }

    @RequestMapping("/<usuario>/peli/<codigo_peli>")
    public DatosPeliUser getDatosPelicula() {
        //TODO
        return null;
    }

    @RequestMapping(value = "/postPelicula", method = RequestMethod.POST)
    public HPelicula postPelicula(@RequestParam ("nombre") String nombre, @RequestParam("codigo") Integer codigo, @RequestParam("genero") String genero, @RequestParam("clasificacion") String clasificacion, @RequestParam ("sinopsis") String sinopsis) {
        return new HPelicula(nombre, codigo, genero, clasificacion, sinopsis, null);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createPelicula(@RequestBody HPelicula pelicula){

        return new ResponseEntity(pelicula, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/emailReserva", method = RequestMethod.PUT)
    public void enviarEmail(){

        EmailSender es = new EmailSender();
        Sala sala1 = new Sala(200, 1, "2D");
        Funcion funcion =  new Funcion(sala1, "10-6-19 8:00:00");
        String emailUser = "miguelenriquebada07@gmail.com";
        int dniUser = 123456;
        es.sendEmail(emailUser, dniUser, funcion, "Caperucita Roja");


    }




}
