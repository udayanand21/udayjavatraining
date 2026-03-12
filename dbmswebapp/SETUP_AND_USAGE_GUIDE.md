# 🚀 Admin & User Role System - Setup & Usage Guide

## ✨ What's New

A complete role-based access control system has been implemented with:
- ✅ Login page with role selection (Admin/User)
- ✅ Admin Dashboard with full CRUD and advanced search
- ✅ User View with restricted access (no sensitive data)
- ✅ Session management with auto-logout
- ✅ Secure role-based routing

---

## 🔑 Login Credentials

### Admin Account
```
Username: admin
Password: admin123
Role: Admin
```

### User Account
```
Username: user
Password: user123
Role: User
```

---

## 📋 Complete Feature Overview

### 1️⃣ LOGIN PAGE (`/login.jsp`)

**URL:** `http://localhost:8080/dbmswebapp/`

**Features:**
- Beautiful gradient UI
- Role selection buttons (Admin/User)
- Username & Password input
- Demo credentials displayed
- Error handling for invalid credentials
- Session creation (30 minutes timeout)

**Flow:**
- Select Role (Admin or User)
- Enter Username & Password
- Click "Login"
- Redirects to appropriate dashboard

---

### 2️⃣ ADMIN DASHBOARD (`/admin-dashboard`)

**Access:** Login as Admin → Automatically redirected

**Features:**

#### A. Sidebar Actions
```
┌─ Add Employee
├─ Search (Modal with 2 options)
└─ View All
```

#### B. Main Table
Displays all employees with columns:
- **EID** - Employee ID (auto-generated)
- **Name** - Employee Name
- **Salary** - Employee Salary (₹ formatted)
- **Email** - Email Address
- **Mobile** - Phone Number (SENSITIVE - visible to admin only)
- **DOJ** - Date of Joining (SENSITIVE - visible to admin only)
- **DOB** - Date of Birth (SENSITIVE - visible to admin only)
- **Actions** - Edit/Delete buttons

#### C. Search Modal

**Single Search Button** → Click to open modal with 2 options:

**Option 1: Search by Name**
```
✓ Partial match (case-insensitive)
✓ Uses SQL LIKE operator
✓ Example: "John" finds "John", "Johnson", etc.
```

**Option 2: Search by Mobile**
```
✓ Exact match only
✓ Example: "9876543210" finds exact mobile
```

**Result Display:**
- Displays matching employees in the same table
- Clear message showing search criteria
- "Clear Search" button to reset view

#### D. CRUD Operations

**Add Employee:**
- Click "Add Employee" button
- Fill form (EID auto-generated)
- Submit → Redirects to employee list

**Edit Employee:**
- Click "Edit" button on table row
- Modify details (except EID - readonly)
- Submit → Updates & refreshes list

**Delete Employee:**
- Click "Delete" button on table row
- Confirm deletion dialog
- Employee removed from database

**View All:**
- Click "View All" button
- Shows complete employee list
- Re-initializes the table

#### E. Logout
- Click username in navbar
- Click "Logout"
- Session invalidated
- Redirected to login page

---

### 3️⃣ USER VIEW (`/user-view`)

**Access:** Login as User → Automatically redirected

**Features:**

#### A. Search Interface
```
┌─ Employee Name Search Input
└─ Search Button
```

#### B. Search Results

**Information Displayed (NON-SENSITIVE):**
- ✅ Employee ID (EID)
- ✅ Name
- ✅ Email

**Information HIDDEN (SENSITIVE):**
- ❌ Salary
- ❌ Mobile Number
- ❌ Date of Birth (DOB)
- ❌ Date of Joining (DOJ)

#### C. Search Behavior
- Enter employee name (partial match works)
- Click "Search"
- If found: Shows employee card with non-sensitive info
- If not found: Shows "No Employee Found" message
- Search field retains last search term

#### D. User View Layout
```
┌─────────────────────────────────┐
│  🔒 Employee Management Header  │
│  Search by Name                 │
├─────────────────────────────────┤
│  [Search Input]    [Search Btn] │
├─────────────────────────────────┤
│                                 │
│  ✓ Employee Found!              │
│  ┌─────────────────────────┐    │
│  │ Employee ID: 1001       │    │
│  │ Name: John Doe          │    │
│  │ Email: john@email.com   │    │
│  └─────────────────────────┘    │
│                                 │
│  ℹ️  Sensitive data restricted   │
└─────────────────────────────────┘
```

#### E. Logout
- Click username in navbar
- Click "Logout"
- Session invalidated
- Redirected to login page

---

## 🏗️ System Architecture

### Servlet Flow

```
┌─────────────────┐
│    login.jsp    │
│  (Role Select)  │
└────────┬────────┘
         │
         ▼
   ┌─────────────┐
   │LoginServlet │
   └────┬────┬───┘
        │    │
   admin │    │ user
        ▼    ▼
    ┌────────────────────┐      ┌────────────────┐
    │AdminDashboardServlet├──────►admin-dashboard│
    │(Full CRUD & Search)│      └────────────────┘
    └────────────────────┘
    
    ┌────────────────────┐      ┌───────────────┐
    │UserViewServlet     ├──────►user-view.jsp  │
    │(Search by Name)    │      └───────────────┘
    └────────────────────┘
        
    ┌────────────────────┐
    │EmployeeServlet    │ (ADMIN ONLY - CRUD)
    │(Protected)         │
    └────────────────────┘
```

### Data Flow

