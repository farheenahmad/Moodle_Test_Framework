package com.netsuite.tlh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BaseParams;
import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;

public class BasePage implements BaseParams, INetsuiteTLHPage {

	public BasePage() throws DriverNotInitializedException {
		new WebDriverWait(BrowserFactory.getDriver(), 60).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public void waitForElementToBeVisibile(WebElement element) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException ex) {
			waitForElementToBeVisibile(element);
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}
	

	public void waitForElementToBeInVisibile(WebElement element) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (NoSuchElementException noExp) {
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForElementToBeInVisibile(By locator) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public WebElement waitForElementToBePresent(By locator) throws Throwable {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (StaleElementReferenceException ex) {
			waitForElementToBePresent(locator);
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}

		return element;
	}

	public WebElement waitForElementToBePresent(By locator, long waitTimeInSecs) throws Throwable {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), waitTimeInSecs, sleepInMillisecs);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (StaleElementReferenceException ex) {
			waitForElementToBePresent(locator);
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}

		return element;
	}

	public void waitForElementToBeClickable(WebElement element) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (StaleElementReferenceException e) {
			try {
				waitForElementToBeClickable(element);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public WebElement waitForElementToBeClickable(By locator) throws Throwable {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			element = wait.until(ExpectedConditions.elementToBeClickable(BrowserFactory.getDriver().findElement(locator)));
		} catch (StaleElementReferenceException e) {
			try {
				waitForElementToBeClickable(locator);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}

		return element;
	}

	public WebElement findElement(By locator) throws Throwable {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (StaleElementReferenceException e) {
			try {
				findElement(locator);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}

		return element;
	}

	public List<WebElement> findElements(By locator) throws Throwable {
		List<WebElement> elements = null;
		try {
			elements = BrowserFactory.getDriver().findElements(locator);
		} catch (StaleElementReferenceException e) {
			try {
				findElements(locator);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}

		return elements;
	}

	public boolean isElementDisplayed(WebElement element, long waitTimeInSecs) {
		boolean isVisible = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), waitTimeInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.visibilityOf(element));
			isVisible = true;
		} catch (Throwable t) {
		}

		return isVisible;
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean isVisible = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.visibilityOf(element));
			isVisible = true;
		} catch (Throwable t) {
		}

		return isVisible;
	}
	
	public boolean isElementDisplayed2(WebElement element) {
		boolean isVisible = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 2, 2000);
			wait.until(ExpectedConditions.visibilityOf(element));
			isVisible = true;
		} catch (Throwable t) {
		}

		return isVisible;
	}

	public boolean isElementDisplayed(List<WebElement> elements) {
		boolean isVisible = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			isVisible = true;
		} catch (Throwable t) {
		}

		return isVisible;
	}

	public boolean isElementPresent(By locator) {
		boolean isPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecsForElement, sleepInMillisecs);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			isPresent = true;
		} catch (Throwable t) {
		}

		return isPresent;
	}

	public boolean isTextPresentInElement(WebElement element, String text) {
		boolean isTextPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			isTextPresent = true;
		} catch (Throwable t) {
		}

		return isTextPresent;
	}

	public void waitForTextToBePresentInElement(By locator, String text) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		} catch (StaleElementReferenceException ex) {
			waitForTextToBePresentInElement(locator, text);
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForTextToBePresentInElement(WebElement element, String text) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (StaleElementReferenceException ex) {
			waitForTextToBePresentInElement(element, text);
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForSelectDropdownToBeAccessible(WebElement element) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs);

			// Wait until expected condition size of the dropdown increases and
			// becomes more than 1
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					Select select = new Select(element);

					return select.getOptions().size() > 1;
				}
			});
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForSelectDropdownToBePopulated(By locator) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs);

			// Wait until expected condition size of the dropdown increases and
			// becomes more than 1
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					Select select = null;
					boolean waitCondition = false;
					try {
						select = new Select(BrowserFactory.getDriver().findElement(locator));
						waitCondition = select.getOptions().size() > 1;
					} catch (StaleElementReferenceException e) {
						try {
							waitForSelectDropdownToBePopulated(locator);
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					return waitCondition;
				}
			});
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForSelectDropdownToBePopulated(By locator, String selectedText) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs);

			// Wait until expected condition size of the dropdown increases and
			// becomes more than 1
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					Select select = null;
					boolean waitCondition = false;
					try {
						select = new Select(BrowserFactory.getDriver().findElement(locator));
						waitCondition = select.getOptions().size() > 1
								&& selectedText.equals(select.getFirstSelectedOption().getText());

					} catch (StaleElementReferenceException e) {
						try {
							waitForSelectDropdownToBePopulated(locator, selectedText);
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return waitCondition;
				}
			});
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public boolean isSelectDropdownPopulated(By locator, String selectedText) {
		Select select = null;
		boolean waitCondition = false;
		try {
			select = new Select(BrowserFactory.getDriver().findElement(locator));
			waitCondition = selectedText.equals(select.getFirstSelectedOption().getText());

		} catch (StaleElementReferenceException e) {
			try {
				isSelectDropdownPopulated(locator, selectedText);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return waitCondition;
	}

	public void waitForElementToContainAttribute(By locator, String attribute, String value) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
		} catch (StaleElementReferenceException e) {
			try {
				waitForElementToContainAttribute(locator, attribute, value);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForElementValueContainsText(WebElement element, String text) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecs, sleepInMillisecs);
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		} catch (StaleElementReferenceException e) {
			try {
				waitForElementValueContainsText(element, text);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void waitForElementToBeEnabled(WebElement element) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecsForElement);
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return element.isEnabled();
				}
			});
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

	public void hoverOnElement(WebElement element) throws Throwable {
		waitForElementToBeVisibile(element);
		Actions action = new Actions(BrowserFactory.getDriver());
		action.moveToElement(element).perform();
	}

	public void waitForTextToBePresentInElement(WebElement element) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), maxTimeoutInSecsForElement);
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return element.getText().length() != 0;
				}
			});
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}

}
