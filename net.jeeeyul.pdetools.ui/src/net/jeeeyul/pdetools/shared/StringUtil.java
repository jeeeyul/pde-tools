package net.jeeeyul.pdetools.shared;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;

public class StringUtil {
	private static String REG_EXP_CHARS = "+*{}()[].$!|\\";

	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean areSame(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}

		else if (str1 != null && str2 != null) {
			return str1.equals(str2);
		}

		return false;
	}

	public static boolean areSameIgnoreCase(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}

		else if (str1 != null && str2 != null) {
			return str1.equalsIgnoreCase(str2);
		}

		return false;
	}

	public static boolean startsWithIgnoreCase(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}

		else if (str1 != null && str2 != null) {
			return str1.toLowerCase().startsWith(str2.toLowerCase());
		}

		return false;
	}

	public static String eraseTag(String htmlString) {

		if (htmlString == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		StringReader reader = new StringReader(htmlString);
		int c = 0;
		try {
			while ((c = reader.read()) != -1) {
				if (c == '<') {
					while (c != '>' && c != -1) {
						c = reader.read();
					}
				} else {
					result.append((char) c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 주어진 문자열의 첫 줄을 리턴합니다.
	 * 
	 * @param source
	 *        입력 문자열. <code>null</code>일 수 없음.
	 * @return 주어진 입력의 첫번째 줄.
	 */
	public static String getFirstLine(String source) {
		Assert.isNotNull(source);
		BufferedReader reader = new BufferedReader(new StringReader(source));
		try {
			String result = reader.readLine();
			reader.close();
			result = StringUtil.nullToEmpty(result);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * source 문자열의 대문자를 추출합니다. 첫 글자는 대문자가 아니더라도 추출합니다.
	 * 
	 * @param source
	 * @return
	 * @since 1.9.3
	 */
	public static String getCamelCase(String source, boolean forceHandleFirstCharToCamel, boolean handleNumberToCamel) {
		if (source == null || source.trim().isEmpty()) {
			return "";
		}

		// if (source.equals(source.toUpperCase())) {
		// source = source.toLowerCase();
		// }

		StringBuffer buffer = new StringBuffer();

		if (forceHandleFirstCharToCamel) {
			// 첫번째 문자를 대문자로 변경한다.
			source = Character.toUpperCase(source.charAt(0)) + source.substring(1, source.length());
		}

		for (int index = 0; index < source.length(); index++) {
			char ch = source.charAt(index);

			if (Character.isUpperCase(ch) || (handleNumberToCamel && Character.isDigit(ch))) {
				buffer.append(ch);
			}
		}

		return buffer.toString();
	}

	public static boolean isHTMLString(String string) {
		if (string == null) {
			return false;
		}
		return string.trim().toLowerCase().startsWith("<html");
	}

	public static void main(String[] args) {
		String input = "VARCHAR(20)";
		Pattern pattern = Pattern.compile("VARCHAR\\((.*)\\)|VARCHAR");
		Matcher matcher = pattern.matcher(input);
		matcher.matches();
		System.out.println(matcher.end());
	}

	public static String read(InputStream stream, String encoding) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte buf[] = new byte[512];
		int len = -1;
		while ((len = stream.read(buf)) != -1) {
			buffer.write(buf, 0, len);
		}
		stream.close();
		buffer.close();
		String result = new String(buffer.toByteArray(), encoding);

		return result;
	}

	public static void write(String content, OutputStream stream, String encoding) throws IOException {
		byte[] data = content.getBytes(encoding);
		int block = 512;
		for (int i = 0; i < data.length; i += block) {
			int size = Math.min(data.length - i, block);
			stream.write(data, i, size);
		}
	}

	/**
	 * 주어진 {@link String}에서 빈 줄을 제거하고 리턴합니다.
	 * 
	 * @param original
	 *        입력 소스. <code>null</code>일 수 없습니다.
	 * @return 빈 줄이 제거된 {@link String}.
	 */
	public static String removeEmptyLine(String original) {
		try {
			BufferedReader reader = new BufferedReader(new StringReader(original));
			StringBuffer buffer = new StringBuffer();
			String line = null;
			boolean isFirstLine = true;
			while ((line = reader.readLine()) != null) {
				if (line.trim().length() > 0) {
					if (isFirstLine) {
						buffer.append(line);
						isFirstLine = false;
					} else {
						buffer.append("\r\n" + line);
					}
				}
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return original;
		}
	}

	/**
	 * 정규 표현식으로 안전하게 나타낼 수 있는 스트링으로 변경됩니다. 정규 표현식의 키워드들이 모두 래핑됩니다.
	 * 
	 * @param source
	 * @return
	 */
	public static String toRegExpSafeString(String source) {
		StringReader reader = new StringReader(source);
		StringBuffer result = new StringBuffer();
		try {
			int data = -1;
			while ((data = reader.read()) != -1) {
				char c = (char) data;
				if (REG_EXP_CHARS.indexOf(c) != -1) {
					result.append('\\');
				}
				result.append(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 정규 표현식으로 안전하게 나타낼 수 있는 스트링으로 변경됩니다. 정규 표현식의 키워드들이 모두 래핑됩니다.
	 * 
	 * @param source
	 * @return
	 */
	public static String wildExpToRegExpSafeString(String source) {
		StringReader reader = new StringReader(source);
		StringBuffer result = new StringBuffer();
		try {
			int data = -1;
			while ((data = reader.read()) != -1) {
				char c = (char) data;
				if (c == '?') {
					result.append(".");
				} else if (c == '*') {
					result.append(".*");
				} else if (REG_EXP_CHARS.indexOf(c) != -1) {
					result.append('\\');
					result.append(c);
				} else {
					result.append(c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static String nullToEmpty(Object value) {
		return ifNull(value, "");
	}

	public static String ifNull(Object value, String nullExpression) {
		return value != null ? value.toString() : nullExpression;
	}

	public static boolean isNullOrBlank(String currentLogicalName) {
		return currentLogicalName == null || currentLogicalName.trim().isEmpty();
	}

	public static String emptyToNull(String value) {
		if (value != null && value.isEmpty()) {
			return null;
		}
		return value;
	}

	public static String camelToPlain(String camelString) {
		Assert.isNotNull(camelString);
		StringBuffer buffer = new StringBuffer();
		Character prev = null;
		for (int i = 0; i < camelString.length(); i++) {
			char c = camelString.charAt(i);
			if (prev != null && Character.isLowerCase(prev) && Character.isUpperCase(c)) {
				buffer.append(" ");
			} else if (prev == null) {
				c = Character.toUpperCase(c);
			}
			buffer.append(c);
			prev = c;
		}
		return buffer.toString();
	}

}
