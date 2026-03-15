# Employee Management System - Admin & User Roles

## Overview
Complete role-based access control system with separate dashboards for Admin and User roles.

---

## 🔐 Authentication System

### Login Credentials
| Role | Username | Password |
|------|----------|----------|
| Admin | admin | admin123 |
| User | user | user123 |

### Login Page Features
- Role selection (Admin/User)
- Beautiful gradient UI
- Demo credentials displayed
- Session management (30 minutes timeout)

---

## 👨‍💼 ADMIN DASHBOARD
**URL:** `/admin-dashboard` (requires admin login)

### Features:
1. **Complete CRUD Operations**
   - Add Employee
   - Edit Employee
   - Delete Employee
   - View All Employees

2. **Advanced Search**
   - Single "Search" button opens modal
   - Two search options in modal:
     - Search by Name (partial match using LIKE)
     - Search by Mobile (exact match)
   - Results displayed in main table

3. **Employee Table View**
   - EID (auto-generated)
   - Name
   - Salary
   - Email
   - Mobile Number (SENSITIVE)
   - Date of Joining (DOJ)
   - Date of Birth (DOB) (SENSITIVE)
   - Edit/Delete action buttons

4. **Sidebar Actions**
   - Add Employee button
   - Search button (opens modal)
   - View All button

5. **Logout Functionality**
   - User profile display
   - Logout button in navbar

---

## 👤 USER VIEW
**URL:** `/user-view` (requires user login)

### Features:
1. **Limited Information Access**
   - Employee ID (EID)
   - Name
   - Email

2. **Restricted Data (NOT Visible to Users)**
   - Salary ❌
   - Mobile Number ❌
   - Date of Birth (DOB) ❌
   - Date of Joining (DOJ) ❌

3. **Search Functionality**
   - Search by Employee Name only
   - Single search box on the page
   - Shows only non-sensitive information

4. **Result Display**
   - Beautiful card layout
   - Shows employee details (if found)
   - "Not found" message if no match
   - Information displayed with icons

---

## 📁 Files Created

### Java Servlets
1. **LoginServlet.java** - Handles login authentication
2. **AdminDashboardServlet.java** - Admin dashboard controller
3. **UserViewServlet.java** - User view controller
4. **LogoutServlet.java** - Logout functionality
5. **EmployeeDao.java** - Updated with `searchByNameSingle()` method

### JSP Pages
1. **login.jsp** - Login page with role selection
2. **admin-dashboard.jsp** - Admin dashboard with full CRUD and search modal
3. **user-view.jsp** - User view with restricted information
4. **index.jsp** - Updated to redirect to login

---

## 🔄 User Flow

### Admin Flow:
```
Login (admin role) 
    ↓
Admin Dashboard
    ├─ View All Employees (table)
    ├─ Add Employee (form)
    ├─ Edit Employee (form)
    ├─ Delete Employee (confirm)
    ├─ Search (modal with 2 options)
    │   ├─ By Name
    │   └─ By Mobile
    └─ Logout
```

### User Flow:
```
Login (user role)
    ↓
User View Page
    ├─ Search by Name
    ├─ View Result (if found)
    │   └─ Shows: EID, Name, Email, Salary
    └─ Logout
```

---

## 🔒 Security Features

1. **Session Management**
   - Session created on login
   - 30-minute inactivity timeout
   - Session invalidated on logout

2. **Role-Based Access Control**
   - Admin dashboard redirects to login if not admin
   - User view redirects to login if not user
   - Logout clears session and redirects to login

3. **Data Protection**
   - Sensitive data (mobile, DOB, DOJ) hidden from users
   - Users can only search by name
   - Admins have full visibility

---

## 📊 Database Information

### Table: employee
```sql
- eid (DECIMAL, Primary Key)
- ename (VARCHAR)
- salary (DECIMAL)
- email (VARCHAR)
- mobile (VARCHAR) - Sensitive
- doj (DATE) - Sensitive
- dob (DATE) - Sensitive
```

---

## 🎨 UI/UX Features

1. **Responsive Design**
   - Bootstrap 5 framework
   - Mobile-friendly layouts

2. **Visual Hierarchy**
   - Gradient backgrounds
   - Color-coded buttons (Success, Primary, Warning, Danger)
   - Icons for better clarity

3. **Search Modal (Admin)**
   - Clean two-option interface
   - In-modal forms
   - Easy toggle between search types

4. **User-Friendly Pages**
   - Clear status messages
   - Icon indicators
   - Non-sensitive information only

---

## 🚀 How to Access

1. **Start Application**
   - Deploy to Tomcat
   - Access: `http://localhost:8080/dbmswebapp/`

2. **Login as Admin**
   - Username: `admin`
   - Password: `admin123`
   - Role: Admin
   - Navigate to: Admin Dashboard

3. **Login as User**
   - Username: `user`
   - Password: `user123`
   - Role: User
   - Navigate to: User View

4. **Logout**
   - Click "Logout" button in navbar
   - Returns to login page

---

## ✨ Key Improvements

✅ Role-based access control implemented
✅ Separate dashboards for admin and user
✅ Search modal for admin (single button, 2 options)
✅ Restricted data access for users
✅ Complete logout functionality
✅ Session management
✅ Beautiful UI with Bootstrap 5
✅ Security checks on all protected pages
✅ Auto-generated Employee IDs
✅ Full CRUD operations for admins

