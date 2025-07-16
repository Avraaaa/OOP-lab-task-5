package JavaUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class IITDUFootballLeagueRegistration {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IITDU Football League Registration");
        frame.setSize(750, 720);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("IIT DU Football League", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setBounds(0, 10, 750, 30);
        frame.add(titleLabel);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(30, 60, 100, 25);
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(180, 60, 500, 25);
        frame.add(firstNameLabel);
        frame.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(30, 100, 100, 25);
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(180, 100, 500, 25);
        frame.add(lastNameLabel);
        frame.add(lastNameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 140, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(180, 140, 500, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 180, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(180, 180, 500, 25);
        frame.add(phoneLabel);
        frame.add(phoneField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 220, 100, 25);
        JTextField addressField = new JTextField();
        addressField.setBounds(180, 220, 500, 25);
        frame.add(addressLabel);
        frame.add(addressField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 260, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(180, 260, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(260, 260, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 300, 100, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2025 - i);
        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setBounds(180, 300, 60, 25);
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setBounds(250, 300, 80, 25);
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setBounds(340, 300, 80, 25);
        frame.add(dobLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        JLabel degreeLabel = new JLabel("Degree:");
        degreeLabel.setBounds(30, 340, 100, 25);
        String[] degrees = {"Select", "BSc", "MSc"};
        JComboBox<String> degreeBox = new JComboBox<>(degrees);
        degreeBox.setBounds(180, 340, 500, 25);
        frame.add(degreeLabel);
        frame.add(degreeBox);

        JLabel positionLabel = new JLabel("Preferred Position:");
        positionLabel.setBounds(30, 380, 150, 25);
        String[] positions = {"Goalkeeper", "Center Back", "Right Back", "Left Back", "Central Defensive Midfielder", "Center Midfielder", "Central Attacking Midfielder", "Left Wing", "Right Wing", "Striker"};
        JComboBox<String> positionBox = new JComboBox<>(positions);
        positionBox.setBounds(180, 380, 500, 25);
        frame.add(positionLabel);
        frame.add(positionBox);

        JLabel interDeptLabel = new JLabel("Previous Interdept Futsal Experience?");
        interDeptLabel.setBounds(30, 420, 300, 25);
        JRadioButton interDeptYes = new JRadioButton("Yes");
        interDeptYes.setBounds(300, 420, 70, 25);
        JRadioButton interDeptNo = new JRadioButton("No");
        interDeptNo.setBounds(380, 420, 70, 25);
        interDeptYes.addActionListener(e -> {
            if (interDeptYes.isSelected()) interDeptNo.setSelected(false);
        });
        interDeptNo.addActionListener(e -> {
            if (interDeptNo.isSelected()) interDeptYes.setSelected(false);
        });
        frame.add(interDeptLabel);
        frame.add(interDeptYes);
        frame.add(interDeptNo);

        JLabel experienceLabel = new JLabel("Football Experience:");
        experienceLabel.setBounds(30, 460, 130, 25);
        JTextArea experienceArea = new JTextArea();
        JScrollPane experienceScroll = new JScrollPane(experienceArea);
        experienceScroll.setBounds(180, 460, 500, 60);
        frame.add(experienceLabel);
        frame.add(experienceScroll);

        JLabel fileLabel = new JLabel("Profile Photo:");
        fileLabel.setBounds(30, 540, 100, 25);
        JButton fileButton = new JButton("Choose File");
        fileButton.setBounds(180, 540, 120, 25);
        JLabel filePathLabel = new JLabel();
        filePathLabel.setBounds(310, 540, 370, 25);
        frame.add(fileLabel);
        frame.add(fileButton);
        frame.add(filePathLabel);

        String[] selectedFilePath = {""};
        fileButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                filePathLabel.setText(file.getName());
            }
        });

        JButton registerBtn = new JButton("Submit");
        registerBtn.setBounds(300, 600, 150, 30);
        frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();
            String gender = "";
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String) degreeBox.getSelectedItem();
            String position = (String) positionBox.getSelectedItem();
            String interDept = interDeptYes.isSelected() ? "Yes" : (interDeptNo.isSelected() ? "No" : "");
            String experience = experienceArea.getText().trim();
            String photo = selectedFilePath[0];

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()
                    || gender.isEmpty() || degree.equals("Select") || position.equals("Select")
                    || interDept.isEmpty() || experience.isEmpty() || photo.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (FileWriter writer = new FileWriter("iitdu_football_registration.txt", true)) {
                writer.write("Name: " + firstName + " " + lastName + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Phone: " + phone + "\n");
                writer.write("Address: " + address + "\n");
                writer.write("Gender: " + gender + "\n");
                writer.write("DOB: " + dob + "\n");
                writer.write("Degree: " + degree + "\n");
                writer.write("Preferred Position: " + position + "\n");
                writer.write("Played Inter-Dept: " + interDept + "\n");
                writer.write("Experience: " + experience + "\n");
                writer.write("Profile Photo: " + photo + "\n");
                writer.write("--------------------------------------------\n");

                JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                addressField.setText("");
                genderGroup.clearSelection();
                degreeBox.setSelectedIndex(0);
                positionBox.setSelectedIndex(0);
                interDeptYes.setSelected(false);
                interDeptNo.setSelected(false);
                experienceArea.setText("");
                dayBox.setSelectedIndex(0);
                monthBox.setSelectedIndex(0);
                yearBox.setSelectedIndex(0);
                filePathLabel.setText("");
                selectedFilePath[0] = "";

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving to file!", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}
