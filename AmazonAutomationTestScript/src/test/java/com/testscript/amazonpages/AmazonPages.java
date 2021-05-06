package com.testscript.amazonpages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class AmazonPages {
	
	 WebDriver driver;
		
	 @FindBy(name="url")
	 WebElement Alldropdown;
	 
	 
	 @FindAll(@FindBy(xpath="//option[starts-with(@value,'search-alias=')]"))
	 List<WebElement> Alloptions;
	 
	 public List<WebElement> getAlloptions(){
		 return Alloptions;
	 }
	 @FindBy(xpath="//input[@id='twotabsearchtextbox']")
	 WebElement searchTextField;
	 public WebElement getSearchTextField()
	 {
		 return searchTextField;
		 
	 }
	 
	 @FindBy(xpath="//input[@id='nav-search-submit-button']")
	 WebElement searchBtn;
	 public WebElement getSearchBtn()
	 {
		 return searchBtn;
	 }
	 
	 @FindAll(@FindBy(xpath="//a[@class='a-link-normal a text-normal']"))
	 List<WebElement> ProductNames;
	 public List<WebElement> getProductNames()
	 {
		 return ProductNames;
	 }
	 @FindAll(@FindBy(xpath="//span[@data-color='price']"))
	 List<WebElement> ProductPrices;
	 public List<WebElement> getProductPrices()
	 {
		 return ProductPrices;
	 }
	 public WebElement getAlldropdown()
	 {
		 return Alldropdown;
	 }
	 
	 @FindBy(linkText="New Apple iPhone 12 Mini (128GB) - White") //  Customer Select New Apple iPhone 12 Mini (128GB) - White
	 WebElement customerselectproduct;
	 public WebElement getCustomerProduct()
	 {
		 return customerselectproduct;
	 }
	 @FindBy(id="buy-now-button") //  
	 WebElement customerclickbuynow;
	 public WebElement getCustomerClickBuyNow()
	 {
		 return customerclickbuynow;
	 }
    
	 @FindBy(id="add-to-cart-button")
	 WebElement customerclickaddtocart;
	 public WebElement getCustomerClickAddtoCart()
	 {
		 return customerclickaddtocart;
	 }
	 
	 
	 
   @FindAll(@FindBy(xpath="//*[@id=\"navFooter\"]/div[4]/ul/li/a"))
	 List<WebElement> footernames;
	 public List<WebElement> getFooterNames()
	 {
		 return footernames;
	 }  
	 public AmazonPages(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
	 
	 @FindBy(xpath="//span[contains(text(),'Sort by:')]")
	 List<WebElement> sortByProductPage;
	 
	 public List<WebElement> getSortByProductPage()
	 {
		 return sortByProductPage;
	 }  
	 
	 @FindBy(xpath="//span[contains(text(),'Back to top')]")
	 List<WebElement> backtotop;
	 public List<WebElement> getBackToTop()
	 {
		 return backtotop;
	 }
	 @FindBy(name="url")
	    WebElement CategoryListBox;
	    public WebElement getCategoryListBox()
	    {
	    	return CategoryListBox;
	    }
	    @FindBy(name="url")
	    WebElement CategoryListBox1;
	    public WebElement getCategoryListBox1()
	    {
	    	Select Element=new Select(CategoryListBox1);
	    	List<WebElement>Options=Element.getOptions();
	    	int count=Options.size();
	    	System.out.println(count);
	    	for(WebElement we: Options)
	    	{
	    		String ElementsName=we.getText();
	    		System.out.println(ElementsName);
	    	}
	    	return CategoryListBox1;
	    }
	  
	 
	 

}
