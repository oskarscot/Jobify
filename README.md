# Springdeed

Springeed is a clone of Indeed built with Spring Boot and Vue. It is a job search engine that allows users to search for jobs by keyword, location, and company. Users can also save jobs to their profile and apply to jobs.
It features a RESTful API with JWT authentication and a PostgreSQL database.

## Frontend

The frontend is built with Vue, Vite and uses the Flowbite UI library along Tailwind. It uses Vue Router for routing and Vuex for state management. It also uses Axios for HTTP requests.

![Dashboard](https://i.imgur.com/jzTrSjQ.png)

![Login](https://i.imgur.com/uwS2XAv.png)

![Register](https://i.imgur.com/yl3wvWG.png)

## Backend

The backend is built with Spring Boot and uses Spring Data JPA for database access. It uses Spring Security for authentication and authorization. It also uses Spring Web for RESTful API endpoints.
Authentication is done with JWT. The frontend stores the JWT in local storage and sends it with every request to the backend. The backend validates the JWT and allows the request to proceed if it is valid.
