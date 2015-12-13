package ru.st.my_properties;

import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PropertiesExample extends JFrame
{
    public PropertiesExample() {
        try {
            // Создаем объект
            Properties pr = new Properties();
            // Загружаем данные из файла - позже узнаем более подробно про файлы
            pr.load(new FileReader("simple.properties"));

            // Получаем свойства по именам - это же по сути Map
            String upText = pr.getProperty("up.button.title");
            String dnText = pr.getProperty("dn.button.title");

            // Создаем кнопки с указанными названиями
            JButton up = new JButton(upText);
            JButton dn = new JButton(dnText);
            add(up, BorderLayout.NORTH);
            add(dn, BorderLayout.SOUTH);
        } catch (IOException io_ex) {
            io_ex.printStackTrace(System.out);
        }

        setBounds(200, 200, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        PropertiesExample pe = new PropertiesExample();
    }
}