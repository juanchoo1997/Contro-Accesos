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

    @Column (name = "tipo_identificacion")
    private String tipo_identificacion;

    @Column (name = "personal_idpersonal")
    private Long personal_idpersonal;

    @Column (name = "usuarios_idusuarios")
    private Long usuarios_idusuarios;

    @Column (name = "fecha_ingreso")
    private String  fecha_ingreso;

    @Column (name = "fecha_salida")
    private String fecha_salida;

    @Column (name = "fecha_registro")
    private String fecha_registro;

    @Column (name = "estado")
    private String estado;

    public AccesosModel() {

    }

    public AccesosModel(Long idaccesos, String tipo_identificacion, Long personal_idpersonal, Long usuarios_idusuarios, String fecha_ingreso, String fecha_salida, String fecha_registro, String estado) {
        this.idaccesos = idaccesos;
        this.tipo_identificacion = tipo_identificacion;
        this.personal_idpersonal = personal_idpersonal;
        this.usuarios_idusuarios = usuarios_idusuarios;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public Long getIdaccesos() {
        return idaccesos;
    }

    public void setIdaccesos(Long idaccesos) {
        this.idaccesos = idaccesos;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
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

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
