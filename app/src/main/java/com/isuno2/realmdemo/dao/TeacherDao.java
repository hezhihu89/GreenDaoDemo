package com.isuno2.realmdemo.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.isuno2.realmdemo.bean.Teacher;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEACHER".
*/
public class TeacherDao extends AbstractDao<Teacher, Long> {

    public static final String TABLENAME = "TEACHER";

    /**
     * Properties of entity Teacher.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property TeacherId = new Property(1, long.class, "teacherId", false, "TEACHER_ID");
        public final static Property Program = new Property(2, String.class, "program", false, "PROGRAM");
    }

    private DaoSession daoSession;


    public TeacherDao(DaoConfig config) {
        super(config);
    }
    
    public TeacherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEACHER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"TEACHER_ID\" INTEGER NOT NULL UNIQUE ," + // 1: teacherId
                "\"PROGRAM\" TEXT);"); // 2: program
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEACHER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Teacher entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getTeacherId());
 
        String program = entity.getProgram();
        if (program != null) {
            stmt.bindString(3, program);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Teacher entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getTeacherId());
 
        String program = entity.getProgram();
        if (program != null) {
            stmt.bindString(3, program);
        }
    }

    @Override
    protected final void attachEntity(Teacher entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Teacher readEntity(Cursor cursor, int offset) {
        Teacher entity = new Teacher( //
            cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // teacherId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // program
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Teacher entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setTeacherId(cursor.getLong(offset + 1));
        entity.setProgram(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Teacher entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Teacher entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Teacher entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}