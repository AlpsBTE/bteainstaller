package dev.nachwahl.bteginstaller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JButton installModpackButton;
    private JButton selectOptionalModsButton;
    public JPanel MainFormPanel;
    private JComboBox modpackVersionDropDown;
    private JLabel versionText;

    public MainForm(final JFrame frame, final InstallUtil installUtil) {

        frame.setResizable(false);
       // String versionNumber = "1.1";
       // versionText.setText("v" + versionNumber);

        modpackVersionDropDown.addItem("1.20.2 (latest)");

        selectOptionalModsButton.addActionListener(e -> {
            JDialog about = new JDialog(frame, "Optional Mods", true);
            about.setContentPane(new OptionsForm(about,installUtil).OptionFormPanel);
            about.setResizable(false);
            about.setSize(500, 300);
            about.setLocationRelativeTo(null);
            about.setVisible(true);
            about.toFront();
            about.repaint();
        });
        installModpackButton.addActionListener(e -> {
            String modpackVersion = modpackVersionDropDown.getSelectedItem().toString();
            JDialog loading = new JDialog(frame, "Installing...", true);
            loading.setContentPane(new LoadingForm(installUtil, frame, loading,modpackVersion).LoadingForm);
            loading.setResizable(false);
            loading.setSize(500, 150);
            loading.setLocationRelativeTo(null);
            loading.setVisible(true);
            loading.toFront();
            loading.repaint();

        });


    }

}
