package dto;

public class LoginResponse {
    private boolean exists;
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(boolean exists, String role) {
        this.exists = exists;
        this.role = role;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
