/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eero
 */
@Entity
@Table(name = "Article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByArticleID", query = "SELECT a FROM Article a WHERE a.articleID = :articleID")
    , @NamedQuery(name = "Article.findByUploadDate", query = "SELECT a FROM Article a WHERE a.uploadDate = :uploadDate")
    , @NamedQuery(name = "Article.findByTitle", query = "SELECT a FROM Article a WHERE a.title = :title")
    , @NamedQuery(name = "Article.findByArticle", query = "SELECT a FROM Article a WHERE a.article = :article")
    , @NamedQuery(name = "Article.findByNsfw", query = "SELECT a FROM Article a WHERE a.nsfw = :nsfw")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ArticleID")
    private Integer articleID;
    @Column(name = "UploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    //@Size(max = 60)
    @Column(name = "Title")
    private String title;
    //@Size(max = 255)
    @Column(name = "Article")
    private String article;
    @Column(name = "NSFW")
    private Boolean nsfw;
     @Column(name = "hasMedia")
    private Boolean hasMedia;
    @JoinColumn(name = "Sender", referencedColumnName = "UserID")
    @ManyToOne
    private Users sender;

    public Article() {
    }

    public Article(Integer articleID) {
        this.articleID = articleID;
    }

    public Article(int i, String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }
    
    public Boolean getHasMedia() {
        return hasMedia;
    }

    public void setHasMedia(Boolean hasMedia) {
        this.hasMedia = hasMedia;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleID != null ? articleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.articleID == null && other.articleID != null) || (this.articleID != null && !this.articleID.equals(other.articleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Article[ articleID=" + articleID + " ]";
    }
    
}
