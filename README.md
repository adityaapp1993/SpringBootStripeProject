The spring boot application uses stripe api software which allows individuals and organizatio to perform payments online. The application provides the features to users to manage the entities that are customers, cards, charges, and refunds. Each of these will have controllers and services.

The below features are used for the application:
1) Customer object - perform recurring charges and have multiple charges for the same customer. The api allows to create/delete/update/retrieve customer.
2) Card object - allows to store multiple cards (Visa, mastercard, etc.) for the customer to perform charges.
3) Charge object - to charge a card for the customer, either create or refund a charge
4) Refund object - to refund a charge that was created for the customer


![SpringBootStripe](https://user-images.githubusercontent.com/22809880/98640573-af8d8300-2343-11eb-8587-f96207d9f495.png)

Technology Stack:
-Java
-Stripe API

Begin to setup a new spring boot project in Eclipse/STS. Include controller, service, and model for each entity.





