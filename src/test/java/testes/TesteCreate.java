package testes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TesteCreate {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4200/clientes");

        driver.getTitle();

        try {
            WebElement button = driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-cliente-crud/button"));
            button.click();

            WebElement textBox1 = driver.findElement(By.name("nome_cli"));
            textBox1.sendKeys("Andreo Rattmann");

            WebElement textBox2 = driver.findElement(By.name("cpf_cli"));
            textBox2.sendKeys("45678912325");

            WebElement textBox3 = driver.findElement(By.name("telefone_cli"));
            textBox3.sendKeys("43996005231");

            WebElement textBox4 = driver.findElement(By.name("email_cli"));
            textBox4.sendKeys("andreor@gmail.com");


            WebElement submitButton = driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-cliente-create/div/mat-card/button[1]/span[1]"));
            submitButton.click();

        }catch (Exception e) {
            System.out.println("Erro durante o preenchimento do formulário: " + e.getMessage());
        }
        driver.quit();
    }
}