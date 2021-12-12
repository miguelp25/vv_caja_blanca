package com.practica.cajablanca;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas del método sustituirPalabra")
public class SustituirPalabraTest {
    Editor editor;

    @BeforeEach
    public void setUp() {
        this.editor = new Editor();
    }

    @Test
    @DisplayName("Test 1: El editor tiene 0 líneas")
    public void EditorVacio() throws EmptyCollectionException {
        editor.sustituirPalabra("Hola", "Picaporte");
        assertEquals(0, editor.size());
    }

    @Test
    @DisplayName("Test 4: El editor tiene filas que sustituir")
    public void SustituirExito() throws EmptyCollectionException {
        editor.leerFichero("./src/test/ArchivosTest/SustituirPalabraTestExito.txt");
        editor.sustituirPalabra("Hola", "Picaporte");
        assertEquals("[Picaporte]", editor.getLinea(1).toString());
        assertEquals("[Picaporte]", editor.getLinea(2).toString());
        assertEquals("[Picaporte]", editor.getLinea(3).toString());
    }

    @Test
    @DisplayName("Test 5: El editor no tiene filas que sustituir")
    public void SustituirFracaso() throws EmptyCollectionException {
        editor.leerFichero("./src/test/ArchivosTest/SustituirPalabraTestFracaso.txt");
        editor.sustituirPalabra("Hola", "Picaporte");
        assertEquals("[Ordenador]", editor.getLinea(1).toString());
        assertEquals("[Ordenador]", editor.getLinea(2).toString());
        assertEquals("[Tijeras]", editor.getLinea(3).toString());
    }
}
