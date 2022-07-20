package org.terenin.models;

import lombok.Data;

import java.sql.Date;
import java.util.HashMap;

@Data
public class TimeTable {

    private HashMap<Date, Long> dateAndTimeInorderId;

    public TimeTable(){}

    public TimeTable(HashMap<Date, Long> dateAndTimeInorderId){

        this.dateAndTimeInorderId = dateAndTimeInorderId;

    }


    public HashMap<Date, Long> getDateAndTimeInorderId() {
        return dateAndTimeInorderId;
    }

    public void setDateAndTimeInorderId(HashMap<Date, Long> dateAndTimeInorderId) {
        this.dateAndTimeInorderId = dateAndTimeInorderId;
    }

}
