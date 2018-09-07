/**
 * 
 */
package com.insigma.util;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author insigma
 *
 */
@Component
@PropertySource("classpath:configinfo.properties")
public class QuartzUtil {
	private static Logger logger = Logger.getLogger(QuartzUtil.class);
	/**
	 * 每天定时23.59.59做数据库的备份cron="59 59 23 * * ?"
	 */
	@Value("${back.hostIP}")
	private String hostIP;
	@Value("${back.userName}")
	private String userName;
	@Value("${back.databaseName}")
	private String databaseName;
	@Value("${back.password}")
	private String password;
	@Value("${back.savePath}")
	private String savePath;
	@Value("${back.fileName}")
	private String fileName;
	@Value("${back.commond}")
	private String commondStr;
	@Value("${delete.timeUnit}")
	private Integer timeUnit;
	@Value("${delete.numTime}")
	private Integer numTime;
	
	@Scheduled(cron="${backJob.cron}")
	public void backScheduled() {
		logger.debug("=============进行备份开始了=========================" + DateUtil.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
		logger.debug("back.hostIP=" + hostIP);
		logger.debug("back.userName=" + userName);
		logger.debug("back.databaseName=" + databaseName);
		logger.debug("back.password=" + password);
		logger.debug("back.savePath=" + savePath);
		logger.debug("back.fileName=" + fileName);
		String fileNameTmp = fileName + DateUtil.date2String(new Date(),"yyyyMMddHHmmss") + ".sql";
		
		BackUtil.exportDatabaseTool(hostIP,userName,password,savePath,fileNameTmp,databaseName,commondStr);
		
		logger.debug("=============备份结束========================" + DateUtil.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
		
	}
	/**
	 * 每月1号2点做备份数据的删除,删除每月以前的备份文件
	 * cron="0 0 02 01 * ?"
	 */
	@Scheduled(cron="${deleteJob.cron}")
	public void deleteScheduled() {
		
		logger.debug("=============进行文件删除=========================" + DateUtil.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));		
		
		Date deleteDate =  new Date();
		switch (timeUnit) {
			case 1:
				deleteDate = DateUtil.AddYear(new Date(), numTime == null ? 0 : numTime);
				break;
			case 2:
				deleteDate = DateUtil.AddMonth(new Date(), numTime == null ? 0 : numTime);
				break;
			case 3:
				deleteDate = DateUtil.AddDay(new Date(), numTime == null ? 0 : numTime);
				break;
			case 4:
				deleteDate = DateUtil.AddHour(new Date(), numTime == null ? 0 : numTime);
				break;
			case 5:
				deleteDate = DateUtil.AddMinute(new Date(), numTime == null ? 0 : numTime);
				break;
			default :
				deleteDate = DateUtil.AddMonth(new Date(), numTime == null ? 0 : numTime);
				break;
		}
		logger.debug("=============删除时间=========================" + DateUtil.date2String(deleteDate,"yyyy-MM-dd HH:mm:ss"));		
		BackUtil.deleteFiles(DateUtil.date2String(deleteDate,"yyyy-MM-dd HH:mm:ss"), savePath);
		logger.debug("=============删除结束=========================" + DateUtil.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));		
		
	}
}
