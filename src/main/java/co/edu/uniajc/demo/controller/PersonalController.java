package co.edu.uniajc.demo.controller;

import co.edu.uniajc.demo.Model.AccesosModel;
import co.edu.uniajc.demo.Model.PersonalModel;
import co.edu.uniajc.demo.service.PersonalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/personal")
@Api("personal")
public class PersonalController {

    private PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @PostMapping(path = "/save")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "ERROR API"),
            @ApiResponse(code = 500, message = "ERROR SERVER")
    })
    public PersonalModel savePersonal(@RequestBody PersonalModel personalModel){
        return personalService.createPersonal(personalModel);
    }

    @GetMapping(path = "/findAll")
    @ApiOperation(value = "Find accesos All", response = PersonalModel.class)
    public List<PersonalModel> findAll(){
        return personalService.findAllPersonal();
    }

    @PostMapping (path = "/validarpersonal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "ERROR API"),
            @ApiResponse(code = 500, message = "ERROR SERVER")
    })
    public boolean validarPersonal(@RequestParam(name = "identificacion") String identificacion,@RequestParam(name = "tipo_id") int tipo_id) {
        try {
            if (personalService.validarPersonal(identificacion, tipo_id)==true) {
                return true;
            }else{
                return false;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
