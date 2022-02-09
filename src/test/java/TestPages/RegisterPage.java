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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
		
	private WebDriver browser;
	private WebDriverWait wait;
	

	File file = new File("C:\\Users\\lucas.corticeiro\\eclipse-workspace\\AdvantageTestes\\src\\test\\resources\\excelUtil\\paginaUsuario.xlsx");

	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	
	XSSFSheet sheet = wb.getSheet("cadastroUsuario");
	
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();	
	
	
	public RegisterPage(WebDriver browser) throws IOException {
		this.browser = browser;
		wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}
		
	
	public void preencheOsDados(int numeroLinha) {
				
	WebElement nome = wait.until(
				ExpectedConditions.elementToBeClickable
				(By.name("usernameRegisterPage")));
	
	WebElement email = browser.findElement(By.name("emailRegisterPage"));
	WebElement senha = browser.findElement(By.name("passwordRegisterPage"));
	WebElement confirmaSenha =	browser.findElement(By.name("confirm_passwordRegisterPage"));
	WebElement primeiroNome = browser.findElement(By.name("first_nameRegisterPage"));
	WebElement segundoNome = browser.findElement(By.name("last_nameRegisterPage"));
	WebElement telefone = browser.findElement(By.name("phone_numberRegisterPage"));		
	WebElement cidade =	browser.findElement(By.name("cityRegisterPage"));
	WebElement endereco = browser.findElement(By.name("addressRegisterPage"));
	WebElement estado =	browser.findElement(By.name("state_/_province_/_regionRegisterPage"));
	WebElement codigoPostal = browser.findElement(By.name("postal_codeRegisterPage"));
		

		nome.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
		email.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());
		senha.sendKeys(sheet.getRow(numeroLinha).getCell(2).getStringCellValue());
		confirmaSenha.sendKeys(sheet.getRow(numeroLinha).getCell(3).getStringCellValue());
		primeiroNome.sendKeys(sheet.getRow(numeroLinha).getCell(4).getStringCellValue());
		segundoNome.sendKeys(sheet.getRow(numeroLinha).getCell(5).getStringCellValue());
		telefone.sendKeys(sheet.getRow(numeroLinha).getCell(6).getStringCellValue());
		
		
//		//ESCOLHER A OPCAO DE BRAZIL			
//			wait.until(ExpectedConditions.
//					elementToBeClickable(By.xpath(""
//							+ "/html/body/div[3]/section/article/"
//							+ "sec-form/div[1]/div[2]/div/div[3]/"
//							+ "div[1]/sec-view[1]/div/select/option[30]"))).click();
		WebElement lista = browser.findElement(By.name("countryListboxRegisterPage"));
		lista.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[label='Afganistan']")));

		Select select = new Select(lista);
		select.selectByVisibleText("Brazil");
				
		cidade.sendKeys(sheet.getRow(numeroLinha).getCell(7).getStringCellValue());
		endereco.sendKeys(sheet.getRow(numeroLinha).getCell(8).getStringCellValue());
		estado.sendKeys(sheet.getRow(numeroLinha).getCell(9).getStringCellValue());
		codigoPostal.sendKeys(sheet.getRow(numeroLinha).getCell(10).getStringCellValue());

	
	//BOTAO DE CONFIRMA A CONDICAO DE PRIVACIDADE 
	browser.findElement(
				By.name("i_agree")).click();
	
	//BOTAO DE REGISTRAR			
	wait.until(
			ExpectedConditions.elementToBeClickable(
					By.id("register_btnundefined"))).click();
			
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
		
		wait.until(ExpectedConditions.elementToBeClickable
				(By.name("usernameRegisterPage"))).click();
			
		action.sendKeys(Keys.TAB);
						
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable
				(By.name("emailRegisterPage")));

		email.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
				
		action.sendKeys(Keys.TAB);
		
		action.sendKeys(Keys.TAB);
		
		action.moveToElement(browser.findElement(
				By.name("emailRegisterPage"))).click();
		
		action.build().perform();
		
	}
	
}
