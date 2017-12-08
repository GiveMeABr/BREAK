/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eero
 */
@Entity
@Table(name = "Votes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votes.findAll", query = "SELECT v FROM Votes v")
    , @NamedQuery(name = "Votes.findByVoter", query = "SELECT v FROM Votes v WHERE v.votesPK.voter = :voter")
    , @NamedQuery(name = "Votes.findByArticle", query = "SELECT v FROM Votes v WHERE v.votesPK.article = :article")
    , @NamedQuery(name = "Votes.findByVoteType", query = "SELECT v FROM Votes v WHERE v.voteType = :voteType")})
public class Votes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotesPK votesPK;
    @Column(name = "VoteType")
    private Boolean voteType;
    @JoinColumn(name = "Voter", referencedColumnName = "UserID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "Article", referencedColumnName = "ArticleID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article1;

    public Votes() {
    }

    public Votes(VotesPK votesPK) {
        this.votesPK = votesPK;
    }

    public Votes(int voter, int article) {
        this.votesPK = new VotesPK(voter, article);
    }

    public VotesPK getVotesPK() {
        return votesPK;
    }

    public void setVotesPK(VotesPK votesPK) {
        this.votesPK = votesPK;
    }

    public Boolean getVoteType() {
        return voteType;
    }

    public void setVoteType(Boolean voteType) {
        this.voteType = voteType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Article getArticle1() {
        return article1;
    }

    public void setArticle1(Article article1) {
        this.article1 = article1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votesPK != null ? votesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votes)) {
            return false;
        }
        Votes other = (Votes) object;
        if ((this.votesPK == null && other.votesPK != null) || (this.votesPK != null && !this.votesPK.equals(other.votesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Votes[ votesPK=" + votesPK + " ]";
    }
    
}
