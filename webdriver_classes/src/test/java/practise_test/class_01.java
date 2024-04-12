package practise_test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class class_01 {

	static List<WebElement> links = new ArrayList<>();
	static List<Object> expected_values = new ArrayList<>();

	@Test()
	public void web() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(3000);
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Employee Name')]")));
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Employee Id')]")));
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Employment Status')]")));
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Include')]")));
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Supervisor Name')]")));
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Job Title')]")));
//		links.add(driver.findElement(By.xpath("//*[contains(text(),'Sub Unit')]")));

		try {
			links.addAll(driver
					.findElements(By.xpath("//*[@class='oxd-grid-4 orangehrm-full-width-grid']/div/div/div/label")));
			System.out.println("The actual texts are should be present in the page are :" + links.size());

			expected_values.add("Employee Name");
			expected_values.add("Employee Id");
			expected_values.add("Employment Status");
			expected_values.add("Include");
			expected_values.add("Supervisor Name");
			expected_values.add("Job Title");
			expected_values.add("Sub Unit");
			System.out.println("The expected texts size are :" + expected_values.size());

			for (int i = 0; i < links.size(); i++) {
				String actual = links.get(i).getText();

				if (actual.equals(expected_values.get(i))) {
					System.out.println("The actual result is :" + actual);
					System.out.println("The expected result is :" + expected_values.get(i));
				} else {
					System.out.println("The actual result is :" + actual);
					System.out.println("The expected result is :" + expected_values.get(i));
					Assert.assertEquals("actual and expected results are doesn't matched", actual,
							expected_values.get(i));
				}
			}
			System.out.println("The given actual and expected results should be matched succesfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}
}
