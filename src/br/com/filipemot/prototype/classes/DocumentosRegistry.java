package br.com.filipemot.prototype.classes;

import java.util.HashMap;
import java.util.Map;

public class DocumentosRegistry {
    private static final DocumentosRegistry INSTANCE = new DocumentosRegistry();
    private static final Map<String, Documento2> REGISTRY = new HashMap<>();

    static {
        Documento2 d1 = new Documento2();
        d1.tipo = "PDF";
        d1.visibilidade = "RESTRITO";
        REGISTRY.put("PDF RESTRITO", d1);

        Documento2 d2 = new Documento2();
        d2.tipo = "PDF";
        d2.visibilidade = "PUBLICO";
        REGISTRY.put("PDF PUBLICO", d2);

        Documento2 d3 = new Documento2();
        d3.tipo = "DOC";
        d3.visibilidade = "RESTRITO";
        REGISTRY.put("DOC RESTRITO", d3);

        Documento2 d4 = new Documento2();
        d4.tipo = "DOC";
        d4.visibilidade = "PUBLICO";
        REGISTRY.put("DOC PUBLICO", d4);
    }

    private DocumentosRegistry() {
    }

    public static DocumentosRegistry getInstance() {
        return INSTANCE;
    }

    public Documento2 getDocumento(String tipo) {
        try {
            return REGISTRY.get(tipo).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
