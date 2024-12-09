import org.junit.Test;
import static org.junit.Assert.*;

public class coursetest {

    @Test
    public void testValidateInputs_AllValid() {
        course courseApp = new course();
        String result = courseApp.validateInputs("Анна Иванова", "Программирование", "1 месяц");
        assertEquals("Данные корректны.", result);
    }

    @Test
    public void testValidateInputs_EmptyName() {
        course courseApp = new course();
        String result = courseApp.validateInputs("", "Программирование", "1 месяц");
        assertEquals("Пожалуйста, введите ваше имя.", result);
    }

    @Test
    public void testValidateInputs_NullName() {
        course courseApp = new course();
        String result = courseApp.validateInputs(null, "Программирование", "1 месяц");
        assertEquals("Пожалуйста, введите ваше имя.", result);
    }

    @Test
    public void testValidateInputs_InvalidDirection() {
        course courseApp = new course();
        String result = courseApp.validateInputs("Анна Иванова", "Выберите направление", "1 месяц");
        assertEquals("Пожалуйста, выберите направление обучения.", result);
    }

    @Test
    public void testValidateInputs_InvalidDuration() {
        course courseApp = new course();
        String result = courseApp.validateInputs("Анна Иванова", "Программирование", "Выберите срок обучения");
        assertEquals("Пожалуйста, выберите срок обучения.", result);
    }
}