package com.tarikkilic;

import java.util.Objects;

/**
 * Derslerin verilerini tutar
 */
public class Courses {
    private int semester;
    private String code;
    private String course_title;
    private int ectsCredit;
    private int gtuCredit;
    private String htl;

    public Courses(){
        this.semester = 0;
        this.code = null;
        this.course_title = null;
        this.ectsCredit = 0;
        this.gtuCredit = 0;
        this.htl = null;
    }
    /**
     * @param semester
     * @param code
     * @param course_title
     * @param ectsCredit
     * @param gtuCredit
     * @param htl
     */
    public Courses(int semester, String code, String course_title, int ectsCredit, int gtuCredit, String htl) {
        this.semester = semester;
        this.code = code;
        this.course_title = course_title;
        this.ectsCredit = ectsCredit;
        this.gtuCredit = gtuCredit;
        this.htl = htl;
    }

    /**
     *
     * @return int semester
     */
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     *
     * @return String code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return String title
     */
    public String getCourse_title() {
        return course_title;
    }

    /**
     * @param course_title
     */
    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    /**
     * @return ects
     */
    public int getEctsCredit() {
        return ectsCredit;
    }

    /**
     * @param ectsCredit
     */
    public void setEctsCredit(int ectsCredit) {
        this.ectsCredit = ectsCredit;
    }
    /**
     * @return gtuCredit
     */
    public int getGtuCredit() {
        return gtuCredit;
    }

    /**
     * @param gtuCredit
     */
    public void setGtuCredit(int gtuCredit) {
        this.gtuCredit = gtuCredit;
    }

    /**
     * @return String h+t+l
     */
    public String getHtl() {
        return htl;
    }

    /**
     * @param htl
     */
    public void setHtl(String htl) {
        this.htl = htl;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "semester=" + semester +
                ", code='" + code + '\'' +
                ", course_title='" + course_title + '\'' +
                ", ectsCredit=" + ectsCredit +
                ", gtuCredit=" + gtuCredit +
                ", htl='" + htl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return semester == courses.semester &&
                ectsCredit == courses.ectsCredit &&
                gtuCredit == courses.gtuCredit &&
                Objects.equals(code, courses.code) &&
                Objects.equals(course_title, courses.course_title) &&
                Objects.equals(htl, courses.htl);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
