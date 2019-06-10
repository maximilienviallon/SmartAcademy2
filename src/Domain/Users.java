package Domain;

public class Users {
    private String permission;
    private String username;
    private String apprenticeName;
    private String conName;
    public Users(String permission, String username, String apprenticeName, String conName){
        this.permission = permission;
        this.username = username;
        this.apprenticeName = apprenticeName;
        this.conName = conName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApprenticeName() {
        return apprenticeName;
    }

    public void setApprenticeName(String apprenticeName) {
        this.apprenticeName = apprenticeName;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }
}
