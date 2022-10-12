package com.groupswd391.fall22.History;

import com.groupswd391.fall22.History.DTO.HistoryRequest;
import com.groupswd391.fall22.History.DTO.HistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    final
    HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @Operation(
            summary = "Tạo 1 history mới ",
            description = "Tạo 1 history mới ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "500", description = "Lỗi Server"),
                    @ApiResponse(responseCode = "403", description = "Truyền sai dữ liệu"),
                    @ApiResponse(responseCode = "401", description = "Lỗi Phân quyền"),
                    @ApiResponse(responseCode = "400", description = "Truyền sai dữ liệu"),
            }
    )
    @PostMapping()
    HistoryResponse addHistory(@Valid @RequestBody HistoryRequest historyRequest) {
        return historyService.createHistory(historyRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteHistory(@PathVariable int id) {
        if (historyService.deleteHistory(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin history ",
            description = "truyền id history muốn thay đổi",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "500", description = "Lỗi Server"),
                    @ApiResponse(responseCode = "403", description = "Truyền sai dữ liệu"),
                    @ApiResponse(responseCode = "401", description = "Lỗi Phân quyền"),
                    @ApiResponse(responseCode = "400", description = "Truyền sai dữ liệu"),
            }
    )
    @PutMapping("/{id}")
    HistoryResponse updateHistory(@Valid @RequestBody HistoryRequest historyRequest, @PathVariable int id) {
        return historyService.updateHistory(historyRequest, id);
    }

    @Operation(
            summary = "Lấy history theo user ID and historyType",
            description = "Truyền giá trị id user and historyType  muốn tìm, bắt buộc"
    )
    @GetMapping("/{userID}{historyTypeID}")
    public ResponseEntity<Map<String, Object>> getApplicationsByUserID(
            @PathVariable(required = false) int userID,
            @PathVariable(required = false) int historyTypeID,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = historyService.getHistory(userID, historyTypeID, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
