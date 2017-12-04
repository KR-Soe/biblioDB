package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibroDAO {

    PreparedStatement ps;
    private static final String SQL_INSERT = "insert into alumno values (?,?,?)";
    private static final String SQL_DELETE = "delete from alumno where id=?";
    private static final String SQL_READALL = "select *from alumno";
    private static final String SQL_READ = "select *from alumno where id=?";
    private static final String SQL_UPDATE = "update alumno set nombre = ?, nota = ? WHERE id = ?;";

    private static final Conexion con = Conexion.getInstance();

    public int insert(Libro book) {
        int flag = 0;
        int año;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, book.getIsbn());
            ps.setString(2, book.getNombre());
            ps.setString(3, book.getAutor());
            ps.setInt(4, book.getAnno());
            ps.setInt(5, book.getMes());
            ps.setString(6, book.getTipo());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        return flag;
    }

    public int update(Libro lib) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(3, lib.getIsbn());
            ps.setString(1, lib.getNombre());
            ps.setString(2, lib.getAutor());
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        return flag;
    }

    public int delete(Integer id) {
        int flag = 0;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            flag = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return flag;
    }

    public ArrayList<Libro> readAll() {
        ArrayList<Libro> alumnos = null;
        try {
            alumnos = new ArrayList<>();
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                alumnos.add(new Libro(res.getInt("isbn"), res.getInt("anno"), res.getString("nombre"), res.getString("autor"), res.getString("editorial"), res.getString(""), res.getBoolean("prestamo"), res.getInt("mes")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
//me devuelve (si lo encuentra) un objeto de tipo Alumno (solo 1)

    public Libro read(Integer id) {
        Libro alumno = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                alumno = new Libro(res.getInt("isbn"), res.getInt("anno"), res.getString("nombre"), res.getString("autor"), res.getString("editorial"), res.getString(""), res.getBoolean("prestamo"), res.getInt("mes"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

}
