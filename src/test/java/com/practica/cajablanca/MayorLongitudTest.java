package com.practica.cajablanca;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas del método mayorLongitud")
public class MayorLongitudTest {
    Editor editor;

    @BeforeEach
    public void setUp() {
        this.editor = new Editor();
    }

    @Test
    @DisplayName("Test 1: El editor tiene 0 líneas")
    public void EditorVacio() throws EmptyCollectionException {
        assertNull(editor.mayorLongitud());
    }

    @Test
    @DisplayName("Test 3: El editor ha leído una línea vacía")
    public void EditorVacio2() throws IOException, EmptyCollectionException {
        editor.leerFichero("./src/test/ArchivosTest/MayorLongitudTestVacio.txt");
        assertNull(editor.mayorLongitud());
    }

    @Test
    @DisplayName("Test 4: El editor ha leído una línea, y esa es la más grande")
    public void EditorCon1Linea() throws IOException, EmptyCollectionException {
        editor.leerFichero("./src/test/ArchivosTest/MayorLongitudTest1Linea.txt");
        assertEquals("Hola", editor.mayorLongitud());
    }

    @Test
    @DisplayName("Test 5: El editor ha leído dos líneas, y la segunda es más grande")
    public void EditorConSegundaMasGrande() throws IOException, EmptyCollectionException {
        editor.leerFichero("./src/test/ArchivosTest/MayorLongitudTest2MasGrande.txt");
        assertEquals("Ventana", editor.mayorLongitud());
    }

    @Test
    @DisplayName("Test 6: El editor ha leído dos líneas, y la primera era más grande")
    public void EditorConPrimeraMasGrande() throws IOException, EmptyCollectionException {
        editor.leerFichero("./src/test/ArchivosTest/MayorLongitudTest1MasGrande.txt");
        assertEquals("Picaporte", editor.mayorLongitud());
    }
}
