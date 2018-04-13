package codigo;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*Hashmap. Almacenamos objetos y le asignamos un ID. Es una estructura dinámica. Se puede acceder a cualquier elemento
por su clave. La búsqueda que hace el hashmap es una búsqueda binaria.*/


public class VentanaPokedex extends javax.swing.JFrame {

    Connection conexion;
    Statement estado;
    ResultSet resultado;
    
    ArrayList<String> lista= new ArrayList();
    
    //Valores dentro del arraylist.
    
    int num=1;
    int nombre=0;
    int altura=1;
    int peso=2;
    int croma=3;
    int habitat=4;
    
    BufferedImage plantilla=null;
    int ancho=260;
    int alto=260;
    int pos=0;
    
     private ImageIcon devuelveElPokemonQueEstaEnLaPosicion (int posicion){
        int columna = posicion / 31;
        int fila = posicion % 31;
        return ( new ImageIcon(plantilla.getSubimage(fila*96, columna*96, 96, 96)
                .getScaledInstance(ancho, alto, Image.SCALE_DEFAULT))); 
    }
 
    
    public VentanaPokedex() {
        initComponents();
        
//        this.setComponentZOrder(jLabel2, 0);  //Orden de las capas.
//        this.setComponentZOrder(jLabel1, 1);
//        this.setComponentZOrder(jLabel3, 0);
//        this.setComponentZOrder(jLabel4, 0);
//        this.setComponentZOrder(jLabel5, 0);
//        this.setComponentZOrder(jLabel6, 0);
//        this.setComponentZOrder(jLabel7, 0);
//        this.setComponentZOrder(jLabel8, 0);
//        this.setComponentZOrder(jLabel9, 0);
//        this.setComponentZOrder(jLabel10, 0);
//        this.setComponentZOrder(jLabel11, 0);
        
        conecta();
        //dibujaFondo();
        
        
       try{
            plantilla = ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
        }
        catch (IOException e){} 
       
       
       
    }

    private void conecta(){
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1/pokemon", "root","root");
            estado=conexion.createStatement();
            
            resultado=estado.executeQuery("SELECT * FROM pokemon");
            
            while(resultado.next()){
            
                lista.add(resultado.getString("name")); //0
                lista.add(resultado.getString("height")); //1
                lista.add(resultado.getString("weight")); //2
                lista.add(resultado.getString("color")); //3
                lista.add(resultado.getString("habitat")); //4
                
            }
            
            System.out.println(lista.size());
        
        }
        catch(SQLException s){
         System.out.println("NO SE HA PODIDO CONECTAR CON EL SERVIDOR");
       }
       
       catch(ClassNotFoundException c){
         System.out.println(c.getMessage());
       }
       
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    
    }
    
   
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 60, 50));

        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 260, 210));

        jLabel4.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 220, 50));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 50, 40));

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 50, 40));

        jLabel7.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("nombre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 110, 30));

        jLabel8.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("habitat");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 100, 30));

        jLabel9.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("alto");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 40, 30));

        jLabel10.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("peso");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 40, 30));

        jLabel11.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("color");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        
        if(habitat+5<lista.size()){
        jLabel2.setText(String.valueOf(num));
        jLabel4.setText(lista.get(nombre));
        jLabel7.setText(lista.get(nombre));
        jLabel8.setText(lista.get(habitat));
        jLabel9.setText(lista.get(altura));
        jLabel10.setText(lista.get(peso));
        jLabel11.setText(lista.get(croma));
        
        jLabel3.setIcon(devuelveElPokemonQueEstaEnLaPosicion(pos));
        
        num++;
        pos++;
        nombre+=5;
        altura+=5;
        peso+=5;
        croma+=5;
        habitat+=5;
        }
        
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        if(nombre-5>=0){
        
        jLabel2.setText(String.valueOf(num));
        jLabel4.setText(lista.get(nombre));
        jLabel7.setText(lista.get(nombre));
        jLabel8.setText(lista.get(habitat));
        jLabel9.setText(lista.get(altura));
        jLabel10.setText(lista.get(peso));
        jLabel11.setText(lista.get(croma));
        
        jLabel3.setIcon(devuelveElPokemonQueEstaEnLaPosicion(pos));
        
        num--;
        pos--;
        nombre-=5;
        altura-=5;
        peso-=5;
        croma-=5;
        habitat-=5;
        }
    }//GEN-LAST:event_jLabel6MousePressed

    /*int num=0;
    int nombre=0;
    int altura=1;
    int peso=2;
    int croma=3;
    int habitat=4;*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
