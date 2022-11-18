package co.edu.uniajc.demo.repository;

import co.edu.uniajc.demo.Model.PersonalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalModel, Long> {

    @Transactional
    @Query(nativeQuery = true, value =
            "select * from personal p where identificacion = :identificacion and tipo_identificacion_idtipo_identificacion = :tipo_id"
    )
    String findPersonal (@Param(value = "identificacion")String identificacion,@Param(value = "tipo_id")int tipo_id);
}
