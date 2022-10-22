package co.edu.uniajc.demo.controller;


import co.edu.uniajc.demo.Model.AccesosModel;
import co.edu.uniajc.demo.Model.StudentModel;
import co.edu.uniajc.demo.service.AccesosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
