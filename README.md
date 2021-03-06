The spring boot application uses stripe api software which allows individuals and organizatio to perform payments online. The application provides the features to users to manage the entities that are customers, cards, charges, and refunds. Each of these will have controllers and services.

The below features are used for the application:
1) Customer - perform recurring charges and have multiple charges for the same customer. The api allows to create/delete/update/retrieve customer.


2) Card - allows to store multiple cards (Visa, mastercard, etc.) for the customer to perform charges.



3) Charge  - to charge a card for the customer, either create or refund a charge


4) Refund  - to refund a charge that was created for the customer



![SpringBootStripePic](https://user-images.githubusercontent.com/22809880/98669436-d1e6c700-236a-11eb-9561-d703b6818d5a.png)




The following describes the flow: 

![SpringBootStripeNew](https://user-images.githubusercontent.com/22809880/98668395-43be1100-2369-11eb-9957-4c81b52ff37e.png)


Technology Stack:
1) Java
2) Stripe API


Begin to setup a new spring boot project in Eclipse/STS. Include controller, service, and model for each entity.


The following apis are to be developed:

1) Customer creation api - create a customer having name, email, address, description.

![Screenshot from 2020-11-12 20-41-40](https://user-images.githubusercontent.com/22809880/98974659-058c3300-24ca-11eb-8f63-170e1a4a7675.png)



2) Customer retrieval api - to retrieve customer details using customer id

![Screenshot from 2020-11-12 20-42-18](https://user-images.githubusercontent.com/22809880/98974981-60258f00-24ca-11eb-83a9-a54a01a9d474.png)



3) Card Creation api - add a card for specific customer

![Screenshot from 2020-11-12 20-42-42](https://user-images.githubusercontent.com/22809880/98975087-88ad8900-24ca-11eb-8e9e-9ef777a6bd15.png)


4) Create charge api - add a charge for the customer for credit or debit card

![Screenshot from 2020-11-12 20-43-21](https://user-images.githubusercontent.com/22809880/98975604-27d28080-24cb-11eb-83a4-6b295810bd13.png)


5) Retrieve charge api - to retrieve a charge using charge id

![Screenshot from 2020-11-12 20-43-45](https://user-images.githubusercontent.com/22809880/98975725-4fc1e400-24cb-11eb-90e2-3704a0384632.png)


6) Refund charge api - to refund the charge created

![Screenshot from 2020-11-12 20-43-57](https://user-images.githubusercontent.com/22809880/98975881-8a2b8100-24cb-11eb-8361-5554c5f909d3.png)


