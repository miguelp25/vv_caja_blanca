import com.practica.cajablanca.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({EditorTest.class, MayorLongitudTest.class, NumPalabrasTest.class, SustituirPalabraTest.class})
public class TestAll {}