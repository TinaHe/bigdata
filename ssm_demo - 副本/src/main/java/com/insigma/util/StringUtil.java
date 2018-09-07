/**
 * 
 */
package com.insigma.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author insigma
 *
 */
public class StringUtil {
    /**
     * 判断是否是空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 判断是否不是空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if((str!=null)&&!"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 格式化模糊查询
     * @param str
     * @return
     */
    public static String formatLike(String str){
        if(isNotEmpty(str)){
            return "%"+str+"%";
        }else{
            return null;
        }
    }
    /**
     * 将字符串根据","分割符转化为数组
     * @param str
     * @return
     */
    public static String[] str2Array(String str) {
    	if (str == null || "".equals(str)) return null;  
        return str2Array(str,","); 
    }
    /**
     * 将字符串根据给定的分割符转化为数组
     * @param str
     * @param split
     * @return
     */
    public static String[] str2Array(String str, String split) {
    	if (str == null || "".equals(str)) return null;  
        return str.split(split);
    }
    /**
     * 将字符串根据","分割符转化为数组
     * @param str
     * @return
     */
    public static String array2Str(String[] arr) {
    	if (arr == null) return null;  
    	
        return array2Str(arr,","); 
    }
    /**
     * 将字符串根据给定的分割符转化为数组
     * @param str
     * @param split
     * @return
     */
    public static String array2Str(String[] arr, String split) {
    	if (arr == null) return null;
    	StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < arr.length; i++) {
	    	sb.append(arr[i]);
	      if (i != arr.length - 1) {
	    	  sb.append(split);
	      }
	    }     	
        return sb.toString();
    }    
    /**
     * 将字符串根据","分割符转化为数组
     * @param str
     * @return
     */
    public static String list2Str(List<String> list) {
    	if (list == null) return null;  
    	
        return list2Str(list,","); 
    }
    /**
     * 将字符串根据给定的分割符转化为数组
     * @param str
     * @param split
     * @return
     */
    public static String list2Str(List<String> list, String split) {
    	if (list == null) return null;
    	StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < list.size(); i++) {
	    	sb.append(list.get(i));
	      if (i != list.size() - 1) {
	    	  sb.append(split);
	      }
	    }     	
        return sb.toString();
    }
    /**
     * 去掉回车换行符
     * @param str
     * @return
     */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}    
}
