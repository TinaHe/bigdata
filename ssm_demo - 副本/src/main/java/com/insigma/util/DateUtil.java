/**
 * 
 */
package com.insigma.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.taglibs.standard.tag.common.fmt.FormatDateSupport;

/**
 * @author insigma
 * 
 */
public class DateUtil {

	/**
	 * 将日期字符串转换为日期类型
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date string2Date(String strDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (strDate == null || "".equals(strDate)) {
			return null;
		}
		Date date = null;
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * 将日期类型转换为指定格式的日期字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (date == null) {
			date = new Date();
		}
		String strDate = null;
		strDate = dateFormat.format(date);
		return strDate;
	}

	/**
	 * 将日期字符串转换为自定义格式的日期类型
	 * 
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static Date string2DateFormat(String strDate, String format) {
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if (strDate == null || "".equals(strDate)) {
			return null;
		}
		Date date = null;
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * 将日期类型转换为自定义格式的日期字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2String(Date date, String format) {
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if (date == null) {
			date = new Date();
		}
		String strDate = null;
		strDate = dateFormat.format(date);
		return strDate;
	}

	/**
	 * 日期比较
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String date1, String date2)
			throws ParseException {

		return compareDate(date1, date2, "yyyy-MM-dd");
	}

	/**
	 * 日期比较
	 * 
	 * @param strDate1
	 * @param strDate2
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static int compareDate(String strDate1, String strDate2,
			String format) throws ParseException {
		// 如果有一个参数为空，则直接返回0
		if (strDate1 == null || "".equals(strDate1) || strDate2 == null
				|| "".equals(strDate2)) {
			return 0;
		}
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date1 = dateFormat.parse(strDate1);
		Date date2 = dateFormat.parse(strDate2);
		return compareDate(date1, date2);
	}

	/**
	 * 日期比较
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {

		if (date1.getTime() > date2.getTime()) {// 第一个日期晚于第二个日期
			return 1;
		} else if (date1.getTime() < date2.getTime()) {// 第一个日期早于第二个日期

			return -1;
		} else {// 第一个日期等于第二个日期
			return 0;
		}
	}

	/**
	 * 日期与当前日期比较，返回1--代表晚于当前日期 -1--代表早于当前日期 0---代表等于当前日期
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static int compareCurrentDate(String strDate) throws ParseException {
		// 如果参数为空，则直接返回0
		if (strDate == null || "".equals(strDate)) {
			return 0;
		}

		return compareCurrentDate(strDate, "yyyy-MM-dd");
	}

	/**
	 * 日期与当前日期比较，返回1--代表晚于当前日期 -1--代表早于当前日期 0---代表等于当前日期
	 * 
	 * @param strDate
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static int compareCurrentDate(String strDate, String format)
			throws ParseException {
		// 如果参数为空，则直接返回0
		if (strDate == null || "".equals(strDate)) {
			return 0;
		}
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = dateFormat.parse(strDate);
		return compareCurrentDate(date);
	}

	/**
	 * 日期与当前日期比较，返回1--代表晚于当前日期 -1--代表早于当前日期 0---代表等于当前日期
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareCurrentDate(Date date) {
		Date currentDate = new Date();
		if (date.getTime() > currentDate.getTime()) {// 日期晚于当前日期
			return 1;
		} else if (date.getTime() < currentDate.getTime()) {// 日期早于当前日期

			return -1;
		} else {// 日期等于当前日期
			return 0;
		}
	}

	/**
	 * 把时间增加指定的天数 ，如果为负，则减去指定的天数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddDay(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	/**
	 * 把时间增加指定的月数 ，如果为负，则减去指定的月数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddMonth(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.MONTH, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	/**
	 * 把时间增加指定的年数 ，如果为负，则减去指定的年数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddYear(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.YEAR, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	/**
	 * 把时间增加指定的小时数 ，如果为负，则减去指定的小时数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddHour(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.HOUR, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	/**
	 * 把时间增加指定的分钟数 ，如果为负，则减去指定的分钟数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddMinute(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.MINUTE, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	/**
	 * 把时间增加指定的秒数 ，如果为负，则减去指定的秒数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddSecond(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.SECOND, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	/**
	 * 把时间增加指定的毫秒数 ，如果为负，则减去指定的毫秒数
	 * 
	 * @param date
	 * @param addNum
	 * @return
	 */
	public static Date AddMilliSecond(Date date, int addNum) {
		if (date == null)
			date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.MILLISECOND, addNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	public static String getStartDate(String startDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (startDate == null) {
			return null;
		}
		Date start = null;
		try {
			start = sdf.parse(startDate + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdf.format(start);
	}
	public static String getEndDate(String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (endDate == null) {
			return null;
		}
		Date end = null;
		try {
			end = sdf.parse(endDate + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdf.format(end);
	}

}
