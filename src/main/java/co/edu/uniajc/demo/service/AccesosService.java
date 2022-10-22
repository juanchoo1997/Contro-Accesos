package co.edu.uniajc.demo.service;


import co.edu.uniajc.demo.Model.AccesosModel;
import co.edu.uniajc.demo.Model.StudentModel;
import co.edu.uniajc.demo.repository.AccesosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccesosService {

    private final AccesosRepository accesosRepository;

    @Autowired
    public AccesosService(AccesosRepository accesosRepository) {
        this.accesosRepository = accesosRepository;
    }

    public AccesosModel createAcceso (AccesosModel accesosModel){
        return accesosRepository.save(accesosModel);
    }

    public AccesosModel updateAcceso (AccesosModel accesosModel){
        return accesosRepository.save(accesosModel);
    }

    public List<AccesosModel> findAllAccesos (){
        return accesosRepository.findAll();
    }

    public void deleteAcceso  (long id){
        accesosRepository.deleteById(id);
    }}
