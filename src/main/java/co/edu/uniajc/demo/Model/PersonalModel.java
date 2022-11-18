package co.edu.uniajc.demo.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personal")
public class PersonalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idpersonal")
    private Long idpersonal;

    @Column (name = "identificacion")
    private String identificacion;

    @Column (name = "tipo_identificacion_idtipo_identificacion")
    private Integer tipo_identificacion_idtipo_identificacion;

    @Column (name = "tipo_personal_idtipo_personal")
    private Integer tipo_personal_idtipo_personal;

    @Column (name = "nombres")
    private String nombres;

    @Column (name = "apellidos")
    private String apellidos;

    @Column (name = "empresa")
    private String empresa;

    @Column (name = "estado")
    private Integer estado;

    @Column (name = "direccion")
    private String direccion;

    @Column (name = "telefono")
    private String telefono;

    @Column (name = "fecha_registro")
    private Date fecha_registro;

    public PersonalModel() {
    }

    public PersonalModel(Long idpersonal, String identificacion, Integer tipo_identificacion_idtipo_identificacion, Integer tipo_personal_idtipo_personal, String nombres, String apellidos, String empresa, Integer estado, String direccion, String telefono, Date fecha_registro) {
        this.idpersonal = idpersonal;
        this.identificacion = identificacion;
        this.tipo_identificacion_idtipo_identificacion = tipo_identificacion_idtipo_identificacion;
        this.tipo_personal_idtipo_personal = tipo_personal_idtipo_personal;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.empresa = empresa;
        this.estado = estado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
    }

    public Long getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Long idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getTipo_identificacion_idtipo_identificacion() {
        return tipo_identificacion_idtipo_identificacion;
    }

    public void setTipo_identificacion_idtipo_identificacion(Integer tipo_identificacion_idtipo_identificacion) {
        this.tipo_identificacion_idtipo_identificacion = tipo_identificacion_idtipo_identificacion;
    }

    public Integer getTipo_personal_idtipo_personal() {
        return tipo_personal_idtipo_personal;
    }

    public void setTipo_personal_idtipo_personal(Integer tipo_personal_idtipo_personal) {
        this.tipo_personal_idtipo_personal = tipo_personal_idtipo_personal;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
