# simple-java-mail

This is a simple java library that helps you to send emails from your java projects.


![Visitor Count](https://profile-counter.glitch.me/{itsmrajesh}/count.svg)

## Installation

Just download the required version of jar from [releases](https://github.com/itsmrajesh/simple-java-mail/releases) and add .jar file to project build path

## Usage

You need to implement MailAuth interface.

```java
package io.github.itsmrajesh.samplemail;

public interface MailAuth {

	String getHostMailAddress();

	String getHostPassword();

}
```


```java

import io.github.itsmrajesh.samplemail.MailAuth;;

public class MyMailAuth implements MailAuth {

	@Override
	public String getHostmailaddress() {
		return "example@gmail.com";
	}

	@Override
	public String getHostpassword() {
		return "mysecret@apppassword"; // your password 
	}

}


```


After implmenting MailAuth interface, you need invoke following method MailService.sendMail and pass the all parameters to sendMail method. 

```java

//create object for newly implemented class and pass it in following method

MailAuth mailAuth = new MyMailAuth(); 

boolean status = MailService.sendMail(MailAuth mailAuth, String recipientMailAddress, String mailSubject, String message);

```

status will be true when your mail sent is successfully.

### Example

```java

import io.github.itsmrajesh.samplemail.MailAuth;

public class SimpleMailAppTester {

 public static void main(String[] args) {
		
  MailAuth mailAuth = new MyMailAuth();
		
  String recipientMailAddress = "example@gmail.com";
  String mailSubject = "Thank You-Simple Mail"; // This is your mail subject
  String message = "Hello User, <br> <h4>Thanks for using our services.</h4> <br> <br> Thank You, <br> Team Simple Mail.";
		
  System.out.println("Please wait while we send your mail.");
		
  boolean mailStatus = SimpleMailService.sendMail(mailAuth, recipientMailAddress, mailSubject, message);
		
  if (mailStatus) {
	System.out.println("Mail Sent Successfully!");
  } else {
	  System.out.println("Failed in sending mail.");
  }
  
 } // End of main method
 
} // End of Class

```



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
