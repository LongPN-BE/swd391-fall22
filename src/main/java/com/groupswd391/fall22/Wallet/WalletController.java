//package com.groupswd391.fall22.Wallet;
//
//import com.groupswd391.fall22.Wallet.Wallet;
//import com.groupswd391.fall22.Wallet.WalletRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class WalletController {
//
//    @Autowired
//    private WalletRepository walletRepository;
//
//    @RequestMapping(value = "/wallet/", method = RequestMethod.GET)
//    public ResponseEntity<List<Wallet>> listAllMajor(){
//        List<Wallet> listWallets = walletRepository.findAll();
//        if(listWallets.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Wallet>>(listWallets, HttpStatus.OK);
//    }
//}
