The spring boot application uses stripe api software which allows individuals and organizatio to perform payments online. The application provides the features to users to manage the entities that are customers, cards, charges, and refunds. Each of these will have controllers and services.

The below features are used for the application:
1) Customer object - perform recurring charges and have multiple charges for the same customer. The api allows to create/delete/update/retrieve customer.

Customer creation api - create a customer with the parameters (name, description, email, address)

Customer retrieval api - retrieve a customer using customer id


2) Card object - allows to store multiple cards (Visa, mastercard, etc.) for the customer to perform charges.

Card creation api - add a card to a customer with the parameters (number, expiry month, expiry year, cvv, customer id)


3) Charge object - to charge a card for the customer, either create or refund a charge

Charge creation api - add a charge for the credit card with the parameters (amount, currency, description, and card details)

Charge retrieval api - retrieve a charge using charge id


4) Refund object - to refund a charge that was created for the customer

Refund charge api - add a refund to the charge using charge id


![SpringBootStripePic](https://user-images.githubusercontent.com/22809880/98669436-d1e6c700-236a-11eb-9561-d703b6818d5a.png)




The following steps are to be followed:

![SpringBootStripeNew](https://user-images.githubusercontent.com/22809880/98668395-43be1100-2369-11eb-9957-4c81b52ff37e.png)


Technology Stack:
1) Java
2) Stripe API


Begin to setup a new spring boot project in Eclipse/STS. Include controller, service, and model for each entity.







