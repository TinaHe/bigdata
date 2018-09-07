/**
 * 
 */
package com.insigma.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author insigma
 *
 */
public class BackUtil {
	private static Logger logger = Logger.getLogger(BackUtil.class);
    /**
     * Java代码实现MySQL数据库导出
     * 
     * @author zhx
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     */
    public static boolean exportDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName,String commondStr) {
    	logger.debug("============备份开始=====================备份路径:" + savePath + "   备份文件名称:" + fileName);
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(commondStr).append(" --opt --verbose ").append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName) .append(" --password=").append(password).append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ").append(databaseName);
        logger.debug("sql=" + stringBuilder.toString());
        try {
            Process process = Runtime.getRuntime().exec(stringBuilder.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
            	logger.debug("备份成功===============================");
                return true;
            }
        } catch (IOException e) {
        	logger.error("备份异常:" + e.getMessage());
        } catch (InterruptedException e) {
        	logger.error("备份异常:" + e.getMessage());
        }
        logger.debug("备份失败===============================");
        return false;
    }	
    /**
     * 删除指定时间之前的文件
     * @param dateTime
     */
    public static void deleteFiles(String dateTime,String filePath) {
    	logger.debug("============删除文件开始=====================路径:" + filePath + "   指定时间:" + dateTime);
    	
    	Date date = DateUtil.string2DateFormat(dateTime,"yyyy-MM-dd HH:mm:ss");  
    	File folder = new File(filePath);  
    	File[] files = folder.listFiles(); 
    	logger.debug("============删除文件数量=====================" + files != null ? files.length : 0);
    	for (int i=0;i<files.length;i++){  
    	    File file = files[i];  
    	    if (!file.isDirectory() && new Date(file.lastModified()).before(date)){ 
    	    	logger.debug("============删除文件名=====================name:" + file.getName());
    	        file.delete();  
    	    }  
    	}    	
    	logger.debug("============删除文件结束====================");
    }
    public static void main(String[] args) {
    	exportDatabaseTool("127.0.0.1","insigma","insigma2017","d:/test","test0314.sql","test11","D:/softinstall/mysql-5.6.38-winx64/bin/mysqldump");
//    	deleteFiles("2018-01-10","d:/test");
	}
}
