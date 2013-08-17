package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
	public static String toString(InputStream in) {
		if (in == null) return "";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int b = 0;
		try {
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}
		return out.toString();
	}
}
