package com.groupswd391.fall22.Wallet;


import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.User.UserRepository;
import com.groupswd391.fall22.Wallet.dto.WalletRequest;
import com.groupswd391.fall22.Wallet.dto.WalletResponse;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WalletServiceImpl implements WalletService {
    final
    WalletRepository walletRepository;
    final
    UserRepository userRepository;
    final
    ModelMapper modelMapper;

    public WalletServiceImpl(WalletRepository walletRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public WalletResponse createWallet(WalletRequest walletRequest) {
        Wallet wallet = modelMapper.map(walletRequest, Wallet.class);
        User user = userRepository.findById(walletRequest.getUserID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found User")
        );
        wallet.setUser(user);
        wallet.setName(walletRequest.getName());
        wallet.setAmount(walletRequest.getAmount());
        Wallet saveWallet = walletRepository.save(wallet);
        return WalletResponse.buildFromWallet(saveWallet);
    }

    @Override
    public WalletResponse updateWallet(WalletRequest walletRequest, int id) {
        Wallet oldWallet = walletRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Wallet")
        );
        User user = userRepository.findById(walletRequest.getUserID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found User")
        );
        oldWallet.setUser(user);
        oldWallet.setName(walletRequest.getName());
        oldWallet.setAmount(walletRequest.getAmount());
        Wallet saveWallet = walletRepository.save(oldWallet);
        return WalletResponse.buildFromWallet(saveWallet);
    }

    @Override
    public boolean deleteWallet(int id) {
        Wallet wallet = walletRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Wallet")
        );
        walletRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getWallets(int page, int size) {
        List<Wallet> wallets = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Wallet> pageTuts = null;
        pageTuts = walletRepository.findAll(paging);
        wallets = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("wallets", wallets);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
