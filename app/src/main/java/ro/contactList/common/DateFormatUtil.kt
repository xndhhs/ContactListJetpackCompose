package ro.contactList.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateFormatUtil {
    fun formatDate(
        unformattedDate: String?,
        unformattedDateFormat: String,
        dateFormat:String
    ): String {
        if (unformattedDate.isNullOrEmpty()) return ""
        val date = SimpleDateFormat(unformattedDateFormat, Locale.US).parse(unformattedDate) ?: return ""
        val calendar = Calendar.getInstance()
        calendar.time = date
        return SimpleDateFormat(dateFormat, Locale.US).format(calendar.time)
    }
}