package com.sjsu.vansbackend.userAuth.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sjsu.vansbackend.courses.Course;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
@Data
public class ApplicationUser implements UserDetails{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
	@Column(unique=true)
    private String username;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="user_role_junction",
        joinColumns = {@JoinColumn(name="user_id")},
        inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> authorities;

	@OneToMany(mappedBy = "professor")
	private Set<Course> taughtCourses = new HashSet<>(); // Courses taught by this user (professor)

	@ManyToMany
	private Set<Course> enrolledCourses = new HashSet<>(); // Courses enrolled by this user (student)


	public ApplicationUser() {
		super();
		authorities = new HashSet<>();
	}

	public ApplicationUser(Integer userId, String username, String password, Set<Role> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.authorities = authorities;

	}
//	public ApplicationUser(Integer userId, String username, String password, Set<Role> authorities, Set<Course> taughtCourses, Set<Course> enrolledCourses) {
//		super();
//		this.userId = userId;
//		this.username = username;
//		this.password = password;
//		this.authorities = authorities;
//		this.taughtCourses = taughtCourses;
//		this.enrolledCourses = enrolledCourses;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/* If you want account locking capabilities create variables and ways to set them for the methods below */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
}
