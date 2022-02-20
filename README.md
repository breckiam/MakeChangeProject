## Make Change Project


### Description
This is a program to calculate change for a purchase. User is displayed with a
menu where they can choose, Jims Burgers, Tonys tacos, or doing manual cash
register. When either food options are selected, it will display their menu where
the user can then select what they want to eat. The cost of the item is then
assigned to total cost. User is then asked for how much they are paying with.
The manual cash register asks for the total cost and how much was paid. Both of
these return change in the largest denomination of bills and coins back. If user
pays with less than total, they are promoted with how much they are short and
can pay extra or quit. 


### Technologies Used

Java

### Lessons Learned
I learned different ways to combat precision error. I had worked through
several different solutions to precision error to find one that consistently
worked without error. This error was only present for Cents side of the
equation. This was combatted by taking the leftover value that was owed after
all bills had been calculated, and moving the decimal point two places then
casting that value to an int. There for instead of working with a value of per
say 0.67, I was working with a value of 67. I had also created this project
previously and challenged myself to find a different solution to the problem. My
original solution was based with division while this was based on using modulus.
