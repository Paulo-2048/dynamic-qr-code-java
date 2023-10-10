# Dynamic QR Code Management API

This API is developed using Spring Boot and PostgreSQL and offers functionalities to manage both static and dynamic QR codes. Below, you will find the documentation of routes, organized by controller file.

## BigNodeController.java

| Route                    | Description                | Parameters         | Response                        |
|--------------------------|----------------------------|--------------------|---------------------------------|
| GET /bignode             | Get a list of big nodes    | None               | List of BigNodeEntity objects   |
| GET /bignode/{uuid}      | Get a big node by UUID     | uuid (String)      | BigNodeEntity object            |
| POST /bignode            | Create a big node          | None               | Created BigNodeEntity object    |
| DELETE /bignode/{uuid}   | Delete a big node by UUID  | uuid (String)      | Success message                |

## SmallNodeController.java

| Route                    | Description                  | Parameters                | Response                           |
|--------------------------|------------------------------|---------------------------|------------------------------------|
| GET /smallnode           | Get a list of small nodes    | None                      | List of SmallNodeEntity objects   |
| GET /smallnode/{uuid}    | Get a small node by UUID     | uuid (String)             | SmallNodeEntity object             |
| POST /smallnode          | Create a small node          | SmallNodeRequestDTO       | Created SmallNodeEntity object     |
| PATCH /smallnode/{uuid}  | Update a small node by UUID  | uuid (String)             | Updated SmallNodeEntity object     |
| DELETE /smallnode/{uuid} | Delete a small node by UUID  | uuid (String)             | Success message                    |

## QrCodeController.java

| Route                    | Description                            | Parameters                     | Response                        |
|--------------------------|----------------------------------------|--------------------------------|---------------------------------|
| GET /qrcode              | Get a list of QR codes associated with a small node | snoUuidReference (String) | List of QrCodeEntity objects |
| GET /qrcode/{uuid}       | Get a QR code by UUID                  | uuid (String)                  | QrCodeEntity object             |
| POST /qrcode             | Create a QR code for a small node      | QrCodeRequestDTO               | Created QrCodeEntity object     |
| PUT /qrcode/{uuid}       | Update a QR code by UUID               | uuid (String)                  | Updated QrCodeEntity object     |
| PATCH /qrcode/{uuid}     | Update a QR code partially by UUID     | uuid (String)                  | Updated QrCodeEntity object     |
| DELETE /qrcode/{uuid}    | Delete a QR code by UUID               | uuid (String)                  | Success message                |

## RedirectController.java

| Route                    | Description                                | Parameters            | Response                   |
|--------------------------|--------------------------------------------|-----------------------|----------------------------|
| GET /{reference}         | Redirect to a URL based on a reference     | reference (String)    | Redirect to the URL        |

## Usage

To use this API, make HTTP requests to the routes listed above using a tool like Postman or integrate it into your application. Ensure you provide the appropriate parameters as documented for each route.

If you have any questions or encounter issues, refer to the GitHub repository for support.

---
