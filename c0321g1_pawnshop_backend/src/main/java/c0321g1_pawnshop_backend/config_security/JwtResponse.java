package c0321g1_pawnshop_backend.config_security;

import c0321g1_pawnshop_backend.entity.employee.Employee;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String userTime;
    private Employee employee;
    private List<String> roles;

    public JwtResponse() {
    }

    public JwtResponse(String token, Long id, String username, String userTime, Employee employee, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.userTime = userTime;
        this.employee = employee;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
