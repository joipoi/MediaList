package com.example.DBTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

//This class is used to run the application and
//creating a simple jFrame which launches the webUI in the users browser
@SpringBootApplication
public class MainFrame implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MainFrame.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
	}

    @Override
    public void run(String... args)  {
        Runtime rt = Runtime.getRuntime();

        JFrame jFrame = new JFrame("a");
        jFrame.setLayout(null);
        JLabel label = new JLabel("Press button to open project in your browser");
        label.setBounds(0,0, 500, 100);
        jFrame.getContentPane().add(label);
        JLabel label2 = new JLabel("exit this window to exit program");
        label2.setBounds(0,0, 500, 800);
        jFrame.getContentPane().add(label2);

        JButton noBtn = new JButton("button");
        noBtn.setBounds(0,100, 200, 100);
        jFrame.getContentPane().add(noBtn);
        noBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/mainPage?type=all"); //opens a web page at the main page
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        });


        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(600,500);
        jFrame.setVisible(true);
    }
}
