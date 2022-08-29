package github.kaierwen.android.dateutildemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val date = Date()
        val today = MyDateTimeUtil.getDateRange(date, MyDateTimeUtil.Range.TODAY)
        val yesterday = MyDateTimeUtil.getDateRange(date, MyDateTimeUtil.Range.YESTERDAY)
        val week = MyDateTimeUtil.getDateRange(date, MyDateTimeUtil.Range.THIS_WEEK,false)
        val weekMondayFirst = MyDateTimeUtil.getDateRange(date, MyDateTimeUtil.Range.THIS_WEEK)
        val month = MyDateTimeUtil.getDateRange(date, MyDateTimeUtil.Range.THIS_MONTH)
        val year = MyDateTimeUtil.getDateRange(date, MyDateTimeUtil.Range.THIS_YEAR)
        Log.d(TAG, "today start = ${today[0]} , today end = ${today[1]}")
        Log.d(TAG, "yesterday start = ${yesterday[0]} , yesterday end = ${yesterday[1]}")
        Log.d(TAG, "week start = ${week[0]} , week end = ${week[1]}")
        Log.d(TAG, "month start = ${month[0]} , month end = ${month[1]}")
        Log.d(TAG, "year start = ${year[0]} , year end = ${year[1]}")

        StringBuilder().append("now = $date \n\n")
            .append("today start = ${today[0]}\n")
            .append("today end = ${today[1]}\n\n")
            .append("yesterday start = ${yesterday[0]} \n")
            .append("yesterday end = ${yesterday[1]}\n\n")
            .append("week start = ${week[0]}\n")
            .append("weekMondayFirst = ${weekMondayFirst[0]}\n")
            .append("week end = ${week[1]}\n\n")
            .append("month start = ${month[0]}\n")
            .append("month end = ${month[1]}\n\n")
            .append("year start = ${year[0]}\n")
            .append("year end = ${year[1]}")
            .apply {
                findViewById<TextView>(R.id.tv).text = this.toString()
            }
    }
}