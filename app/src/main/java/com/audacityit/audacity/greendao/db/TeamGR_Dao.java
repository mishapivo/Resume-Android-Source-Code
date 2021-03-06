package com.audacityit.audacity.greendao.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.audacityit.audacity.greendao.db.TeamGR_;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEAM_GR_".
*/
public class TeamGR_Dao extends AbstractDao<TeamGR_, Long> {

    public static final String TABLENAME = "TEAM_GR_";

    /**
     * Properties of entity TeamGR_.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Designation = new Property(2, String.class, "designation", false, "DESIGNATION");
        public final static Property Photo = new Property(3, String.class, "photo", false, "PHOTO");
        public final static Property Team_id = new Property(4, long.class, "team_id", false, "TEAM_ID");
    };

    private DaoSession daoSession;

    private Query<TeamGR_> teamGR_TeamGR_ListQuery;

    public TeamGR_Dao(DaoConfig config) {
        super(config);
    }
    
    public TeamGR_Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEAM_GR_\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"DESIGNATION\" TEXT," + // 2: designation
                "\"PHOTO\" TEXT," + // 3: photo
                "\"TEAM_ID\" INTEGER NOT NULL );"); // 4: team_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEAM_GR_\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TeamGR_ entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String designation = entity.getDesignation();
        if (designation != null) {
            stmt.bindString(3, designation);
        }
 
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(4, photo);
        }
        stmt.bindLong(5, entity.getTeam_id());
    }

    @Override
    protected void attachEntity(TeamGR_ entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TeamGR_ readEntity(Cursor cursor, int offset) {
        TeamGR_ entity = new TeamGR_( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // designation
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // photo
            cursor.getLong(offset + 4) // team_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TeamGR_ entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDesignation(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPhoto(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTeam_id(cursor.getLong(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TeamGR_ entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TeamGR_ entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "teamGR_List" to-many relationship of TeamGR. */
    public List<TeamGR_> _queryTeamGR_TeamGR_List(long team_id) {
        synchronized (this) {
            if (teamGR_TeamGR_ListQuery == null) {
                QueryBuilder<TeamGR_> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Team_id.eq(null));
                teamGR_TeamGR_ListQuery = queryBuilder.build();
            }
        }
        Query<TeamGR_> query = teamGR_TeamGR_ListQuery.forCurrentThread();
        query.setParameter(0, team_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTeamGRDao().getAllColumns());
            builder.append(" FROM TEAM_GR_ T");
            builder.append(" LEFT JOIN TEAM_GR T0 ON T.\"TEAM_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected TeamGR_ loadCurrentDeep(Cursor cursor, boolean lock) {
        TeamGR_ entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        TeamGR teamGR = loadCurrentOther(daoSession.getTeamGRDao(), cursor, offset);
         if(teamGR != null) {
            entity.setTeamGR(teamGR);
        }

        return entity;    
    }

    public TeamGR_ loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<TeamGR_> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<TeamGR_> list = new ArrayList<TeamGR_>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<TeamGR_> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<TeamGR_> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
