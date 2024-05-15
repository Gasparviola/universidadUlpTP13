
import java.sql.*;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        
        Connection con = Conexion.getConexion();
               
                                   
        //Insertando Alumnos 
        String sqlAlumno1 = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) VALUES (42298745,'Perri','Diego', '2000-05-13',1)";
        String sqlAlumno2 = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) VALUES (42211745,'Lucero','Gaspar', '1998-03-10',1)";
        String sqlAlumno3 = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) VALUES (49011745,'Stampanoni','Joaquin', '1970-01-19',1)";
        String sqlAlumno4 = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) VALUES (42204589,'Viola','Nahuel', '2004-05-19',1)";
        
        //Insertando Materias
        String sqlMateria1 = "INSERT INTO materia(nombre,año,estado) VALUES ('Programacion',2020,1)";
        String sqlMateria2 = "INSERT INTO materia(nombre,año,estado) VALUES ('Ciencias Naturales',2010,1)";
        String sqlMateria3 = "INSERT INTO materia(nombre,año,estado) VALUES ('Matematicas 1',2015,1)";
        String sqlMateria4 = "INSERT INTO materia(nombre,año,estado) VALUES ('Ingenieria en Software',2024,1)";
        
        //Inscribiendo alumnos a las materias
        String sqlInscripcion1 = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (8,1,2)";
        String sqlInscripcion2 = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES 10,2,1)";
        String sqlInscripcion3 = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES 6,3,4)";
        String sqlInscripcion4 = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES 7,1,4)";
        String sqlInscripcion5 = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES 9,2,3)";
        String sqlInscripcion6 = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES 4,3,2)";
        
        
        //Listando alumnos
        String sqlListadoAlumnos = "SELECT * FROM alumno a, inscripcion i WHERE "
                + "a.idAlumno = i.idAlumno AND i.nota > 8";
        
        try {
            
            //Insertando Alumnos
            PreparedStatement psAl1 = con.prepareStatement(sqlAlumno1);
            psAl1.executeUpdate();
            System.out.println("Se ha insertado el alumno 1");
            
            PreparedStatement psAl2 = con.prepareStatement(sqlAlumno2);
            psAl2.executeUpdate();
            System.out.println("Se ha insertado el alumno 2");
            
            PreparedStatement psAl3 = con.prepareStatement(sqlAlumno3);
            psAl3.executeUpdate();
            System.out.println("Se ha insertado el alumno 3");
            
            PreparedStatement psAl4 = con.prepareStatement(sqlAlumno4);
            psAl4.executeUpdate();
            System.out.println("Se ha insertado el alumno 4");
            
            //Insertando Materias
            PreparedStatement psMat1 = con.prepareStatement(sqlMateria1);
            psMat1.executeUpdate();
            System.out.println("Se ha insertado la materia 1");
            
            PreparedStatement psMat2 = con.prepareStatement(sqlMateria2);
            psMat2.executeUpdate();
            System.out.println("Se ha insertado la materia 2");
            
            PreparedStatement psMat3 = con.prepareStatement(sqlMateria3);
            psMat3.executeUpdate();
            System.out.println("Se ha insertado la materia 3");
            
            PreparedStatement psMat4 = con.prepareStatement(sqlMateria4);
            psMat4.executeUpdate();
            System.out.println("Se ha insertado la materia 4");
            
            //Inscribiendo a los alumnos a 2 materias cada uno
            
            PreparedStatement psIns1 = con.prepareStatement(sqlInscripcion1);
            psIns1.executeUpdate();
            System.out.println("Se ha inscripto al alumno 1 en la materia 2");
            
            PreparedStatement psIns2 = con.prepareStatement(sqlInscripcion2);
            psIns2.executeUpdate();
            System.out.println("Se ha inscripto al alumno 2 en la materia 1");
            
            PreparedStatement psIns3 = con.prepareStatement(sqlInscripcion3);
            psIns3.executeUpdate();
            System.out.println("Se ha inscripto al alumno 3 en la materia 4");
            
            PreparedStatement psIns4 = con.prepareStatement(sqlInscripcion4);
            psIns4.executeUpdate();
            System.out.println("Se ha inscripto al alumno 1 en la materia 4");
            
            PreparedStatement psIns5 = con.prepareStatement(sqlInscripcion5);
            psIns5.executeUpdate();
            System.out.println("Se ha inscripto al alumno 2 en la materia 3");
            
            PreparedStatement psIns6 = con.prepareStatement(sqlInscripcion6);
            psIns6.executeUpdate();
            System.out.println("Se ha inscripto al alumno 3 en la materia 2");
            
            
            //Listando Alumnos con nota superior a 8
            PreparedStatement ps = con.prepareStatement(sqlListadoAlumnos);
            
            ResultSet datos = ps.executeQuery();
            while(datos.next()){
                
                int id = datos.getInt("idAlumno");
                int dni = datos.getInt("dni");
                String apellido = datos.getString("apellido");
                String nombre = datos.getString("nombre");
                Date fechaNacimiento = datos.getDate("fechaNacimiento");
                
                System.out.println("Id: " + id);
                System.out.println("Dni: " + dni);
                System.out.println("Apellido: " + apellido);
                System.out.println("Nombre " + nombre);
                System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
                
                System.out.println("");
                
                
            }
            
            //Desinscribir un alumno de una de las materias
            String sqlDesinscribir = "DELETE FROM inscripcion WHERE idInscripto = 3";
            PreparedStatement desinscribir = con.prepareStatement(sqlDesinscribir);
            desinscribir.executeUpdate();
            
 
            
            
        } catch (SQLException ex) {           
            JOptionPane.showMessageDialog(null, "Error de conexion ");
        }
        
    }        
    
}
