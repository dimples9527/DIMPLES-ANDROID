package com.dimples.ui.main.book.bean;

/**
  *
  * @author zhongyj
  * @date 2019/3/29 12:28
  */
public class TreatPatientBean {
    private Long patientInfoId;

    private String pinyin;

    private String patientName;

    private String patientAge;

    private String patientSex;

    private String patientBirthday;

    private String patientAddress;

    private String patientTelephone;

    private String patientNation;

    private String patientCard;

    private String remark;

    private String status;

    private Long patientRegisterId;

    private String patientId;

    private String doctor;

    private String doctorCode;

    private String registerDepartment;

    private String departmentCode;

    private String registerNumber;

    private String registerTime;

    private String treatStatus;

    public Long getPatientInfoId() {
        return patientInfoId;
    }

    public void setPatientInfoId(Long patientInfoId) {
        this.patientInfoId = patientInfoId;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientTelephone() {
        return patientTelephone;
    }

    public void setPatientTelephone(String patientTelephone) {
        this.patientTelephone = patientTelephone;
    }

    public String getPatientNation() {
        return patientNation;
    }

    public void setPatientNation(String patientNation) {
        this.patientNation = patientNation;
    }

    public String getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(String patientCard) {
        this.patientCard = patientCard;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPatientRegisterId() {
        return patientRegisterId;
    }

    public void setPatientRegisterId(Long patientRegisterId) {
        this.patientRegisterId = patientRegisterId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getRegisterDepartment() {
        return registerDepartment;
    }

    public void setRegisterDepartment(String registerDepartment) {
        this.registerDepartment = registerDepartment;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getTreatStatus() {
        return treatStatus;
    }

    public void setTreatStatus(String treatStatus) {
        this.treatStatus = treatStatus;
    }

    @Override
    public String toString() {
        return "TreatPatientBean{" +
                "patientInfoId=" + patientInfoId +
                ", pinyin='" + pinyin + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientAge='" + patientAge + '\'' +
                ", patientSex='" + patientSex + '\'' +
                ", patientBirthday='" + patientBirthday + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientTelephone='" + patientTelephone + '\'' +
                ", patientNation='" + patientNation + '\'' +
                ", patientCard='" + patientCard + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", patientRegisterId=" + patientRegisterId +
                ", patientId='" + patientId + '\'' +
                ", doctor='" + doctor + '\'' +
                ", doctorCode='" + doctorCode + '\'' +
                ", registerDepartment='" + registerDepartment + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", treatStatus='" + treatStatus + '\'' +
                '}';
    }
}
