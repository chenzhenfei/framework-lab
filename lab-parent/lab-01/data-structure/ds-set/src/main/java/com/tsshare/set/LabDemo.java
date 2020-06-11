package com.tsshare.set;

/**
 * @author chenzhenfei
 * @title: LabDemo
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/6/1122:18
 */
public class LabDemo implements  Comparable {
    private Integer labInt;
    private String  labStr;

    public Integer getLabInt() {
        return labInt;
    }

    public void setLabInt(Integer labInt) {
        this.labInt = labInt;
    }

    public String getLabStr() {
        return labStr;
    }

    public void setLabStr(String labStr) {
        this.labStr = labStr;
    }

    public LabDemo(Integer labInt, String labStr) {
        this.labInt = labInt;
        this.labStr = labStr;
    }

    @Override
    public String toString() {
        return "LabDemo{" +
                "labInt=" + labInt +
                ", labStr='" + labStr + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.labInt.hashCode()+this.getLabStr().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() ==((LabDemo)obj).hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
