package testngbestybuy;

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
		<class name="com.capstoneproject.Pages.SignUpAndLogin"/>
		<class name="com.capstoneproject.Pages.InvalidLoginTest"/>
		<class name="com.capstoneproject.Pages.NavigateAndValidateTitles"/>
	    <class name="com.capstoneproject.Pages.SearchAndAddCart"/>
	    <class name="com.capstoneproject.Pages.AddItemFromBrandTest"/>
	    <class name="com.capstoneproject.Pages.AddItemFromDepartmentTest"/>
        <class name="com.capstoneproject.Pages.CheckoutTest"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
