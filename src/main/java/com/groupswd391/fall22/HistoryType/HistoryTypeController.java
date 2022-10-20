package com.groupswd391.fall22.HistoryType;

import com.groupswd391.fall22.HistoryType.DTO.HistoryTypeRequest;
import com.groupswd391.fall22.HistoryType.DTO.HistoryTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/historyTypes")
public class HistoryTypeController {

    final
    HistoryTypeService historyTypeService;

    public HistoryTypeController(HistoryTypeService historyTypeService) {
        this.historyTypeService = historyTypeService;
    }

    @Operation(
            summary = "Tạo 1 history type mới ",
            description = "Tạo 1 history type mới "
    )
    @PostMapping()
    HistoryTypeResponse addHistoryType(@Valid @RequestBody HistoryTypeRequest historyTypeRequest) {
        return historyTypeService.createHistoryType(historyTypeRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteHistoryType(@PathVariable int id) {
        if (historyTypeService.deleteHistoryType(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin history type",
            description = "truyền id history type muốn thay đổi"
    )
    @PutMapping("/{id}")
    HistoryTypeResponse updateHistoryType(@Valid @RequestBody HistoryTypeRequest historyTypeRequest, @PathVariable int id) {
        return historyTypeService.updateHistoryType(historyTypeRequest, id);
    }

    @Operation(
            summary = "Lấy history types",
            description = "Truyền giá trị name if want to find else get all"
    )
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getHistoryType(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = historyTypeService.getHistoryType(page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
