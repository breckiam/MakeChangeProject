## Make Change Project


### Description
This is a program to calculate change for a purchase. User is prompted to enter
the total cost of the item, then prompted to enter total amount paid. This then
returns bills and coins back in the largest denomination. If customer didn't pay
enough, calculations will not run and display missing amount to user.


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
