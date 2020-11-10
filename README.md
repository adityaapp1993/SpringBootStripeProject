The spring boot application uses stripe api software which allows individuals and organizatio to perform payments online. The application provides the features to users to manage the entities that are customers, cards, charges, and refunds. Each of these will have controllers and services.

The below features are used for the application:
1) Customer - perform recurring charges and have multiple charges for the same customer. The api allows to create/delete/update/retrieve customer.


2) Card - allows to store multiple cards (Visa, mastercard, etc.) for the customer to perform charges.



3) Charge  - to charge a card for the customer, either create or refund a charge


4) Refund  - to refund a charge that was created for the customer



![SpringBootStripePic](https://user-images.githubusercontent.com/22809880/98669436-d1e6c700-236a-11eb-9561-d703b6818d5a.png)




The following steps are to be followed:

![SpringBootStripeNew](https://user-images.githubusercontent.com/22809880/98668395-43be1100-2369-11eb-9957-4c81b52ff37e.png)


Technology Stack:
1) Java
2) Stripe API


Begin to setup a new spring boot project in Eclipse/STS. Include controller, service, and model for each entity.


The following apis are to be developed:

1) Customer creation api - create a customer with the parameters (name, description, email, address)

http://localhost:8080/v1/customers

request: 

{
    "name": "Adam",
    "email": "adam123@gmail.com",
    "description": "first description",
    "address": 
    {
        "city": "New York",
        "country": "US",
        "line1": "street 1"
    }
}

response:

{
  "id": "cus_IMguZnkKs9gTNw",
  "object": "customer",
  "address": {
    "city": "New York",
    "country": "US",
    "line1": "street 1",
    "line2": null,
    "postal_code": null,
    "state": null
  },
  "balance": 0,
  "created": 1605017307,
  "currency": null,
  "default_source": null,
  "delinquent": false,
  "description": "first description",
  "discount": null,
  "email": "adam123@gmail.com",
  "invoice_prefix": "615172F8",
  "invoice_settings": {
    "custom_fields": null,
    "default_payment_method": null,
    "footer": null
  },
  "livemode": false,
  "metadata": {
  },
  "name": "Adam",
  "next_invoice_sequence": 1,
  "phone": null,
  "preferred_locales": [

  ],
  "shipping": null,
  "tax_exempt": "none"
}


2) Customer retrieval api - retrieve a customer using customer id

http://localhost:8080/v1/customers/{customerId}



response:

{
  "id": "cus_IMguZnkKs9gTNw",
  "object": "customer",
  "address": {
    "city": "New York",
    "country": "US",
    "line1": "street 1",
    "line2": null,
    "postal_code": null,
    "state": null
  },
  "balance": 0,
  "created": 1605017307,
  "currency": null,
  "default_source": null,
  "delinquent": false,
  "description": "first description",
  "discount": null,
  "email": "adam123@gmail.com",
  "invoice_prefix": "615172F8",
  "invoice_settings": {
    "custom_fields": null,
    "default_payment_method": null,
    "footer": null
  },
  "livemode": false,
  "metadata": {
  },
  "name": "Adam",
  "next_invoice_sequence": 1,
  "phone": null,
  "preferred_locales": [

  ],
  "shipping": null,
  "tax_exempt": "none"
}



3) Card creation api - add a card to a customer with the parameters (number, expiry month, expiry year, cvv, customer id)


http://localhost:8080/v1/customers/{customerId}/sources

request

{
    "cardDetails":{
        "expiryMonth": "12",
        "expiryYear": "2021",
        "number": "4242424242424242",
        "cvc": "310"
    }
}

response

{
  "id": "card_1Hlxs5DcCC2Xdv7JVffI5d50",
  "object": "card",
  "address_city": null,
  "address_country": null,
  "address_line1": null,
  "address_line1_check": null,
  "address_line2": null,
  "address_state": null,
  "address_zip": null,
  "address_zip_check": null,
  "brand": "Visa",
  "country": "US",
  "customer": "cus_IMguZnkKs9gTNw",
  "cvc_check": "pass",
  "dynamic_last4": null,
  "exp_month": 12,
  "exp_year": 2021,
  "fingerprint": "pgEWAyQx7J2AesAD",
  "funding": "credit",
  "last4": "4242",
  "metadata": {
  },
  "name": null,
  "tokenization_method": null
}



