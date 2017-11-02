package com.prafulmishra.girlscriptsummit.data;

/**
 * Created by Praful on 20-10-2017.
 */

public class WomenInTech {
    private String name,city,col_org,mobile_no,mail_id,other_skills,word_aboutwitech,html_knowledge,join_indiasummi,practice,stipend,time_added;
    private float tech_skills;

    public WomenInTech()
    {

    }

    public WomenInTech(String name, String city, String col_org, String mobile_no, String mail_id, String other_skills, String word_aboutwitech, String html_knowledge, String join_indiasummi, String practice, String stipend, float tech_skills, String time_added) {
        this.name = name;
        this.city = city;
        this.col_org = col_org;
        this.mobile_no = mobile_no;
        this.mail_id = mail_id;
        this.other_skills = other_skills;
        this.word_aboutwitech = word_aboutwitech;
        this.html_knowledge = html_knowledge;
        this.join_indiasummi = join_indiasummi;
        this.practice = practice;
        this.stipend = stipend;
        this.tech_skills = tech_skills;
        this.time_added = time_added;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCol_org() {
        return col_org;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public String getMail_id() {
        return mail_id;
    }

    public String getOther_skills() {
        return other_skills;
    }

    public String getWord_aboutwitech() {
        return word_aboutwitech;
    }

    public String getHtml_knowledge() {
        return html_knowledge;
    }

    public String getJoin_indiasummi() {
        return join_indiasummi;
    }

    public String getPractice() {
        return practice;
    }

    public String getStipend() {
        return stipend;
    }

    public float getTech_skills() {
        return tech_skills;
    }

    public String getTime_added() {
        return time_added;
    }
}
