package github.kaierwen.android.dateutildemo

import java.util.*

/**
 * 日期时间工具类
 *
 * @since 2021/8/7
 */
class MyDateTimeUtil {

    companion object {

        /**
         * 根据[Date]计算日期范围，并返回该[Date]的开始日期和结束日期
         *
         * @param date 需要进行计算的日期，一般是传入当前日期
         * @param range 参数参见[Range]
         * @param mondayFirstDay 设置星期一是否为每周的第一天，true为周一为第一天，false则是系统获取到的周第一天
         * @return 日期范围，长度为2的数组：arr[0]是开始时间，arr[1]是结束时间
         */
        fun getDateRange(date: Date, range: Range, mondayFirstDay: Boolean = true): Array<Date> {
            val dateArray = arrayOf(date, date)
            Calendar.getInstance().apply {
                // 计算开始和结束日期
                when (range) {
                    Range.TODAY -> {
                        dateArray[0] = dayFirstTimeStamp(date)
                    }
                    Range.YESTERDAY -> {
                        time = yesterday(date)
                        dateArray[0] = dayFirstTimeStamp(time)
                        dateArray[1] = dayLastTimeStamp(time)
                    }
                    Range.THIS_WEEK -> {
                        dateArray[0] = firstDayOfWeek(date, mondayFirstDay)
                    }
                    Range.THIS_MONTH -> {
                        dateArray[0] = firstDayOfMonth(date)
                    }
                    Range.THIS_YEAR -> {
                        dateArray[0] = firstDayOfYear(date)
                    }
                }
            }
            return dateArray
        }

        /**
         * 获取昨天的日期
         * https://stackoverflow.com/a/11425259/1416421
         */
        fun yesterday(curDate: Date): Date {
            Calendar.getInstance().apply {
                time = curDate
                add(Calendar.DATE, -1)
                return time
            }
        }

        /**
         * 获取今周第一天的日期
         * https://stackoverflow.com/a/2938209/1416421
         */
        fun firstDayOfWeek(curDate: Date, mondayFirstDay: Boolean = true): Date {
            Calendar.getInstance().apply {
                time = dayFirstTimeStamp(curDate)
                if (mondayFirstDay) set(
                    Calendar.DAY_OF_WEEK,
                    Calendar.MONDAY
                ) else set(Calendar.DAY_OF_WEEK, firstDayOfWeek)
                return time
            }
        }

        /**
         * 获取今月第一天的日期
         * https://stackoverflow.com/a/2938209/1416421
         */
        fun firstDayOfMonth(curDate: Date): Date {
            Calendar.getInstance().apply {
                time = dayFirstTimeStamp(curDate)
                set(Calendar.DAY_OF_MONTH, 1)
                return time
            }
        }

        /**
         * 获取今年第一天的日期
         * https://stackoverflow.com/a/2938209/1416421
         */
        fun firstDayOfYear(curDate: Date): Date {
            Calendar.getInstance().apply {
                time = dayFirstTimeStamp(curDate)
                set(Calendar.DAY_OF_YEAR, 1)
                return time
            }
        }

        /**
         * curDate这天的第一毫秒： 00:00:00:000
         */
        fun dayFirstTimeStamp(curDate: Date): Date {
            Calendar.getInstance().apply {
                time = curDate
                // https://stackoverflow.com/a/2938209/1416421
                set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
                clear(Calendar.MINUTE)
                clear(Calendar.SECOND)
                clear(Calendar.MILLISECOND)
//                set(Calendar.HOUR_OF_DAY, 0)
//                set(Calendar.MINUTE, 0)
//                set(Calendar.SECOND, 0)
//                set(Calendar.MILLISECOND, 0)
                return time
            }
        }

        /**
         * curDate这天的最后一毫秒： 23:59:59:999
         */
        fun dayLastTimeStamp(curDate: Date): Date {
            Calendar.getInstance().apply {
                time = curDate
                set(Calendar.HOUR_OF_DAY, 23)
                set(Calendar.MINUTE, 59)
                set(Calendar.SECOND, 59)
                set(Calendar.MILLISECOND, 999)
                return time
            }
        }
    }

    enum class Range {
        /**
         * 时间范围：今天00:00:00:000 - 当前时间
         */
        TODAY,

        /**
         * 时间范围：昨天00:00:00:000 - 昨天23:59:59:000
         */
        YESTERDAY,

        /**
         * 时间范围：今周第一天00:00:00:000 - 当前时间
         */
        THIS_WEEK,

        /**
         * 时间范围：今月第一天00:00:00:000 - 当前时间
         */
        THIS_MONTH,

        /**
         * 时间范围：今年第一天00:00:00:000 - 当前时间
         */
        THIS_YEAR
    }
}