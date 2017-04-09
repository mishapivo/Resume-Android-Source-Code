package com.audacityit.audacity.greendao.db;

import com.audacityit.audacity.greendao.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TEAM_GR_".
 */
public class TeamGR_ {

    private Long id;
    private String name;
    private String designation;
    private String photo;
    private long team_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient TeamGR_Dao myDao;

    private TeamGR teamGR;
    private Long teamGR__resolvedKey;


    public TeamGR_() {
    }

    public TeamGR_(Long id) {
        this.id = id;
    }

    public TeamGR_(Long id, String name, String designation, String photo, long team_id) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.photo = photo;
        this.team_id = team_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeamGR_Dao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    /** To-one relationship, resolved on first access. */
    public TeamGR getTeamGR() {
        long __key = this.team_id;
        if (teamGR__resolvedKey == null || !teamGR__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamGRDao targetDao = daoSession.getTeamGRDao();
            TeamGR teamGRNew = targetDao.load(__key);
            synchronized (this) {
                teamGR = teamGRNew;
            	teamGR__resolvedKey = __key;
            }
        }
        return teamGR;
    }

    public void setTeamGR(TeamGR teamGR) {
        if (teamGR == null) {
            throw new DaoException("To-one property 'team_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.teamGR = teamGR;
            team_id = teamGR.getId();
            teamGR__resolvedKey = team_id;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}