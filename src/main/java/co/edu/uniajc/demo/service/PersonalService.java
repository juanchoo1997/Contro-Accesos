package co.edu.uniajc.demo.service;
import co.edu.uniajc.demo.Model.PersonalModel;
import co.edu.uniajc.demo.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class PersonalService {

    private final PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    String dateTime = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss").format(LocalDateTime.now());

    Date date = new Date();

    public PersonalModel createPersonal (PersonalModel personalModel){
        //personalModel.setFecha_registro(DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss").format(LocalDateTime.now()));
        return personalRepository.save(personalModel);
    }

    public List<PersonalModel> findAllPersonal (){
        return personalRepository.findAll();
    }

    public boolean validarPersonal ( String identificacion,int tipo_id){
        if (personalRepository.findPersonal(identificacion,tipo_id) == null){
            return false;
        }else {
            return true;
        }
    }

}
