# Telephone Switchboard System

## Project description:

Design and implement a Telephone switchboard console application.
The application will be replicated the whole process of communication between two phone users.

## Goals:

The application will be written from scratch following the OOP best practices, write clean code, 
implement proper validations and exception handling, including unit tests.

## Functional Requirements:

> The application must support creating multiple 'Phone users'
> 
> Each user must have a first name, last name, company, mobile phone number, business phone number, email, notes.

- The name `must` be unique, string between 5 and 15 symbols.
- The company name, string between 3 and 20 symbols, not unique, multiple users can be employees in the same company.
- The email associated with the phone number should be unique, string between 5 and 25 symbols.
- The notes will be array of strings.

> Each phone should be able to call other phone numbers, to send SMS, to be on 'Airplane' mode.

> Each phone should be able to receive SMS, incoming calls, to get an audio notification about unavailability the called number, if it's out of range or busy.

> `IMPORTANT` Each phone number should be part of one of two telecommunications companies: Modafone or Telecore<br>
>  When the number is created - user must choose one of two companies.<br>
>  When the contract is signed user will be granted with available amount of hours and SMS they could use within a month.<br>
> IF they spent ALL their hours or/and SMS - the service automatically became available only for incoming calls and SMS, until the customer is prolonged services with additional payment.

## Test cases:

### Step 1:
#### To Start the process command: OPEN
#### Create User command: CREATE USER {first name, last name*, company*, business phone number*, email*, notes*}
#### Create Telecommunication Company command: CREATE COMPANY {"Modafone", econom{10hours, 50sms, 100USD}, vip{50hours, 250sms, 200USD}}
#### Sign a contract with TC** command: SIGN CONTRACT {first name, last name, Modafone, econom, signed}
#### Resign a contract with TC** command: SIGN CONTRACT {first name, last name, Modafone, econom, resigned}
#### Create a number for TC** command: CREATE NUMBER {Modafone, 1253698, econom{10hours, 50sms, 100USD}}
#### Show all available numbers to buy command: SHOW NUMBERS {Modafone}
#### Buy a specific number command: BUY NUMBER {Modafone, number}  <br>(If user weren't happy about the plan (Econom or VIP), they would be able to resign and sign the preferred one once again)

### Step 2:
#### Call other user command -TODO
#### Send SMS to other user  -TODO
#### IF the called user is busy - there is a message: "The number is busy". -TODO
#### IF the called user is out of range - there is a message: "SMS wasn't delivered", otherwise: "SMS was delivered" -TODO
#### To close the process command: CLOSE








<br>
<br>
<br>
<br>
<br>
<br>
-----------------------------------------------<br>
company* - not mandatory object.<br>
TC** - Telecommunication Company
