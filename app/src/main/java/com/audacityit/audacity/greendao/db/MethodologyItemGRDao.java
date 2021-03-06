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

import com.audacityit.audacity.greendao.db.MethodologyItemGR;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "METHODOLOGY_ITEM_GR".
*/
public class MethodologyItemGRDao extends AbstractDao<MethodologyItemGR, Long> {

    public static final String TABLENAME = "METHODOLOGY_ITEM_GR";

    /**
     * Properties of entity MethodologyItemGR.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Details = new Property(2, String.class, "details", false, "DETAILS");
        public final static Property Icon = new Property(3, String.class, "icon", false, "ICON");
        public final static Property Item_id = new Property(4, long.class, "item_id", false, "ITEM_ID");
    };

    private DaoSession daoSession;

    private Query<MethodologyItemGR> methodologyGR__MethodologyItemGRListQuery;

    public MethodologyItemGRDao(DaoConfig config) {
        super(config);
    }
    
    public MethodologyItemGRDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"METHODOLOGY_ITEM_GR\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"DETAILS\" TEXT," + // 2: details
                "\"ICON\" TEXT," + // 3: icon
                "\"ITEM_ID\" INTEGER NOT NULL );"); // 4: item_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"METHODOLOGY_ITEM_GR\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MethodologyItemGR entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String details = entity.getDetails();
        if (details != null) {
            stmt.bindString(3, details);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(4, icon);
        }
        stmt.bindLong(5, entity.getItem_id());
    }

    @Override
    protected void attachEntity(MethodologyItemGR entity) {
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
    public MethodologyItemGR readEntity(Cursor cursor, int offset) {
        MethodologyItemGR entity = new MethodologyItemGR( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // details
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // icon
            cursor.getLong(offset + 4) // item_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MethodologyItemGR entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDetails(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIcon(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setItem_id(cursor.getLong(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MethodologyItemGR entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MethodologyItemGR entity) {
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
    
    /** Internal query to resolve the "methodologyItemGRList" to-many relationship of MethodologyGR_. */
    public List<MethodologyItemGR> _queryMethodologyGR__MethodologyItemGRList(long item_id) {
        synchronized (this) {
            if (methodologyGR__MethodologyItemGRListQuery == null) {
                QueryBuilder<MethodologyItemGR> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Item_id.eq(null));
                methodologyGR__MethodologyItemGRListQuery = queryBuilder.build();
            }
        }
        Query<MethodologyItemGR> query = methodologyGR__MethodologyItemGRListQuery.forCurrentThread();
        query.setParameter(0, item_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getMethodologyGR_Dao().getAllColumns());
            builder.append(" FROM METHODOLOGY_ITEM_GR T");
            builder.append(" LEFT JOIN METHODOLOGY_GR_ T0 ON T.\"ITEM_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MethodologyItemGR loadCurrentDeep(Cursor cursor, boolean lock) {
        MethodologyItemGR entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        MethodologyGR_ methodologyGR_ = loadCurrentOther(daoSession.getMethodologyGR_Dao(), cursor, offset);
         if(methodologyGR_ != null) {
            entity.setMethodologyGR_(methodologyGR_);
        }

        return entity;    
    }

    public MethodologyItemGR loadDeep(Long key) {
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
    public List<MethodologyItemGR> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MethodologyItemGR> list = new ArrayList<MethodologyItemGR>(count);
        
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
    
    protected List<MethodologyItemGR> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MethodologyItemGR> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
