package co.edu.uniajc.demo.repository;

import co.edu.uniajc.demo.Model.AccesosModel;
import co.edu.uniajc.demo.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesosRepository extends JpaRepository<AccesosModel, Long> {

}
