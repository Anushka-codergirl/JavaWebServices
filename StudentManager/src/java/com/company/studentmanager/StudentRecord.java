/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.studentmanager;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "student_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentRecord.findAll", query = "SELECT s FROM StudentRecord s"),
    @NamedQuery(name = "StudentRecord.findByStudentId", query = "SELECT s FROM StudentRecord s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentRecord.findByStudentName", query = "SELECT s FROM StudentRecord s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "StudentRecord.findByStudentEmail", query = "SELECT s FROM StudentRecord s WHERE s.studentEmail = :studentEmail"),
    @NamedQuery(name = "StudentRecord.findByStudentPassword", query = "SELECT s FROM StudentRecord s WHERE s.studentPassword = :studentPassword"),
    @NamedQuery(name = "StudentRecord.findByStudentGender", query = "SELECT s FROM StudentRecord s WHERE s.studentGender = :studentGender"),
    @NamedQuery(name = "StudentRecord.findByStudentAddress", query = "SELECT s FROM StudentRecord s WHERE s.studentAddress = :studentAddress")})
public class StudentRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Size(max = 100)
    @Column(name = "student_name")
    private String studentName;
    @Size(max = 50)
    @Column(name = "student_email")
    private String studentEmail;
    @Size(max = 20)
    @Column(name = "student_password")
    private String studentPassword;
    @Size(max = 1)
    @Column(name = "student_gender")
    private String studentGender;
    @Size(max = 100)
    @Column(name = "student_address")
    private String studentAddress;

    public StudentRecord() {
    }

    public StudentRecord(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentRecord)) {
            return false;
        }
        StudentRecord other = (StudentRecord) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.studentmanager.StudentRecord[ studentId=" + studentId + " ]";
    }
    
}
