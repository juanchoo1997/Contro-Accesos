package co.edu.uniajc.demo.controller;


import co.edu.uniajc.demo.Model.AccesosModel;
import co.edu.uniajc.demo.service.AccesosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/accesos")
@Api("Accesos")
public class AcesosController {

    private AccesosService accesosService;

    public AcesosController(AccesosService accesosService) {
        this.accesosService = accesosService;
    }

    @PostMapping(path = "/save")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "ERROR API"),
            @ApiResponse(code = 500, message = "ERROR SERVER")
    })
    public AccesosModel saveAccesos(@RequestBody AccesosModel accesosModel){
        return accesosService.createAcceso(accesosModel);
    }

    @PostMapping(path = "/input")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "ERROR API"),
            @ApiResponse(code = 500, message = "ERROR SERVER")
    })
    public boolean generateInput(@RequestParam(name = "identificacion") String identificacion,@RequestParam(name = "tipo_id") int tipo_id,@RequestParam(name = "usuario") String usuario) {
        try {
            if (accesosService.generateInput(identificacion, tipo_id, usuario)) {
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @PutMapping(path = "/output")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "ERROR API"),
            @ApiResponse(code = 500, message = "ERROR SERVER")
    })
    public boolean generateOutput(@RequestParam(name = "identificacion") String identificacion,@RequestParam(name = "tipo_id") int tipo_id) {
        try {
            if (accesosService.generateOutput(identificacion, tipo_id)) {
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @PutMapping(path = "/update")
    @ApiOperation(value = "update accesos", response = AccesosModel.class)
    public AccesosModel updateAccesos(@RequestBody AccesosModel accesosModel){
        return accesosService.updateAcceso(accesosModel);
    }

    @GetMapping(path = "/findAll")
    @ApiOperation(value = "Find accesos All", response = AccesosModel.class)
    public List<AccesosModel> findAll(){
        return accesosService.findAllAccesos();
    }

    @DeleteMapping(path = "/delete")
    @ApiOperation(value = "Delete accesos por ID", response = AccesosModel.class)
    public void deleteAccesos(@RequestParam(name = "id") long id){
        accesosService.deleteAcceso(id);
    }
}
