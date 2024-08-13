package test;

import dao.impl.DaoH2;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);
    OdontologoService odontologoService = new OdontologoService(new DaoH2());

    @BeforeAll
    static void crearTabla(){
        Connection connection = null;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./examenRobertoJuliana;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
            connection.setAutoCommit(false);
            logger.info("Se ha creado la tabla");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }

        }
    }

    @Test
    @DisplayName("Probar que se devuelven todos los odontologos")
    void caso1() {
        List<Odontologo> odontologos;
        odontologos = odontologoService.buscarTodos();
        assertNotNull(odontologos);
    }

}