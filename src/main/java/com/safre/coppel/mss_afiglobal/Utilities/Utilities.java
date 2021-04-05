package com.safre.coppel.mss_afiglobal.Utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import net.minidev.json.JSONArray;


public class Utilities {

	public static FTPClient ftpClient = new FTPClient();

	public static Properties getMyProperties(String nameMS)
			throws IOException, UnsatisfiedLinkError, NullPointerException, SecurityException {
		Properties pro = new Properties();

		InputStream input = null;
		try {
			input = new FileInputStream("../conf/application.properties");
			pro.load(input);
			pro.setProperty("server.port", pro.getProperty("port.mssafiglobal"));

		} catch (IOException ex) {
			// ex.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return pro;
	}

	public static void log(String name, String text) {

		FileHandler fh = null;

		try {

			boolean write = Boolean.parseBoolean(System.getProperty("log.ms.write"));

			if (!write) {
				return;
			}

			Logger logger = Logger.getLogger("MyLog");

			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

			System.setProperty("java.util.logging.SimpleFormatter.format",
					"%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %n %4$s: %5$s %n");

			fh = new FileHandler(System.getProperty("log.ms") + name + "-" + ft.format(dNow) + ".log", true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info(text);

		} catch (SecurityException e) {
			// e.printStackTrace();
			return;
		} catch (IOException e) {
			// e.printStackTrace();
			return;
		} finally {
			if (fh != null) {
				fh.close();
			}
		}
	}

	public static net.minidev.json.JSONObject leerArchivoFTP(String servidor, String puerto, String uFtp, String pFtp, String localPath,
			String filename) {

		InputStream in = null;
		String str;
		net.minidev.json.JSONObject objContenido = new net.minidev.json.JSONObject(); 
		
		
		try {
			connectToServer(servidor, puerto, uFtp, pFtp, localPath);

			ftpClient.enterLocalPassiveMode();
			ftpClient.setControlKeepAliveTimeout(300);
			// Set transfer binary file

			setFileType(FTP.BINARY_FILE_TYPE);
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				Utilities.log("mss_afiglobal", "failed to connect to the FTP Server:" + servidor);
			}
			ftpClient.changeWorkingDirectory(localPath);

			// FTP file get file
			in = ftpClient.retrieveFileStream(filename);
			InputStreamReader isReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isReader);
			JSONArray jsonArray = new JSONArray();
			while ((str = reader.readLine()) != null) {
				
				jsonArray.add(str);
				
			}
			
			objContenido.put("text", jsonArray);
			
			ftpClient.disconnect();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			Utilities.log("mss_afiglobal", "Error al leer el archivo:" + e.toString());
			e.printStackTrace();
		}
		
		return objContenido;

	}

	private static void connectToServer(String servidor, String puerto, String uFtp, String pFtp, String localPath)
			throws FTPConnectionClosedException, Exception {
		if (!ftpClient.isConnected()) {
			int reply;
			try {
				ftpClient = new FTPClient();
				ftpClient.setControlEncoding("UTF-8");
				ftpClient.enterLocalPassiveMode();
				ftpClient.connect(servidor, Integer.valueOf(puerto));
				ftpClient.login(uFtp, pFtp);
				reply = ftpClient.getReplyCode();

				if (!FTPReply.isPositiveCompletion(reply)) {
					ftpClient.disconnect();
					Utilities.log("mss_afiglobal", "connectToServer FTP server refused connection.");
				}

			} catch (FTPConnectionClosedException ex) {
				Utilities.log("mss_afiglobal", "Server:IP:" + servidor
						+ "No connection! There are too many connected users, please try later " + ex);
				throw ex;
			} catch (Exception e) {
				Utilities.log("mss_afiglobal", "Login to ftp server [" + servidor + "] failed " + e);
				throw e;
			}
		}
	}

	private static void setFileType(int fileType) {
		try {
			ftpClient.setFileType(fileType);
		} catch (Exception e) {
			Utilities.log("mss_afiglobal", "Failed to set the type of file transfer by FTP! " + e);
		}
	}

}
