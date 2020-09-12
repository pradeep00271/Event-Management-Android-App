package com.example.student.clubhub;

/**
 * Created by Pretha_2015 on 08-09-2017.
 */

public class model {
    String eventName,description,clubName;
    public model(){

    }
    public String getEventName(){
        return eventName;
    }
    public String getDescription(){
        return description;
    }
    public String getClubName(){
        return clubName;
    }
    public void setEventName(String eventName){
        this.eventName=eventName;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setClubName(String clubName){
        this.clubName=clubName;
    }
}
