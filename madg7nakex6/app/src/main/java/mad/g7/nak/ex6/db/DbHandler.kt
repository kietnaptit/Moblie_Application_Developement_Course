package mad.g7.nak.ex6.db

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import mad.g7.nak.ex6.model.Member

class DbHandler(context: Context) {
    private val dbHelper: DbHelper = DbHelper(context)

    fun checkLogin(username: String, password: String): Member? {
        val db = dbHelper.readableDatabase
        val projection = arrayOf(
            DbHelper.COLUMN_ID,
            DbHelper.COLUMN_FULL_NAME,
            DbHelper.COLUMN_USERNAME,
            DbHelper.COLUMN_PASSWORD,
            DbHelper.COLUMN_ROLE
        )
        val selection = "${DbHelper.COLUMN_USERNAME} = ? AND ${DbHelper.COLUMN_PASSWORD} = ?"
        val selectionArgs = arrayOf(username, password)

        var member: Member? = null
        var cursor: Cursor? = null

        try {
            cursor = db.query(
                DbHelper.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
            )

            if (cursor.moveToFirst()) {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_ID))
                val fullName = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_FULL_NAME))
                val role = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_ROLE))
                member = Member(id, fullName, username, password, role)
            }
        } catch (e: SQLException) {
            // Handle database errors, if any
        } finally {
            cursor?.close()
        }

        return member
    }
}