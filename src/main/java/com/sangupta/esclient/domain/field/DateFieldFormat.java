package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;

public enum DateFieldFormat {
	
	@SerializedName("basic_date")
	BasicDate,
	
	@SerializedName("basic_date_time")
	BasicDateTime,
	
	@SerializedName("basic_date_time_no_millis")
	BasicDateTimeNoMillis,
	
	@SerializedName("basic_ordinal_date")
	BasicOrdinalDate,
	
	@SerializedName("basic_ordinal_date_time")
	BasicOrdinalDateTime,
	
	@SerializedName("basic_ordinal_date_time_no_millis")
	BasicOrdinalDateTimeNoMillis,
	
	@SerializedName("basic_time")
	BasicTime,
	
	@SerializedName("basic_time_no_millis")
	BasicTimeNoMillis,
	
	@SerializedName("basic_t_time")
	BasicTTime,
	
	@SerializedName("basic_t_time_no_millis")
	BasicTTimeNoMillis,
	
	@SerializedName("basic_week_date")
	BasicWeekDate,
	
	@SerializedName("basic_week_date_time")
	BasicWeekDateTime,
	
	@SerializedName("basic_week_date_time_no_millis")
	BasicWeekDateTimeNoMillis,
	
	@SerializedName("date")
	Date,
	
	@SerializedName("date_hour")
	DateHour,
	
	@SerializedName("date_hour_minute")
	DateHourMinute,
	
	@SerializedName("date_hour_minute_second")
	DateHourMinuteSecond,
	
	@SerializedName("date_hour_minute_second_fraction")
	DateHourMinuteSecondFraction,
	
	@SerializedName("date_hour_minute_second_millis")
	DateHourMinuteSecondMillis,
	
	@SerializedName("date_optional_time")
	DateOptionalTime,
	
	@SerializedName("date_time")
	DateTime,
	
	@SerializedName("date_time_no_millis")
	DateTimeNoMillis,
	
	@SerializedName("hour")
	Hour,
	
	@SerializedName("hour_minute")
	HourMinute,
	
	@SerializedName("hour_minute_second")
	HourMinuteSecond,
	
	@SerializedName("hour_minute_second_fraction")
	HourMinuteSecondFraction,
	
	@SerializedName("hour_minute_second_millis")
	HourMinuteSecondMillis,
	
	@SerializedName("ordinal_date")
	OrdinalDate,
	
	@SerializedName("ordinal_date_time")
	OrdinalDateTime,
	
	@SerializedName("ordinal_date_time_no_millis")
	OrdinalDateTimeNoMillis,
	
	@SerializedName("time")
	Time,
	
	@SerializedName("time_no_millis")
	TimeNoMillis,
	
	@SerializedName("t_time")
	TTime,
	
	@SerializedName("t_time_no_millis")
	TTimeNoMillis,
	
	@SerializedName("week_date")
	WeekDate,
	
	@SerializedName("week_date_time")
	WeekDateTime,
	
	@SerializedName("weekDateTimeNoMillis")
	WeekDateTimeNoMillis,
	
	@SerializedName("week_year")
	WeekYear,
	
	@SerializedName("weekyearWeek")
	WeekYearWeek,
	
	@SerializedName("weekyearWeekDay")
	WeekYearWeekDay,
	
	@SerializedName("year")
	Year,
	
	@SerializedName("year_month")
	YearMonth,
	
	@SerializedName("year_month_day")
	YearMonthDay,
	
	@SerializedName("date")
	EpochMillis;
	
}
