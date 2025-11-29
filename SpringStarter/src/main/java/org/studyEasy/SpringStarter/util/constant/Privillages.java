package org.studyEasy.SpringStarter.util.constant;

public enum Privillages {

    RESET_ANY_USER_PASSWORD(1l, "RESET_ANY_USER_PASSWORD"),
    ACCESS_ANY_ADMIN_PANEL(2l, "ACCESS_ADMIN_PANEL");

    private Long id;
    private String privillage;
    private Privillages(Long authorityId, String authorityString){
        this.id = authorityId;
        this.privillage = authorityString;
    }

    public Long getId(){
        return id;
    }

    public String getPrivillage(){
        return privillage;
    }
    
}