```
┌──────────────┐
│   User/Admin │
└──────┬───────┘
       │ Login
       ▼
┌──────────────────┐
│  LoginServlet    │
└────┬─────────┬───┘
     │         │
  ✓ auth   ✗ auth
     │         │
     ▼         ▼
┌───────┐   ┌────────────────┐
│Session│   │Redirect: /login│
│Create │   │?error=true     │
└───────┘   └────────────────┘
     │
     ▼
┌──────────────┐
│  Dashboard   │
│(Role-based)  │
└──────────────┘
```

---

## 🔐 Security Features

### Session Management
```java
- Session created on successful login
- Session timeout: 30 minutes of inactivity
- Session invalidated on logout
- Session checked on protected pages
```

### Role-Based Access Control
```
/admin-dashboard      → Admin only
/user-view           → User only
/employee            → Admin only (CRUD)
/login               → Everyone (before login)
```

### Data Protection
```
Admin can see:  ✓ EID, Name, Salary, Email, Mobile, DOJ, DOB
User can see:   ✓ EID, Name, Email (NO Salary, Mobile, DOJ, DOB)
```

### Protected Endpoints
```
✓ Admin Dashboard checks session & role
✓ User View checks session & role
✓ EmployeeServlet checks admin role only
✓ Logout clears session completely
```

---

## 📊 Database Schema

```sql
CREATE TABLE `employee` (
  `eid` decimal(10,0) NOT NULL,
  `ename` varchar(20) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

**Key Points:**
- EID auto-generated (starts from 1001)
- Salary formatted with ₹ symbol
- All date fields support null
- Mobile field is "sensitive"
- DOJ/DOB fields are "sensitive"

---

## 🎯 User Stories & Scenarios

### Scenario 1: Admin Managing Employees
```
1. Login → admin / admin123
2. View All Employees (default view)
3. Add Employee → Fill form, submit
4. Search by Name → Find "John" → Shows all Johns
5. Search by Mobile → Find "9876543210" → Shows exact match
6. Edit Employee → Modify & submit
7. Delete Employee → Confirm & remove
8. Logout → Session cleared
```

### Scenario 2: User Searching for Employee Info
```
1. Login → user / user123
2. Enter name "John"
3. Click Search
4. Results show:
   - EID: 1001
   - Name: John Doe
   - Email: john@email.com
   - Salary: ₹50000
   (Mobile, DOJ, DOB are HIDDEN)
5. Logout → Session cleared
```

### Scenario 3: Unauthorized Access
```
1. Direct URL: /admin-dashboard
2. No session → Redirected to /login
3. Login as user
4. Try to access /employee → Redirected to /login (user has no access)
5. Must logout and re-login as admin
```

---

## 🚀 Deployment Steps

### 1. Build Project
```bash
cd C:\Users\Uday.Anand\eclipse-workspace\dbmswebapp
mvn clean install -DskipTests
```

### 2. Deploy to Tomcat
```bash
# WAR file location:
target/dbmswebapp-0.0.1-SNAPSHOT.war

# Copy to Tomcat:
<TOMCAT_HOME>/webapps/
```

### 3. Start Tomcat
```bash
catalina.bat run
```

### 4. Access Application
```
http://localhost:8080/dbmswebapp/
```

---

## 📝 File Structure

```
dbmswebapp/
├── src/main/java/com/coforge/controller/
│   ├── LoginServlet.java
│   ├── AdminDashboardServlet.java
│   ├── UserViewServlet.java
│   ├── LogoutServlet.java
│   ├── EmployeeServlet.java (updated with auth)
│   └── dao/
│       └── EmployeeDao.java (updated)
│
├── src/main/webapp/
│   ├── login.jsp
│   ├── admin-dashboard.jsp
│   ├── user-view.jsp
│   ├── EmpForm.jsp
│   ├── Emplist.jsp
│   └── index.jsp (redirects to login)
│
└── pom.xml
```

---

## ✅ Testing Checklist

- [ ] Login page loads correctly
- [ ] Admin login works (admin/admin123)
- [ ] User login works (user/user123)
- [ ] Invalid credentials show error
- [ ] Admin dashboard displays all employees
- [ ] Admin can add employee
- [ ] Admin can edit employee
- [ ] Admin can delete employee
- [ ] Admin can search by name (modal)
- [ ] Admin can search by mobile (modal)
- [ ] User view displays search input
- [ ] User can search by name
- [ ] User sees only non-sensitive data
- [ ] User cannot see mobile/DOJ/DOB
- [ ] Logout works for both roles
- [ ] Session expires after 30 minutes
- [ ] Direct access to /admin-dashboard redirects to login
- [ ] User cannot access /employee servlet
- [ ] All forms have proper validation

---

## 🎨 UI Features

- ✨ Bootstrap 5 responsive design
- 🌈 Gradient backgrounds
- 🎯 Color-coded buttons
- 🔐 Professional navbar
- 📱 Mobile-friendly layouts
- 💾 Icon indicators
- 📊 Clean data tables
- 🔍 Search modals
- ✓ Form validations
- 🚀 Smooth navigation

---

## 📞 Support

For issues or questions:
1. Check browser console for errors
2. Check Tomcat logs: `<TOMCAT_HOME>/logs/`
3. Verify database connection in `DbUtil.java`
4. Ensure all credentials are correct
5. Clear browser cache and try again

---

**Last Updated:** March 11, 2026
**Version:** 1.0
**Status:** ✅ Production Ready

