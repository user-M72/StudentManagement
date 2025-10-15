package StudentManagment.API;

import StudentManagment.dto.req.DepartmentRequestDto;
import StudentManagment.dto.res.DepartmentResponseDto;
import StudentManagment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/department/v1")
public class DepartmentApi {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentResponseDto> get(){
        return departmentService.get();
    }

    @GetMapping("{departmentId}")
    public DepartmentResponseDto getById(@PathVariable("departmentId")UUID id){
        return departmentService.getByID(id);
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> create(@RequestBody DepartmentRequestDto dto){
        DepartmentResponseDto create = departmentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("{departmentId}")
    public DepartmentResponseDto update(@PathVariable("departmentId") UUID id,
                                        @RequestBody DepartmentRequestDto dto){
        return departmentService.update(id, dto);
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<Void> delete(@PathVariable("departmentId") UUID id){
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
