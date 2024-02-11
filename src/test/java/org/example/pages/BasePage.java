package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    //////////////////////////////// DRIVER & Chromedriver config////////////////////////////////
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //////////////////////////////// OPEN/CLOSE DRIVER ////////////////////////////////
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }
    //////////////////////////////// ELEMENT FINDERS ////////////////////////////////
    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findAll(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    //////////////////////////////// ELEMENT ACTIONS ////////////////////////////////
    public String textFromElement(By locator) {
        return find(locator).getText();
    }

    public void write(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public void selectFromDropdownByValue(By locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(By locator, int index) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(index);
    }

    public void selectFromDropdownByText(By locator, String value) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(value);
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////// CLICK ACTIONS ////////////////////////////////
    public void hoverOverElement(By locator) {
        action.moveToElement(find(locator));
    }

    public void doubleClick(By locator) {
        action.doubleClick(find(locator));
    }

    public void rightClick(By locator) {
        action.contextClick(find(locator));
    }
    //////////////////////////////// VALIDATORS  ////////////////////////////////
    public boolean elementIsEnabled(By locator){
        return find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public boolean elementIsSelected(By locator){
        return find(locator).isSelected();
    }
}
