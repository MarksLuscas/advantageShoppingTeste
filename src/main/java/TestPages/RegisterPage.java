package TestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigFileReader;

public class RegisterPage {
		
	private WebDriver browser;
	private WebDriverWait wait;
//	private ConfigFileReader configFileReader;
	
	
	public RegisterPage(WebDriver browser) throws IOException {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
//		configFileReader = new ConfigFileReader();
	}

	File file = new File("C:\\Users\\lucas.corticeiro\\eclipse-workspace\\AdvantageTestes\\src\\test\\resources\\excelUtil\\paginaUsuario.xlsx");
	//path original -> C:\\Users\\lucas.corticeiro\\eclipse-workspace\\AdvantageTestes\\src\\test\\resources\\excelUtil\\paginaUsuario.xlsx
		
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	
	XSSFSheet sheet = wb.getSheet("cadastroUsuario");
	
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();	
	
	//FIND BY
	
	@FindBy(how = How.NAME, using = "usernameRegisterPage") 
	private WebElement nome;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage") 
	private WebElement email;
	
	@FindBy(how = How.NAME, using ="passwordRegisterPage") 
	private WebElement senha;
	
	@FindBy(how = How.NAME, using ="confirm_passwordRegisterPage") 
	private WebElement confirmaSenha;
	
	@FindBy(how = How.NAME, using = "first_nameRegisterPage") 
	private WebElement primeiroNome;
	
	@FindBy(how = How.NAME, using = "last_nameRegisterPage") 
	private WebElement segundoNome;
	
	@FindBy(how = How.NAME, using = "phone_numberRegisterPage") 
	private WebElement telefone;
	
	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement cidade ;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement endereco;
	
	@FindBy(how = How.NAME, using ="state_/_province_/_regionRegisterPage")
	private WebElement estado;
	
	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement codigoPostal;
	
	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement i_agreeBtn;
	
	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement registerBtn;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement countryListBox;
	
	//METODOS	
	public void preencheOsDados(int numeroLinha) {
		wait.until(ExpectedConditions.
				elementToBeClickable(nome)).
						sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
		email.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());
		senha.sendKeys(sheet.getRow(numeroLinha).getCell(2).getStringCellValue());
		confirmaSenha.sendKeys(sheet.getRow(numeroLinha).getCell(3).getStringCellValue());
		primeiroNome.sendKeys(sheet.getRow(numeroLinha).getCell(4).getStringCellValue());
		segundoNome.sendKeys(sheet.getRow(numeroLinha).getCell(5).getStringCellValue());
		telefone.sendKeys(sheet.getRow(numeroLinha).getCell(6).getStringCellValue());

		countryListBox.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.cssSelector("option[label='Afganistan']")));

		Select select = new Select(countryListBox);
		select.selectByVisibleText("Brazil");
				
		cidade.sendKeys(sheet.getRow(numeroLinha).getCell(7).getStringCellValue());
		endereco.sendKeys(sheet.getRow(numeroLinha).getCell(8).getStringCellValue());
		estado.sendKeys(sheet.getRow(numeroLinha).getCell(9).getStringCellValue());
		codigoPostal.sendKeys(sheet.getRow(numeroLinha).getCell(10).getStringCellValue());

	
	//BOTAO DE CONFIRMA A CONDICAO DE PRIVACIDADE 
	i_agreeBtn.click();
	
	//BOTAO DE REGISTRAR			
	wait.until(
			ExpectedConditions.elementToBeClickable(registerBtn)).click();
			
	}

	public boolean estaLogadoComOCadastroNovo() {

	boolean nome = wait.until(ExpectedConditions.
			visibilityOfElementLocated(
					By.cssSelector(
							".hi-user.containMiniTitle.ng-binding"))).
																isDisplayed();
		
		return nome;			
	}

	public boolean mensagemDeEmailInvalido() {
		
		boolean texto = wait.until(ExpectedConditions.
				textToBe(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/sec-form[1]/div[2]/label[1]"),
										"Invalid e-mail address"));
		
			return texto;
	}


	public boolean mensagensDeErro() {

		boolean msgDeUsuario = wait.until(ExpectedConditions.
				textToBe(By.cssSelector("sec-view[sec-model='model.username'] "
						+ "label[class='invalid']"), "Username field is required"));
		
		boolean msgDeSenha = wait.until(ExpectedConditions.
				textToBe(By.cssSelector("sec-view[a-hint='Password'] label[class='invalid']"), "Password field is required"));
		
		boolean msgDeConfirmaSenha = wait.until(ExpectedConditions.
				textToBe(By.cssSelector("sec-view[a-hint='Confirm password'] label[class='invalid']"), "Confirm password field is required"));
	
		if(msgDeUsuario && msgDeSenha && msgDeConfirmaSenha) {
			return true;
		}	return false;
	}


	public void preencheOCampoDeEmail(int numeroLinha) {
		
		Actions action = new Actions(browser);
		
		wait.until(ExpectedConditions.elementToBeClickable(nome)).click();
//		nome.click();
			
		action.sendKeys(Keys.TAB);
		
		email.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
				
		action.sendKeys(Keys.TAB);
		
		action.sendKeys(Keys.TAB);
		
		action.moveToElement(email).click();
		
		action.build().perform();
		
	}
	
}
