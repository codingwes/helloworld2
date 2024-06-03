import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld extends JFrame {
    private JTextField inputField;
    private JButton addButton;
    private JTextArea cityList;

    private List<String> cities;

    public HelloWorld() {
        setTitle("Urban Explorer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputField = new JTextField(20);
        addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        cityList = new JTextArea();
        cityList.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(cityList), BorderLayout.CENTER);

        cities = new ArrayList<>();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String city = inputField.getText();
            cities.add(city);
            updateCityList();
            inputField.setText("");
        }
    }

    private void updateCityList() {
        StringBuilder sb = new StringBuilder();
        for (String city : cities) {
            sb.append(city).append("\n");
        }
        cityList.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HelloWorld());
    }
}