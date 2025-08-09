This is a Spring Boot Project with Togglz Java library Demo.

This will demo on the feature flags used to enable or disable a flag using web console or Database.

Feature flags are Initialized in **MyFeatures** enum under utils package.

Feature Flags, togglz configuration is maintained in Config Package with **TogglzConfiguration**.

Anyone can clone this repository and resolve the dependencies their system, and run this project.

This is created using, 
``Java : 21, Maven : 3.9.11, Spring Boot : 3.5.4 and PostgreSQL latest version.``



| Return Type          | Method Name                 | Url                                                   |
|----------------------|-----------------------------|-------------------------------------------------------|
| Optional<Employee>   | getEmployeeDetails(int employeeId) | localhost:8080/api/v1/get-employee?employeeId=1       |
| Map<String, Boolean> | getFeatureState()           | localhost:8080/api/v1/getFeaturesState                |
| String               | saveEmployeeDetails(Employee emp) | (Http Post Call ) localhost:8008/api/v1/save-employee |
 List<Employee>       | getAllEmployees()     | localhost:8080/api/v1/getEmployees                    |

You can access the Togglz Console using the localhost:8080/togglz-console

Sample Post Request body would look like 
``{
  "id": 7,
  "employeeName": "Beth",
  "department": "marketing"
}``