package mad.g7.nak.ex6.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import mad.g7.nak.ex6.model.Member

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        const val DATABASE_NAME = "Members.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "members"
        const val COLUMN_ID = "id"
        const val COLUMN_FULL_NAME = "fullName"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_ROLE = "role"

        private fun insertSampleData(db: SQLiteDatabase?){
            val sampleMembers = listOf(
                Member(1, "Administrator", "admin", "admin", "admin"),
                Member(2, "Nguyen Anh Kiet", "kietna", "kietna", "member")
            )

            for(member in sampleMembers){
                val values = ContentValues()
                values.put(COLUMN_FULL_NAME, member.fullname)
                values.put(COLUMN_USERNAME, member.username)
                values.put(COLUMN_PASSWORD, member.password)
                values.put(COLUMN_ROLE, member.role)

                db?.insert(TABLE_NAME, null, values)
            }
        }

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
                CREATE TABLE $TABLE_NAME(
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_FULL_NAME TEXT,
                    $COLUMN_USERNAME TEXT,
                    $COLUMN_PASSWORD TEXT,
                    $COLUMN_ROLE TEXT
                )
            """.trimIndent()
        db?.execSQL(createTableQuery)

        insertSampleData(db)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}