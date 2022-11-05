package co.edu.uniajc.demo.repository;

import co.edu.uniajc.demo.Model.AccesosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
}
