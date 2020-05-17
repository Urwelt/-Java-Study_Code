package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	/**
	 * コンソールから文字を入力する
	 * 
	 * @return 入力した文字（１文字）
	 */
	public static char getChar() {
		return getChar("char");
	}

	public static char getChar(String s) {

		char c = 0;
		String str = getStr(s);
		if (str == null)
			return 0;
		try {
			c = str.charAt(0);

		} catch (Exception e) {
			c = 0;
		}
		return c;
	}

	/**
	 * コンソールからbyteを入力する
	 * 
	 * @return 入力したbyte
	 */
	public static byte getByte() {
		return getByte("byte");
	}

	public static byte getByte(String s) {

		byte b = 0;
		String str = getStr(s);
		if (str == null)
			return 0;
		try {
			b = Byte.parseByte(str);

		} catch (Exception e) {
			b = 0;
		}
		return b;

	}

	/**
	 * コンソールからshort整数を入力する
	 * 
	 * @return 入力した整数
	 */
	public static short getShort() {
		return getShort("short");
	}

	public static short getShort(String s) {

		short n = 0;
		String str = getStr(s);
		if (str == null)
			return 0;
		try {
			n = Short.parseShort(str);

		} catch (Exception e) {
			n = 0;
		}
		return n;

	}

	/**
	 * コンソールから整数を入力する
	 * 
	 * @return 入力した整数
	 */
	public static int getInt() {
		return getInt("int");
	}

	public static int getInt(String s) {

		int n = 0;
		String str = getStr(s);
		/*
		 * エンターキーだけの入力では0を返す
		 */
		if (str == null) {
			return 0;
		}else if(str.length()==1 && !Character.isDigit(str.charAt(0))) {
			/* 
			 * 数字でない１文字の入力は、文字コードの整数値を返す
			 */
			return str.charAt(0);
		}
		/*
		 * 数値にパースする。非数値だった場合は0を返す
		 */
		try {
			n = Integer.parseInt(str);

		} catch (Exception e) {
			n = 0;
		}
		return n;

	}
	/*
	 * 16進数形式でのbyte値の入力
	 * 
	 */
	public static byte getHex() {
		return getHex("Hex");
	}
	public static byte getHex(String s) {
		byte n = 0;
		String str = getStr(s);		
		
		/*
		 * エンターキーだけの入力では0を返す
		 */
		if (str == null) {
			return 0;
		}
		/*
		 * 2文字以上あると、先頭の2文字だけを使う
		 */
		if(str.length()>2) {
			str = str.substring(0, 2);
		}
		try {
			n = (byte)Long.parseLong(str, 16);
			
		} catch (Exception e) {
			n = 0;
		}
		return n;
	}
	/*
	 * 2進数形式でのbyte値の入力
	 * 
	 */
	public static byte getBin() {
		return getBin("Bin");
	}	
	public static byte getBin(String s) {
		byte n = 0;
		String str = getStr(s);	
		/*
		 * エンターキーだけの入力では0を返す
		 */
		if (str == null) {
			return 0;
		}
		/*
		 * 8文字以上あると、先頭の8文字だけを使う
		 */
		if(str.length()>8) {
			str = str.substring(0, 8);
		}
		try {
			n = (byte)Long.parseLong(str, 2);
			
		} catch (Exception e) {
			n = 0;
		}
		return n;
	}
	/**
	 * コンソールからlong整数を入力する
	 * 
	 * @return 入力した整数
	 */
	public static long getLong() {
		return getLong("long");
	}

	public static long getLong(String s) {

		long n = 0;
		String str = getStr(s);
		if (str == null)
			return 0L;
		try {
			n = Long.parseLong(str);

		} catch (Exception e) {
			n = 0;
		}
		return n;

	}

	/**
	 * コンソールからDoubleを入力する
	 * 
	 * @return 入力した実数
	 */
	public static double getDouble() {
		return getDouble("double");
	}

	public static double getDouble(String s) {

		double x = 0;
		String str = getStr(s);
		if (str == null)
			return 0.0;
		try {
			x = Double.parseDouble(str);

		} catch (Exception e) {
			x = 0.0;
		}
		return x;

	}

	/**
	 * コンソールからFloatを入力する
	 * 
	 * @return 入力した実数
	 */
	public static float getFloat() {
		return getFloat("float");
	}

	public static float getFloat(String s) {

		float x = 0f;
		String str = getStr(s);
		if (str == null)
			return 0.0f;
		try {
			x = Float.parseFloat(str);

		} catch (Exception e) {
			x = 0.0f;
		}
		return x;

	}

	/**
	 * コンソールからbooleanを入力する<br/>
	 * true 以外はすべてfalseとなる
	 * 
	 * @return true または false（既定値）
	 */
	public static boolean getBoolean() {
		return getBoolean("boolean");
	}

	public static boolean getBoolean(String s) {

		String str = getStr(s);
		if (str != null && str.trim().toLowerCase().equals("true")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * コンソールから文字列を入力する
	 * 
	 * @return 入力した文字列
	 */
	public static String getString() {

		return getString("String");
	}

	public static String getString(String s) {

		String str = getStr(s);

		if (str == null || str.length() == 0) {
			return null;

		} else {
			return str;
		}
	}
	/**
	 * コンソールから文字列を入力する
	 * リターンキーだけタイプすると空文字を返す
	 * nullを返すには、\0または、\nullを入力する
	 * 
	 * @return 入力した文字列
	 */
	public static String getStringE() {

		return getStringE("String");
	}

	public static String getStringE(String s) {

		String str = getStr(s);
		if (str == null || str.length() == 0) {
			return "";		// 空文字

		}else if(str.equals("\\0")||str.equals("\\null")){
			return null;   // null
			
		}else {
			return str;
		}
	}

	/**
	 * コンソールから文字列を入力する
	 * 
	 * @param s
	 * @return
	 */
	public static String getStr(String s) {

		String str = null;
		guide(s);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
		} catch (IOException e) {
			return null;
		}
		return str;

	}

	public static void guide(String s) {

		System.out.print(s + ">");
		System.out.flush();
	}
}
