package com.audacityit.audacity.greendao.db;

import com.audacityit.audacity.greendao.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "OVERVIEWITEMS_GR".
 */
public class OverviewitemsGR {

    private Long id;
    private String title;
    private String description;
    private String icon;
    private long overview_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient OverviewitemsGRDao myDao;

    private OverviewGR overviewGR;
    private Long overviewGR__resolvedKey;


    public OverviewitemsGR() {
    }

    public OverviewitemsGR(Long id) {
        this.id = id;
    }

    public OverviewitemsGR(Long id, String title, String description, String icon, long overview_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.overview_id = overview_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOverviewitemsGRDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getOverview_id() {
        return overview_id;
    }

    public void setOverview_id(long overview_id) {
        this.overview_id = overview_id;
    }

    /** To-one relationship, resolved on first access. */
    public OverviewGR getOverviewGR() {
        long __key = this.overview_id;
        if (overviewGR__resolvedKey == null || !overviewGR__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OverviewGRDao targetDao = daoSession.getOverviewGRDao();
            OverviewGR overviewGRNew = targetDao.load(__key);
            synchronized (this) {
                overviewGR = overviewGRNew;
            	overviewGR__resolvedKey = __key;
            }
        }
        return overviewGR;
    }

    public void setOverviewGR(OverviewGR overviewGR) {
        if (overviewGR == null) {
            throw new DaoException("To-one property 'overview_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.overviewGR = overviewGR;
            overview_id = overviewGR.getId();
            overviewGR__resolvedKey = overview_id;
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
