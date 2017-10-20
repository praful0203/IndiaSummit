package com.prafulmishra.indiasummit.data;

/**
 * Created by Praful on 18-10-2017.
 */

public class Participant {
    String name;
    String city;
    String college_org;
    String mobile;
    String mailid;
    String expect;
    String events_attended;
    Float tech_skills;
    Float lead_skills;
    String next_5years;
    String attend_event;

    public Participant()
    {

    }

    public Participant(String name, String city, String college_org, String mobile, String mailid, String expect, String events_attended, Float tech_skills, Float lead_skills, String next_5years, String attend_event) {

        this.name = name;
        this.city = city;
        this.college_org = college_org;
        this.mobile = mobile;
        this.mailid = mailid;
        this.expect = expect;
        this.events_attended = events_attended;
        this.tech_skills = tech_skills;
        this.lead_skills = lead_skills;
        this.next_5years = next_5years;
        this.attend_event = attend_event;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCollege_org() {
        return college_org;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMailid() {
        return mailid;
    }

    public String getExpect() {
        return expect;
    }

    public String getEvents_attended() {
        return events_attended;
    }

    public Float getTech_skills() {
        return tech_skills;
    }

    public Float getLead_skills() {
        return lead_skills;
    }

    public String getNext_5years() {
        return next_5years;
    }

    public String getAttend_event() {
        return attend_event;
    }
}