package com.akdenizbank.mls.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

	public static final int ISTANBUL_TIME_OFFSET = 1;

	public static String stampTimeNow() {
		return stampTimeNow("yyyy-MM-dd HH:mm:ss.S");
	}

	public static String stampTimeNow(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date now = new Date();
		String nowString = dateFormat.format(now);
		return nowString;
	}

	public static String stampTime1Day() {
		return stampTimeDaysFromNow(1);
	}

	public static String stampTimeDaysFromNow(int days) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, days); // number of days to add
		return dateFormat.format(calendar.getTime()); // dt is now the new date
	}

	public static Date timeStampDate() {
		return Date.from(tsInstantNow());
	}

	public static LocalTime timeFromNow(int minutes) {
		return LocalTime.now().plus(minutes, ChronoUnit.MINUTES);
	}

	public static Instant tsInstantNow() {
		return LocalDateTime.now().toInstant(ZoneOffset.ofHours(TimeUtils.ISTANBUL_TIME_OFFSET));
	}

	public static String tsStringNow() {
		return String.valueOf(Instant.now().toEpochMilli());
	}

	public static String tsStringMillisLater(Long millis) {
		return String.valueOf(Instant.now().toEpochMilli() + millis);
	}

	public static TimeZone getCurrentTimeZone() {
		return TimeZone.getTimeZone("Etc/GMT-3");
	}

	public static Date getIstanbulDate() {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT-3"));
		Date currentDate = calendar.getTime();
		return currentDate;
	}

	public static LocalDate getCurrentLocalDate() {
		return LocalDate.now();
	}

	public static LocalDate get30NovemberLocalDate() {
		return LocalDate.of(2018, 11, 30);
	}

	public static LocalDate getSomeDate(int year, int month, int day) {
		return LocalDate.of(year, month, day);
	}

	public static String getTodaysString() {
		LocalDate date = LocalDate.now();
		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();
		LocalDate theDay = TimeUtils.getSomeDate(year, month, day);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return theDay.format(formatter);
	}

	public static Date getIstanbulDateXMinutesNow(int minutes) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT-3"));
		calendar.add(Calendar.MINUTE, minutes);
		Date currentDate = calendar.getTime();
		return currentDate;
	}
}