# | FindMyDoctor-API |
Demo for a medical web API which finds doctors based on patient's symptom and location.

This backend APIs is to achieve task like:

- Adding a doctor, 
- Adding a patient & it’s symptom, 
- Depending on the patient's symptoms and location, recommending a doctor.

# Doctor’s entity

Has name, city, email, phone number and speciality.

# Patient’s entity

Has name, city, email, phone number and symptom.

Following fields have the mentioned validations at the backend:

- Name (should be at least 3 characters)
- City (should be at max 20 characters)
- Email (should be a valid email address)
- Phone number (should be at least 10 number)

# Recommending Doctors

There is another API that accepts patient ID, and suggest the doctors based out of the patient location and the symptom.

E.g.: If the patient ID that we received in this API, that patient have Arthritis as symptom then all the doctors of that location who is an Orthopedic will be sent as the response, since Arthritis comes under Orthopedic speciality.

Edge case scenarios:

- Edge-Case 1: If there isn’t any doctor on that location (i.e.outside doctors cities), the response should be “We are still waiting to expand to your location”
- Edge-Case 2: If there isn’t any doctor for that symptom on that location, the response should be “There isn’t any doctor present at your location for your symptom”

