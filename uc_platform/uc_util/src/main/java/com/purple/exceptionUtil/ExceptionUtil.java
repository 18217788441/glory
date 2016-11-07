package com.purple.exceptionUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExceptionUtil {
	public static String getExceptionDetail(Throwable t) {
		if (t == null)
			return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			t.printStackTrace(new PrintStream(baos));
		} finally {
			try {
				baos.close();
			} catch (IOException localIOException) {
			}
		}
		return baos.toString();
	}
}
