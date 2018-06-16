/**
 *
 * @author Jesus Ivan
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class Tablas extends JFrame {
    public static int ANCHURA=700;
    public static int ALTURA=300;
    public static String TITULO="Viruz Blog: Primer JTable";
  
    /*El array(MATRIZ) datos contendrá los valores iniciales de la tabla y el array nombrecolumnas los
    encabezados de las columnas. La tabla se insertará en el ScrollPane miscroll: */
    Object[][] datos={
        {"Francisco","Perez","Fernandez", 25,"Programador", true},
        {"Alicia","Sanchez","Oliver", 30,"Administrativo", false},
        {"Fernando","Castro","Plaza", 17,"Estudiante", true},
        {"Fermin","Saez","Fermoso", 24,"Albañil", false},
        {"Veronica","Martin","Hernandez", 27,"Estudiante", false},
        {"Lucia","Garcia","Fernandez",23,"Ama de casa", false},
        {"Miguel","Pazos","Heredia", 45,"Abogado", true}
    };
  
    String[] nombrecolumnas={"Nombre","Primer apellido","Segundo apellido",
                            "Edad","Profesion","Socio"};
  //se instancia la clase y se le asignan los datos
    JTable mitabla=new JTable(datos,nombrecolumnas);
  //Crear un contenedor como un JPanel, JScrollPane, o un JTabbedPane Para 
  //Añadir Componentes en Un JFrame
    JScrollPane miscroll;
  
    public Tablas() {
        super(TITULO);
        setSize(ANCHURA,ALTURA);
        move(50,50);
        addComponentes();
        addEventos();
        setVisible(true);
    }
    
    private void addComponentes(){
        JComboBox comboBox= new JComboBox();
        comboBox.addItem(true);
        comboBox.addItem(false);
    //getColumnModel() regresa a TableColumn todas las columnas de la tabla
    //getColumn(5) indica en que Columna va aparecer el JCombo Box
        TableColumn columnaSocio=mitabla.getColumnModel().getColumn(5);
        //agrega ala Tabla las Opciones de comboBox
        columnaSocio.setCellEditor(new DefaultCellEditor(comboBox));

        miscroll=new JScrollPane(mitabla);
        //setContentPane para convertirlo en el panel de contenido del frame. 
        setContentPane(miscroll);
    }
   
    private void addEventos(){
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
         });
      } 
}