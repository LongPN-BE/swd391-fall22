package com.groupswd391.fall22.User;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.groupswd391.fall22.Major.Major;
import com.groupswd391.fall22.Major.MajorRepository;
import com.groupswd391.fall22.Role.Role;
import com.groupswd391.fall22.Role.RoleRepository;
import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;
import com.groupswd391.fall22.User.DTO.UserDtoResponse;
import com.groupswd391.fall22.User.DTO.UserDtoResponseLogin;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import com.groupswd391.fall22.jwtToken.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final MajorRepository majorRepository;
    final ModelMapper modelMapper;
    final AuthenticationManager manager;
    final UserRoleRepository userRoleRepository;

    final JwtUtil jwtUtil;
    final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, MajorRepository majorRepository, ModelMapper modelMapper,
                           AuthenticationManager manager, UserRoleRepository userRoleRepository,
                           JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.majorRepository = majorRepository;
        this.modelMapper = modelMapper;
        this.manager = manager;
        this.userRoleRepository = userRoleRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity<?> Register(UserDtoRequest userDtoRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(userDtoRequest.getEmail());
        if (optionalUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email is exist");
        }
        User account = modelMapper.map(userDtoRequest, User.class);
        account.setPassword(passwordEncoder.encode(userDtoRequest.getPassword()));

        Optional<Major> optionalMajor = majorRepository.findByName(userDtoRequest.getMajor());
        Optional<Role> optionalRole = roleRepository.findByName("USER");
        if (optionalRole.isPresent() && optionalMajor.isPresent()) {
            Role role = optionalRole.get();
            Major major = optionalMajor.get();
            account.setRole(role);
            account.setMajor(major);
            account.setStatus(true);
            userRepository.save(account);
            return ResponseEntity.ok().body("Create Email Successful");
        }
        return ResponseEntity.badRequest().body("Role or Major not found");

    }


    @Override
    public ResponseEntity<?> Login(UserDtoRequestLogin userDtoRequestLogin) {
        try {
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDtoRequestLogin.getEmail(), userDtoRequestLogin.getPassword())
            );
            User account = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            UserDtoResponseLogin userDtoResponse = new UserDtoResponseLogin(account.getEmail(), accessToken);
            return ResponseEntity.ok(userDtoResponse);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.badRequest().body("Email Failing");
        }
    }

    @Override
    public ResponseEntity<?> LoginFireBase(String token) {
        try {

            FirebaseToken decoded = FirebaseAuth.getInstance().verifyIdToken(token);
            String email = decoded.getEmail();
            System.out.println("Email: " + email);
            User user = userRepository.findByEmail(email).orElseThrow(
                    () -> new NotFoundException("Not found User")
            );
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            User account = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            UserDtoResponseLogin userDtoResponse = new UserDtoResponseLogin(account.getEmail(), accessToken);
            return ResponseEntity.ok(userDtoResponse);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.badRequest().body("Email Failing");
        } catch (FirebaseAuthException e) {
            return ResponseEntity.badRequest().body("Email Failing");
        }
    }

    @Override
    public Map<String, Object> getUsers(String fullname, int page, int size) {
        List<User> users;
        Pageable paging = PageRequest.of(page, size);
        Page<User> pageTuts;
        if (fullname == null)
            pageTuts = userRepository.findAll(paging);
        else
            pageTuts = userRepository.findByFullnameContaining(fullname, paging);
        users = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("accounts", users);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    public Map<String, Object> getUsersByMajor(String major, int page, int size) {
        List<User> users;
        Pageable paging = PageRequest.of(page, size);
        Page<User> pageTuts;
        if (major == null)
            pageTuts = userRepository.findAll(paging);
        else
            pageTuts = userRepository.findUsersByMajor(major, paging);
        users = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("accounts", users);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public User getUsersByID(int userID) {
        return userRepository.getUserById(userID);
    }

    @Override
    public UserDtoResponse updateUser(UserDtoRequest userDtoRequest, int id) {
        User oldUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found User")
        );
        Optional<Major> optionalMajor = majorRepository.findByName(userDtoRequest.getMajor());
        Optional<Role> optionalRole = roleRepository.findByName("USER");
        modelMapper.map(userDtoRequest, oldUser);
        Role role = optionalRole.get();
        Major major = optionalMajor.get();
        oldUser.setRole(role);
        oldUser.setMajor(major);
        oldUser.setStatus(true);
        oldUser.setFullname(userDtoRequest.getFullname());
        oldUser.setEmail(userDtoRequest.getEmail());
        oldUser.setDob(userDtoRequest.getDob());
        oldUser.setPhone(userDtoRequest.getPhone());
        oldUser.setImg(userDtoRequest.getImg());
        User saveUser = userRepository.save(oldUser);
        return UserDtoResponse.buildFromUser(saveUser);
    }

    @Override
    public ResponseEntity<?> getUserById(int id) {
        try {
            User user = userRepository.findById(id).orElseThrow(
                    () -> new NotFoundException("Not found User")
            );
            return ResponseEntity.ok(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.badRequest().body("Found Failing");
        }
    }

    @Override
    public boolean deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found User")
        );
        userRepository.deleteById(id);
        return true;
    }


}
