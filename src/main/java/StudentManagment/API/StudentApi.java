package StudentManagment.API;

import StudentManagment.dto.req.StudentRequestDto;
import StudentManagment.dto.res.StudentResponseDto;
import StudentManagment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/students/v1")
public class StudentApi {

    @Autowired private StudentService service;

    @GetMapping
    public List<StudentResponseDto> get(){
        return service.get();
    }

    @GetMapping("{studentId}")
    public StudentResponseDto getById(@PathVariable("studentId") UUID id){
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> created(@RequestBody StudentRequestDto dto){
        StudentResponseDto create = service.created(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{studentId}")
    public StudentResponseDto updated(@PathVariable("studentId") UUID id,
                                    @RequestBody StudentRequestDto dto){
        return service.updated(id, dto);
    }
    @DeleteMapping("studentId")
    public void delete(@PathVariable("studentId") UUID id){
        service.deleted(id);
    }
}
