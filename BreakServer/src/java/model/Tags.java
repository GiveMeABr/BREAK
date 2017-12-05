/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author Eero
 */
@Entity
@Table(name = "Tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tags.findAll", query = "SELECT t FROM Tags t")
    , @NamedQuery(name = "Tags.findByTagID", query = "SELECT t FROM Tags t WHERE t.tagID = :tagID")
    , @NamedQuery(name = "Tags.findByTag", query = "SELECT t FROM Tags t WHERE t.tag = :tag")})
public class Tags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TagID")
    private Integer tagID;
    @Size(max = 50)
    @Column(name = "Tag")
    private String tag;

    public Tags() {
    }

    public Tags(Integer tagID) {
        this.tagID = tagID;
    }

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagID != null ? tagID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tags)) {
            return false;
        }
        Tags other = (Tags) object;
        if ((this.tagID == null && other.tagID != null) || (this.tagID != null && !this.tagID.equals(other.tagID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tags[ tagID=" + tagID + " ]";
    }
    
}
