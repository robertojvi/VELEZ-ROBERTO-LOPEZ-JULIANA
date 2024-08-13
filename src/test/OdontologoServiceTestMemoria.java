package test;

import model.Odontologo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTestMemoria {
    OdontologoService odontologoService = new OdontologoService(new dao.impl.DaoMemoria());

    @Test
    @DisplayName("Probar que se devuelven todos los odontologos")
    void caso1() {
        List<Odontologo> odontologos;
        odontologos = odontologoService.buscarTodos();
        assertNotNull(odontologos);
    }
}