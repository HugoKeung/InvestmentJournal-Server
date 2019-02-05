# InvestmentJournal-Server

This is the back-end API end-point provider for the Investment Journal project.
(front end can be found here: https://github.com/HugoKeung/InvestmentJournal )

Data is pulled from a SQLite database, using SpringBoot JPA. 
Data like the buy and sell history of the user can be pulled from the end-point API.

Strucutre of the application is as follow:
Repository -> Service -> Controller

Auth0 is used to secure the API so that only authorised user can reach these end-point. (Work in Progress)
