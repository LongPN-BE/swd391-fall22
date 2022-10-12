package com.groupswd391.fall22.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

import com.groupswd391.fall22.Major.Major;
import com.groupswd391.fall22.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "role_ID", referencedColumnName = "id")
    private Role role;

    @ManyToOne( targetEntity = Major.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "major_ID", referencedColumnName = "id")
    private Major major;

    private String fullname;

    @Column(name = "password")
    private String password;

    @Column(unique = true)
    private String email;
    private String phone;
    private Date dob;
    private Integer legit;
    private boolean status;
    private String img;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
