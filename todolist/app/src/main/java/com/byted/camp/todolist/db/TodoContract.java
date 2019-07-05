package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

import com.byted.camp.todolist.beans.State;

import java.sql.Date;

import static com.byted.camp.todolist.db.TodoContract.TodoEntry.TABLE_NAME;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    // TODO 定义表结构和 SQL 语句常量

    private TodoContract() {
    }

    public static class TodoEntry implements BaseColumns{

        public static final String TABLE_NAME="datalist";
        public static final String COLUMN_NAME_ID="ID";
        public static final String COLUMN_NAME_CONTENT="content";
        public static final String  COLUMN_NAME_DATE="date";
        public static final String  COLUMN_NAME_STATE="state";
    };

    public static final String SQL_CREATE_ENTRIES=
            "CREATE TABLE "+ TodoEntry.TABLE_NAME+" ("+
                    TodoEntry.COLUMN_NAME_ID+" LONG PRIMARY KEY,"+
                    TodoEntry.COLUMN_NAME_CONTENT+" TEXT,"+
                    TodoEntry.COLUMN_NAME_DATE+" LONG,"+
                    TodoEntry.COLUMN_NAME_STATE+" INTEGER)";

}
