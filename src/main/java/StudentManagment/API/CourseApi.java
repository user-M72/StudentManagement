package StudentManagment.API;

import StudentManagment.dto.req.CourseRequestDto;
import StudentManagment.dto.res.CourseResponseDto;
import StudentManagment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses/v1")
public class CourseApi {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<CourseResponseDto> get(){
        return service.get();
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> created(@RequestBody CourseRequestDto dto){

        CourseResponseDto create = service.created(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

}
