package Utiity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class helper {

	public static void captureScreenShot(WebDriver driver ,String ScreenShotName)
	{
		Path destination = Paths.get("./ScreenShots", ScreenShotName+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out =new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {

			System.out.println("Exception while Takin creenShot" + e.getMessage());

		}
		
	 
		

	}

}
