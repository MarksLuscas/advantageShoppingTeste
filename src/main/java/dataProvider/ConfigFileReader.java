package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs/Configurations.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at" + propertyFilePath);
		}	
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("application url not specified in the Configuration.properties file ");
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;		
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
		
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equals("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else if(browserName.equals("edge")) return DriverType.EDGE;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}
	
	public String getExcelDeNovoCadastro() {
		String excelDeNovoCadastro = properties.getProperty("excelCadastroUsuario");
		if(excelDeNovoCadastro!= null) return excelDeNovoCadastro;
		else throw new RuntimeException("application url not specified in the Configuration.properties file ");
	}
	
	public String getExcelDeLogin() {
		String excelDeLogin = properties.getProperty("excelLoginUsuario");
		if(excelDeLogin!= null) return excelDeLogin;
		else throw new RuntimeException("application url not specified in the Configuration.properties file ");
	}
	
}