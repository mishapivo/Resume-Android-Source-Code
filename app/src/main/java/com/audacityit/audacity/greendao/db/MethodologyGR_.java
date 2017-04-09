package com.audacityit.audacity.greendao.db;

import java.util.List;
import com.audacityit.audacity.greendao.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "METHODOLOGY_GR_".
 */
public class MethodologyGR_ {

    private Long id;
    private String background;
    private String logo;
    private long methodology_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MethodologyGR_Dao myDao;

    private MethodologyGR methodologyGR;
    private Long methodologyGR__resolvedKey;

    private List<MethodologyItemGR> methodologyItemGRList;

    public MethodologyGR_() {
    }

    public MethodologyGR_(Long id) {
        this.id = id;
    }

    public MethodologyGR_(Long id, String background, String logo, long methodology_id) {
        this.id = id;
        this.background = background;
        this.logo = logo;
        this.methodology_id = methodology_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMethodologyGR_Dao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getMethodology_id() {
        return methodology_id;
    }

    public void setMethodology_id(long methodology_id) {
        this.methodology_id = methodology_id;
    }

    /** To-one relationship, resolved on first access. */
    public MethodologyGR getMethodologyGR() {
        long __key = this.methodology_id;
        if (methodologyGR__resolvedKey == null || !methodologyGR__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MethodologyGRDao targetDao = daoSession.getMethodologyGRDao();
            MethodologyGR methodologyGRNew = targetDao.load(__key);
            synchronized (this) {
                methodologyGR = methodologyGRNew;
            	methodologyGR__resolvedKey = __key;
            }
        }
        return methodologyGR;
    }

    public void setMethodologyGR(MethodologyGR methodologyGR) {
        if (methodologyGR == null) {
            throw new DaoException("To-one property 'methodology_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.methodologyGR = methodologyGR;
            methodology_id = methodologyGR.getId();
            methodologyGR__resolvedKey = methodology_id;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<MethodologyItemGR> getMethodologyItemGRList() {
        if (methodologyItemGRList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MethodologyItemGRDao targetDao = daoSession.getMethodologyItemGRDao();
            List<MethodologyItemGR> methodologyItemGRListNew = targetDao._queryMethodologyGR__MethodologyItemGRList(id);
            synchronized (this) {
                if(methodologyItemGRList == null) {
                    methodologyItemGRList = methodologyItemGRListNew;
                }
            }
        }
        return methodologyItemGRList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMethodologyItemGRList() {
        methodologyItemGRList = null;
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