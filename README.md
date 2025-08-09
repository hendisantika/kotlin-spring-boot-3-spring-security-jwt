# kotlin-spring-boot-3-spring-security-jwt

Well, in our project we will implement a REST API for articles and users.

Articles will be visible to any user who successfully authenticates using the JWT access token.

Users endpoint, on the other hand, will be accessible only for admin users in our system (with one exception- a public
endpoint for creating new users).

Of course, we will expose additional authentication endpoints, which will take data from users, like email and password
and generate access and refresh tokens for our system.

Long story short- I believe this project will be simple enough to easily understand the topic, and comprehensive enough
to cover the most popular real-life cases.

### A Tiny Bit Of Theory

In this paragraph, I’d like to cover what exactly JWT tokens are, the difference between authorization and
authentication, and present from a bird’s eye view how Spring Security works.

So, if you feel that you understand these and came here for the practice, then please skip to the next chapter 😉

### Authentication vs Authorization

I am pretty sure that you heard both terms plenty of times already and even heard people using them alternately.

Nevertheless, although similar, these two terms refer to completely different things.

Imagine you’re at the entrance of a super-secret club:

**Authentication** is like showing your ID to prove you are who you say you are. It’s the process of confirming your
identity. So, in our club scenario, it’s like showing your driver’s license to the bouncer.

**Authorization**, on the other hand, is like being allowed into different parts of the club based on your VIP status.
Once you’re inside (thanks to authentication), authorization decides what you can and cannot do. For example, VIP
members might access the VIP lounge, while regular guests can’t.

### JWT Tokens

Among plenty of existing ways to authenticate users, JWTs (JSON Web Tokens) are one of the most popular ones.

They are like a digital secret handshake on the internet. When we log into a website, the server gives us a special JWT.
This token is like a digital badge that says, “Hey, this person is legit!”

Why are they so cool? Well, they are safe, compact, and allow us to hold information.

JWTs consist of three parts separated by dots: header.payload.signature:

**Spring Security** is like the security team of a building. It manages authentication and authorization for our app
with:

1. **Filters**– think of security filters as checkpoints at different doors in the building. When a request comes in, it
   goes through these filters. These filters handle tasks like authentication and authorization. For instance, there
   might be a filter that checks if you have a proper access card (authentication), and another that ensures you can
   enter specific rooms (authorization).
2. **Authentication**– when you log in, Spring Security checks your credentials (like username and password). If they
   match, you’re authenticated. Spring Security uses authentication providers, which can be a database, LDAP, or any
   other source, to verify your identity.
3. **Security Context**– once authenticated, your security details are stored in the Security Context. It’s like being
   given a special pass after passing through the checkpoint. This pass (security context) contains your roles and
   permissions.
4. **Authorization**– now, when you try to access a specific part of the application, Spring Security checks your roles
   and permissions stored in the security context. If you’re authorized (based on your roles), you’re allowed in.
   Otherwise, you might be denied access.
5. **Customization**– Spring Security allows you to customize the security filters, authentication providers, and access
   rules according to your application’s requirements. You can configure which URLs need authentication, what roles are
   required, etc.

## API Usage Examples

This section provides practical examples of how to interact with the API using curl commands and HTTP requests.

### Authentication

#### Login and Get JWT Tokens

**Request:**

```bash
curl -X POST http://localhost:8080/api/auth \
  -H "Content-Type: application/json" \
  -d '{
    "email": "user@example.com",
    "password": "password123"
  }'
```

**HTTP Request:**

```
POST /api/auth HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response:**

```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### User Management

#### Create a New User

**Request:**

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "email": "newuser@example.com",
    "password": "securepassword"
  }'
```

**Response:**

```json
{
  "uuid": "123e4567-e89b-12d3-a456-426614174000",
  "email": "newuser@example.com"
}
```

#### Get All Users (Admin Required)

**Request:**

```bash
curl -X GET http://localhost:8080/api/users \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

**Response:**

```json
[
  {
    "uuid": "123e4567-e89b-12d3-a456-426614174000",
    "email": "user1@example.com"
  },
  {
    "uuid": "456e7890-e89b-12d3-a456-426614174001",
    "email": "user2@example.com"
  }
]
```

#### Get User by UUID

**Request:**

```bash
curl -X GET http://localhost:8080/api/users/123e4567-e89b-12d3-a456-426614174000 \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

**Response:**

```json
{
  "uuid": "123e4567-e89b-12d3-a456-426614174000",
  "email": "user@example.com"
}
```

#### Delete User by UUID

**Request:**

```bash
curl -X DELETE http://localhost:8080/api/users/123e4567-e89b-12d3-a456-426614174000 \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

**Response:** `204 No Content`

### Articles

#### Get All Articles (Authentication Required)

**Request:**

```bash
curl -X GET http://localhost:8080/api/articles \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

**HTTP Request:**

```
GET /api/articles HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

**Response:**

```json
[
  {
    "id": "789e0123-e89b-12d3-a456-426614174002",
    "title": "Introduction to Spring Security",
    "content": "Spring Security is a powerful authentication and authorization framework..."
  },
  {
    "id": "012e3456-e89b-12d3-a456-426614174003",
    "title": "JWT Tokens Explained",
    "content": "JWT tokens are a secure way to transmit information between parties..."
  }
]
```

### Error Responses

When authentication fails or access is denied, you'll receive error responses:

**401 Unauthorized:**

```json
{
  "timestamp": "2023-10-31T15:52:00.000+00:00",
  "status": 401,
  "error": "Unauthorized",
  "path": "/api/articles"
}
```

**403 Forbidden:**

```json
{
  "timestamp": "2023-10-31T15:52:00.000+00:00",
  "status": 403,
  "error": "Forbidden",
  "path": "/api/users"
}
```

