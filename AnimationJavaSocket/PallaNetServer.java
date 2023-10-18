import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.swing.*;
import javax.swing.JFrame;

public class PallaNetServer extends JFrame{
    private Socket connessione = null;
    private DataOutputStream out = null;
    private DataInputStream input = null;
    public PallaNetServer(){
        super("PallaNet - Server");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ThreadConnessione attendi = new ThreadConnessione();
        this.setVisible(true);
    }
}