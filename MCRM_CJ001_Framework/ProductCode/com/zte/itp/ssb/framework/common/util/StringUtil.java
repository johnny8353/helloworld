/*     */package com.zte.itp.ssb.framework.common.util;

/*     */
/*     */import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*     */
/*     */public abstract class StringUtil
/*     */{
	/* 31 */private static final Pattern INT_PATTERN = Pattern
			.compile("^-?\\d+$");
	/*     */
	/* 33 */private static Log log = LogFactory.getLog(StringUtil.class);

	/*     */
	/*     */public static int convertStringToInt(String s)
	/*     */{
		/* 43 */int param = 0;
		/* 44 */if (isInteger(s))
		/*     */{
			/* 46 */param = Integer.parseInt(s);
			/*     */}
		/*     */else
		/*     */{
			/* 50 */throw new IllegalArgumentException(
					"Argum occured exception in convert String to int");
			/*     */}
		/* 52 */return param;
		/*     */}

	/*     */
	/*     */public static boolean equalsIgnoreCase(String str, String standardValue)
	/*     */{
		/* 62 */return (null != str) && (str.equalsIgnoreCase(standardValue));
		/*     */}

	/*     */
	/*     */public static int getCheckboxLimit(String limitParam)
	/*     */{
		/* 73 */return (null == limitParam)
				|| ((null != limitParam) && ("".equals(limitParam.trim()))) ? 10
				: convertStringToInt(limitParam);
		/*     */}

	/*     */
	/*     */public static boolean isStandardDate(String date)
	/*     */{
		/* 84 */if (null == date)
		/*     */{
			/* 86 */return false;
			/*     */}
		/*     */
		/* 89 */String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		/* 90 */Pattern p = Pattern.compile(eL);
		/* 91 */Matcher m = p.matcher(date);
		/* 92 */return m.matches();
		/*     */}

	/*     */
	/*     */public static boolean isInteger(String str)
	/*     */{
		/* 102 */Matcher matcher = INT_PATTERN.matcher(str);
		/* 103 */return matcher.find();
		/*     */}

	/*     */
	/*     */public static boolean isNullAndBlank(String str)
	/*     */{
		/* 113 */boolean flag = false;
		/* 114 */if ((null != str) && (!"".equals(str.trim())))
		/*     */{
			/* 116 */flag = true;
			/*     */}
		/* 118 */return flag;
		/*     */}

	/*     */
	/*     */public static boolean isNullOrEmpty(String str)
	/*     */{
		/* 129 */boolean flag = true;
		/* 130 */if ((null != str) && (!"".equals(str.trim())))
		/*     */{
			/* 132 */flag = false;
			/*     */}
		/* 134 */return flag;
		/*     */}

	/*     */
	/*     */public static String getUUID()
	/*     */{
		/* 144 */return UUID.randomUUID().toString();
		/*     */}

	/*     */
	/*     */public static String getNoLineUUID()
	/*     */{
		/* 153 */return getUUID().replace("-", "");
		/*     */}

	/*     */
	/*     */public static long getRandom()
	/*     */{
		/* 162 */Random rd = new Random();
		/* 163 */StringBuffer buf = new StringBuffer();
		/*     */do
		/*     */{
			/*     */int rdGet;
			/* 168 */if (rd.nextInt() % 2 == 1)
			/*     */{
				/* 170 */rdGet = Math.abs(rd.nextInt()) % 10 + 48;
				/*     */}
			/*     */else
			/*     */{
				/* 174 */rdGet = Math.abs(rd.nextInt()) % 26 + 97;
				/*     */}
			/* 176 */buf.append(rdGet);
			/*     */}
		/* 178 */while (buf.toString().length() < 8);
		/* 179 */return Long.parseLong(buf.toString());
		/*     */}

	/*     */
	/*     */public static void main(String[] args)
	/*     */{
		/* 184 */getRandom();
		/*     */}

	/*     */
	/*     */public static String toUpperCase(String str)
	/*     */{
		/* 194 */if (null == str)
		/*     */{
			/* 196 */return str;
			/*     */}
		/* 198 */return str.toUpperCase();
		/*     */}

	/*     */
	/*     */public static String getConnectionStr(String start, String end)
	/*     */{
		/* 208 */StringBuffer buf = new StringBuffer();
		/* 209 */return start + end;
		/*     */}

	/*     */
	/*     */public static List<String> splitStrByComma(String str)
	/*     */{
		/* 219 */List list = new ArrayList();
		/* 220 */String[] strArray = str.split(",");
		/* 221 */if (null != strArray)
		/*     */{
			/* 223 */for (String s : strArray)
			/*     */{
				/* 225 */if ((null == s) || ("".equals(s.trim())))
					/*     */continue;
				/* 227 */list.add(s);
				/*     */}
			/*     */}
		/*     */
		/* 231 */return list;
		/*     */}

	/*     */
	/*     */public static String mergeStr(String beginStr, String endStr)
	/*     */{
		/* 242 */return beginStr + endStr;
		/*     */}

	/*     */
	/*     */public static boolean isInvalidStr(String str)
	/*     */{
		/* 252 */return (null == str)
				|| ((null != str) && ("undefined".equalsIgnoreCase(str)));
		/*     */}

	/*     */
	public static String delLastComma(String str) {
		String temp = retBlankIfNull(str);
		if (temp.indexOf(',') > 0) {
			temp = str.substring(0, str.length() - 1);
		}
		return temp;
	}

	public static String retBlankIfNull(String str) {
		if (str == null)
			return "";
		else
			return str;
	}
	
	/**
     * 默认转义字符
     * 对content的内容进行转换后，在作为oracle查询的条件字段值。使用/作为oracle的转义字符,比较合适。<br>
     * 既能达到效果,而且java代码相对容易理解，建议这种使用方式<br>
     * "%'" + content + "'%  ESCAPE '/' "这种拼接sql看起来也容易理解<br>
     * 
     * @param content
     * @return
     */
    public static String decodeSpecialCharsWhenLikeUseBackslash(String content)
    {
        // 单引号是oracle字符串的边界,oralce中用2个单引号代表1个单引号
        String afterDecode = content.replaceAll("'", "''");
        // 由于使用了/作为ESCAPE的转义特殊字符,所以需要对该字符进行转义
        // 这里的作用是将"a/a"转成"a//a"
        afterDecode = afterDecode.replaceAll("/", "//");
        // 使用转义字符 /,对oracle特殊字符% 进行转义,只作为普通查询字符，不是模糊匹配
        afterDecode = afterDecode.replaceAll("%", "/%");
        // 使用转义字符 /,对oracle特殊字符_ 进行转义,只作为普通查询字符，不是模糊匹配
        afterDecode = afterDecode.replaceAll("_", "/_");
        return afterDecode;
    }

    /**
     * 对content的内容进行转换后，在作为oracle查询的条件字段值。使用\作为oracle的转义字符。<br>
     * 这种做法也能达到目的，但不是好的做法，比较容易出错，而且代码很那看懂。<br>
     * "%'" + content + "'%  ESCAPE '\' "这种拼接sql实际上是错误的.<br>
     * "%'" + content + "'%  ESCAPE '\\' "这种拼接sql才是正确的<br>
     * 
     * @param content
     * @return
     */
    public static String decodeSpecialCharsWhenLikeUseSlash(String content)
    {
        // 单引号是oracle字符串的边界,oralce中用2个单引号代表1个单引号
        String afterDecode = content.replaceAll("'", "''");
        // 由于使用了\作为ESCAPE的转义特殊字符,所以需要对该字符进行转义
        // 由于\在java和正则表达式中都是特殊字符,需要进行特殊处理
        // 这里的作用是将"a\a"转成"a\\a"
        afterDecode = afterDecode.replaceAll("\\\\", "\\\\\\\\");
        // 使用转义字符 \,对oracle特殊字符% 进行转义,只作为普通查询字符，不是模糊匹配
        afterDecode = afterDecode.replaceAll("%", "\\\\%");
        // 使用转义字符 \,对oracle特殊字符_ 进行转义,只作为普通查询字符，不是模糊匹配
        afterDecode = afterDecode.replaceAll("_", "\\\\_");
        return afterDecode;
    }
    
    

    /**
    *
    * 业务描述：傳入一个字符串，截取掉中间一部分，该部分用一个特殊符号包含。返回截取后的字符串
    * 作    者：Johnny Huang
    * 完成日期：2015-12-28
    * @param 
    * @return
    * @throws 
    */
    public static String GetStrDelSpeCode(String str,String SpeCode){
    	String returnSql = "";
    	 Pattern regex =Pattern.compile(SpeCode);
         String[] strs=regex.split(str);
         if(strs.length==3){
        	 returnSql = strs[0]+strs[2];
         }else{
        	 returnSql = str ;
         }
         return returnSql;
         
    }
    
    private static final Pattern REG_UNICODE = Pattern.compile("[0-9A-Fa-f]{4}");  
    private static final Pattern EN_CODE = Pattern.compile("[A-Za-z]{4}");  

    public static String unicode2String(String str) {  
        StringBuilder sb = new StringBuilder();  
        int len = str.length();  
        for (int i = 0; i < len; i++) {  
            char c1 = str.charAt(i);  
            if (c1 == '\\' && i < len - 1) {  
                char c2 = str.charAt(++i);  
                if (c2 == 'u' && i <= len - 5) {  
                    String tmp = str.substring(i + 1, i + 5);  
                    Matcher matcher = REG_UNICODE.matcher(tmp);  
                    if (matcher.find()) {  
                        sb.append((char) Integer.parseInt(tmp, 16));  
                        i = i + 4;  
                    } else {  
                        sb.append(c1).append(c2);  
                    }  
                } else {  
                    sb.append(c1).append(c2);  
                }  
            } else {  
                sb.append(c1);  
            }  
        }  
        return sb.toString();  
    } 

    /**
     * Convert the whole String object.
     * @param str
     * @return
     */
    public static String string2Unicode(String str)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            String tmpStr = Integer.toHexString(str.charAt(i));
            if(tmpStr.length() < 4){
                sb.append("\\u00");
            }else{
                sb.append("\\u");
            }
            sb.append(tmpStr);
        }
        return sb.toString();
    }
    /**
     * Just convert Chinese String Java将汉字转换\\uxxx方式
     * @param str
     * @return
     */
    public static String chinese2Unicode(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            String tmpStr = Integer.toHexString(str.charAt(i));

            if(tmpStr.length() < 4){
                sb.append(str.charAt(i));
            }else{
                sb.append("\\u");
                sb.append(tmpStr);
            }
        }
        return sb.toString();
    }
    public static String HtmlEncode(String str){
        return  StringEscapeUtils.escapeHtml(str);
    }
    public static String HtmlDecode(String str){
        return  StringEscapeUtils.unescapeHtml(str);
    }
    
    /**
     * 判断指定的字符串是否是空(null或""或"null"或"NULL"都是空)
    * 业务描述：
    * 作    者：Johnny Huang
    * 完成日期：2016-1-13 	上午11:00:02
    * @param @param str
    * @param @return
    * @return boolean 空：true;非空:false
     */
    public static boolean checkStrIsEmpty(String str)
    {
    	boolean bln=false;
    	if(str==null || "".equals(str)||"NULL".equalsIgnoreCase(str))
    	{
    		bln=true;
    	}
    	return bln;
    }
}
/*
 * Location: E:\Project\中兴通讯\JAVA\jar\zte\jssb.jar Qualified Name:
 * com.zte.itp.ssb.framework.common.util.StringUtil JD-Core Version: 0.6.0
 */