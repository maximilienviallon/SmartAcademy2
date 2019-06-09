package Domain;

public class Permissions {
    private String permission;
    private Integer permissionID;
    private Integer companyID;
    public Permissions(String permission, Integer permissionID, Integer companyID){
        this.permission = permission;
        this.permissionID = permissionID;
        this.companyID = companyID;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }
}
