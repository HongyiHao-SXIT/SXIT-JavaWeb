package util;
import java.io.UnsupportedEncodingException;
public class MyUtil {
	/**
	 * 中文文件名字符编码转换方法
	 */
	public static String toUTF8String(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i = 0; i < len; i++){
			//取出字符中的每个字符
			char c = str.charAt(i);
			//Unicode码值在0-255之间，不作处理
			if(c >= 0 && c <= 255){
				sb.append(c);
			}else{//转换UTF-8编码
				byte b[];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					b = null;
				}
				//转换为%HH的字符串形式
				for(int j = 0; j < b.length; j ++){
					int k = b[j];
					if(k < 0){
						k &= 255;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}
