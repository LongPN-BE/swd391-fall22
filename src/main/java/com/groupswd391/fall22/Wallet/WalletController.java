package com.groupswd391.fall22.Wallet;

import com.groupswd391.fall22.Wallet.dto.WalletRequest;
import com.groupswd391.fall22.Wallet.dto.WalletResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    final
    WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> getWallets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(walletService.getWallets(page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 wallet mới ",
            description = "Tạo 1 wallet mới "
    )
    @PostMapping()
    WalletResponse addWallet(@Valid @RequestBody WalletRequest walletRequest) {
        return walletService.createWallet(walletRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteWallet(@PathVariable int id) {
        if (walletService.deleteWallet(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin wallet",
            description = "truyền id wallet muốn thay đổi"
    )
    @PutMapping("/{id}")
    WalletResponse updateWallet(@Valid @RequestBody WalletRequest walletRequest, @PathVariable int id) {
        return walletService.updateWallet(walletRequest, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findWalletByID(@PathVariable int id) {
        return walletService.getWalletById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findWalletByUserID(@PathVariable int userId) {
        return walletService.getWalletByUser(userId);
    }
}
