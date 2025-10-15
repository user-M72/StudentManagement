package StudentManagment.API;

import StudentManagment.dto.req.EnrollmentRequestDto;
import StudentManagment.dto.res.EnrollmentResponseDto;
import StudentManagment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/enrollment/v1")
public class EnrollmentApi {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentResponseDto> get(){
        return enrollmentService.get();
    }

    @GetMapping("{enrollmentId}")
    public EnrollmentResponseDto getById(@PathVariable("enrollmentId") UUID id){
        return enrollmentService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<EnrollmentResponseDto> create(@RequestBody EnrollmentRequestDto dto){
        EnrollmentResponseDto create = enrollmentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{enrollmentId}")
    public EnrollmentResponseDto update(@PathVariable("enrollmentId") UUID id,
                                                        @RequestBody EnrollmentRequestDto dto){
        return enrollmentService.update(id,dto);
    }

    @DeleteMapping("{enrollmentId}")
    public ResponseEntity<Void> delete(@PathVariable("enrollmentId")UUID id){
         enrollmentService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
