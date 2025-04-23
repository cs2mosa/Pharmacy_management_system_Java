package Class_model;

public final class Role {
    private String ID;
    private String RoleName;
    private int PermissionsLevel;  
    private String Description;  
    
    //contructors , setters , getters and other functionalities 
    public Role(String ID, String RoleName, int PermissionsLevel, String Description){
        this.Description = Description;
        this.ID = ID;
        this.PermissionsLevel = PermissionsLevel;
        this.RoleName = RoleName;
    }
    public String getID() {
        return ID;
    }
    public String getRoleName() {
        return RoleName;
    }
    public int getPermissionsLevel() {
        return PermissionsLevel;
    }
    public String getDescription() {
        return Description;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }
    public void setPermissionsLevel(int PermissionsLevel) {
        this.PermissionsLevel = PermissionsLevel;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            Role role = (Role) obj;
            return (PermissionsLevel == role.PermissionsLevel);
        }
        else if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        else{
            return false;
        }
    }
}
