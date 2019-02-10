# JavaMatic

This command-line application was written as a coding assessment.
It runs as per the specification provided by the recruiter.

The included test cases provide 100% unit test coverage.

The program can be altered to add additional drinks to the menu or modify unit prices for each ingredient.
One can also alter the maximum stock level for all ingredients.
The recipes for each drink can also be modified as needed.


The application was developed and tested (all JUnit tests passed) using Eclipse IDE on Mac OS. 

The command-line application was tested successfully on windows (not via Eclipse, just through command-line).

When running the JUnit tests via Eclipse on Windows, the tests will fail because the line break characters on windows are 
represented with "\r\n" instead of "\n" as on Unix/MacOS. 
This can be fixed by replacing all "\n" with "\r\n" on Windows and then (re-)running the test class.
Alternatively, the unit test class could be modified to use 'System.getProperty("line.separator")' for a system-independent 
new-line character. 
