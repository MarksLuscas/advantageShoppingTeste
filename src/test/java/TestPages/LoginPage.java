package TestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver browser;
	
	File file = new File("C:\\Users\\lucas.corticeiro\\eclipse-workspace\\AdvantageTestes\\src\\test\\resources\\excelUtil\\loginUsuario.xlsx");

	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	
	XSSFSheet sheet = wb.getSheet("loginUsuario");
	
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();	
		
	
	public LoginPage(WebDriver browser)  throws IOException {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}
	
	
	public RegisterPage clicaParaIrParaAPaginaDeCadastro() throws IOException {
							
			wait.until(ExpectedConditions
					.elementToBeClickable
					(By.linkText("CREATE NEW ACCOUNT"))).click();
			
			return new RegisterPage(browser);	
	}


	public void preencheComOsDados(int numeroLinha) {
		
		WebElement username = 
				wait.until(ExpectedConditions.elementToBeClickable
						(By.name("username")));
		
		WebElement password = browser.findElement(By.name("password"));
				
		username.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
		password.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());
	
		browser.findElement(By.id("sign_in_btnundefined")).click();
	
	
	}
	
	public boolean loginErrado() {
		
		boolean msgDeErro = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("signInResultMessage"))).isDisplayed();
				
		return msgDeErro;
	}
	
	

}
