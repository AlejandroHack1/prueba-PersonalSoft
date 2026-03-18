package mapper;

import co.com.prueba.model.Fondo;
import co.com.prueba.mongo.repositories.document.FondoDocument;

public class FondoMapper {

    public static Fondo toDomain(FondoDocument doc) {
        Fondo fondo = new Fondo();
        fondo.setId(doc.getId());
        fondo.setNombre(doc.getNombre());
        fondo.setMontoMinimo(doc.getMontoMinimo());
        fondo.setCategoria(doc.getCategoria());
        return fondo;
    }

    public static FondoDocument toDocument(Fondo fondo) {
        FondoDocument doc = new FondoDocument();
        doc.setId(fondo.getId());
        doc.setNombre(fondo.getNombre());
        doc.setMontoMinimo(fondo.getMontoMinimo());
        doc.setCategoria(fondo.getCategoria());
        return doc;
    }
}
