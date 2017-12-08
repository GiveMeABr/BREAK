/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eero
 */
@Embeddable
public class VotesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Voter")
    private int voter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Article")
    private int article;

    public VotesPK() {
    }

    public VotesPK(int voter, int article) {
        this.voter = voter;
        this.article = article;
    }

    public int getVoter() {
        return voter;
    }

    public void setVoter(int voter) {
        this.voter = voter;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) voter;
        hash += (int) article;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotesPK)) {
            return false;
        }
        VotesPK other = (VotesPK) object;
        if (this.voter != other.voter) {
            return false;
        }
        if (this.article != other.article) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VotesPK[ voter=" + voter + ", article=" + article + " ]";
    }
    
}
