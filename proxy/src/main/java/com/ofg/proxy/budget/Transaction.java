package com.ofg.proxy.budget;


import java.util.Date;

public class Transaction {
    
    private String comment;

    private Date when;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
}
