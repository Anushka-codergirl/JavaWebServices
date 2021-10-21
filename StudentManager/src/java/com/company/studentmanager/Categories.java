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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findBySlNo", query = "SELECT c FROM Categories c WHERE c.slNo = :slNo"),
    @NamedQuery(name = "Categories.findByCategoryName", query = "SELECT c FROM Categories c WHERE c.categoryName = :categoryName")})
public class Categories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sl_no")
    private Integer slNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "category_name")
    private String categoryName;

    public Categories() {
    }

    public Categories(Integer slNo) {
        this.slNo = slNo;
    }

    public Categories(Integer slNo, String categoryName) {
        this.slNo = slNo;
        this.categoryName = categoryName;
    }

    public Integer getSlNo() {
        return slNo;
    }

    public void setSlNo(Integer slNo) {
        this.slNo = slNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slNo != null ? slNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.slNo == null && other.slNo != null) || (this.slNo != null && !this.slNo.equals(other.slNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.studentmanager.Categories[ slNo=" + slNo + " ]";
    }
    
}
