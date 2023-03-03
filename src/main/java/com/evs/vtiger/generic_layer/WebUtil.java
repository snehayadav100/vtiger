package com.evs.vtiger.generic_layer;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebUtil {
	
	private WebDriver driver;
	private ExtentReports report;
	private ExtentTest test;

	//forJavaDoc = ( alt+shift+j ) //


	/**
	 * @param browername
	 */
	public void Browerlaunch(String browername) {

		try {
			if (browername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browername.equalsIgnoreCase("firefox")) {
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			} else if (browername.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.println("Brower name is wrong please check it");
			}
		} catch (Exception a) {
			a.printStackTrace();
		}

	}

	/**
	 * @param url
	 */
	public void forURLhit(String url) {
		try {
			driver.get(url);
			test.log(Status.INFO, url+" open successfully ");
		} catch (Exception e) {
			test.log(Status.INFO, url+" open successfully ");
			driver.navigate().to(url);
		} catch (Throwable e) {
			test.log(Status.FAIL, url+" not open successfully ");
			e.printStackTrace();
		}
	}

	/**
	 * @param we 
	 * @param locatorValue
	 * @param elementName
	 */

	public WebDriver GetDriver() {
		if(driver==null)	{
			test.log(Status.FAIL,"") ; 
		}
		return driver;
	}


	/**
	 * @param driver
	 * @return
	 */
	public WebDriver setDriver(WebDriver driver) {
		this.driver=driver;
		return driver;
	}


	/**
	 * @param we
	 * @param elementName
	 */
	public void sizeOfElement(WebElement we, String elementName) {
		try {
			Dimension elemntDimension = elementSize(we);
			{
				System.out.println("height of " + elementName + "  -" + elemntDimension.height);
				System.out.println("Width of " + elementName + "  -" + elemntDimension.width);
			}
		} catch (Exception e) {

		}

	}


	/**
	 * @param locatortype
	 * @param locatorvalue
	 * @param elememntName
	 * @param required_x_cordinate
	 * @param required_Y_cordinate
	 */
	public void valildateLocation(WebElement we, String elememntName,
			int required_x_cordinate, int required_Y_cordinate) {
		// TODO Auto-generated method stub
		try {
			Point objPoint = we.getLocation();
			int actual_X_cordinate = objPoint.x;
			int actual_Y_cordinate = objPoint.y;
			if (required_x_cordinate == actual_X_cordinate) {
				test.log(Status.PASS, elememntName + "x-cordinate verified!");
			} else {
				test.log(Status.FAIL, elememntName + "x-cordinate mismatched with expected value!");
			}
			if (required_Y_cordinate == actual_Y_cordinate) {
				test.log(Status.PASS, elememntName + "y-cordinate verified!");
			} else {
				test.log(Status.FAIL, elememntName + "y-cordinate mismatched with expected value!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "while validating location of " + elememntName
					+ " exception occured thus,followed by handeling it");

		}
	}


	/**
	 * @param locatortype
	 * @param locatorvalue
	 * @param elememntName
	 * @param required_height
	 * @param required_width
	 */
	public void valildateSize(WebElement we, String elememntName, int required_height,
			int required_width) {
		try {
			Dimension objDimension = we.getSize();
			int actual_height = objDimension.getHeight();
			int actual_width = objDimension.getWidth();
			if (required_height == actual_height) {
				test.log(Status.PASS, elememntName +actual_height+ " height verified!"+required_height);
			} else {
				test.log(Status.FAIL, elememntName + " height mismatched with expected value!");
			}
			if (required_width == actual_width) {
				test.log(Status.PASS, elememntName + " width verified!");
			} else {
				test.log(Status.FAIL, elememntName + " width mismatched with expected value!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL,
					"while validating size of " + elememntName + " exception occured thus,followed by handeling it");
		}
	}


	/**
	 * @param locatortype
	 * @param locatorvalue
	 * @param elememntName
	 */
	public void isEnabled(WebElement we,  String elementName) {
		try {

			boolean e = we.isEnabled();

			if (e == true) {
				test.log(Status.PASS, elementName + "  is clickable ");

			} else {
				test.log(Status.FAIL, elementName + "  is not clickable ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param locatortype
	 * @param locatorvalue
	 * @param elementName
	 */
	public void isDisplayed(WebElement we, String elementName) {
		try {
			boolean id = we.isDisplayed();

			if (id == true) {
				test.log(Status.PASS, elementName + "is visisble");

			} else {
				test.log(Status.FAIL, elementName + "is not visible");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param expectedTitle
	 */
	public void validatePageTitle(String expectedTitle) {

		if (gettitle().equals(expectedTitle))
			test.log(Status.PASS, " Title verified with expected title " + expectedTitle);
		else {
			test.log(Status.FAIL, " Title mismatched with expected title " + expectedTitle);

		}

	}

	/**
	 * @return
	 */
	public String gettitle() {
		String title = null;
		try {
			return driver.getTitle();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;

	}

	/**
	 * @param locatorvalue
	 * @param locatortype
	 * @param elementName
	 */
	public void gettext(WebElement we, String elementName) {
		try {

			String gtt = we.getText();

			test.log(Status.INFO, "text of " + elementName + " taken successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "text of " + elementName + "  not taken successfully.");
		}
	}

	/**
	 * @param locatorvalue
	 * @param locatortype
	 * @param elementName
	 * @return
	 */
	public String getAttribute(WebElement we, String elementName) {
		String geta =null;
		try {
			geta = we.getAttribute(geta);

			test.log(Status.INFO, "Attribute value  of " + elementName + " taken successfully.");
		}

		catch (Exception e) {
			test.log(Status.FAIL, "Attribute value  of " + elementName + " taken successfully.");

			e.printStackTrace();
		}
		return geta;
	}

	/**
	 * @param timeout
	 */
	public void waitforimplicity( int timeout) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	public WebElement searchElement(WebElement we,) {
	//		WebElement obj = null;
	//		try {
	//			if (we.equalsIgnoreCase("xpath")) {
	//			 obj = driver.findElement(By.xpath(locatorValue));
	//			} else if (we.equalsIgnoreCase("id")) {
	//				 obj = driver.findElement(By.id(locatorValue));
	//			} else if (we.equalsIgnoreCase("css")) {
	//				 obj = driver.findElement(By.cssSelector(locatorValue));
	//			} else if (we.equalsIgnoreCase("name")) {
	//				 obj = driver.findElement(By.name(locatorValue));
	//
	//			} else if (we.equalsIgnoreCase("tag name")) {
	//				 obj = driver.findElement(By.tagName(locatorValue));
	//
	//			} else if (we.equalsIgnoreCase("class")) {
	//				obj=driver.findElement(By.className(locatorValue));
	//			} else if(we.equalsIgnoreCase("linkText")){
	//				obj=driver.findElement(By.linkText(locatorValue));
	//			}else {
	//			
	//				System.out.println("xpath is wrong please check it ");
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			
	//		}
	//		return obj;



	/**
	 * @param we
	 * @param inputvalue
	 */
	public void sendvalue(WebElement we, String inputvalue) {
		try {
			we.clear();
			we.sendKeys(inputvalue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	/**
	 * @param we
	 */
	public void clickbutton( WebElement we) {
		we.click();
	}


	/**
	 * @param frameninndex
	 */
	public void forframe(int frameninndex) {
		try {
			driver.switchTo().frame(frameninndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param NameOrId
	 */
	public void forframe(String NameOrId) {
		try {
			driver.switchTo().frame(NameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param element
	 * @return
	 */
	public Dimension elementSize(WebElement element) {
		Dimension measurement = element.getSize();
		System.out.println(measurement);
		return measurement;

	}

	/**
	 * @param weframeobj
	 */
	public void forframe(WebElement weframeobj) {
		try {
			driver.switchTo().frame(weframeobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param elementName
	 */
	public void ForAlertAccept(String elementName) {
		try {
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * @param elementName
	 */
	public void ForAlertDismiss(String elementName) {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param elementName
	 */
	public void ForAlertSendkey(String elementName) {
		try {
			driver.switchTo().alert().sendKeys(elementName);

		} catch (Exception e) {
			e.printStackTrace();
		}}


	/**
	 * @param driver
	 * @param et
	 */
	public void genericM(WebDriver driver, ExtentTest et) {
		WebElement wb = driver.findElement(By.xpath("xpath"));
		try {
			if (wb.isDisplayed() == true) {
				et.log(Status.INFO, "Element is visible");
				if (wb.isEnabled() == true) {
					et.log(Status.INFO, "Element is clickable");
				} else {
					et.log(Status.FAIL, "Element is not visible");
				}
			} else {
				et.log(Status.FAIL, "Element is not clickable");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void flushed() {

		try {
			report.flush();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("report flushed !!");
		}
	}


	/**
	 * @param reportName
	 */
	public void generateRepot(String reportName) {
		try {
			String time=fordate();
			ExtentSparkReporter esr = new ExtentSparkReporter("report\\" + reportName+time + ".html");
			report = new ExtentReports();
			report.attachReporter(esr);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @param tcName
	 */
	public void initlog(String tcName) {
		try {
			test = report.createTest(tcName);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void forScreenshot() {
		try {
			String date=fordate();

			TakesScreenshot tsc = (TakesScreenshot) driver;
			File to = tsc.getScreenshotAs(OutputType.FILE);
			File from = new File("sneha//screenshot"+date+".png");
			Files.copy(to, from);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public String  fordate() {
		String time=null;
		try {
			DateFormat dt = new SimpleDateFormat("MM--DD--YY--HH--MM--SS");
			time = dt.format(new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * @param actiobj
	 * @param elementName
	 */
	public void mouseover(WebElement actiobj, String elementName) {
		try {
			Actions linkofmarketing = new Actions(driver);
			linkofmarketing.moveToElement(actiobj).build().perform();
			test.log(Status.INFO, " move to the element  " + elementName + " successfully.");
		} catch (Exception e) {
			test.log(Status.INFO, " not move to the element  " + elementName + " successfully.");

			e.printStackTrace();
		}
	}


	/**
	 * @param windowTitle
	 */
	public void ForWindowHandlebyTitle(String windowTitle) {
		try {
			Set<String> handleValus = driver.getWindowHandles();
			System.out.println(handleValus.size());
			System.out.println(handleValus);
			for (String hValue : handleValus) {
				String actualTitle = driver.switchTo().window(hValue).getTitle();

				if (actualTitle.contains(windowTitle)) {
					test.log(Status.INFO, "title of currret window is -- " + windowTitle);
					break;
				}

			}

		} catch (Exception e) {
			test.log(Status.INFO, "title of currret window isnot taken successfully.");

			e.printStackTrace();
		}}


	/**
	 * @param windowURL
	 */
	public void ForWindowHandleByURL(String windowURL) {
		try {
			Set<String> handleValus = driver.getWindowHandles();
			System.out.println(handleValus.size());
			System.out.println(handleValus);
			for (String hValue : handleValus) {
				String actualURL = driver.switchTo().window(hValue).getCurrentUrl();

				if (actualURL.contains(windowURL)) {
					test.log(Status.INFO, "URL of currret window is -- " + windowURL);
					break;
				}

			}

		} catch (Exception e) {
			test.log(Status.INFO, "title of currret window isnot taken successfully.");

			e.printStackTrace();
		}}

	/**
	 * @param we
	 * @return
	 */
	//	public List<WebElement> searchElements(WebElement we) {
	//		List<WebElement> obj = null;
	//		try {
	//			if (we.equalsIgnoreCase("xpath")) {
	//				return obj = driver.findElements(By.xpath(locatorValue));
	//			} else if (we.equalsIgnoreCase("id")) {
	//				return obj = driver.findElements(By.id(locatorValue));
	//			} else if (we.equalsIgnoreCase("css")) {
	//				return obj = driver.findElements(By.cssSelector(locatorValue));
	//			} else if (we.equalsIgnoreCase("name")) {
	//				return obj = driver.findElements(By.name(locatorValue));
	//
	//			} else if (we.equalsIgnoreCase("tag name")) {
	//				return obj = driver.findElements(By.tagName(locatorValue));
	//
	//			} else if (we.equalsIgnoreCase("classname")) {
	//				driver.findElements(By.className(locatorValue));
	//			} else {
	//				System.out.println( "we is wrong please check it ");
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			return obj;
	//		}
	//		return obj;
	//	}

	/**
	 * @param key
	 * @return
	 */
	public String ReadData(String key)	{
		String pathOfPropertiesFile="vtigerr/src/main/java/AboutGenericMethod/ReadData";
		FileInputStream obj=null;
		try {
			obj=new FileInputStream(pathOfPropertiesFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Properties objOfPro= new Properties();
		try {
			objOfPro.load(obj);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		String stringValue=  objOfPro.getProperty(key);
		return stringValue;
	}



	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 * @param expectedText
	 */
	public void ValidateText(WebElement we, String elementName, String expectedText ) {

		String actualText= getAttribute(we, elementName);  
		try {   
			if(actualText.equals(expectedText)) {
				test.log(Status.PASS, elementName+" has "+expectedText );
			}
			else {
				test.log(Status.FAIL, elementName+" hasn't "+expectedText );


			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	} 	 

	/**
	 * @param elementName
	 * @return
	 */
	public String getPageTitle (String elementName) { 	 
		String Title =null;
		try {
			return Title =driver.getTitle();

		}catch(Exception e) {
			e.printStackTrace();	
		}
		return Title; 

	}	

	/**
	 * @param we
	 * @param locatorValue
	 * @param elementName
	 * @return
	 */
	public String getInnerText(WebElement we, String elementName) {
		String obj=null;
		try {
			obj=we.getText();	

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.INFO,"InnerText has not find ");
		}
		return obj;
	}


	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 */
	public void getText(WebElement we, String  elementName) {
		try {
			String ObjOfString= we.getText();
			test.log(Status.INFO, "text of" +elementName+"taken successfully")	;
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"text of" +elementName+ "not taken successfully");
		}	}


	/**
	 * @param sourcelocatorType
	 * @param sourcelocatorValue
	 * @param targetLocatorType
	 * @param targetLocatorValue
	 * @param elementName
	 */
//	public void FordragAndDrop(String sourcelocatorType,String sourcelocatorValue,String targetLocatorType,String targetLocatorValue,String elementName){
//		try {
//			WebElement source=we(targetLocatorType, targetLocatorValue);
//			WebElement Locator=searchElement(targetLocatorType, targetLocatorValue);
//
//			Actions ObjOfAction= new Actions(driver);
//			ObjOfAction.dragAndDrop(source, Locator).build().perform();
//			test.log(Status.INFO, elementName+ "is dragged and drop successfully");
//		}catch (Exception e) {
//			e.printStackTrace();

//		}}


	/**
	 * @param locatorValue
	 * @param locatorType
	 * @param elementName
	 */
	public void ValidateClick (WebElement we, String  elementName) {
		try {
			WebElement ObjOfClick =we;	 
			if(ObjOfClick.isDisplayed()==true) {
				test.log(Status.INFO, elementName+"text box is displayed");
				if (ObjOfClick.isEnabled()==true) {

					test.log(Status.INFO, elementName+"text box is Enablyed");
					ObjOfClick.click();
				}
				test.log(Status.INFO, elementName+" ckick performed successfully");
			}	else {
				test.log(Status.FAIL, elementName+"clickable not successfully")	;
			}	
		} catch(Exception e) {
			e.printStackTrace();

		} 	


		

	}}


