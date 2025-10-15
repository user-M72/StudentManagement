package StudentManagment.API;

import StudentManagment.dto.req.TeacherRequestDto;
import StudentManagment.dto.res.TeacherResponseDto;
import StudentManagment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/teacher/v1")
public class TeacherApi {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherResponseDto> get(){
        return teacherService.get();
    }

    @GetMapping("{teacherId}")
    public TeacherResponseDto getById(@PathVariable("teacherId") UUID id){
        return teacherService.getById(id);
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDto> created(@RequestBody TeacherRequestDto dto){
        TeacherResponseDto create = teacherService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{teacherId}")
    public TeacherResponseDto update(@PathVariable("teacherId") UUID id,
                                     @RequestBody TeacherRequestDto dto){
        return teacherService.updated(id, dto);
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<Void> delete(@PathVariable("teacherId") UUID id){
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