4) Charge creation api - add a charge for the credit card with the parameters (amount, currency, description, and card details)

http://localhost:8080/v1/charges


request

{
    
    "amount": 200,
    "currency": "usd",
    "description": "charge",
    "customerId": "cus_IMguZnkKs9gTNw"
}

response

{
  "id": "ch_1HlxwJDcCC2Xdv7J8Byfnqww",
  "object": "charge",
  "amount": 200,
  "amount_captured": 200,
  "amount_refunded": 0,
  "application": null,
  "application_fee": null,
  "application_fee_amount": null,
  "balance_transaction": "txn_1HlxwKDcCC2Xdv7J6aHUcZF7",
  "billing_details": {
    "address": {
      "city": null,
      "country": null,
      "line1": null,
      "line2": null,
      "postal_code": null,
      "state": null
    },
    "email": null,
    "name": null,
    "phone": null
  },
  "calculated_statement_descriptor": "Stripe",
  "captured": true,
  "created": 1605018919,
  "currency": "usd",
  "customer": "cus_IMguZnkKs9gTNw",
  "description": "charge",
  "destination": null,
  "dispute": null,
  "disputed": false,
  "failure_code": null,
  "failure_message": null,
  "fraud_details": {
  },
  "invoice": null,
  "livemode": false,
  "metadata": {
  },
  "on_behalf_of": null,
  "order": null,
  "outcome": {
    "network_status": "approved_by_network",
    "reason": null,
    "risk_level": "normal",
    "risk_score": 12,
    "seller_message": "Payment complete.",
    "type": "authorized"
  },
  "paid": true,
  "payment_intent": null,
  "payment_method": "card_1Hlxs5DcCC2Xdv7JVffI5d50",
  "payment_method_details": {
    "card": {
      "brand": "visa",
      "checks": {
        "address_line1_check": null,
        "address_postal_code_check": null,
        "cvc_check": "pass"
      },
      "country": "US",
      "exp_month": 12,
      "exp_year": 2021,
      "fingerprint": "pgEWAyQx7J2AesAD",
      "funding": "credit",
      "installments": null,
      "last4": "4242",
      "network": "visa",
      "three_d_secure": null,
      "wallet": null
    },
    "type": "card"
  },
  "receipt_email": null,
  "receipt_number": null,
  "receipt_url": "https://pay.stripe.com/receipts/acct_1BFkLBDcCC2Xdv7J/ch_1HlxwJDcCC2Xdv7J8Byfnqww/rcpt_IMhKFT9BUS0GgDozu0MwbqtoamaA3Yp",
  "refunded": false,
  "refunds": {
    "object": "list",
    "data": [

    ],
    "has_more": false,
    "total_count": 0,
    "url": "/v1/charges/ch_1HlxwJDcCC2Xdv7J8Byfnqww/refunds"
  },
  "review": null,
  "shipping": null,
  "source": {
    "id": "card_1Hlxs5DcCC2Xdv7JVffI5d50",
    "object": "card",
    "address_city": null,
    "address_country": null,
    "address_line1": null,
    "address_line1_check": null,
    "address_line2": null,
    "address_state": null,
    "address_zip": null,
    "address_zip_check": null,
    "brand": "Visa",
    "country": "US",
    "customer": "cus_IMguZnkKs9gTNw",
    "cvc_check": "pass",
    "dynamic_last4": null,
    "exp_month": 12,
    "exp_year": 2021,
    "fingerprint": "pgEWAyQx7J2AesAD",
    "funding": "credit",
    "last4": "4242",
    "metadata": {
    },
    "name": null,
    "tokenization_method": null
  },
  "source_transfer": null,
  "statement_descriptor": null,
  "statement_descriptor_suffix": null,
  "status": "succeeded",
  "transfer_data": null,
  "transfer_group": null
}


5) Charge retrieval api - retrieve a charge using charge id

http://localhost:8080/v1/charges/ch_1HlxwJDcCC2Xdv7J8Byfnqww

response

