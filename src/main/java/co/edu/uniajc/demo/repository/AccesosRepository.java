package co.edu.uniajc.demo.repository;

import co.edu.uniajc.demo.Model.AccesosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccesosRepository extends JpaRepository<AccesosModel, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value =
        "INSERT INTO " +
        "accesos (personal_idpersonal, usuarios_idusuarios,fecha_ingreso,fecha_registro,estado) " +
        "VALUES (" +
        "(select idpersonal  from personal p where identificacion = :identificacion and tipo_identificacion_idtipo_identificacion = :tipo_id)," +
        "(select u.idusuarios from usuarios u where u.usuario = :usuario)," +
        "CURRENT_TIMESTAMP," +
        "CURRENT_TIMESTAMP," +
        "TRUE)"
    )
    Integer generateInput (@Param(value = "identificacion")String identificacion,@Param(value = "tipo_id")int tipo_id,@Param(value = "usuario")String usuario);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value =
        "UPDATE accesos as a\n" +
        "SET fecha_salida  = current_timestamp, \n" +
        "estado = false,\n" +
        "fecha_registro = current_timestamp \n" +
        "where\n" +
        "personal_idpersonal = (select idpersonal  from personal p where identificacion = :identificacion and tipo_identificacion_idtipo_identificacion = :tipo_id)\n" +
        "and estado = true\n" +
        "and fecha_registro = (SELECT MAX(fecha_registro) FROM accesos);"
    )
    Integer generateOutput (@Param(value = "identificacion")String identificacion,@Param(value = "tipo_id")int tipo_id);

    @Transactional
    @Query(nativeQuery = true, value =
            "select\n" +
                    "\ta.idaccesos,\n" +
                    "\tcase\n" +
                    "\t\tp.tipo_identificacion_idtipo_identificacion  \n" +
                    "\t\twhen 1 then 'CC'\n" +
                    "\t\twhen 2 then 'TI'\n" +
                    "\t\telse 'ERROR'\n" +
                    "\tend as tipo_identificacion,\n" +
                    "\tp.identificacion as personal_idpersonal,\n" +
                    "\tu.usuario as usuarios_idusuarios,\n" +
                    "\tTO_CHAR(a.fecha_ingreso, 'dd-mm-yyyy hh:mm:ss') as fecha_ingreso,\n" +
                    "\tTO_CHAR(a.fecha_salida, 'dd-mm-yyyy hh:mm:ss') as fecha_salida,\n" +
                    "\tTO_CHAR(a.fecha_registro, 'dd-mm-yyyy hh:mm:ss') as fecha_registro,\n" +
                    "\tcase\n" +
                    "\t\ta.estado\n" +
                    "\t\twhen true then 'INGRESO'\n" +
                    "\t\twhen false then 'SALIO'\n" +
                    "\t\telse 'ERROR'\n" +
                    "\tend as estado\n" +
                    "from\n" +
                    "\taccesos a,\n" +
                    "\tpersonal p,\n" +
                    "\tusuarios u\n" +
                    "where\n" +
                    "\ta.personal_idpersonal = p.idpersonal\n" +
                    "\tand \n" +
                    "\ta.usuarios_idusuarios = u.idusuarios;"
    )
    List<AccesosModel> findAccess ();
}
