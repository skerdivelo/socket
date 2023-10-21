import java.io.DataInputStream;
import java.net.ServerSocket;

import javax.swing.JOptionPane;

class ThreadConnessione implements Runnable{
    private PallaNetServer finestra;
    private Thread me;

    public ThreadConnessione(PallaNetServer finestra){
        this.finestra = finestra;
        me = new Thread(this);
        me.start();
    }
    public void run(){
        try{
            ServerSocket server = new ServerSocket(6789);
            finestra.setConnessione(server.accept());
            server.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            System.exit(-1);
        }
    }

    public void setConnessione(Socket connessione){
        this.connessione = connessione;
        try{
            out = new DataOutputStream(connessione.getOutputStream());
            input = new DataInputStream(connessione.getInputStream());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            System.exit(-1);
        }
    }

    PanelloAnimazione pan = new PanelloAnimazione(this, this.getSize());
    this.add(pan);

    public DataInputStream getInput(){
        return input;
    }

    public DataOutputStream getOutput(){
        return out;
    }
}