{
  "id": "ch_1HlxwJDcCC2Xdv7J8Byfnqww",
  "object": "charge",
  "amount": 200,
  "amount_captured": 200,
  "amount_refunded": 0,
  "application": null,
  "application_fee": null,
  "application_fee_amount": null,
  "balance_transaction": "txn_1HlxwKDcCC2Xdv7J6aHUcZF7",
  "billing_details": {
    "address": {
      "city": null,
      "country": null,
      "line1": null,
      "line2": null,
      "postal_code": null,
      "state": null
    },
    "email": null,
    "name": null,
    "phone": null
  },
  "calculated_statement_descriptor": "Stripe",
  "captured": true,
  "created": 1605018919,
  "currency": "usd",
  "customer": "cus_IMguZnkKs9gTNw",
  "description": "charge",
  "destination": null,
  "dispute": null,
  "disputed": false,
  "failure_code": null,
  "failure_message": null,
  "fraud_details": {
  },
  "invoice": null,
  "livemode": false,
  "metadata": {
  },
  "on_behalf_of": null,
  "order": null,
  "outcome": {
    "network_status": "approved_by_network",
    "reason": null,
    "risk_level": "normal",
    "risk_score": 12,
    "seller_message": "Payment complete.",
    "type": "authorized"
  },
  "paid": true,
  "payment_intent": null,
  "payment_method": "card_1Hlxs5DcCC2Xdv7JVffI5d50",
  "payment_method_details": {
    "card": {
      "brand": "visa",
      "checks": {
        "address_line1_check": null,
        "address_postal_code_check": null,
        "cvc_check": "pass"
      },
      "country": "US",
      "exp_month": 12,
      "exp_year": 2021,
      "fingerprint": "pgEWAyQx7J2AesAD",
      "funding": "credit",
      "installments": null,
      "last4": "4242",
      "network": "visa",
      "three_d_secure": null,
      "wallet": null
    },
    "type": "card"
  },
  "receipt_email": null,
  "receipt_number": null,
  "receipt_url": "https://pay.stripe.com/receipts/acct_1BFkLBDcCC2Xdv7J/ch_1HlxwJDcCC2Xdv7J8Byfnqww/rcpt_IMhKFT9BUS0GgDozu0MwbqtoamaA3Yp",
  "refunded": false,
  "refunds": {
    "object": "list",
    "data": [

    ],
    "has_more": false,
    "total_count": 0,
    "url": "/v1/charges/ch_1HlxwJDcCC2Xdv7J8Byfnqww/refunds"
  },
  "review": null,
  "shipping": null,
  "source": {
    "id": "card_1Hlxs5DcCC2Xdv7JVffI5d50",
    "object": "card",
    "address_city": null,
    "address_country": null,
    "address_line1": null,
    "address_line1_check": null,
    "address_line2": null,
    "address_state": null,
    "address_zip": null,
    "address_zip_check": null,
    "brand": "Visa",
    "country": "US",
    "customer": "cus_IMguZnkKs9gTNw",
    "cvc_check": "pass",
    "dynamic_last4": null,
    "exp_month": 12,
    "exp_year": 2021,
    "fingerprint": "pgEWAyQx7J2AesAD",
    "funding": "credit",
    "last4": "4242",
    "metadata": {
    },
    "name": null,
    "tokenization_method": null
  },
  "source_transfer": null,
  "statement_descriptor": null,
  "statement_descriptor_suffix": null,
  "status": "succeeded",
  "transfer_data": null,
  "transfer_group": null
}



6) Refund charge api - add a refund to the charge using charge id

http://localhost:8080/v1/refunds

request
{
    
    "chargeId": "ch_1HlxwJDcCC2Xdv7J8Byfnqww"
}

response

{
  "id": "re_1HlcGXDcCC2Xdv7JzB4qFEbh",
  "object": "refund",
  "amount": 200,
  "balance_transaction": "txn_1HlcGXDcCC2Xdv7JwERY3iXR",
  "charge": "ch_1HlcElDcCC2Xdv7JEhFp2PoW",
  "created": 1604935605,
  "currency": "usd",
  "metadata": {
  },
  "payment_intent": null,
  "reason": null,
  "receipt_number": null,
  "source_transfer_reversal": null,
  "status": "succeeded",
  "transfer_reversal": null
}









