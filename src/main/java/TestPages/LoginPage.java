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

import managers.FileReaderManager;
import selenium.Wait;


public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver browser;

	public LoginPage(WebDriver browser)  throws IOException {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
	}

	File file = new File(FileReaderManager.getInstance().getConfigReader().getExcelDeLogin());

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
	
	@FindBy(how = How.CLASS_NAME, using = "loader")
	private WebElement logger;
	
	public RegisterPage clicaParaIrParaAPaginaDeCadastro() throws IOException {

		wait.until(ExpectedConditions.visibilityOf(logger));
		wait.until(ExpectedConditions.invisibilityOf(logger));		
		
		wait.until(ExpectedConditions.elementToBeClickable(nomeUsuario));
		
		criarNovaConta.click();
		
		return new RegisterPage(browser);	
	}

	public void preencheComOCampoDeNome(int numeroLinha) {
			
		Wait.untilPageLoadComplete(browser);

		nomeUsuario.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
	}
	
	public void preencheOCampoDeSenha(int numeroLinha) {
		senhaUsuario.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());				
	}
	
	public void clicaBotaoDeLogin(){
		wait.until(ExpectedConditions.visibilityOf(logger));
		
		wait.until(ExpectedConditions.invisibilityOf(logger));
		
		btnLogin.click();	
	}
	
	public boolean loginErrado() {
		
		boolean msgDeErro = wait.until(ExpectedConditions.
									visibilityOf(msgDeLoginErrado)).isDisplayed();
				
		return msgDeErro;
	}
}