package com.practica.cajablanca;
import org.junit.jupiter.api.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas del método numPalabras")
public class NumPalabrasTest {
    Editor editor;

    @BeforeEach
    public void setUp() {
        this.editor = new Editor();
    }

    @Test
    @DisplayName("Test 1: incio menor o igual que 0")
    public void IncioMenorIgual0() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> editor.numPalabras(0, 0, "picaporte"));
    }

    @Test
    @DisplayName("Test 2: fin mayor que la cantidad de lineas de editor")
    public void FinMayorQueLineas() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            editor.leerFichero("./src/test/ArchivosTest/NumPalabrasTest.txt");
            editor.numPalabras(1, editor.size()+1, "picaporte");
        });
    }

    @Test
    @DisplayName("Test 3: inicio mayor que fin")
    public void InicioMayorQueFin() throws IOException {
        editor.leerFichero("./src/test/ArchivosTest/NumPalabrasTest.txt");
        assertEquals(0, editor.numPalabras(7, editor.size(), "Camarero"));
    }

    @Test
    @DisplayName("Test 4: editor vacio.")
    public void EditorVacio() {
        assertEquals(0, editor.numPalabras(1, 0, "Camarero"));
    }

    @Test
    @DisplayName("Test 6: El parámetro palabra no se encuentra en editor")
    public void NoApariciones() throws IOException {
        editor.leerFichero("./src/test/ArchivosTest/NumPalabrasTest.txt");
        assertEquals(0, editor.numPalabras(1, editor.size(), "Ordenador"));
    }

    @Test
    @DisplayName("Test 7: Se encuentran 2 apariciones")
    public void SiApariciones() throws IOException {
        editor.leerFichero("./src/test/ArchivosTest/NumPalabrasTest.txt");
        assertEquals(2, editor.numPalabras(1, editor.size(), "Agua"));
    }

}
