## Assignment 01 [my solutions](https://github.com/210419-USF-BSN-Java/tom-dixon/blob/main/Assignment01/Assignment1.java)
### 4/20/21, Tuesday

### _Print Number in Word_
Write a method called printNumberInWord. The method has one parameter number
which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
for any other number including negative numbers. You can use if-else
statement or switch statement whatever is easier for you.

### 
```java 
// signature
public String printNumberInWord(int number) {
		// TODO Write an implementation for this method declaration
		
		return ;
	}

```

### _Reverse String_

Without using the StringBuilder or StringBuffer class, write a method that
reverses a String. Example: reverse("example"); -> "elpmaxe"

```java 
// signature
public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		
		return;
	}

```
## Project0 [my solution](https://github.com/210419-USF-BSN-Java/tom-dixon/tree/dev/project0/Shop)
## *Some Kind of Shop* 

## Description

   The Somekind of Shop app is a console-based application that facilitates the purchasing of some kind of item, the choice is up to you. 
	An employee can add these items to an inventory and manage offers for those those items while a customer can view the available items and make offers.
	
## Purpose

   We want to see that you can meet deadlines and that you can code. You are expected to complete the following requirements and give a 5 minute presentation of your project to our QC team.

## Requirements
1. Functionality should reflect the below user stories.
2. Data is stored in a database.
3. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
4. All input is received using the java.util.Scanner class.
5. All public service layer methods must have at least one JUnit test.
6. Log4j is implemented to log events to a file.


## User Stories
Total Points: 25 Points

* As a user, I can login.
	* 2 points
* As an employee, I can add an item to the shop.
	* 3 points
* As a customer, I can view the available items.
	* 1 point
* As a customer, I can make an offer for an item.
	* 3 points
* As an employee, I can accept or reject a pending offer for an item.
	* 2 points
* As the system, I update an item to an owned state when an offer is accepted.
	* 2 points
* As the system, I reject all other pending offers for an item when an offer is accepted.
	* 3 points
* As a user, I can register for a customer account.
	* 3 points
* As an employee, I can remove an item from the shop.
	* 2 points
* As a customer, I can view the items that I own.
	* 1 point
* As a customer, I can view my remaining payments for an item.
	* 1 point
* As an employee, I can view all payments.
	* 1 point
* As the system, I can calculate the weekly payment.
	* 1 point

## Bonus

* As a user, I can make a payment.
* As a manager, I can make employee accounts.
* As an employee, I can edit existing items.
* As a manager, I can fire employees.
* As a manager, I can view sales history of all offers.

## Extra bonus

Be creative and incorporate other topics into your project, they do not have to have been covered by our curriculum. Some suggestions:
* File I/O
* Threading
* Mocking
* Password hashing
<hr>

## Project1 - Employment Reimbursement System (ERS) [my solution](https://www.youtube.com/watch?v=oHg5SJYRHA0)
## Executive Summary
* The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. 
* All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. 
* Finance managers can log in and view all reimbursement requests and past history for all employees in the company. 
* Finance managers are authorized to approve and deny requests for expense reimbursement.

#### Employee User Stories 
- An Employee can login
- An Employee can view the Employee Homepage
- An Employee can logout
- An Employee can submit a reimbursement request
- An Employee can upload an image of his/her receipt as part of the reimbursement request (extra credit)
- An Employee can view their pending reimbursement requests
- An Employee can view their resolved reimbursement requests
- An Employee can view their information
- An Employee can update their information
- An Employee receives an email when one of their reimbursement requests is resolved (optional)

#### Manager User Stories
- A Manager can login
- A Manager can view the Manager Homepage
- A Manager can logout
- A Manager can approve/deny pending reimbursement requests
- A Manager can view all pending requests from all employees
- A Manager can view images of the receipts from reimbursement requests (extra credit)
- A Manager can view all resolved requests from all employees and see which manager resolved it
- A Manager can view all Employees
- A Manager can view reimbursement requests from a single Employee 


**State-chart Diagram (Reimbursement Statuses)** 
![](./imgs/state-chart.jpg)

**Reimbursement Types**

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)

## Technical Requirements

* The back-end system shall use `JDBC` connect to an **AWS RDS Postgres database**. 
* The application shall deploy onto a Tomcat Server. 
* The middle tier shall use Servlet technology for dynamic Web application development. 
* The front-end view shall use HTML/JavaScript to make an application that can call server-side components. 
* The middle tier shall follow proper layered architecture, have reasonable test coverage of the service layer, and implement **log4j** for appropriate logging. 

**Stretch Goals:** *These will count for extra credit and are entirely optional*
* Users can upload a document or image of their receipt when submitting reimbursements which can stored in the database and reviewed by a financial manager.
* Passwords shall be encrypted in Java and securely stored in the database. 
* Application shall be hosted remotely on an EC2.


