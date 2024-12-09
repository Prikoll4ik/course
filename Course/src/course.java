import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class course extends JFrame {

    private JTextField nameField;
    private JComboBox<String> directionComboBox;
    private JComboBox<String> durationComboBox;

    private String[] directions = {"Выберите направление", "Программирование", "Здоровье и питание", "Вышивание"};
    private String[] durations = {"Выберите срок обучения", "1 месяц", "3 месяца", "6 месяцев", "1 год", "2 года"};

    public course() {
        setTitle("Курсы обучения");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(new JLabel("Имя Фамилия:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Направление:"), gbc);

        gbc.gridx = 1;
        directionComboBox = new JComboBox<>(directions);
        add(directionComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Срок обучения:"), gbc);

        gbc.gridx = 1;
        durationComboBox = new JComboBox<>(durations);
        add(durationComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JButton enrollButton = new JButton("Записаться");
        enrollButton.addActionListener(new EnrollButtonListener());
        add(enrollButton, gbc);
    }

    public String validateInputs(String name, String direction, String duration) {
        if (name == null || name.trim().isEmpty()) {
            return "Пожалуйста, введите ваше имя.";
        }
        if ("Выберите направление".equals(direction)) {
            return "Пожалуйста, выберите направление обучения.";
        }
        if ("Выберите срок обучения".equals(duration)) {
            return "Пожалуйста, выберите срок обучения.";
        }
        return "Данные корректны.";
    }

    private class EnrollButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String direction = (String) directionComboBox.getSelectedItem();
            String duration = (String) durationComboBox.getSelectedItem();

            String validationMessage = validateInputs(name, direction, duration);

            if (!"Данные корректны.".equals(validationMessage)) {
                JOptionPane.showMessageDialog(null, validationMessage, "Ошибка", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] selectedCourses = getCourses(direction);
                JOptionPane.showMessageDialog(null, "Здравствуйте, " + name + "! Подходящие курсы для вас:\n" + Arrays.toString(selectedCourses), "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private String[] getCourses(String direction) {
        switch (direction) {
            case "Программирование":
                return new String[]{"Java для начинающих", "Основы веб-разработки", "Python для анализа данных"};
            case "Здоровье и питание":
                return new String[]{"Йога и медитация", "Основы правильного питания", "Фитнес для всех"};
            case "Вышивание":
                return new String[]{"Основы вышивания", "Создание декоративных украшений", "Основы скрапбукинга"};
            default:
                return new String[0];
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new course().setVisible(true);
        });
    }
}