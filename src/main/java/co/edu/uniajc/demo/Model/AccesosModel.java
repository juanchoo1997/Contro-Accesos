package co.edu.uniajc.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accesos")
public class AccesosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idaccesos")
    private Long idaccesos;

    @Column (name = "personal_idpersonal")
    private Long personal_idpersonal;

    @Column (name = "usuarios_idusuarios")
    private Long usuarios_idusuarios;

    @Column (name = "fecha_ingreso")
    private Date  fecha_ingreso;

    @Column (name = "fecha_salida")
    private Date fecha_salida;

    @Column (name = "fecha_registro")
    private Date fecha_registro;

    public AccesosModel() {

    }

    public AccesosModel(long idaccesos, long personal_idpersonal, long usuarios_idusuarios, Date fecha_ingreso, Date fecha_salida, Date fecha_registro) {
        this.idaccesos = idaccesos;
        this.personal_idpersonal = personal_idpersonal;
        this.usuarios_idusuarios = usuarios_idusuarios;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.fecha_registro = fecha_registro;
    }

    public Long getIdaccesos() {
        return idaccesos;
    }

    public void setIdaccesos(Long idaccesos) {
        this.idaccesos = idaccesos;
    }

    public Long getPersonal_idpersonal() {
        return personal_idpersonal;
    }

    public void setPersonal_idpersonal(Long personal_idpersonal) {
        this.personal_idpersonal = personal_idpersonal;
    }

    public Long getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(Long usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
