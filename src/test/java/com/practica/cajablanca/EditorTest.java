package com.practica.cajablanca;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas Genéricas")
public class EditorTest {
    Editor editor;

    @BeforeEach
    public void setUp() {
        this.editor = new Editor();
    }

    @Test
    @DisplayName("Test 1: El editor tiene 0 líneas")
    public void EditorIsEmpty() throws EmptyCollectionException {
        assertTrue(editor.editIsEmpty());
        editor.leerFichero("./src/test/ArchivosTest/NumPalabrasTest.txt");
        assertFalse(editor.editIsEmpty());
    }
}
