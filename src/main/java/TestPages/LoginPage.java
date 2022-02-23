package TestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.Wait;


public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver browser;
	//private ConfigFileReader configFileReader;

	public LoginPage(WebDriver browser)  throws IOException {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
//		configFileReader = new ConfigFileReader();
	}

	File file = new File("C:\\Users\\lucas.corticeiro\\eclipse-workspace\\AdvantageTestes\\src\\test\\resources\\excelUtil\\loginUsuario.xlsx");
	//path original -> C:\\Users\\lucas.corticeiro\\eclipse-workspace\\AdvantageTestes\\src\\test\\resources\\excelUtil\\loginUsuario.xlsx
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	
	XSSFSheet sheet = wb.getSheet("loginUsuario");
	
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();	
	
	@FindBy(how = How.CSS, using = ".create-new-account.ng-scope")
	private WebElement criarNovaConta;	
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement nomeUsuario;	
		
	@FindBy(how = How.NAME, using = "password")
	private WebElement senhaUsuario;	
	
	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement btnLogin;	
	
	@FindBy(how = How.ID, using = "signInResultMessage")
	private WebElement msgDeLoginErrado;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]")
	private WebElement logger;
	
	public RegisterPage clicaParaIrParaAPaginaDeCadastro() throws IOException {
	
		Wait.untilPageLoadComplete(browser);
		
		wait.until(ExpectedConditions.invisibilityOf(logger));		
		
		criarNovaConta.click();
		
		return new RegisterPage(browser);	
	}

	public void preencheComOsDados(int numeroLinha) {
			
		Wait.untilPageLoadComplete(browser);

		wait.until(ExpectedConditions.invisibilityOf(logger));	
		
		nomeUsuario.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
		senhaUsuario.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());				
		
		btnLogin.click();	
	}
	
	public boolean loginErrado() {
		
		boolean msgDeErro = wait.until(ExpectedConditions.
									visibilityOf(msgDeLoginErrado)).isDisplayed();
				
		return msgDeErro;
	}
	
	

}
